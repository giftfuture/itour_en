package com.itour.dao;

import java.util.List;

import com.itour.base.dao.BaseDao;
import com.itour.entity.SysRoleRel;

/**
 * SysRoleRel Mapper
 * @author Administrator
 *
 */
public interface SysRoleRelDao<SysMenuBtn> extends BaseDao<SysMenuBtn> {
	
	public void deleteByRoleId(java.util.Map<String, Object> param);
	
	public void deleteByObjId(java.util.Map<String, Object> param);
	
	public void logicdeleteByRoleId(java.util.Map<String, Object> param);
	
	public void logicdeleteByObjId(java.util.Map<String, Object> param);
	
	public List<SysRoleRel> queryByRoleId(java.util.Map<String, Object> param);
	
	public List<SysRoleRel> queryByObjId(java.util.Map<String, Object> param);
	
	
}
