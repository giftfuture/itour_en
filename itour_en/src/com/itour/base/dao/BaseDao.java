package com.itour.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itour.base.page.BasePage;

public interface BaseDao<T> {

	 void add(T t);
	
	 void update(T t);
	
	 void delete(@Param(value="id")String id);
	
	 void logicdelete(@Param(value="id")String id);

	 int queryByCount(BasePage page);
	
	 List<T> queryByList(BasePage page);
	
	 BasePage<T> pagedQuery(BasePage page);
	
	 T queryById(@Param(value="id")String id);
}
