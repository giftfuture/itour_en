package com.itour.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.itour.base.page.BasePage;
import com.itour.base.service.BaseService;
import com.itour.convert.SysMenuKit;
import com.itour.dao.SysVariablesDao;
import com.itour.entity.SysMenu;
import com.itour.entity.SysVariables;
import com.itour.vo.SysMenuVO;
import com.itour.vo.SysVariablesVO;

/**
 * 
 * <br>
 * <b>功能：</b>SysVariablesService<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
@Service("sysVariablesService")
public class SysVariablesService<T> extends BaseService<T> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public BasePage<SysVariables> pagedQuery(SysVariablesVO vo) {
		List<SysVariables> list = (List<SysVariables>) mapper.queryByList(vo);
		int count = mapper.queryByCount(vo);
		return new BasePage<SysVariables>(vo.getStart(), vo.getLimit(), list, count);
	}
	@Autowired
    private SysVariablesDao<T> mapper;
		
	public SysVariablesDao<T> getDao() {
		return mapper;
	}

}
