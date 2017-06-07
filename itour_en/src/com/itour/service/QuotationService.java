package com.itour.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.itour.base.page.BasePage;
import com.itour.base.service.BaseService;
import com.itour.convert.FeedbackKit;
import com.itour.convert.QuotationKit;
import com.itour.dao.QuotationDao;
import com.itour.entity.Feedback;
import com.itour.entity.Quotation;
import com.itour.vo.FeedbackVO;
import com.itour.vo.QuotationVO;

/**
 * 
 * <br>
 * <b>功能：</b>QuotationService<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
@Service//("quotationService")
public class QuotationService<T> extends BaseService<T> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public BasePage<QuotationVO> pagedQuery(QuotationVO vo) {
		List<Quotation> list = (List<Quotation>) mapper.queryByList(vo);
		int count = mapper.queryByCount(vo);
		List<QuotationVO> records = Lists.newArrayList();
		for(Quotation fb:list) {
			records.add(QuotationKit.toRecord(fb));
		}
		return new BasePage<QuotationVO>(vo.getStart(), vo.getLimit(), records, count);
	}
	
	@Autowired
    private QuotationDao<T> mapper;

		
	public QuotationDao<T> getDao() {
		return mapper;
	}

}
