package com.itour.base.convert;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter.ConvertiblePair;

import com.itour.base.convert.Converter;

/**
 * 字符类型转换器
 * @author  
 * @version 
 * @see Converter
 */
public class CharacterConverter implements Converter<Character> {
	public static final CharacterConverter INSTANCE = new CharacterConverter();

	public Character convert(Object source, Class<? extends Character> toType, Character vDefault) {
		try {
			if (toType.isPrimitive() && vDefault == null) {
				vDefault = Character.valueOf(Character.MIN_VALUE);
			}
			if (source == null) {
				return vDefault;
			}
			if (source instanceof Character) {
				return (Character) source;
			}
			if (source instanceof String && ((String) source).length() > 0) {
				return ((String) source).charAt(0);
			}
		} catch (Exception e) {
			// Ignore//
		}
		return vDefault;
	}

	@Override
	public boolean support(Class<? extends Character> type) {
		return Character.class.equals(type);
	}

	@Override
	public Object convert(Object arg0, TypeDescriptor arg1, TypeDescriptor arg2) {
		return null;
	}

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		return new HashSet<ConvertiblePair>();
	}
}
