package com.itour.base.convert;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter.ConvertiblePair;

import com.itour.base.collect.HashMapx;
import com.itour.base.collect.Mapx;

/**
 * MAP映射表类型转换器
 * @author  
 */
public class MapxConverter implements Converter<Mapx> {

	public static final MapxConverter INSTANCE = new MapxConverter();

	@SuppressWarnings("rawtypes")
	@Override
	public Mapx convert(Object source, Class<? extends Mapx> toType, Mapx vDefault) {
		try {
			if (source instanceof Map) {
				Mapx result = new HashMapx();
				for (Object o : (((Map) source).entrySet())) {
					Map.Entry entry = (Map.Entry) o;
					result.put(String.valueOf(entry.getKey()), entry.getValue());
				}
				return result;
			}
		} catch (Exception e) {
			// Ignore//
		}
		return vDefault;
	}

	@Override
	public boolean support(Class<? extends Mapx> type) {
		return Mapx.class.isAssignableFrom(type);
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
