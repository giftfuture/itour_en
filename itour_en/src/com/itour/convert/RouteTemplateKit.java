package com.itour.convert;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.itour.base.util.DateUtil;
import com.itour.entity.RouteTemplate;
import com.itour.vo.RouteTemplateVo;
/**
 * 
 * <br>
 * <b>功能：</b>RouteTemplateEntity<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class RouteTemplateKit{
	public static RouteTemplateVo toRecord(RouteTemplate rt){
		RouteTemplateVo vo = new RouteTemplateVo();
		vo.setCreateBy(rt.getCreateBy());
		vo.setCreateTime(DateUtil.getDateYmdHs(rt.getCreateTime()));
		vo.setCustomerId(rt.getCustomerId());
		vo.setD1(rt.getD1());
		vo.setD10(rt.getD10());
		vo.setD11(rt.getD11());
		vo.setD12(rt.getD12());
		vo.setD13(rt.getD13());
		vo.setD14(rt.getD14());
		vo.setD15(rt.getD15());
		vo.setD16(rt.getD16());
		vo.setD17(rt.getD17());
		vo.setD18(rt.getD18());
		vo.setD19(rt.getD19());
		vo.setD2(rt.getD2());
		vo.setD20(rt.getD20());
		vo.setD21(rt.getD21());
		vo.setD22(rt.getD22());
		vo.setD23(rt.getD23());
		vo.setD24(rt.getD24());
		vo.setD25(rt.getD25());
		vo.setD26(rt.getD26());
		vo.setD27(rt.getD27());
		vo.setD28(rt.getD28());
		vo.setD29(rt.getD29());
		vo.setD3(rt.getD3());
		vo.setD30(rt.getD30());
		vo.setD31(rt.getD31());
		vo.setD32(rt.getD32());
		vo.setD33(rt.getD33());
		vo.setD34(rt.getD34());
		vo.setD35(rt.getD35());
		vo.setD36(rt.getD36());
		vo.setD37(rt.getD37());
		vo.setD38(rt.getD38());
		vo.setD39(rt.getD39());
		vo.setD4(rt.getD4());
		vo.setD40(rt.getD40());
		vo.setD41(rt.getD41());
		vo.setD42(rt.getD42());
		vo.setD43(rt.getD43());
		vo.setD44(rt.getD44());
		vo.setD45(rt.getD45());
		vo.setD46(rt.getD46());
		vo.setD47(rt.getD47());
		vo.setD48(rt.getD48());
		vo.setD49(rt.getD49());
		vo.setD5(rt.getD5());
		vo.setD50(rt.getD50());
		vo.setD51(rt.getD51());
		vo.setD52(rt.getD52());
		vo.setD53(rt.getD53());
		vo.setD54(rt.getD54());
		vo.setD55(rt.getD55());
		vo.setD56(rt.getD56());
		vo.setD57(rt.getD57());
		vo.setD58(rt.getD58());
		vo.setD59(rt.getD59());
		vo.setD6(rt.getD6());
		vo.setD60(rt.getD60());
		vo.setId(rt.getId());
		vo.setUpdateBy(rt.getUpdateBy());
		vo.setUpdateTime(DateUtil.getDateYmdHs(rt.getUpdateTime()));
		vo.setRemark(rt.getRemark());
		vo.setSpecial(rt.getSpecial());
		vo.setRelated(rt.getRelated());
		vo.setTravelStyle(rt.getTravelStyle());
		vo.setRouteMap(rt.getRouteMap());
		vo.setTravelItems(rt.getTravelItems());
		vo.setCover(rt.getCover());
		vo.setTitle(rt.getTitle());
		vo.setAlias(rt.getAlias());
		vo.setShortContent(rt.getShortContent());
		vo.setRouteCode(rt.getRouteCode());
		vo.setArrive(rt.getArrive());
		vo.setDeparture(rt.getDeparture());
		vo.setTransportation(rt.getTransportation());
		vo.setTrekDistance(rt.getTrekDistance());
		vo.setMileage(rt.getMileage());
		vo.setMountStyle(rt.getMountStyle());
		vo.setRcdDays(rt.getRcdDays());
		vo.setDifficultyRate(rt.getDifficultyRate());
		List<Integer> diff = Lists.newArrayList();
		for(int i=0;i<rt.getDifficultyRate();i++){
			diff.add(1);
		}
		vo.setDiffRate(diff);
		List<Integer> undiffRate = Lists.newArrayList();
		for(int i=0;i<5-rt.getDifficultyRate();i++){
			undiffRate.add(1);
		}
		vo.setUndiffRate(undiffRate);
		vo.setQuotoForm(rt.getQuotoForm());
		vo.setDesignConcept(rt.getDesignConcept());
		vo.setCustomizedService(rt.getCustomizedService());
		vo.setBeforeInstruction(rt.getBeforeInstruction());
		vo.setSimilars(rt.getSimilars());
		vo.setElevation(rt.getElevation());
		vo.setStarLevel(rt.getStarLevel());
		vo.setLevelArea(rt.getLevelArea());
		vo.setViewphotos(rt.getViewphotos());
		return vo;
	}
	public static RouteTemplate toEntity(RouteTemplateVo rt){
		RouteTemplate vo = new RouteTemplate();
		vo.setCreateBy(rt.getCreateBy());
		try {
			if(StringUtils.isNotEmpty( rt.getCreateTime())){			
				vo.setCreateTime(DateUtil.fromStringToDate(DateUtil.ymdhms,rt.getCreateTime()));
			}
			if(StringUtils.isNotEmpty(rt.getUpdateTime())){
				vo.setUpdateTime(DateUtil.fromStringToDate(DateUtil.ymdhms,rt.getUpdateTime()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		vo.setCustomerId(rt.getCustomerId());
		vo.setD1(rt.getD1());
		vo.setD10(rt.getD10());
		vo.setD11(rt.getD11());
		vo.setD12(rt.getD12());
		vo.setD13(rt.getD13());
		vo.setD14(rt.getD14());
		vo.setD15(rt.getD15());
		vo.setD16(rt.getD16());
		vo.setD17(rt.getD17());
		vo.setD18(rt.getD18());
		vo.setD19(rt.getD19());
		vo.setD2(rt.getD2());
		vo.setD20(rt.getD20());
		vo.setD21(rt.getD21());
		vo.setD22(rt.getD22());
		vo.setD23(rt.getD23());
		vo.setD24(rt.getD24());
		vo.setD25(rt.getD25());
		vo.setD26(rt.getD26());
		vo.setD27(rt.getD27());
		vo.setD28(rt.getD28());
		vo.setD29(rt.getD29());
		vo.setD3(rt.getD3());
		vo.setD30(rt.getD30());
		vo.setD31(rt.getD31());
		vo.setD32(rt.getD32());
		vo.setD33(rt.getD33());
		vo.setD34(rt.getD34());
		vo.setD35(rt.getD35());
		vo.setD36(rt.getD36());
		vo.setD37(rt.getD37());
		vo.setD38(rt.getD38());
		vo.setD39(rt.getD39());
		vo.setD4(rt.getD4());
		vo.setD40(rt.getD40());
		vo.setD41(rt.getD41());
		vo.setD42(rt.getD42());
		vo.setD43(rt.getD43());
		vo.setD44(rt.getD44());
		vo.setD45(rt.getD45());
		vo.setD46(rt.getD46());
		vo.setD47(rt.getD47());
		vo.setD48(rt.getD48());
		vo.setD49(rt.getD49());
		vo.setD5(rt.getD5());
		vo.setD50(rt.getD50());
		vo.setD51(rt.getD51());
		vo.setD52(rt.getD52());
		vo.setD53(rt.getD53());
		vo.setD54(rt.getD54());
		vo.setD55(rt.getD55());
		vo.setD56(rt.getD56());
		vo.setD57(rt.getD57());
		vo.setD58(rt.getD58());
		vo.setD59(rt.getD59());
		vo.setD6(rt.getD6());
		vo.setD60(rt.getD60());
		vo.setId(rt.getId());
		vo.setUpdateBy(rt.getUpdateBy());
		vo.setRemark(rt.getRemark());
		vo.setSpecial(rt.getSpecial());
		vo.setRelated(rt.getRelated());
		vo.setTravelStyle(rt.getTravelStyle());
		vo.setRouteMap(rt.getRouteMap());
		vo.setTravelItems(rt.getTravelItems());
		vo.setCover(rt.getCover());
		vo.setTitle(rt.getTitle());
		vo.setAlias(rt.getAlias());
		vo.setShortContent(rt.getShortContent());
		vo.setRouteCode(rt.getRouteCode());
		vo.setArrive(rt.getArrive());
		vo.setDeparture(rt.getDeparture());
		vo.setTransportation(rt.getTransportation());
		vo.setTrekDistance(rt.getTrekDistance());
		vo.setMileage(rt.getMileage());
		vo.setMountStyle(rt.getMountStyle());
		vo.setRcdDays(rt.getRcdDays());
		vo.setDifficultyRate(rt.getDifficultyRate());
		vo.setQuotoForm(rt.getQuotoForm());
		vo.setDesignConcept(rt.getDesignConcept());
		vo.setCustomizedService(rt.getCustomizedService());
		vo.setBeforeInstruction(rt.getBeforeInstruction());
		vo.setStarLevel(rt.getStarLevel());
		vo.setLevelArea(rt.getLevelArea());
		vo.setSimilars(rt.getSimilars());
		vo.setElevation(rt.getElevation());
		vo.setViewphotos(rt.getViewphotos());
		return vo;
	}
}

