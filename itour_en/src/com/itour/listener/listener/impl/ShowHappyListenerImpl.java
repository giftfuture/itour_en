package com.itour.listener.listener.impl;

import com.itour.listener.event.ShowHappyEvent;
import com.itour.listener.listener.ShowHappyListener;
import com.itour.util.Constants;

public class ShowHappyListenerImpl extends BaseListenerImpl implements ShowHappyListener {

	@Override
	public void event(ShowHappyEvent le) {
		System.out.println("####ShowHappy重新加载####");
		Constants.load(le.getSource());
	}

 
}
