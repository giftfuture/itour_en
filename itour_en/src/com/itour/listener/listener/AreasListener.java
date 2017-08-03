package com.itour.listener.listener;

import java.util.EventListener;

import com.itour.listener.event.AreasEvent;

public interface  AreasListener extends BaseListener {
	void event(AreasEvent le);  
}
