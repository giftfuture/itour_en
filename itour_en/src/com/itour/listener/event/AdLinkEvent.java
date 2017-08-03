package com.itour.listener.event;

import com.itour.service.AdLinkService;

public class AdLinkEvent extends BaseEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4624945633153765337L;
	private AdLinkService obj;  
	public AdLinkEvent(AdLinkService source) {
		super(source);  
        obj = source; 
	}
	 public AdLinkService getSource(){  
	        return obj;  
	 } 
}
