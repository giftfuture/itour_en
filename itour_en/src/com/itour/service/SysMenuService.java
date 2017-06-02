package com.itour.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.itour.base.page.BasePage;
import com.itour.base.service.BaseService;
import com.itour.convert.CustomerKit;
import com.itour.convert.SysMenuKit;
import com.itour.dao.SysMenuDao;
import com.itour.entity.Customers;
import com.itour.entity.SysMenu;
import com.itour.entity.SysMenuBtn;
import com.itour.entity.SysRoleRel;
import com.itour.entity.SysRoleRel.RelType;
import com.itour.vo.CustomerVO;
import com.itour.vo.SysMenuVO;

/**
 * 
 * <br>
 * <b>功能：</b>SysMenuService<br>
 * <b>日期：</b> Jun 9, 2016 <br>
 */
@Service("sysMenuService")
public class SysMenuService<T> extends BaseService<T> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());


	@Autowired(required=false)
	private SysRoleRelService<SysRoleRel> sysRoleRelService;
	
	@Autowired(required=false)
	private SysMenuBtnService<SysMenuBtn> sysMenuBtnService;
	
	@Autowired
    private SysMenuDao<T> mapper;
	
	/**
	 * 保存菜单btn
	 * @param btns
	 * @throws Exception 
	 */
	public void saveBtns(SysMenu menu,List<SysMenuBtn> btns) throws Exception{
		if(btns == null || btns.isEmpty()){
			return;
		}
		for (SysMenuBtn btn : btns) {
			if(btn.getId()!= null && "1".equals(btn.getDeleteFlag())){
				sysMenuBtnService.delete(btn.getId());
				continue;
			}
			btn.setDeleted(0);
			btn.setActions("0");
			btn.setMenuid(menu.getId());
			if(btn.getId() == null){
				btn.setCreateBy(menu.getUpdateBy());
				sysMenuBtnService.add(btn);
			}else{
				sysMenuBtnService.update(btn);
			}
		}
		
	}
	
	/**
	 * 
	 * @param menu
	 * @throws Exception
	 */
	public String add(SysMenu menu) throws Exception {
		String id = super.add((T)menu);
		saveBtns(menu,menu.getBtns());
		return id;
	}




	public void update(SysMenu menu) throws Exception {
		super.update((T)menu);
		saveBtns(menu,menu.getBtns());
	}




	/**
	 * 查询所有系统菜单列表
	 * @return
	 */
	public List<T> queryByAll(){
		return mapper.queryByAll();
	}
	
	/**
	 * 获取顶级菜单
	 * @return
	 */
	public List<T> getRootMenu(String menuId){
		return mapper.getRootMenu(menuId);
	}
	
	/**
	 * 获取子菜单
	 * @return
	 */
	public List<T> getChildMenu(String parentId){
		return mapper.getChildMenu(parentId);
	}
	
	/**
	 * 根据用户id查询父菜单
	 * @param roleId
	 * @return
	 */
	public List<T> getRootMenuByUser(String userId){
		return getDao().getRootMenuByUser(userId);
	}
	
	
	/**
	 * 根据用户id查询子菜单
	 * @param roleId
	 * @return
	 */
	public List<T> getChildMenuByUser(String userId){
		//Map<String, String> map = new HashMap<String, String>();
		//map.put("userId", userId);
		return getDao().getChildMenuByUser(userId);
	}
	
	
	/**
	 * 根据权限id查询菜单
	 * @param roleId
	 * @return
	 */
	public List<T> getMenuByRoleId(String roleId){
		//Map<String, String> map = new HashMap<String, String>();
		//map.put("roleId", roleId);
		return getDao().getMenuByRoleId(roleId);
	}
	
	
	
	@Override
	public void delete(String[] ids) throws Exception {
		super.delete(ids);
		//删除关联关系
		for(String id : ids){
			sysRoleRelService.deleteByObjId(id, RelType.MENU.key);
			sysMenuBtnService.deleteByMenuid(id);
		}
	}

	

	/**
	 * 获取表中最大rank
	 * @return
	 */
	public int maxRank() {
		return  getDao().maxRank();
	}
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public BasePage<Map<String, Object>> pagedQuery(SysMenuVO vo) {
		List<SysMenu> list = (List<SysMenu>) mapper.queryByList(vo);
		int count = mapper.queryByCount(vo);
		List<Map<String, Object>> records = Lists.newArrayList();
		for(SysMenu menu : list) {
			records.add(SysMenuKit.toRecord(menu));
		}
		return new BasePage<Map<String, Object>>(vo.getStart(), vo.getLimit(), records, count);
	}
	public SysMenuDao<T> getDao() {
		return mapper;
	}

}
