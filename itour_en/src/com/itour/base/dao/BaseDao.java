package com.itour.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itour.base.page.BasePage;

public interface BaseDao<T> {

	 int add(T t);
	
	 int update(T t);
	
	 int delete(@Param(value="id")String id);
	
	 int logicdelete(@Param(value="id")String id);

	 int queryByCount(BasePage page);
	
	 List<T> queryByList(BasePage page);
	
	 BasePage<T> pagedQuery(BasePage page);
	
	 T queryById(@Param(value="id")String id);
}
