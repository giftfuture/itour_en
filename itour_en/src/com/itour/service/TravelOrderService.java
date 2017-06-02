package com.itour.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.itour.base.page.BasePage;
import com.itour.base.service.BaseService;
import com.itour.convert.TravelOrderKit;
import com.itour.convert.TravelStyleKit;
import com.itour.dao.TravelOrderDao;
import com.itour.entity.TravelOrder;
import com.itour.entity.TravelStyle;
import com.itour.vo.TravelOrderVO;
import com.itour.vo.TravelStyleVO;

/**
 * 
 * <br>
 * <b>功能：</b>TravelOrderService<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
@Service("travelOrderService")
public class TravelOrderService<T> extends BaseService<T> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public BasePage<TravelOrderVO> pagedQuery(TravelOrderVO vo) {
		List<TravelOrder> list = (List<TravelOrder>) mapper.queryByList(vo);
		int count = mapper.queryByCount(vo);
		List<TravelOrderVO> records = Lists.newArrayList();
		try {
			for (TravelOrder to : list) {
				records.add(TravelOrderKit.toVo(to));
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BasePage<TravelOrderVO>(vo.getStart(), vo.getLimit(), records,count);
	}
	@Autowired
    private TravelOrderDao<T> mapper;

		
	public TravelOrderDao<T> getDao() {
		return mapper;
	}

}
