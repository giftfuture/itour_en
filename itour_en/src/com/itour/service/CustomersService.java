package com.itour.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.itour.base.page.BasePage;
import com.itour.base.service.BaseService;
import com.itour.convert.CustomerKit;
import com.itour.dao.CustomersDao;
import com.itour.entity.Customers;
import com.itour.vo.CustomerVo;

/**
 * 
 * <br>
 * <b>功能：</b>CustomersService<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
@Service("customersService")
public class CustomersService extends BaseService<Customers> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());

	@Autowired
    private CustomersDao mapper;
		
	public CustomersDao getDao(){
		return mapper;
	}

	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */

	public BasePage<Map<String, Object>> pagedQuery(CustomerVo vo) {
		List<Customers> list = mapper.queryByList(vo);
		int count = mapper.queryByCount(vo);
		//BasePage<CustomerVo> basepage = (BasePage<CustomerVo>)mapper.pagedQuery(page);
		//Map<String, String> map = Maps.newHashMap();
		List<Map<String, Object>> records = Lists.newArrayList();
		for(int i = 0; i < list.size(); i++) {
			Customers customers = list.get(i);
			records.add(CustomerKit.toRecord(customers));
		}
		return new BasePage<Map<String, Object>>(vo.getStart(), vo.getLimit(), records, count);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<CustomerVo> queryOrdersByCid(String id){
		return mapper.queryOrdersByCid(id);
	};
	public CustomerVo selectById(String id){
		return mapper.selectById(id);
	};
}
