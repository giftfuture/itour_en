package com.itour.base.convert;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter.ConvertiblePair;

/**
 * 枚举类型转换器
 * @author  
 */
@SuppressWarnings("rawtypes")
public class EnumConverter implements Converter<Enum> {

	public static final EnumConverter INSTANCE = new EnumConverter();

	@SuppressWarnings("unchecked")
	@Override
	public Enum convert(Object source, Class<? extends Enum> toType, Enum vDefault) {
		try {
			if (toType.isEnum()) {
				if (toType.isInstance(source)) {
					return (Enum) source;
				}
				String name = source.toString();
				return Enum.valueOf(toType, name);
			}
		} catch (Exception e) {
			/* Ignore the error */
		}
		return vDefault;
	}

	@Override
	public boolean support(Class<? extends Enum> toType) {
		return Enum.class.isAssignableFrom(toType);
	}

	@Override
	public Object convert(Object arg0, TypeDescriptor arg1, TypeDescriptor arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		return new HashSet<ConvertiblePair>();
	}

}
