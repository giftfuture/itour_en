package com.itour.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.itour.base.page.BasePage;
import com.itour.base.service.BaseService;
import com.itour.convert.SysUserKit;
import com.itour.dao.SysRoleDao;
import com.itour.dao.SysUserDao;
import com.itour.entity.SysRole;
import com.itour.entity.SysRoleRel;
import com.itour.entity.SysRoleRel.RelType;
import com.itour.entity.SysUser;
import com.itour.vo.SysUserVo;

/**
 * 
 * <br>
 * <b>功能：</b>SysUserService<br>
 * <b>作者：</b>fred<br>
 * <b>日期：</b> Jun 9, 2016 <br>
 */
@Service("sysUserService")
public class SysUserService<T> extends BaseService<T> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SysRoleRelService<SysRoleRel> sysRoleRelService;
	@Autowired
	private SysRoleDao<SysRole> sysRoleDao;
	
	
	@Override
	public void delete(String[] ids) throws Exception {
		super.delete(ids);
		for(String id :  ids){
			sysRoleRelService.deleteByObjId(id, RelType.USER.key);
		}
	}
	/**
	 * 检查登录
	 * @param email
	 * @param pwd
	 * @return
	 */
	public T queryLogin(String email,String pwd){
		SysUserVo model = new SysUserVo();
		model.setEmail(email);
		model.setPwd(pwd);
		SysUserDao<T> mapper = getDao();
		mapper.queryById("");
		return getDao().queryLogin(model);
	}
	
	/**
	 * 查询邮箱总数，检查是否存在
	 * @param email
	 * @return
	 */
	public int getUserCountByEmail(String email){
		return getDao().getUserCountByEmail(email);
	}
	
	/**
	 * 查询用户权限
	 * @param userId
	 * @return
	 */
	public List<SysRoleRel> getUserRole(String userId){
		return sysRoleRelService.queryByObjId(userId,RelType.USER.key);
	}
	
	/**
	 * 添加用户权限
	 * @param userId
	 * @param roleIds
	 * @throws Exception
	 */
	public List<String> addUserRole(String userId,String[] roleIds) throws Exception{
		List<String> list = Lists.newArrayList();
		if(userId == null ||  roleIds == null || roleIds.length < 1 ){ 
			return list;
		}
		//清除关联关系
		sysRoleRelService.deleteByObjId(userId, RelType.USER.key);
		for(String roleId :roleIds){ 
			SysRoleRel rel = new SysRoleRel();
			rel.setRoleId(roleId);
			rel.setObjId(userId);
			rel.setRelType(RelType.USER.key);
			list.add(sysRoleRelService.add(rel));
		}
		return list;
	}

	public void updateCode(HashMap map){
		getDao().updateCode(map);
	};
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public BasePage<SysUserVo> pagedQuery(SysUserVo vo) {
		List<SysUser> list = (List<SysUser>) mapper.queryByList(vo);
		int count = mapper.queryByCount(vo);
		List<SysUserVo>	vos = Lists.newArrayList();
		for(SysUser user:list){
			List<SysRole> roleRels = sysRoleDao.queryByUserid(user.getId());
			user.setRoleStr(rolesToStr(roleRels));
			vos.add(SysUserKit.toRecord(user));
		}
		return new BasePage<SysUserVo>(vo.getStart(), vo.getLimit(), vos, count);
	}
	/**
	 * 
	 * @param email
	 * @return
	 */
	public SysUser getUserByEmail(String email){
	  return getDao().getUserByEmail(email);
	};
	
	/**
	 * 角色列表转成字符串
	 * @param list
	 * @return
	 */
	private String rolesToStr(List<SysRole> list){
		if(list == null || list.isEmpty()){
			return null;
		}
		StringBuffer str = new StringBuffer();
		for(int i=0;i<list.size();i++){
			SysRole role = list.get(i);
			str.append(role.getRoleName());
			if((i+1) < list.size()){
				str.append(",");
			}
		}
		return str.toString();
	}
	
	@Autowired
    private SysUserDao<T> mapper;

		
	public SysUserDao<T> getDao() {
		return mapper;
	}

}
