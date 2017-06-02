package com.itour.convert;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.itour.base.util.DateUtil;
import com.itour.entity.ShowHappy;
import com.itour.vo.ShowHappyVO;

public class ShowHappyKit {
	/**
	 * 
	 * @param vo
	 * @return
	 */
	public static Map<String, Object> toRecord(ShowHappyVO vo){
		Map<String, Object> record = new HashMap<String, Object>();
		record.put("id", vo.getId());
		record.put("customer", vo.getCustomer());
		record.put("createTime", DateUtil.getFomartDate(vo.getCreateTime(),DateUtil.ymdcn));
		record.put("status", vo.getStatus());
		record.put("updateTime", DateUtil.getFomartDate(vo.getUpdateTime(),DateUtil.ymdcn));
		record.put("area", vo.getArea());
		record.put("content", vo.getContent());
		record.put("result", vo.getResult());
		record.put("signature", vo.getSignature());
		record.put("title", vo.getTitle());
		record.put("route", vo.getRoute());
		record.put("tourTime",vo.getTourTime());
		record.put("cover", vo.getCover());
		record.put("valid", vo.getValid());
		record.put("shortContent", vo.getShortContent());
		record.put("shCode", vo.getShCode());
		return record;
	}
	/**
	 * 
	 * @param vo
	 * @return
	 */
	public static ShowHappy toEntity(ShowHappyVO vo){
		ShowHappy sh = new ShowHappy();
		sh.setId(vo.getId());
		sh.setCustomer(vo.getCustomer());
		sh.setStatus(vo.getStatus());
		sh.setArea(vo.getArea());
		sh.setContent(vo.getContent());
		sh.setResult(vo.getResult());
		sh.setRoute(vo.getRoute());
		sh.setCreateTime(vo.getCreateTime());
		sh.setUpdateTime(vo.getUpdateTime());
		sh.setSignature(vo.getSignature());
		sh.setTitle(vo.getTitle());
	//	sh.setTourTime(vo.getTourTime());
		try {
			if(StringUtils.isNotEmpty(vo.getTourTime())){			
				sh.setTourTime(DateUtil.fromStringToDate(DateUtil.ymd,vo.getTourTime()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sh.setCover(vo.getCover());
		sh.setValid(vo.getValid());
		sh.setShortContent(vo.getShortContent());
		sh.setShCode(vo.getShCode());
		return sh;
	}
	/**
	 * 
	 * @param vo
	 * @return
	 */
	public static ShowHappyVO toVo(ShowHappy sh){
		ShowHappyVO vo = new ShowHappyVO();
		vo.setId(sh.getId());
		vo.setArea(sh.getArea());
		vo.setContent(sh.getContent());
		vo.setCreateTime(sh.getCreateTime());
		vo.setCustomer(sh.getCustomer());
		vo.setResult(sh.getResult());
		vo.setRoute(sh.getRoute());
		vo.setSignature(sh.getSignature());
		vo.setStatus(sh.getStatus());
		vo.setTitle(sh.getTitle());
		vo.setTourTime(DateUtil.getDateLong(sh.getTourTime()));
		vo.setUpdateTime(sh.getUpdateTime());
		vo.setCover(sh.getCover());
		vo.setValid(sh.getValid());
		vo.setShortContent(sh.getShortContent());
		vo.setShCode(sh.getShCode());
		return vo;
	}
	/**
	 * 
	 * @param sh
	 * @return
	 */
	public static Map<String, Object> toRecord(ShowHappy sh){
		Map<String, Object> record = new HashMap<String, Object>();
		record.put("id", sh.getId());
		record.put("customer", sh.getCustomer());
		if(sh.getCreateTime() !=null){
			record.put("createTime", DateUtil.getFomartDate(sh.getCreateTime(),DateUtil.ymdcn));
		}
		record.put("status", sh.getStatus());
		if(sh.getUpdateTime() !=null){
			record.put("updateTime", DateUtil.getFomartDate(sh.getUpdateTime(),DateUtil.ymdcn));
		}
		record.put("area", sh.getArea());
		record.put("content", sh.getContent());
		record.put("result", sh.getResult());
		record.put("signature", sh.getSignature());
		record.put("title", sh.getTitle());
		record.put("route", sh.getRoute());
		if(sh.getTourTime() !=null){
			record.put("tourTime",DateUtil.getFomartDate(sh.getTourTime(),DateUtil.ymdcn));
		}
		record.put("cover", sh.getCover());
		record.put("valid", sh.getValid());
		record.put("shortContent", sh.getShortContent());
		record.put("shCode", sh.getShCode());
		return record;
	}
}
