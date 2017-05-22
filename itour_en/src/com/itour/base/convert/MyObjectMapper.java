package com.itour.base.convert;


import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.itour.base.collect.Listx;
import com.itour.base.collect.Mapx;
import com.itour.base.json.databind.DateDeserializer;
import com.itour.base.json.databind.DateSerializer;
import com.itour.base.json.databind.ListxDeserializer;
import com.itour.base.json.databind.MapxDeserializer;
import com.itour.base.json.databind.StringUnicodeSerializer;

/**
 * Jackson_ObjectMapper的自定义扩展
 */
public class MyObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 1L;

	public static final ObjectMapper INSTANCE = new MyObjectMapper();

	public MyObjectMapper() {

		// 当找不到对应的序列化器时 忽略此字段
		this.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		 //目标类中找不到json字符串中属性时直接忽略  
      //  this.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// 支持结束
		this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		this.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		//
		this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

		// 使Jackson JSON支持Unicode编码非ASCII字符
		SimpleModule module = new SimpleModule();
		module.addSerializer(String.class, new StringUnicodeSerializer());
		module.addSerializer(Date.class, new DateSerializer());

		module.addDeserializer(Date.class, new DateDeserializer());
		module.addDeserializer(Mapx.class, new MapxDeserializer());
		module.addDeserializer(Listx.class, new ListxDeserializer());
		this.registerModule(module);
	}
}
