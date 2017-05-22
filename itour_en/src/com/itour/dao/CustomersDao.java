package com.itour.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itour.base.dao.BaseDao;
import com.itour.entity.Customers;
import com.itour.vo.CustomerVo;
/**
 * 
 * <br>
 * <b>功能：</b>CustomersDao<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2013 <br>
 */
public interface CustomersDao extends BaseDao<Customers> {
	
	List<CustomerVo> queryOrdersByCid(@Param(value="id")String id);
	CustomerVo selectById(@Param(value="id")String id);
}
