package com.itour.base.cache;

import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;

public class OSCacheServiceImpl extends GeneralCacheAdministrator implements CacheService {
	 
	private static final long serialVersionUID = -4950916198444378845L;
	
	@Override
	public void remove(KEY key) {
		this.removeEntry(key.getValue());
	}
	
	@Override
	public void put(KEY key, Object value) {
		this.putInCache(key.getValue(), value);
	}
	
	@Override
	public Object get(KEY key, TIME time) {
		try {
		    return this.getFromCache(key.getValue(), time.getValue());
		} catch (NeedsRefreshException e) {
		    this.cancelUpdate(key.getValue());
		    return null;
	   }
	}

}
