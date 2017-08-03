package com.itour.listener.event;

import com.itour.entity.SysVariables;
import com.itour.service.SysVariablesService;

public class SystemVariablesEvent extends BaseEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4624945633153765337L;
	private SysVariablesService obj;  
	public SystemVariablesEvent(SysVariablesService source) {
		super(source);  
        obj = source; 
	}
	 public SysVariablesService getSource(){  
	        return obj;  
	 } 
}
