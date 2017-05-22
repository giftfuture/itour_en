package com.itour.base.convert;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;

import com.itour.base.convert.Converter;

/**
 * 布尔类型转换器
 * @author  
 * @version  
 * @see Converter
 */
public class BooleanConverter implements Converter<Boolean> {

	public static final BooleanConverter INSTANCE = new BooleanConverter();
	@Override
	public Object convert(Object arg0, TypeDescriptor arg1, TypeDescriptor arg2) {
		return null;
	}
	@Override
	public Boolean convert(Object source, Class<? extends Boolean> toType, Boolean vDefault) {
		try {
			if (toType.isPrimitive() && vDefault == null) {
				vDefault = Boolean.FALSE;
			}
			if (source == null) {
				return vDefault;
			}
			if (source instanceof Boolean) {
				return (Boolean) source;
			}
			if (source instanceof Number) {
				return ((Number) source).intValue() != 0;
			}
			if (source instanceof String) {
				String value = (String) source;
				if ("1".equals(value) || "true".equalsIgnoreCase(value) || "on".equalsIgnoreCase(value)) {
					return Boolean.TRUE;
				}
				if ("0".equals(value) || "false".equalsIgnoreCase(value) || "off".equalsIgnoreCase(value)) {
					return Boolean.FALSE;
				}
			}
		} catch (Exception e) {
			// Ignore//
		}
		return vDefault;
	}

	@Override
	public boolean support(Class<? extends Boolean> type) {
		return Boolean.class.equals(type) || Boolean.TYPE.equals(type);
	}



	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		return new HashSet<ConvertiblePair>();
	}

}
