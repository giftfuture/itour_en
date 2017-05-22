package com.itour.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itour.base.page.BasePage;

public interface BaseDao<T> {

	public void add(T t);
	
	public void update(T t);
	
	public void delete(@Param(value="id")String id);
	
	public void logicdelete(@Param(value="id")String id);

	public int queryByCount(BasePage page);
	
	public List<T> queryByList(BasePage page);
	
	public BasePage<T> pagedQuery(BasePage page);
	
	public T queryById(@Param(value="id")String id);
}
