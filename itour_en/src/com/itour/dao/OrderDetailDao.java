package com.itour.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itour.base.dao.BaseDao;
import com.itour.base.page.BasePage;
import com.itour.entity.OrderDetail;
import com.itour.vo.OrderDetailVO;
/**
 * 
 * <br>
 * <b>功能：</b>OrderDetailDao<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2013 <br>
 */
public interface OrderDetailDao<T> extends BaseDao<T> {
	OrderDetailVO queryByOrderId(@Param(value="orderId")String orderId);
	List<String> queryGroupCode(@Param(value="groupCode")String groupCode);
	List<OrderDetailVO> queryByListVo(BasePage page);
}
