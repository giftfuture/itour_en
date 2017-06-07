package com.itour.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itour.base.service.BaseService;
import com.itour.dao.SysRoleRelDao;
import com.itour.entity.SysRoleRel;

/**
 * 
 * <br>
 * <b>功能：</b>SysRoleRelService<br>
 * <b>作者：</b>fred<br>
 * <b>日期：</b> Jun 9, 2016 <br>
 */
@Service//("sysRoleRelService")
public class SysRoleRelService<T> extends BaseService<T> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	
	/**
	 * 
	 * @param roleId
	 * @param relType
	 * @return
	 */
	public List<SysRoleRel> queryByRoleId(String roleId,Integer relType){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", roleId);
		param.put("relType", relType);
		return getDao().queryByRoleId(param);
	}
	
	/**
	 * 
	 * @param objId
	 * @param relType
	 * @return
	 */
	public List<SysRoleRel> queryByObjId(String objId,Integer relType){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("objId", objId);
		param.put("relType", relType);
		return getDao().queryByObjId(param);
	}
	
	/**
	 * 根据关联对象id,关联类型删除 
	 * @param objId
	 * @param relType
	 */
	public void deleteByObjId(String objId,Integer relType){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("objId", objId);
		param.put("relType", relType);
		getDao().deleteByObjId(param);
	}
	/**
	 * 根据关联对象id,关联类型删除 
	 * @param objId
	 * @param relType
	 */
	public void logicdeleteByObjId(String objId,Integer relType){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("objId", objId);
		param.put("relType", relType);
		getDao().logicdeleteByObjId(param);
	}
	/**
	 * 根据角色id删除 
	 * @param roleId
	 */
	public void deleteByRoleId(String roleId){
		deleteByRoleId(roleId,null);
	}
	/**
	 * 根据角色id删除 
	 * @param roleId
	 */
	public void logicdeleteByRoleId(String roleId){
		logicdeleteByRoleId(roleId,null);
	}
	/**
	 *  根据角色id,关联类型删除 
	 * @param roleId
	 * @param relType
	 */
	public void deleteByRoleId(String roleId,Integer relType){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", roleId);
		param.put("relType", relType);
		getDao().deleteByRoleId(param);
	}
	
	/**
	 *  根据角色id,关联类型删除 
	 * @param roleId
	 * @param relType
	 */
	public void logicdeleteByRoleId(String roleId,Integer relType){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", roleId);
		param.put("relType", relType);
		getDao().logicdeleteByRoleId(param);
	}
	@Autowired
    private SysRoleRelDao<T> mapper;

		
	public SysRoleRelDao<T> getDao() {
		return mapper;
	}

}
