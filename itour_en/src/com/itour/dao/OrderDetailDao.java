package com.itour.dao;


import org.apache.ibatis.annotations.Param;

import com.itour.base.dao.BaseDao;
import com.itour.entity.OrderDetail;
/**
 * 
 * <br>
 * <b>功能：</b>OrderDetailDao<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2013 <br>
 */
public interface OrderDetailDao<T> extends BaseDao<T> {
	OrderDetail queryByOrderId(@Param(value="orderId")String orderId);
	
}
