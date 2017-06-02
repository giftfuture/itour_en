package com.itour.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.itour.base.entity.BaseEntity.STATE;
import com.itour.base.page.BasePage;
import com.itour.base.service.BaseService;
import com.itour.base.util.SessionUtils;
import com.itour.convert.SysMenuKit;
import com.itour.convert.SysRoleKit;
import com.itour.dao.SysRoleDao;
import com.itour.entity.SysMenu;
import com.itour.entity.SysRole;
import com.itour.entity.SysRoleRel;
import com.itour.entity.SysUser;
import com.itour.entity.SysRoleRel.RelType;
import com.itour.vo.SysMenuVO;
import com.itour.vo.SysRoleVO;

/**
 * 
 * <br>
 * <b>功能：</b>SysRoleService<br>
 * <b>作者：</b>fred<br>
 * <b>日期：</b> Jun 9, 2016 <br>
 */
@Service("sysRoleService")
public class SysRoleService<T> extends BaseService<T> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SysRoleRelService<SysRoleRel> sysRoleRelService;
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public BasePage<SysRoleVO> pagedQuery(SysRoleVO vo) {
		List<SysRole> list = (List<SysRole>) mapper.queryByList(vo);
		int count = mapper.queryByCount(vo);
		List<SysRoleVO>	vos = Lists.newArrayList();
		for(SysRole sv:list){
			vos.add(SysRoleKit.toRecord(sv));
		}
		return new BasePage<SysRoleVO>(vo.getStart(), vo.getLimit(), vos, count);
	}
	/**
	 * 添加角色&菜单关系
	 */
	public void addRoleMenuRel(String roleId,String[] menuIds,String creater) throws Exception{
		if(roleId == null ||  menuIds == null || menuIds.length < 1 ){ 
			return;
		}
		for(String menuid :menuIds ){ 
			SysRoleRel rel = new SysRoleRel();
			rel.setRoleId(roleId);
			rel.setObjId(menuid);
			rel.setRelType(RelType.MENU.key);
			rel.setCreateBy(creater);
			rel.setUpdateBy(creater);
			sysRoleRelService.add(rel);
		}
	}
		
	/**
	 * 添加角色&菜单关系
	 */
	public void addRoleBtnRel(String roleId,String[] btnIds,String creater) throws Exception{
		if(roleId == null ||  btnIds == null || btnIds.length < 1 ){ 
			return;
		}
		for(String btnid : btnIds ){ 
			SysRoleRel rel = new SysRoleRel();
			rel.setRoleId(roleId);
			rel.setObjId(btnid);
			rel.setRelType(RelType.BTN.key);
			rel.setCreateBy(creater);
			rel.setUpdateBy(creater);
			sysRoleRelService.add(rel);
		}
	}
		
	
	/**
	 * 添加
	 * @param role
	 * @param menuIds
	 * @throws Exception
	 */
	public String add(SysRole role,String[] menuIds,String[] btnIds,String creater) throws Exception {
		String id = super.add((T)role);
		addRoleMenuRel(role.getId(),menuIds,creater);
		addRoleBtnRel(role.getId(),btnIds,creater);
		return id;
	}

	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String[] ids) throws Exception {
		super.delete(ids);
		for(String id : ids){
			//清除关联关系
			sysRoleRelService.deleteByRoleId(id);
		}
	}

	/**
	 * 修改
	 * @param role
	 * @param menuIds
	 * @throws Exception
	 */
	public void update(SysRole role,String[] menuIds,String[] btnIds,String creater) throws Exception {
		super.update((T)role);
		//如果角色被禁用则删除关联的用户关系
		if(STATE.DISABLE.key == role.getState()){
			sysRoleRelService.deleteByRoleId(role.getId(),RelType.USER.key);
		}
		//清除关联关系
		sysRoleRelService.deleteByRoleId(role.getId(),RelType.MENU.key);
		sysRoleRelService.deleteByRoleId(role.getId(),RelType.BTN.key);
			addRoleMenuRel(role.getId(),menuIds,creater);
			addRoleBtnRel(role.getId(),btnIds,creater);
		
	}

	
	/**
	 *查询全部有效的权限
	 * @return
	 */
	public List<T> queryAllList(){
		return getDao().queryAllList();
	}

	/**
	 *查询全部有效的权限
	 * @return
	 */
	public List<T> queryByUserid(String userid){
		return getDao().queryByUserid(userid);
	}
	/**
	 * 
	 * @return
	 */
	public int maxNumber(){
		return getDao().maxNumber();
	}
	
	@Autowired
    private SysRoleDao<T> mapper;

		
	public SysRoleDao<T> getDao() {
		return mapper;
	}

}
