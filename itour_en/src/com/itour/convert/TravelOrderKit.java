package com.itour.convert;

import java.text.ParseException;

import org.apache.commons.lang3.StringUtils;

import com.itour.base.util.DateUtil;
import com.itour.entity.TravelOrder;
import com.itour.vo.OrderDetailVO;
import com.itour.vo.TravelOrderVO;
/**
 * 
 * <br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class TravelOrderKit{
	
	public static TravelOrderVO toVo(TravelOrder to)throws Exception{
		TravelOrderVO tv = new TravelOrderVO();
		tv.setBank(to.getBank());
		tv.setBudget(to.getBudget());
		tv.setCreateTime(DateUtil.getDateYmdHs(to.getCreateTime()));
		tv.setCustomerId(to.getCustomerId());
		tv.setExpectedBack(DateUtil.getDateYmdCn(to.getExpectedBack()));
		tv.setExpectedDepart(DateUtil.getDateYmdCn(to.getExpectedDepart()));
		tv.setId(to.getId());
		tv.setPayed(to.getPayed());
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
		tv.setValid(to.getValid());
		tv.setRoutename(to.getRoutename());
		tv.setReceiveremail(to.getReceiveremail());
		tv.setGender(to.getGender());
		tv.setRouteId(to.getRouteId());
		return tv;
	}
	public static TravelOrderVO toEditVo(TravelOrder to)throws Exception{
		TravelOrderVO tv = new TravelOrderVO();
		tv.setBank(to.getBank());
		tv.setBudget(to.getBudget());
		tv.setCreateTime(DateUtil.getDateYmdHs(to.getCreateTime()));
		tv.setCustomerId(to.getCustomerId());
		tv.setExpectedBack(DateUtil.getFormattedDateUtil(to.getExpectedBack(),DateUtil.y_m_d));
		tv.setExpectedDepart(DateUtil.getFormattedDateUtil(to.getExpectedDepart(),DateUtil.y_m_d));
		tv.setId(to.getId());
		tv.setPayed(to.getPayed());
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
		tv.setValid(to.getValid());
		tv.setRoutename(to.getRoutename());
		tv.setReceiveremail(to.getReceiveremail());
		tv.setGender(to.getGender());
		tv.setRouteId(to.getRouteId());
		return tv;
	}
	public static TravelOrderVO detailToVo(TravelOrder to,OrderDetailVO od)throws Exception{
		TravelOrderVO tv = new TravelOrderVO();
		tv.setBank(to.getBank());
		tv.setBudget(to.getBudget());
		tv.setCreateTime(DateUtil.getDateYmdHs(to.getCreateTime()));
		tv.setCustomerId(to.getCustomerId());
		tv.setExpectedBack(DateUtil.getFormattedDateUtil(to.getExpectedBack(),DateUtil.y_m_d));
		tv.setExpectedDepart(DateUtil.getFormattedDateUtil(to.getExpectedDepart(),DateUtil.y_m_d));
		tv.setId(to.getId());
		tv.setPayed(to.getPayed());
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
		tv.setValid(to.getValid());
		tv.setRoutename(to.getRoutename());
		tv.setReceiveremail(to.getReceiveremail());
		tv.setGender(to.getGender());
		tv.setRouteId(to.getRouteId());
		
		
		tv.setContent(od.getContent());
		tv.setPerPrice(od.getPerPrice());
		tv.setCount(od.getCount());
		tv.setOrderId(od.getOrderId());
		tv.setAdults(od.getAdults());
		tv.setChildren(od.getChildren());
		tv.setGroupCode(od.getGroupCode());
		tv.setGroupDate(od.getGroupDate());
		tv.setTravelfashion(od.getTravelfashion());
		tv.setSingleorcluster(od.getSingleorcluster());
		tv.setTravelrequest(od.getTravelrequest());
		tv.setHotel(od.getHotel());
		tv.setStayrequest(od.getStayrequest());
		tv.setTraffic(od.getTraffic());
		tv.setTickets(od.getTickets());
		tv.setFoodrequest(od.getFoodrequest());
		tv.setRecreation(od.getRecreation());
		tv.setSpecialrequest(od.getSpecialrequest());
		tv.setTravelOrder(od.getTravelOrder());
		tv.setComefrom(od.getComefrom());
		tv.setAreaname(od.getAreaname());
		tv.setGuide(od.getGuide());
		tv.setGuide_other(od.getGuide_other());
		tv.setFoodArrange(od.getFoodArrange());
		tv.setTaste(od.getTaste());
		tv.setHatefood(od.getHatefood());
		tv.setTrain(od.getTrain());
		tv.setCruise(od.getCruise());
		tv.setCar_new(od.getCar_new());
		tv.setCar(od.getCar());
		tv.setCar_no_smoking(od.getCar_no_smoking());
		tv.setShipping_space(od.getShipping_space());
		tv.setPlane(od.getPlane());
		tv.setHotel_info(od.getHotel_info());
		tv.setHotel_quiet(od.getHotel_quiet());
		tv.setHotel_no_smoking(od.getHotel_no_smoking());
		tv.setSuite(od.getSuite());
		tv.setDb_room(od.getDb_room());
		tv.setBb_room(od.getBb_room());
		tv.setPosition(od.getPosition());
		return tv;
	}
	public static TravelOrder toRecord(TravelOrderVO to)throws Exception{
		TravelOrder tv = new TravelOrder();
		tv.setBank(to.getBank());
		tv.setBudget(to.getBudget());
		tv.setCustomerId(to.getCustomerId());
		tv.setId(to.getId());
		tv.setPayed(to.getPayed());
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
		tv.setValid(to.getValid());
		tv.setRoutename(to.getRoutename());
		tv.setReceiveremail(to.getReceiveremail());
		tv.setGender(to.getGender());
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

