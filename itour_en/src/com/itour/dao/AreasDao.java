package com.itour.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itour.base.dao.BaseDao;
import com.itour.entity.Areas;

public interface AreasDao extends BaseDao<Areas> {
	
	 int add(Areas t);
		
	 int update(Areas t);
	
	 int delete(@Param(value="id")String id);
	
	 int logicdelete(@Param(value="id")String id);
	 
	List<Areas> queryAll();
	
	Areas queryByPinyin(@Param(value="pinyin")String pinyin);
}
