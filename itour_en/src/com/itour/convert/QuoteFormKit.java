package com.itour.convert;

import java.text.ParseException;

import org.apache.commons.lang3.StringUtils;

import com.itour.base.util.DateUtil;
import com.itour.entity.QuoteForm;
import com.itour.vo.QuoteFormVO;

public class QuoteFormKit {
	/**
	 * 
	 * @param qf
	 * @return
	 */
	public static QuoteFormVO toVo(QuoteForm qf){
		QuoteFormVO qfv = new QuoteFormVO();
		qfv.setId(qf.getId());
		qfv.setAdults(qf.getAdults());
		qfv.setAsAdult(qf.getAsAdult());
		qfv.setBathcostAsadult(qf.getBathcostAsadult());
		qfv.setBathorseCost(qf.getBathorseCost());
		qfv.setBeriefTrip(qf.getBeriefTrip());
		qfv.setShowTrip(qf.getShowTrip());
		qfv.setBigTraffic(qf.getBigTraffic());
		qfv.setBigtrafficeAsadult(qf.getBigtrafficeAsadult());
		qfv.setBigTrafficSum(qf.getBigTrafficSum());
		qfv.setChildren(qf.getChildren());
		qfv.setClimbncostAsadult(qf.getClimbncostAsadult());
		qfv.setClimbNexusCost(qf.getClimbNexusCost());
		qfv.setClimbrcostAsadult(qf.getClimbrcostAsadult());
		qfv.setClimbRegisterCost(qf.getClimbRegisterCost());
		qfv.setComphcostAsadult(qf.getComphcostAsadult());
		qfv.setComprehensiveCosts(qf.getComprehensiveCosts());
		qfv.setCreateBy(qf.getCreateBy());
		if(qf.getCreateTime()!=null){
			qfv.setCreateTime(DateUtil.getDateYmdHs(qf.getCreateTime()));
		}
		qfv.setDinner(qf.getDinner());
		qfv.setDinnerAsadult(qf.getDinnerAsadult());
		qfv.setElseCost(qf.getElseCost());
		qfv.setElsecostAsadult(qf.getElsecostAsadult());
		qfv.setHotel(qf.getHotel());
		qfv.setHotelAsadult(qf.getHotelAsadult());
		qfv.setInsurance(qf.getInsurance());
		qfv.setInsuranceAsadult(qf.getInsuranceAsadult());
		qfv.setItemGuide(qf.getItemGuide());
		qfv.setItemguideAsadult(qf.getItemguideAsadult());
		qfv.setPresented(qf.getPresented());
		qfv.setRecreation(qf.getRecreation());
		qfv.setRecreationAsadult(qf.getRecreationAsadult());
		qfv.setRemark(qf.getRemark());
		qfv.setRentCar(qf.getRentCar());
		qfv.setRentcarAsadult(qf.getRentcarAsadult());
		qfv.setRidehorseCost(qf.getRidehorseCost());
		qfv.setRidecostAsadult(qf.getRidecostAsadult());
		qfv.setRouteTemplate(qf.getRouteTemplate());
		qfv.setTicketAsadult(qf.getTicketAsadult());
		qfv.setTicketBlock(qf.getTicketBlock());
		qfv.setTourGuide(qf.getTourGuide());
		qfv.setTourguideAsadult(qf.getTourguideAsadult());
		qfv.setTraveldocAsadult(qf.getTraveldocAsadult());
		qfv.setTravelDocs(qf.getTravelDocs());
		qfv.setUpdateBy(qf.getUpdateBy());
		if(qf.getUpdateTime() !=null){
			qfv.setUpdateTime(DateUtil.getDateYmdHs(qf.getUpdateTime()));
		}
		qfv.setValid(qf.getValid());
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
	public static QuoteForm toRecord(QuoteFormVO vo){
		QuoteForm qfv = new QuoteForm();
		qfv.setId(vo.getId());
		qfv.setAdults(vo.getAdults());
		qfv.setAsAdult(vo.getAsAdult());
		qfv.setBathcostAsadult(vo.getBathcostAsadult());
		qfv.setBathorseCost(vo.getBathorseCost());
		qfv.setBeriefTrip(vo.getBeriefTrip());
		qfv.setShowTrip(vo.getShowTrip());
		qfv.setBigTraffic(vo.getBigTraffic());
		qfv.setBigtrafficeAsadult(vo.getBigtrafficeAsadult());
		qfv.setBigTrafficSum(vo.getBigTrafficSum());
		qfv.setChildren(vo.getChildren());
		qfv.setClimbncostAsadult(vo.getClimbncostAsadult());
		qfv.setClimbNexusCost(vo.getClimbNexusCost());
		qfv.setClimbrcostAsadult(vo.getClimbrcostAsadult());
		qfv.setClimbRegisterCost(vo.getClimbRegisterCost());
		qfv.setComphcostAsadult(vo.getComphcostAsadult());
		qfv.setComprehensiveCosts(vo.getComprehensiveCosts());
		qfv.setCreateBy(vo.getCreateBy());
		qfv.setDinner(vo.getDinner());
		qfv.setDinnerAsadult(vo.getDinnerAsadult());
		qfv.setElseCost(vo.getElseCost());
		qfv.setElsecostAsadult(vo.getElsecostAsadult());
		qfv.setHotel(vo.getHotel());
		qfv.setHotelAsadult(vo.getHotelAsadult());
		qfv.setInsurance(vo.getInsurance());
		qfv.setInsuranceAsadult(vo.getInsuranceAsadult());
		qfv.setItemGuide(vo.getItemGuide());
		qfv.setItemguideAsadult(vo.getItemguideAsadult());
		qfv.setPresented(vo.getPresented());
		qfv.setRecreation(vo.getRecreation());
		qfv.setRecreationAsadult(vo.getRecreationAsadult());
		qfv.setRemark(vo.getRemark());
		qfv.setRentCar(vo.getRentCar());
		qfv.setRentcarAsadult(vo.getRentcarAsadult());
		qfv.setRidehorseCost(vo.getRidehorseCost());
		qfv.setRidecostAsadult(vo.getRidecostAsadult());
		qfv.setRouteTemplate(vo.getRouteTemplate());
		qfv.setTicketAsadult(vo.getTicketAsadult());
		qfv.setTicketBlock(vo.getTicketBlock());
		qfv.setTourGuide(vo.getTourGuide());
		qfv.setTourguideAsadult(vo.getTourguideAsadult());
		qfv.setTraveldocAsadult(vo.getTraveldocAsadult());
		qfv.setTravelDocs(vo.getTravelDocs());
		qfv.setUpdateBy(vo.getUpdateBy());
		qfv.setValid(vo.getValid());
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
