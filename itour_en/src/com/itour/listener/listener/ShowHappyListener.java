package com.itour.listener.listener;

import java.util.EventListener;

import com.itour.listener.event.ShowHappyEvent;

public interface  ShowHappyListener extends BaseListener {
	void event(ShowHappyEvent le);  
}
