package com.itour.base.convert;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter.ConvertiblePair;

import com.itour.base.collect.ArrayListx;
import com.itour.base.collect.Listx;


/**
 * LIST集合类型转换器
 * @author  
 */
public class ListxConverter implements Converter<Listx> {

	public static final ListxConverter INSTANCE = new ListxConverter();

	@Override
	public Listx convert(Object source, Class<? extends Listx> toType, Listx vDefault) {
		try {
			if (source instanceof Collection) {
				Listx result = new ArrayListx();
				result.addAll((Collection<?>) source);
				return result;
			} else if (source instanceof Object[]) {
				Listx result = new ArrayListx();
				Collections.addAll(result, (Object[]) source);
				return result;
			} else if (source instanceof Iterable) {
				Listx result = new ArrayListx();
				for (@SuppressWarnings("rawtypes")
				Iterator elements = (Iterator) source; elements.hasNext(); result.add(elements.next()))
					;
				return result;
			}
		} catch (Exception e) {
			// Ignore//
		}
		return vDefault;
	}

	@Override
	public boolean support(Class<? extends Listx> type) {
		return Listx.class.isAssignableFrom(type);
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
