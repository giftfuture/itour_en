package com.itour.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itour.base.service.BaseService;
import com.itour.dao.LogSettingDetailDao;

/**
 * 
 * <br>
 * <b>功能：</b>LogSettingDetailService<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
@Service("logSettingDetailService")
public class LogSettingDetailService<T> extends BaseService<T> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());

	@Autowired
    private LogSettingDetailDao<T> mapper;

		
	public LogSettingDetailDao<T> getDao() {
		return mapper;
	}

}
