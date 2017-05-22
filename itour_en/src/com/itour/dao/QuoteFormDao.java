package com.itour.dao;

import org.apache.ibatis.annotations.Param;

import com.itour.base.dao.BaseDao;
import com.itour.entity.QuoteForm;
import com.itour.vo.QuoteFormVo;

public interface QuoteFormDao extends BaseDao<QuoteForm> {
	QuoteForm queryByRtId(@Param(value="routeTemplate")String routeTemplate); 
	QuoteFormVo selectById(@Param(value="id")String id); 
}
