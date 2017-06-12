package com.itour.service;

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
import com.itour.convert.AreasKit;
import com.itour.dao.AreasDao;
import com.itour.entity.Areas;
import com.itour.vo.AdLinkVO;
@Service 
public class AreasService extends BaseService<Areas>{

	protected final Logger logger =  LoggerFactory.getLogger(getClass());

	@Autowired
    private AreasDao mapper;
		
	public AreasDao getDao(){
		return mapper;
	}
		
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */

	public BasePage<Map<String, String>> pagedQuery(AdLinkVO vo) {
			List<Areas> list = mapper.queryByList(vo);
			int count = mapper.queryByCount(vo);
			List<Map<String, String>> records = Lists.newArrayList();
			for(int i = 0; i < list.size(); i++) {
				Areas areas = list.get(i);
				records.add(AreasKit.toRecord(areas));
			}
			return new BasePage<Map<String, String>>(vo.getStart(), vo.getLimit(), records, count);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Areas> allAreas(){
		return mapper.queryAll();
	}
	
	/**
	 * 
	 * @param pinyin
	 * @return
	 */
	public Areas queryByPinyin(String pinyin){
		return mapper.queryByPinyin(pinyin);
	};
}
