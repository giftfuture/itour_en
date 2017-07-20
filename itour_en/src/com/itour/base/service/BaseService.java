package com.itour.base.service;

import java.util.Enumeration;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import com.itour.base.dao.BaseDao;
import com.itour.base.page.BasePage;
import com.itour.base.util.ClassReflectUtil;
import com.itour.base.util.IDGenerator;
import com.itour.dao.CustomersDao;
import com.itour.dao.LevelAreaDao;
import com.itour.listener.event.BaseEvent;
import com.itour.listener.listener.BaseListener;
public abstract class BaseService<T>{
	
	protected BaseDao<T> mapper;
	//protected Mapper<T> mapper;
	
	protected BaseDao<T> getDao() {
		return mapper;
	}
	private BaseListener baseListener;
	private Vector  repository = new Vector ();
	public void addBaseListener(BaseListener ll){
		repository.addElement(ll);//这步要注意同步问题  
	}
	public void notifyBaseEvent(BaseEvent event) {  
        Enumeration e = repository.elements();//这步要注意同步问题  
        while(e.hasMoreElements()){  
        	baseListener = (BaseListener)e.nextElement();  
        	baseListener.event(event); 
        }  
    }
	 public void removeBaseListener(BaseListener ll){  
        repository.remove(ll);//这步要注意同步问题  
     } 
	public String add(T t)  throws Exception{
		//设置主键.字符类型采用UUID,数字类型采用自增
		String uuid = IDGenerator.getUUID();// UUID.randomUUID().toString();
		//System.out.println("uuid="+uuid);
		ClassReflectUtil.setIdKeyValue(t,"id",uuid);
		//ClassReflectUtil.setIdKeyValue(t,"id",IDGenerator.getLongId()+"");
		int result = getDao().add(t);
		if(result > 0 ){
			notifyBaseEvent(new BaseEvent(this));
		}
		return uuid;
	}
	
	public void update(T t)  throws Exception{
		int result = getDao().update(t);
		if(result > 0 ){
			notifyBaseEvent(new BaseEvent(this));
		}
	}
	
	
	public void delete(String... ids) throws Exception{
		if(ids == null || ids.length < 1){
			return;
		}
		for(String id : ids ){
			int result = getDao().delete(id);
			if(result > 0 ){
				notifyBaseEvent(new BaseEvent(this));
			}
		}
	}
	
	public void logicdelete(String... ids) throws Exception{
		if(ids == null || ids.length < 1){
			return;
		}
		for(String id : ids ){
			int result = getDao().logicdelete(id);
			if(result > 0 ){
				notifyBaseEvent(new BaseEvent(this));
			}
		}
	}
	public int queryByCount(BasePage page)throws Exception{
		return getDao().queryByCount(page);
	}
	
	public List<T> queryByList(BasePage page) throws Exception{
		Integer rowCount = queryByCount(page);
		page.getPager().setRowCount(rowCount);
		return getDao().queryByList(page);
	}

	public T queryById(String id) throws Exception{
		return getDao().queryById(id);
	}
}
