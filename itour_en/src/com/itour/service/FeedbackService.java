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
import com.itour.dao.FeedbackDao;
import com.itour.entity.Feedback;
import com.itour.vo.FeedbackVo;

/**
 * 
 * <br>
 * <b>功能：</b>FeedbackService<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
@Service("feedbackService")
public class FeedbackService extends BaseService<Feedback> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());

	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */
	public BasePage<FeedbackVo> pagedQuery(FeedbackVo vo) {
		List<Feedback> list = (List<Feedback>) mapper.queryByList(vo);
		int count = mapper.queryByCount(vo);
		List<FeedbackVo> records = Lists.newArrayList();
		for(Feedback fb:list) {
			records.add(FeedbackKit.toRecord(fb));
		}
		return new BasePage<FeedbackVo>(vo.getStart(), vo.getLimit(), records, count);
	}
	
	@Autowired
    private FeedbackDao mapper;

		
	public FeedbackDao getDao() {
		return mapper;
	}

}
