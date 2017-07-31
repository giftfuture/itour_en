package com.itour.dao;


import org.apache.ibatis.annotations.Param;

import com.itour.base.dao.BaseDao;
/**
 * 
 * <br>
 * <b>功能：</b>SysVariablesDao<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2013 <br>
 */
public interface SysVariablesDao<SysVariables> extends BaseDao<SysVariables> {
	 int add(SysVariables t);
		
	 int update(SysVariables t);
	
	 int delete(@Param(value="id")String id);
	
	 int logicdelete(@Param(value="id")String id);
	
}
