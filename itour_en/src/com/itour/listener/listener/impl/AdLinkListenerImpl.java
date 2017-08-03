package com.itour.listener.listener.impl;

import com.itour.listener.event.AdLinkEvent;
import com.itour.listener.listener.AdLinkListener;
import com.itour.util.Constants;

public class AdLinkListenerImpl extends BaseListenerImpl implements AdLinkListener {

	@Override
	public void event(AdLinkEvent le) {
		System.out.println("####adLink重新加载####");
		Constants.load(le.getSource());
	}

 
}
