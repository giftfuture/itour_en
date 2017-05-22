package com.itour.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.itour.base.page.BasePage;
import com.itour.base.service.BaseService;
import com.itour.convert.QuoteFormKit;
import com.itour.dao.QuoteFormDao;
import com.itour.entity.QuoteForm;
import com.itour.vo.QuoteFormVo;
@Service("quoteFormService")
public class QuoteFormService extends BaseService<QuoteForm> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */
	public BasePage<QuoteFormVo> pagedQuery(QuoteFormVo vo) {
		List<QuoteForm> list = (List<QuoteForm>) mapper.queryByList(vo);
		int count = mapper.queryByCount(vo);
		List<QuoteFormVo> records = Lists.newArrayList();
		for(QuoteForm fb:list) {
			records.add(QuoteFormKit.toVo(fb));
		}
		return new BasePage<QuoteFormVo>(vo.getStart(), vo.getLimit(), records, count);
	}
	public QuoteFormVo selectById(String id){
		return mapper.selectById(id);
	}
	public QuoteFormVo queryByRtId(String routeTemplate){
		QuoteForm qf = mapper.queryByRtId(routeTemplate);
		return QuoteFormKit.toVo(qf);
	}
	@Autowired
    private QuoteFormDao mapper;

		
	public QuoteFormDao getDao() {
		return mapper;
	}
}
