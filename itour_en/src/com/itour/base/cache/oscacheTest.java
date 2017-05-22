package com.itour.base.cache;

import org.springframework.context.ApplicationContext;

import com.opensymphony.oscache.general.GeneralCacheAdministrator;

public class oscacheTest {
	
	ApplicationContext applicationContext = null;
    public void OSFlushAll(){  
        GeneralCacheAdministrator cacheAdmin = (GeneralCacheAdministrator)applicationContext.getBean("cacheManager");  
        cacheAdmin.flushAll();  
        System.out.println("Processing OSFlushingAll");  
    }  
      
    /**                                                           
    * 描述 : <清空指定组名称的缓存>. <br> 
    *<p>                                                  
                                                                                                                                                                                                           
    * @param groupName                                                                                                  
    */  
    public void OSFlushGroup(String groupName){  
        GeneralCacheAdministrator cacheAdmin = (GeneralCacheAdministrator)applicationContext.getBean("cacheManager");  
        cacheAdmin.flushGroup(groupName);//清除该组的缓存：pb_test  
        System.out.println("Processing OSFlushingGroup:"+groupName);  
    }  
	public static void main(String[] args) {

	}

}
