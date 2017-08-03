package com.itour.listener.event;

import com.itour.service.LevelAreaService;

public class LevelAreaEvent extends BaseEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7214381694283320971L;
	private LevelAreaService obj;  
	public LevelAreaEvent(LevelAreaService source) {
		super(source);  
        obj = source; 
	}
	 public LevelAreaService getSource(){  
	        return obj;  
	 } 
}
