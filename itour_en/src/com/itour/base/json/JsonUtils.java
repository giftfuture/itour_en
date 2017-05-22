package com.itour.base.json;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import com.itour.base.collect.Listx;
import com.itour.base.collect.Listxs;
import com.itour.base.collect.Mapx;
import com.itour.base.collect.Mapxs;
import com.itour.base.convert.ConvertUtil;

public class JsonUtils {


	//===================================Fields==============================================
	private final static Gson GSON;
	private final static Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);
	static {
		
		GsonBuilder builder = new GsonBuilder();
		//对日期格式进行特殊处理
		builder.registerTypeHierarchyAdapter(java.util.Date.class, new JsonSerializer<java.util.Date>() {
			public JsonElement serialize(Date source, Type type, JsonSerializationContext context) {
				return new JsonPrimitive(source.getTime());
			}
		});
		builder.registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory());
		builder.registerTypeHierarchyAdapter(java.util.Date.class, new JsonDeserializer<java.util.Date>() {
			public Date deserialize(JsonElement element, Type type, JsonDeserializationContext context)
					throws JsonParseException {
				String value = element.getAsString();
				Date date = ConvertUtil.toDate(value, null);
				return date;
			}

		});
		//不转义HTML字符
		builder.disableHtmlEscaping();
		//创建GSON
		GSON = builder.create();
	}

	//===================================Methods=============================================
	/**
	 * 将JAVA对象编码为JSON字符串
	 * @param src JAVA对象
	 * @return 对象的JSON字符串
	 */
	public static <T> String encode(T src) {
		return GSON.toJson(src);
	}

	/**
	 * 将JSON字符串解码为JAVA对象
	 * @param json 对象的JSON字符串
	 * @param type JAVA对象类型
	 * @return JSON对应的JAVA对象，如果无法解析将返回NULL.
	 */
	public static <T> T decode(String json, Class<T> type) {
		return decode(json, type, null);
	}

	/**
	 * 将JSON字符串，解码为JAVA对象
	 * @param json JSON字符串
	 * @param type JAVA对象类型
	 * @param _default 默认值
	 * @return JSON对应的JAVA对象，如果无法解析将返回默认值.
	 */
	public static <T> T decode(String json, Class<T> type, T _default) {
		try {
			return GSON.fromJson(json, type);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			return _default;
		}
	}

	/**
	 * 将JSON字符串，解码为JAVA对象
	 * @param json JSON字符串
	 * @param token 类型标记
	 * @return JSON对应的JAVA对象，如果无法解析将返回NULL.
	 */
	public static <T> T decode(String json, TypeToken<T> token) {
		try {
			return GSON.getAdapter(token).fromJson(json);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			return null;
		}
	}

	/**
	 * 将JSON转换为MAP对象
	 * @param json JSON字符串
	 * @return MAP对象,如果类型不匹配或者转换出现异常则返回null.
	 */
	public static Mapx toMapx(String json) {
		try {
			JsonElement element = new JsonParser().parse(json);
			if (element.isJsonObject()) {
				return toMapx(element.getAsJsonObject());
			}
		} catch (Exception e) {
			LOGGER.warn(e.toString(), e);
		}
		return null;
	}

	/**
	 * 将JSON转换为LIST对象
	 * @param json JSON字符串
	 * @return LIST对象,如果类型不匹配或者转换出现异常则返回null.
	 */
	public static Listx toListx(String json) {
		try {
			JsonElement element = new JsonParser().parse(json);
			if (element.isJsonArray()) {
				return toListx(element.getAsJsonArray());
			}
		} catch (Exception e) {
			LOGGER.warn(e.toString(), e);
		}
		return null;
	}

	private static Mapx toMapx(JsonObject object) {
		Mapx map = Mapxs.newMapx();
		for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
			map.put(entry.getKey(), toBasicValue(entry.getValue()));
		}
		return map;
	}

	private static Listx toListx(JsonArray array) {
		Listx list = Listxs.newListx();
		for (Iterator<JsonElement> it = array.iterator(); it.hasNext();) {
			list.add(toBasicValue(it.next()));
		}
		return list;
	}

	private static Object toBasicValue(JsonElement element) {
		if (element == null || element.isJsonNull()) {
			return null;
		}
		if (element.isJsonArray()) {//ARRAY
			return toListx(element.getAsJsonArray());
		}
		if (element.isJsonObject()) {//ARRAY
			return toMapx(element.getAsJsonObject());
		}
		if (element.isJsonPrimitive()) {
			return element.getAsString();
		}
		return null;
	}
/*	public static String toJSONString(Object object, boolean filterNull, SerializerFeature[] features) {
		SerializeWriter out = new SerializeWriter();
		JSONSerializer serializer = new JSONSerializer(out);
		for (int i = 0; i < features.length; i++) {
		SerializerFeature feature = features[i];
		serializer.config(feature, true);
		}
		serializer.setDateFormat("yyyy-MM-dd HH:mm:ss");
		serializer.config(SerializerFeature.WriteDateUseDateFormat, true);
		//根据PropertyName判断是否序列化
		serializer.getPropertyPreFilters().add(new PropertyPreFilter() {
		public boolean apply(JSONSerializer serializer, Object object, String name) {
		try {
			if (((object instanceof Map)) || ((object instanceof Iterable))) {
			return true;
			}
			Field f = object.getClass().getDeclaredField(name);
			if (!f.isAccessible()) {
				f.setAccessible(true);
			}
			Object val = f.get(object);
			return Hibernate.isInitialized(val);
		} catch (NoSuchFieldException localNoSuchFieldException) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

		}
		public static String toJSONString(Object object) {
			return toJSONString(object, false, new SerializerFeature[0]);
		}*/
}
