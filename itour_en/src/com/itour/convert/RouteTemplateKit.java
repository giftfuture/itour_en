package com.itour.convert;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.itour.base.util.DateUtil;
import com.itour.entity.RouteTemplate;
import com.itour.vo.RouteTemplateVO;
/**
 * 
 * <br>
 * <b>功能：</b>RouteTemplateEntity<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class RouteTemplateKit{
	public static RouteTemplateVO toRecord(RouteTemplate rt){
		RouteTemplateVO vo = new RouteTemplateVO();
		vo.setCreateBy(rt.getCreateBy());
		vo.setCreateTime(DateUtil.getDateYmdHs(rt.getCreateTime()));
		vo.setCustomerId(rt.getCustomerId());
		vo.setId(rt.getId());
		vo.setUpdateBy(rt.getUpdateBy());
		vo.setUpdateTime(DateUtil.getDateYmdHs(rt.getUpdateTime()));
		vo.setRemark(rt.getRemark());
		vo.setSpecial(rt.getSpecial());
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
		vo.setElevation(rt.getElevation());
		vo.setStarLevel(rt.getStarLevel());
		vo.setLevelArea(rt.getLevelArea());
		vo.setViewphotos(rt.getViewphotos());
		vo.setServiceAndQuote(rt.getServiceAndQuote());
		return vo;
	}
	public static RouteTemplate toEntity(RouteTemplateVO rt){
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
		vo.setId(rt.getId());
		vo.setUpdateBy(rt.getUpdateBy());
		vo.setRemark(rt.getRemark());
		vo.setSpecial(rt.getSpecial());
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
		vo.setElevation(rt.getElevation());
		vo.setViewphotos(rt.getViewphotos());
		vo.setServiceAndQuote(rt.getServiceAndQuote());
		return vo;
	}
}

