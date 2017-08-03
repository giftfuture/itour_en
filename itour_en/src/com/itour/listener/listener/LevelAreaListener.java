package com.itour.listener.listener;

import java.util.EventListener;

import com.itour.listener.event.LevelAreaEvent;

public interface  LevelAreaListener extends BaseListener {
	void event(LevelAreaEvent le);  
}
