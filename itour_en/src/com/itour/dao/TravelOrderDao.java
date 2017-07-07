package com.itour.dao;


import java.util.List;

import com.itour.base.dao.BaseDao;
import com.itour.entity.TravelOrder;
/**
 * 
 * <br>
 * <b>功能：</b>TravelOrderDao<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2013 <br>
 */
public interface TravelOrderDao<T> extends BaseDao<T> {
	
	List<TravelOrder> unDealedOrders();
}
