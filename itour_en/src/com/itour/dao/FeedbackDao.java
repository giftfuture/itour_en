package com.itour.dao;


import java.util.List;

import com.itour.base.dao.BaseDao;
import com.itour.entity.Feedback;
import com.itour.vo.FeedbackVO;
/**
 * 
 * <br>
 * <b>功能：</b>FeedbackDao<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2013 <br>
 */
public interface FeedbackDao extends BaseDao<Feedback> {
	
	List<Feedback> allFeedback();
	List<FeedbackVO> queryByListVo(FeedbackVO vo);
	int queryByCountVO(FeedbackVO vo);
}
