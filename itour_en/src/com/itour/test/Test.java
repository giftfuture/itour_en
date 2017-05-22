package com.itour.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Test {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put(new Object(), new Object());
		map.put(new Object(), new Object());
		map.put(new ArrayList(), new ArrayList());
		map.put(new ArrayList(), new ArrayList());
		map.put(1, 2);
		map.put(1, 22);
		//for(map.forEach(action);)
		Iterator<Entry> it = map.entrySet().iterator();
		while(it.hasNext())
		{
			Entry en = it.next();
			System.out.println(en.getKey()+"   "+en.getValue());
		}
	}
	
}
