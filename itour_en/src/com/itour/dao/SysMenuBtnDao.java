package com.itour.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itour.base.dao.BaseDao;

/**
 * SysMenuBtn Mapper
 * @author Administrator
 *
 */
public interface SysMenuBtnDao<SysMenuBtn> extends BaseDao<SysMenuBtn> {
	
	public List<SysMenuBtn> queryByMenuid(@Param(value="menuid")String menuid);
	
	public List<SysMenuBtn> queryByMenuUrl(@Param(value="url")String url); 
	
	public void deleteByMenuid(@Param(value="menuid")String menuid);
	
	public void logicdeleteByMenuid(@Param(value="menuid")String menuid);
	
	public List<SysMenuBtn> getMenuBtnByUser(@Param(value="userId")String userId); 
	
	public List<SysMenuBtn> queryByAll();
	
}
