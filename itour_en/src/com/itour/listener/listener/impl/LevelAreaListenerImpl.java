package com.itour.listener.listener.impl;

import com.itour.listener.event.LevelAreaEvent;
import com.itour.listener.listener.LevelAreaListener;
import com.itour.util.Constants;

public class  LevelAreaListenerImpl extends BaseListenerImpl implements LevelAreaListener {

	@Override
	public void event(LevelAreaEvent le) {
		System.out.println("####LevelArea重新加载####");
		Constants.load(le.getSource());
	};  
}
