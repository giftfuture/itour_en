package com.itour.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itour.base.dao.BaseDao;
import com.itour.base.service.BaseService;
import com.itour.dao.SysMenuBtnDao;

/**
 * 
 * <br>
 * <b>功能：</b>SysMenuBtnService<br>
 * <b>作者：</b>fred<br>@Autowired
 * <b>日期：</b> Jun 9, 2016 <br>
 */
@Service("sysMenuBtnService")
public class SysMenuBtnService<T> extends BaseService<T> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	
	public List<T> queryByAll(){
		return getDao().queryByAll();
	}
	
	public List<T> queryByMenuid(String menuid){
		return getDao().queryByMenuid(menuid);
	}
	
	public List<T> queryByMenuUrl(String url){
		return getDao().queryByMenuUrl(url);
	}
	
	public void deleteByMenuid(String menuid){
		getDao().deleteByMenuid(menuid);
	}
	
	public void logicdeleteByMenuid(String menuid){
		getDao().logicdeleteByMenuid(menuid);
	}
	
	public List<T> getMenuBtnByUser(String userid){
		return getDao().getMenuBtnByUser(userid);
	}
	
	@Autowired
    private SysMenuBtnDao<T> mapper;

		
	public SysMenuBtnDao<T> getDao() {
		return mapper;
	}

}
