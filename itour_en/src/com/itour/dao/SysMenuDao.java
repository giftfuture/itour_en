package com.itour.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itour.base.dao.BaseDao;

/**
 * SysMenu Mapper
 * @author Administrator
 *
 */
public interface SysMenuDao<SysMenuBtn> extends BaseDao<SysMenuBtn> {
	
	/**
	 * 查询所有系统菜单列表
	 * @return
	 */
	List<SysMenuBtn> queryByAll();
	
	
	/**
	 * 获取顶级菜单
	 * @return
	 */
	List<SysMenuBtn> getRootMenu(@Param(value="menuId")java.lang.String menuId);
	
	/**
	 * 获取子菜单
	 * @return
	 */
	List<SysMenuBtn> getChildMenu(@Param(value="parentId")java.lang.String parentId);
	
	

	/**
	 * 根据权限id查询菜单
	 * @param roleId
	 * @return
	 */
	List<SysMenuBtn> getMenuByRoleId(@Param(value="roleId")java.lang.String roleId);
	
	
	/**
	 * 根据用户id查询父菜单菜单
	 * @param userId
	 * @return
	 */
	List<SysMenuBtn> getRootMenuByUser(@Param(value="userId")java.lang.String userId);
	
	/**
	 * 根据用户id查询子菜单菜单
	 * @param userId
	 * @return
	 */
	List<SysMenuBtn> getChildMenuByUser(@Param(value="userId")java.lang.String userId);
	
	/**
	 * 获取表中最大rank
	 * @return
	 */
	int maxRank();
	
}
