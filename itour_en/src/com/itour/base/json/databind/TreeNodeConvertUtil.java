package com.itour.base.json.databind;

import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.itour.base.collect.Listx;
import com.itour.base.collect.Listxs;
import com.itour.base.collect.Mapx;
import com.itour.base.collect.Mapxs;
import com.itour.base.log.Logger;

/**
 * 类型转换工具类
 * @author  
 * @version  
 */
public class TreeNodeConvertUtil {

	private static final Logger LOGGER = Logger.getLogger(TreeNodeConvertUtil.class);

	/**
	 * 将TreeNode转换为Mapx类型
	 * @param node TreeNode字符串
	 * @return Mapx对象,如果类型不匹配或者转换出现异常则返回null.
	 */
	public static Mapx toMapx(TreeNode node) {
		try {
			if (node instanceof ObjectNode) {
				return toMapx((ObjectNode) node);
			}
		} catch (Exception e) {
			LOGGER.warn(node.getClass() + "cannot be cast to ObjectNode", e);
		}
		return null;
	}

	/**
	 * 将TreeNode转换为Listx类型
	 * @param node TreeNode字符串
	 * @return Listx对象,如果类型不匹配或者转换出现异常则返回null.
	 */
	public static Listx toListx(TreeNode node) {
		try {
			if (node instanceof ArrayNode) {
				return toListx((ArrayNode) node);
			}
		} catch (Exception e) {
			LOGGER.warn(node.getClass() + "cannot be cast to ObjectNode", e);
		}
		return null;
	}

	// 将ObjectNode转化为Mapx
	private static Mapx toMapx(ObjectNode node) {
		Mapx map = Mapxs.newMapx();
		for (Iterator<Map.Entry<String, JsonNode>> it = node.fields(); it.hasNext();) {
			Map.Entry<String, JsonNode> entry = it.next();
			String key = entry.getKey();
			Object value = toBasicValue(entry.getValue());
			map.put(key, value);
		}
		return map;
	}

	// 将ArrayNode转化为Listx
	private static Listx toListx(ArrayNode node) {
		Listx list = Listxs.newListx();
		for (int i = 0, I = node.size(); i < I; i++) {
			list.add(toBasicValue(node.get(i)));
		}
		return list;
	}

	// 将ValueNode转化为String
	private static String toString(ValueNode node) {
		return node.asText();
	}

	// 将JsonNode转化为基础对象或者扩展集合对象
	private static Object toBasicValue(JsonNode node) {
		if (node == null || node instanceof NullNode || node instanceof MissingNode) {// NULL|MISSING
			return null;
		}
		if (node instanceof ArrayNode) {// ARRAY
			return toListx((ArrayNode) node);
		}
		if (node instanceof ObjectNode) {// OBJECT
			return toMapx((ObjectNode) node);
		}
		if (node instanceof ValueNode) {// BINARY|BOOLEAN|NUMBER|POJO|STRING
			return toString((ValueNode) node);
		}
		return null;
	}
}
