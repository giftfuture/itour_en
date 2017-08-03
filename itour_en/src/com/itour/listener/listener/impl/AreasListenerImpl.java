package com.itour.listener.listener.impl;

import com.itour.listener.event.AreasEvent;
import com.itour.listener.listener.AreasListener;
import com.itour.util.Constants;

public class AreasListenerImpl extends BaseListenerImpl implements AreasListener {

	@Override
	public void event(AreasEvent le) {
		System.out.println("####Areas重新加载####");
		Constants.load(le.getSource());
	}

 
}
