package com.itour.convert;

import java.text.ParseException;

import org.apache.commons.lang3.StringUtils;

import com.itour.base.util.DateUtil;
import com.itour.entity.TravelOrder;
import com.itour.vo.TravelOrderVo;
/**
 * 
 * <br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class TravelOrderKit{
	
	public static TravelOrderVo toVo(TravelOrder to)throws Exception{
		TravelOrderVo tv = new TravelOrderVo();
		tv.setBank(to.getBank());
		tv.setBudget(to.getBudget());
		tv.setCreateTime(DateUtil.getDateYmdHs(to.getCreateTime()));
		tv.setCustomerId(to.getCustomerId());
		tv.setExpectedBack(DateUtil.getDateYmdCn(to.getExpectedBack()));
		tv.setExpectedDepart(DateUtil.getDateYmdCn(to.getExpectedDepart()));
		tv.setId(to.getId());
		tv.setIsPayed(to.getIsPayed());
		tv.setOrderItems(to.getOrderItems());
		tv.setOrderName(to.getOrderName());
		tv.setOrderNo(to.getOrderNo());
		tv.setOrderStatus(to.getOrderStatus());
		tv.setPayAccount(to.getPayAccount());
		tv.setPayPlatform(to.getPayPlatform());
		tv.setPayTerminal(to.getPayTerminal());
		tv.setPayTime(DateUtil.getDateYmdHs(to.getPayTime()));
		tv.setPayType(to.getPayType());
		tv.setReceiver(to.getReceiver());
		tv.setReceiverMobile(to.getReceiverMobile());
		tv.setRemark(to.getRemark());
		tv.setTotalStaff(to.getTotalStaff());
		tv.setUpdateTime(DateUtil.getDateYmdHs(to.getUpdateTime()));
		tv.setValid(to.isValid());
		tv.setRoutename(to.getRoutename());
		tv.setReceiveremail(to.getReceiveremail());
		tv.setGender(to.isGender());
		tv.setRouteId(to.getRouteId());
		return tv;
	}
	public static TravelOrderVo toEditVo(TravelOrder to)throws Exception{
		TravelOrderVo tv = new TravelOrderVo();
		tv.setBank(to.getBank());
		tv.setBudget(to.getBudget());
		tv.setCreateTime(DateUtil.getDateYmdHs(to.getCreateTime()));
		tv.setCustomerId(to.getCustomerId());
		tv.setExpectedBack(DateUtil.getFormattedDateUtil(to.getExpectedBack(),DateUtil.y_m_d));
		tv.setExpectedDepart(DateUtil.getFormattedDateUtil(to.getExpectedDepart(),DateUtil.y_m_d));
		tv.setId(to.getId());
		tv.setIsPayed(to.getIsPayed());
		tv.setOrderItems(to.getOrderItems());
		tv.setOrderName(to.getOrderName());
		tv.setOrderNo(to.getOrderNo());
		tv.setOrderStatus(to.getOrderStatus());
		tv.setPayAccount(to.getPayAccount());
		tv.setPayPlatform(to.getPayPlatform());
		tv.setPayTerminal(to.getPayTerminal());
		tv.setPayTime(DateUtil.getDateYmdHs(to.getPayTime()));
		tv.setPayType(to.getPayType());
		tv.setReceiver(to.getReceiver());
		tv.setReceiverMobile(to.getReceiverMobile());
		tv.setRemark(to.getRemark());
		tv.setTotalStaff(to.getTotalStaff());
		tv.setUpdateTime(DateUtil.getDateYmdHs(to.getUpdateTime()));
		tv.setValid(to.isValid());
		tv.setRoutename(to.getRoutename());
		tv.setReceiveremail(to.getReceiveremail());
		tv.setGender(to.isGender());
		tv.setRouteId(to.getRouteId());
		return tv;
	}
	public static TravelOrder toRecord(TravelOrderVo to)throws Exception{
		TravelOrder tv = new TravelOrder();
		tv.setBank(to.getBank());
		tv.setBudget(to.getBudget());
		tv.setCustomerId(to.getCustomerId());
		tv.setId(to.getId());
		tv.setIsPayed(to.getIsPayed());
		tv.setOrderItems(to.getOrderItems());
		tv.setOrderName(to.getOrderName());
		tv.setOrderNo(to.getOrderNo());
		tv.setOrderStatus(to.getOrderStatus());
		tv.setPayAccount(to.getPayAccount());
		tv.setPayPlatform(to.getPayPlatform());
		tv.setPayTerminal(to.getPayTerminal());
		tv.setPayType(to.getPayType());
		tv.setReceiver(to.getReceiver());
		tv.setReceiverMobile(to.getReceiverMobile());
		tv.setRemark(to.getRemark());
		tv.setTotalStaff(to.getTotalStaff());
		tv.setValid(to.isValid());
		tv.setRoutename(to.getRoutename());
		tv.setReceiveremail(to.getReceiveremail());
		tv.setGender(to.isGender());
		tv.setRouteId(to.getRouteId());
		try {
			if(StringUtils.isNotEmpty(to.getCreateTime())){			
				tv.setCreateTime(DateUtil.fromStringToDate(DateUtil.ymdhms,to.getCreateTime()));
			}
			if(StringUtils.isNotEmpty(to.getUpdateTime())){			
				tv.setCreateTime(DateUtil.fromStringToDate(DateUtil.ymdhms,to.getUpdateTime()));
			}
			if(StringUtils.isNotEmpty(to.getPayTime())){
				tv.setPayTime(DateUtil.fromStringToDate(DateUtil.ymdhms,to.getPayTime()));
			}
			if(StringUtils.isNotEmpty(to.getExpectedBack())){
				tv.setExpectedBack(DateUtil.fromStringToDate(DateUtil.ymdhm,to.getExpectedBack()));
			}
			if(StringUtils.isNotEmpty(to.getExpectedDepart())){
				tv.setExpectedDepart(DateUtil.fromStringToDate(DateUtil.ymdhm,to.getExpectedDepart()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tv;
	}
}

