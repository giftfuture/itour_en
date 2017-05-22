package com.itour.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itour.base.dao.BaseDao;

/**
 * SysRole Mapper
 * @author Administrator
 *
 */
public interface SysRoleDao<SysMenuBtn> extends BaseDao<SysMenuBtn> {
	
	/**
	 *查询全部有效的权限
	 * @return
	 */
	public List<SysMenuBtn> queryAllList();
	
	
	/**
	 *根据用户Id查询权限
	 * @return
	 */
	public List<SysMenuBtn> queryByUserid(@Param(value="userid")String userid);
	
	/**
	 * 
	 * @return
	 */
	public int maxNumber();
}
