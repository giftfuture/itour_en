package com.itour.listener.listener;

import java.util.EventListener;

import com.itour.listener.event.BaseEvent;

public interface BaseListener extends EventListener {
	void event(BaseEvent le);  
}
