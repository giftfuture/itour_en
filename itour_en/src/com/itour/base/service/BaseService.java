package com.itour.base.service;

import java.util.List;
import java.util.UUID;

import com.itour.base.dao.BaseDao;
import com.itour.base.page.BasePage;
import com.itour.base.util.ClassReflectUtil;
import com.itour.base.util.IDGenerator;
import com.itour.dao.CustomersDao;
import com.itour.dao.LevelAreaDao;
public abstract class BaseService<T>{
	
	protected BaseDao<T> mapper;
	//protected Mapper<T> mapper;
	
	protected BaseDao<T> getDao() {
		return mapper;
	}
	
	public String add(T t)  throws Exception{
		//设置主键.字符类型采用UUID,数字类型采用自增
		String uuid = IDGenerator.getUUID();// UUID.randomUUID().toString();
		//System.out.println("uuid="+uuid);
		ClassReflectUtil.setIdKeyValue(t,"id",uuid);
		//ClassReflectUtil.setIdKeyValue(t,"id",IDGenerator.getLongId()+"");
		getDao().add(t);
		return uuid;
	}
	
	public void update(T t)  throws Exception{
		getDao().update(t);
	}
	
	
	public void delete(String... ids) throws Exception{
		if(ids == null || ids.length < 1){
			return;
		}
		for(String id : ids ){
			getDao().delete(id);
		}
	}
	
	public void logicdelete(String... ids) throws Exception{
		if(ids == null || ids.length < 1){
			return;
		}
		for(String id : ids ){
			getDao().logicdelete(id);
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
