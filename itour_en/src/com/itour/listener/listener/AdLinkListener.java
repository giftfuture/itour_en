package com.itour.listener.listener;

import java.util.EventListener;

import com.itour.listener.event.AdLinkEvent;

public interface  AdLinkListener extends BaseListener {
	void event(AdLinkEvent le);  
}
