package com.itour.convert;

import java.text.ParseException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;
import com.itour.base.util.DateUtil;
import com.itour.entity.OrderDetail;
import com.itour.vo.OrderDetailVO;
/**
 * 
 * <br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class OrderDetailKit{
	public static OrderDetailVO toRecord(OrderDetail od){
		OrderDetailVO vo  = new OrderDetailVO();
		vo.setContent(od.getContent());
		vo.setCount(od.getCount());
		vo.setCreateTime(DateUtil.getDateYmdHs(od.getCreateTime()));
		vo.setId(od.getId());
		vo.setOrderId(od.getOrderId());
		vo.setPerPrice(od.getPerPrice());
		vo.setRemark(od.getRemark());
		vo.setStatus(od.getStatus());
		vo.setUpdateTime(DateUtil.getDateYmdHs(od.getUpdateTime()));
		vo.setValid(od.getValid());
		vo.setGroupCode(od.getGroupCode());
		vo.setAdults(od.getAdults());
		vo.setChildren(od.getChildren());
		if(od.getGroupDate() !=null){
			vo.setGroupDate(DateUtil.getDateYmdCn(od.getGroupDate()));
		}
		vo.setTravelfashion(od.getTravelfashion());
		vo.setSingleorcluster(od.getSingleorcluster());
		vo.setTravelrequest(od.getTravelrequest());
		vo.setHotel(od.getHotel());
		vo.setTravelOrder(od.getTravelOrder());
		vo.setStayrequest(od.getStayrequest());
		vo.setTraffic(od.getTraffic());
		vo.setTickets(od.getTickets());
		vo.setFoodrequest(od.getFoodrequest());
		vo.setRecreation(od.getRecreation());
		vo.setSpecialrequest(od.getSpecialrequest());
		vo.setComefrom(od.getComefrom());
		vo.setGuide(od.getGuide());
		vo.setGuide(od.getGuide());
		vo.setTaste(od.getTaste());
		vo.setHatefood(od.getHatefood());
		vo.setTrain(od.getTrain());
		vo.setCruise(od.getCruise());
		vo.setCar_new(od.getCar_new());
		vo.setCar_no_smoking(od.getCar_no_smoking());
		vo.setCar(od.getCar());
		vo.setShipping_space(od.getShipping_space());
		vo.setPlane(od.getPlane());
		vo.setHotel_info(od.getHotel_info());
		vo.setHotel_quiet(od.getHotel_quiet());
		vo.setHotel_no_smoking(od.getHotel_no_smoking());
		vo.setSuite(od.getSuite());
		vo.setDb_room(od.getDb_room());
		vo.setBb_room(od.getBb_room());
		vo.setPosition(od.getPosition());
		vo.setFoodArrange(od.getFoodArrange());
		return vo;
	}
	public static OrderDetail toEntity(OrderDetailVO od){
		OrderDetail vo  = new OrderDetail();
		vo.setContent(od.getContent());
		vo.setCount(od.getCount());
		vo.setId(od.getId());
		vo.setOrderId(od.getOrderId());
		vo.setPerPrice(od.getPerPrice());
		vo.setRemark(od.getRemark());
		vo.setStatus(od.getStatus());
		vo.setValid(od.getValid());
		vo.setAdults(od.getAdults());
		vo.setChildren(od.getChildren());
		vo.setTravelfashion(od.getTravelfashion());
		if(od.getTravelfashion().equals("加入散客团")){
			vo.setGroupCode(od.getGroupCode());
			if(StringUtils.isNotEmpty(od.getGroupDate())){
				try {
					vo.setGroupDate(DateUtil.fromStringToDate(DateUtil.y_m_d,od.getGroupDate()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		vo.setSingleorcluster(od.getSingleorcluster());
		vo.setTravelrequest(od.getTravelrequest());
		vo.setHotel(od.getHotel());
		vo.setTravelOrder(od.getTravelOrder());
		vo.setStayrequest(od.getStayrequest());
		vo.setTraffic(od.getTraffic());
		vo.setTickets(od.getTickets());
		vo.setFoodrequest(od.getFoodrequest());
		vo.setRecreation(od.getRecreation());
		vo.setSpecialrequest(od.getSpecialrequest());
		vo.setComefrom(od.getComefrom());
		vo.setGuide(od.getGuide()!=null&&od.getGuide().equals("其他语种")?od.getGuide_other():od.getGuide());
		vo.setTaste(od.getTaste());
		vo.setHatefood(od.getHatefood());
		vo.setTrain(od.getTrain());
		vo.setCruise(od.getCruise());
		vo.setCar_new(od.getCar_new());
		vo.setCar_no_smoking(od.getCar_no_smoking());
		vo.setCar(od.getCar());
		vo.setShipping_space(od.getShipping_space());
		vo.setPlane(od.getPlane());
		vo.setHotel_info(od.getHotel_info());
		vo.setHotel_quiet(od.getHotel_quiet());
		vo.setHotel_no_smoking(od.getHotel_no_smoking());
		vo.setSuite(od.getSuite());
		vo.setDb_room(od.getDb_room());
		vo.setBb_room(od.getBb_room());
		vo.setPosition(od.getPosition());
		vo.setFoodArrange(od.getFoodArrange());
		try {
			if(StringUtils.isNotEmpty(od.getCreateTime())){
				vo.setCreateTime(DateUtil.fromStringToDate(DateUtil.ymdhms,od.getCreateTime()));
			}
			if(StringUtils.isNotEmpty(od.getUpdateTime())){
				vo.setUpdateTime(DateUtil.fromStringToDate(DateUtil.ymdhms,od.getUpdateTime()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return vo;
	}
	/**
	 * 
	 * @param od
	 * @return
	 */
	public static Map<String,String> toMap(OrderDetail od){
		Map<String,String> map = Maps.newHashMap();
		map.put("content", od.getContent());
		map.put("count", od.getCount()+"");
		map.put("createTime", DateUtil.getDateYmdHs(od.getCreateTime()));
		map.put("id", od.getId());
		map.put("orderId", od.getOrderId());
		map.put("perPrice", od.getPerPrice()+"");
		map.put("remark", od.getRemark());
		map.put("status", od.getStatus()+"");
		map.put("updateTime",DateUtil.getDateYmdHs(od.getUpdateTime()));
		map.put("valid", od.getValid()+"");
		map.put("groupCode", od.getGroupCode());
		map.put("adults", od.getAdults()+"");
		map.put("children", od.getChildren()+"");
		map.put("groupDate", DateUtil.getDateYmdCn(od.getGroupDate()));
		map.put("travelfashion",od.getTravelfashion());
		map.put("singleorcluster", od.getSingleorcluster());
		map.put("travelrequest", od.getTravelrequest());
		map.put("hotel", od.getHotel());
		map.put("travelOrder", od.getTravelOrder());
		map.put("stayRequest", od.getStayrequest());
		map.put("traffic", od.getTraffic());
		map.put("tickets", od.getTickets());
		map.put("foodrequest", od.getFoodrequest());
		map.put("recreation", od.getRecreation());
		map.put("specialrequest", od.getSpecialrequest());
		map.put("comefrom", od.getComefrom());
		map.put("guide", od.getGuide());
		map.put("taste", od.getTaste());
		map.put("hatefood", od.getHatefood());
		map.put("train", od.getTrain());
		map.put("cruise", od.getCruise());
		map.put("car_new", od.getCar_new());
		map.put("car_no_smoking", od.getCar_no_smoking());
		map.put("car", od.getCar());
		map.put("shipping_space",od.getShipping_space());
		map.put("plane", od.getPlane());
		map.put("hotel_info", od.getHotel_info());
		map.put("hotel_quiet", od.getHotel_quiet());
		map.put("hotel_no_smoking", od.getHotel_no_smoking());
		map.put("suite", od.getSuite()+"");
		map.put("db_room", od.getDb_room()+"");
		map.put("bb_room", od.getBb_room()+"");
		map.put("position", od.getPosition());
		map.put("foodArrange", od.getFoodArrange());
		return map;
	}
}

