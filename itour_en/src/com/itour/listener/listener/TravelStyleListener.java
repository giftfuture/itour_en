package com.itour.listener.listener;

import java.util.EventListener;

import com.itour.listener.event.TravelStyleEvent;

public interface  TravelStyleListener extends BaseListener {
	void event(TravelStyleEvent le);  
}
