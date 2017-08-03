package com.itour.listener.event;

import com.itour.service.AreasService;

public class AreasEvent extends BaseEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2603881575656196900L;
	private AreasService obj;  
	public AreasEvent(AreasService source) {
		super(source);  
        obj = source; 
	}
	 public AreasService getSource(){  
	        return obj;  
	 } 
}
