package com.itour.listener.event;

import com.itour.service.ShowHappyService;

public class ShowHappyEvent extends BaseEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1991961449153880102L;
	private ShowHappyService obj;  
	public ShowHappyEvent(ShowHappyService source) {
		super(source);  
        obj = source; 
	}
	 public ShowHappyService getSource(){  
	        return obj;  
	 } 
}
