package com.itour.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

import com.itour.base.dao.BaseDao;
import com.itour.entity.SysUser;
import com.itour.vo.SysUserVo;

/**
 * SysUser Mapper
 * @author Administrator
 *
 */
public interface SysUserDao<SysMenuBtn> extends BaseDao<SysMenuBtn> {
	
	/**
	 * 检查登录
	 * @param email
	 * @param pwd
	 * @return
	 */
	SysMenuBtn queryLogin(SysUserVo model);
	
	
	/**
	 * 查询邮箱总数，检查是否存在
	 * @param email
	 * @return
	 */
	int getUserCountByEmail(@Param(value="email")String email);
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	void updateCode(HashMap map);
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	SysUser getUserByEmail(@Param(value="email")String email);
}
