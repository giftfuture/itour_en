package com.itour.convert;

import com.itour.entity.TravelItem;
import com.itour.vo.TravelItemVo;
/**
 * 
 * <br>
 * <b>功能：</b>TravelItemEntity<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class TravelItemKit{
	public static TravelItemVo toRecord(TravelItem tt){
		TravelItemVo vo = new TravelItemVo();
		vo.setContent(tt.getContent());
		vo.setCover(tt.getCover());
		vo.setDifficultyRate(tt.getDifficultyRate());
		vo.setDiscount(tt.getDiscount());
		vo.setElevation(tt.getElevation());
		vo.setEquip(tt.getEquip());
		vo.setExclude(tt.getExclude());
		vo.setFeature(tt.getFeature());
		vo.setFileselect(tt.getFileselect());
		vo.setHappyValue(tt.getHappyValue());
		vo.setHot(tt.isHot());
		vo.setId(tt.getId());
		vo.setItem(tt.getItem());
		vo.setItemCode(tt.getItemCode());
		vo.setItinerary(tt.getItinerary());
		vo.setMap(tt.getMap());
		vo.setMileage(tt.getMileage());
		vo.setPhotos(tt.getPhotos());
		vo.setRank(tt.getRank());
		vo.setRcdDays(tt.getRcdDays());
		vo.setTravelStyle(tt.getTravelStyle());
		vo.setShortContent(tt.getShortContent());
		vo.setSeason(tt.getSeason());
		vo.setScope(tt.getScope());
		vo.setRemark(tt.getRemark());
		vo.setRecommandReason(tt.getRecommandReason());
		vo.setRecommandEquip(tt.getRecommandEquip());
		vo.setRecommandCrowd(tt.getRecommandCrowd());
		vo.setValid(tt.isValid());
		vo.setHot(tt.isHot());
		vo.setCreateBy(tt.getCreateBy());
		vo.setUpdateBy(tt.getUpdateBy());
		vo.setStarLevel(tt.getStarLevel());
		vo.setTicketsBlock(tt.getTicketsBlock());
		vo.setFullyearTicket(tt.isFullyearTicket());
		vo.setAlias(tt.getAlias());
		vo.setBusyseason(tt.getBusyseason());
		vo.setFreeseason(tt.getFreeseason());
		return vo;
	}
	public static TravelItem toBean(TravelItemVo tt){
		TravelItem vo = new TravelItem();
		vo.setContent(tt.getContent());
		vo.setCover(tt.getCover());
		vo.setDifficultyRate(tt.getDifficultyRate());
		vo.setDiscount(tt.getDiscount());
		vo.setElevation(tt.getElevation());
		vo.setEquip(tt.getEquip());
		vo.setExclude(tt.getExclude());
		vo.setFeature(tt.getFeature());
		vo.setFileselect(tt.getFileselect());
		vo.setHappyValue(tt.getHappyValue());
		vo.setHot(tt.isHot());
		vo.setId(tt.getId());
		vo.setItem(tt.getItem());
		vo.setItemCode(tt.getItemCode());
		vo.setItinerary(tt.getItinerary());
		vo.setMap(tt.getMap());
		vo.setMileage(tt.getMileage());
		vo.setPhotos(tt.getPhotos());
		vo.setRank(tt.getRank());
		vo.setRcdDays(tt.getRcdDays());
		vo.setTravelStyle(tt.getTravelStyle());
		vo.setShortContent(tt.getShortContent());
		vo.setSeason(tt.getSeason());
		vo.setScope(tt.getScope());
		vo.setRemark(tt.getRemark());
		vo.setRecommandReason(tt.getRecommandReason());
		vo.setRecommandEquip(tt.getRecommandEquip());
		vo.setRecommandCrowd(tt.getRecommandCrowd());
		vo.setValid(tt.isValid());
		vo.setHot(tt.isHot());
		vo.setCreateBy(tt.getCreateBy());
		vo.setUpdateBy(tt.getUpdateBy());
		vo.setStarLevel(tt.getStarLevel());
		vo.setTicketsBlock(tt.getTicketsBlock());
		vo.setFullyearTicket(tt.isFullyearTicket());
		vo.setAlias(tt.getAlias());
		vo.setBusyseason(tt.getBusyseason());
		vo.setFreeseason(tt.getFreeseason());
		return vo;
	}
}

