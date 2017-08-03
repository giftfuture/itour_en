package com.itour.listener.event;

import java.util.EventObject;

import com.itour.base.service.BaseService;

public class BaseEvent extends EventObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3207660444476938712L;
	private BaseService obj;  
	public BaseEvent(BaseService source) {
		super(source);  
        obj = source; 
	}
	 public BaseService getSource(){  
	        return obj;  
	 } 
}
