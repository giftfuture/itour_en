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
import com.itour.convert.AdLinkKit;
import com.itour.dao.AdLinkDao;
import com.itour.entity.AdLink;
import com.itour.vo.AdLinkVO;
@Service 
public class AdLinkService extends BaseService<AdLink>{

	protected final Logger logger =  LoggerFactory.getLogger(getClass());

	@Autowired
    private AdLinkDao mapper;
		
	public AdLinkDao getDao(){
		return mapper;
	}
		
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */

	public BasePage<Map<String, String>> pagedQuery(AdLinkVO vo) {
		List<AdLink> list = mapper.queryByList(vo);
		int count = mapper.queryByCount(vo);
		List<Map<String, String>> records = Lists.newArrayList();
		for(int i = 0; i < list.size(); i++) {
			AdLink areas = list.get(i);
			records.add(AdLinkKit.toRecord(areas));
		}
		return new BasePage<Map<String, String>>(vo.getStart(), vo.getLimit(), records, count);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<AdLink> allAdLink(){
		 List<AdLink> allinks =  mapper.queryAll();
		 return allinks;
	}
	
}
