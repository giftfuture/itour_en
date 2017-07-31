package com.itour.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itour.base.dao.BaseDao;
import com.itour.entity.AdLink;

public interface AdLinkDao extends BaseDao<AdLink> {
	
	 int add(AdLink t);
		
	 int update(AdLink t);
	
	 int delete(@Param(value="id")String id);
	
	 int logicdelete(@Param(value="id")String id);
	 
	List<AdLink> queryAll(@Param(value="foot")int foot);
}
