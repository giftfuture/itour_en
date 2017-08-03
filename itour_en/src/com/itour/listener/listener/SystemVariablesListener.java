package com.itour.listener.listener;

import java.util.EventListener;

import com.itour.listener.event.SystemVariablesEvent;

public interface  SystemVariablesListener extends BaseListener {
	void event(SystemVariablesEvent le);  
}
