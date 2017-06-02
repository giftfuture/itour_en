package com.itour.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.itour.base.page.BasePage;
import com.itour.base.service.BaseService;
import com.itour.convert.SysMenuKit;
import com.itour.convert.TravelStyleKit;
import com.itour.dao.TravelStyleDao;
import com.itour.entity.TravelStyle;
import com.itour.vo.TravelStyleVO;

/**
 * 
 * <br>
 * <b>功能：</b>TravelStyleService<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
@Service("travelStyleService")
public class TravelStyleService<T> extends BaseService<T> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public BasePage<TravelStyleVO> pagedQuery(TravelStyleVO vo) {
		List<TravelStyle> list = (List<TravelStyle>) mapper.queryByList(vo);
		int count = mapper.queryByCount(vo);
		List<TravelStyleVO> records = Lists.newArrayList();
		for(TravelStyle ts:list) {
			records.add(TravelStyleKit.toRecord(ts));
		}
		return new BasePage<TravelStyleVO>(vo.getStart(), vo.getLimit(), records, count);
	}
	/**
	 * 
	 * @param alias
	 * @return
	 */
	public TravelStyle queryByAlias(String alias){
		List<TravelStyle> list = mapper.queryByAlias(alias);
		if(list != null && list.size()>= 1){
			return list.get(0);
		}
		return new TravelStyle();
	};
	/**
	 * 
	 * @return
	 */
	public List<Map<String,Object>> loadStyles(){
		return mapper.loadStyles();
	};
	@Autowired
    private TravelStyleDao<T> mapper;

		
	public TravelStyleDao<T> getDao() {
		return mapper;
	}
	public List<TravelStyle> queryValid(){
		return mapper.queryValid();
	};
	public void updateCover(TravelStyle ts){
		mapper.updateCover(ts);
	};
}
