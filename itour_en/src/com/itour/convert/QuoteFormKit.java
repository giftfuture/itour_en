package com.itour.convert;

import java.text.ParseException;

import org.apache.commons.lang3.StringUtils;

import com.itour.base.util.DateUtil;
import com.itour.entity.QuoteForm;
import com.itour.vo.QuoteFormVo;

public class QuoteFormKit {
	/**
	 * 
	 * @param qf
	 * @return
	 */
	public static QuoteFormVo toVo(QuoteForm qf){
		QuoteFormVo qfv = new QuoteFormVo();
		qfv.setId(qf.getId());
		qfv.setAdults(qf.getAdults());
		qfv.setAsAdult(qf.isAsAdult());
		qfv.setBathcostAsadult(qf.isBathcostAsadult());
		qfv.setBathorseCost(qf.getBathorseCost());
		qfv.setBeriefTrip(qf.getBeriefTrip());
		qfv.setShowTrip(qf.getShowTrip());
		qfv.setBigTraffic(qf.getBigTraffic());
		qfv.setBigtrafficeAsadult(qf.isBigtrafficeAsadult());
		qfv.setBigTrafficSum(qf.isBigTrafficSum());
		qfv.setChildren(qf.getChildren());
		qfv.setClimbncostAsadult(qf.isClimbncostAsadult());
		qfv.setClimbNexusCost(qf.getClimbNexusCost());
		qfv.setClimbrcostAsadult(qf.isClimbrcostAsadult());
		qfv.setClimbRegisterCost(qf.getClimbRegisterCost());
		qfv.setComphcostAsadult(qf.isComphcostAsadult());
		qfv.setComprehensiveCosts(qf.getComprehensiveCosts());
		qfv.setCreateBy(qf.getCreateBy());
		if(qf.getCreateTime()!=null){
			qfv.setCreateTime(DateUtil.getDateYmdHs(qf.getCreateTime()));
		}
		qfv.setDinner(qf.getDinner());
		qfv.setDinnerAsadult(qf.isDinnerAsadult());
		qfv.setElseCost(qf.getElseCost());
		qfv.setElsecostAsadult(qf.isElsecostAsadult());
		qfv.setHotel(qf.getHotel());
		qfv.setHotelAsadult(qf.isHotelAsadult());
		qfv.setInsurance(qf.getInsurance());
		qfv.setInsuranceAsadult(qf.isInsuranceAsadult());
		qfv.setItemGuide(qf.getItemGuide());
		qfv.setItemguideAsadult(qf.isItemguideAsadult());
		qfv.setPresented(qf.getPresented());
		qfv.setRecreation(qf.getRecreation());
		qfv.setRecreationAsadult(qf.isRecreationAsadult());
		qfv.setRemark(qf.getRemark());
		qfv.setRentCar(qf.getRentCar());
		qfv.setRentcarAsadult(qf.isRentcarAsadult());
		qfv.setRidehorseCost(qf.getRidehorseCost());
		qfv.setRidecostAsadult(qf.isRidecostAsadult());
		qfv.setRouteTemplate(qf.getRouteTemplate());
		qfv.setTicketAsadult(qf.isTicketAsadult());
		qfv.setTicketBlock(qf.getTicketBlock());
		qfv.setTourGuide(qf.getTourGuide());
		qfv.setTourguideAsadult(qf.isTourguideAsadult());
		qfv.setTraveldocAsadult(qf.isTraveldocAsadult());
		qfv.setTravelDocs(qf.getTravelDocs());
		qfv.setUpdateBy(qf.getUpdateBy());
		if(qf.getUpdateTime() !=null){
			qfv.setUpdateTime(DateUtil.getDateYmdHs(qf.getUpdateTime()));
		}
		qfv.setValid(qf.isValid());
		qfv.setGroupCode(qf.getGroupCode());
		if(qf.getGroupDate()!=null){
			qfv.setGroupDate(DateUtil.getDateYmdCn(qf.getGroupDate()));
		}
		qfv.setShowTicket(qf.getShowTicket());
		qfv.setShowBathorse(qf.getShowBathorse());
		qfv.setShowBigtraffic(qf.getShowBigtraffic());
		qfv.setShowClimbnexus(qf.getShowClimbnexus());
		qfv.setShowClimbregister(qf.getShowClimbregister());
		qfv.setShowComphcost(qf.getShowComphcost());
		qfv.setShowDinner(qf.getShowDinner());
		qfv.setShowElsecost(qf.getShowElsecost());
		qfv.setShowHotel(qf.getShowHotel());
		qfv.setShowInsurance(qf.getShowInsurance());
		qfv.setShowItemguide(qf.getShowItemguide());
		qfv.setShowPresented(qf.getShowPresented());
		qfv.setShowRecreation(qf.getShowRecreation());
		qfv.setShowRentcar(qf.getShowRentcar());
		qfv.setShowRidehorse(qf.getShowRidehorse());
		qfv.setShowTourguide(qf.getShowTourguide());
		qfv.setShowTraveldoc(qf.getShowTraveldoc());
		qfv.setAgodaDetail(qf.getAgodaDetail());
		return qfv;
	}
	/**
	 * 
	 * @param vo
	 * @return
	 */
	public static QuoteForm toRecord(QuoteFormVo vo){
		QuoteForm qfv = new QuoteForm();
		qfv.setId(vo.getId());
		qfv.setAdults(vo.getAdults());
		qfv.setAsAdult(vo.isAsAdult());
		qfv.setBathcostAsadult(vo.isBathcostAsadult());
		qfv.setBathorseCost(vo.getBathorseCost());
		qfv.setBeriefTrip(vo.getBeriefTrip());
		qfv.setShowTrip(vo.getShowTrip());
		qfv.setBigTraffic(vo.getBigTraffic());
		qfv.setBigtrafficeAsadult(vo.isBigtrafficeAsadult());
		qfv.setBigTrafficSum(vo.isBigTrafficSum());
		qfv.setChildren(vo.getChildren());
		qfv.setClimbncostAsadult(vo.isClimbncostAsadult());
		qfv.setClimbNexusCost(vo.getClimbNexusCost());
		qfv.setClimbrcostAsadult(vo.isClimbrcostAsadult());
		qfv.setClimbRegisterCost(vo.getClimbRegisterCost());
		qfv.setComphcostAsadult(vo.isComphcostAsadult());
		qfv.setComprehensiveCosts(vo.getComprehensiveCosts());
		qfv.setCreateBy(vo.getCreateBy());
		qfv.setDinner(vo.getDinner());
		qfv.setDinnerAsadult(vo.isDinnerAsadult());
		qfv.setElseCost(vo.getElseCost());
		qfv.setElsecostAsadult(vo.isElsecostAsadult());
		qfv.setHotel(vo.getHotel());
		qfv.setHotelAsadult(vo.isHotelAsadult());
		qfv.setInsurance(vo.getInsurance());
		qfv.setInsuranceAsadult(vo.isInsuranceAsadult());
		qfv.setItemGuide(vo.getItemGuide());
		qfv.setItemguideAsadult(vo.isItemguideAsadult());
		qfv.setPresented(vo.getPresented());
		qfv.setRecreation(vo.getRecreation());
		qfv.setRecreationAsadult(vo.isRecreationAsadult());
		qfv.setRemark(vo.getRemark());
		qfv.setRentCar(vo.getRentCar());
		qfv.setRentcarAsadult(vo.isRentcarAsadult());
		qfv.setRidehorseCost(vo.getRidehorseCost());
		qfv.setRidecostAsadult(vo.isRidecostAsadult());
		qfv.setRouteTemplate(vo.getRouteTemplate());
		qfv.setTicketAsadult(vo.isTicketAsadult());
		qfv.setTicketBlock(vo.getTicketBlock());
		qfv.setTourGuide(vo.getTourGuide());
		qfv.setTourguideAsadult(vo.isTourguideAsadult());
		qfv.setTraveldocAsadult(vo.isTraveldocAsadult());
		qfv.setTravelDocs(vo.getTravelDocs());
		qfv.setUpdateBy(vo.getUpdateBy());
		qfv.setValid(vo.isValid());
		qfv.setGroupCode(vo.getGroupCode());
		qfv.setShowTicket(vo.getShowTicket());
		qfv.setShowBathorse(vo.getShowBathorse());
		qfv.setShowBigtraffic(vo.getShowBigtraffic());
		qfv.setShowClimbnexus(vo.getShowClimbnexus());
		qfv.setShowClimbregister(vo.getShowClimbregister());
		qfv.setShowComphcost(vo.getShowComphcost());
		qfv.setShowDinner(vo.getShowDinner());
		qfv.setShowElsecost(vo.getShowElsecost());
		qfv.setShowHotel(vo.getShowHotel());
		qfv.setShowInsurance(vo.getShowInsurance());
		qfv.setShowItemguide(vo.getShowItemguide());
		qfv.setShowPresented(vo.getShowPresented());
		qfv.setShowRecreation(vo.getShowRecreation());
		qfv.setShowRentcar(vo.getShowRentcar());
		qfv.setShowRidehorse(vo.getShowRidehorse());
		qfv.setShowTourguide(vo.getShowTourguide());
		qfv.setShowTraveldoc(vo.getShowTraveldoc());
		qfv.setAgodaDetail(vo.getAgodaDetail());
		try {
			if(StringUtils.isNotEmpty(vo.getCreateTime())){			
				qfv.setCreateTime(DateUtil.fromStringToDate(DateUtil.ymdhms,vo.getCreateTime()));
			}
			if(StringUtils.isNotEmpty(vo.getUpdateTime())){			
				qfv.setCreateTime(DateUtil.fromStringToDate(DateUtil.ymdhms,vo.getUpdateTime()));
			}
			if(StringUtils.isNotEmpty(vo.getGroupDate())){
				qfv.setGroupDate(DateUtil.fromStringToDate(DateUtil.ymdhms,vo.getGroupDate()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return qfv;
	}
}
