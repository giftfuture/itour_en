package com.itour.listener.event;

import com.itour.service.TravelStyleService;

public class TravelStyleEvent extends BaseEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1522832055110095503L;
	private TravelStyleService obj;  
	public TravelStyleEvent(TravelStyleService source) {
		super(source);  
        obj = source; 
	}		
	 public TravelStyleService getSource(){  
	        return obj;  
	 } 
}
