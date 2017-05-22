package com.itour.convert;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;
import com.itour.base.util.DateUtil;
import com.itour.entity.AdLink;
import com.itour.vo.AdLinkVo;

public class AdLinkKit {
	
	/**
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public static AdLink toEntity(AdLinkVo vo)throws Exception{
		AdLink adlink = new AdLink();
		adlink.setId(vo.getId());
		adlink.setAdvertise(vo.getAdvertise());
		adlink.setAdlink(vo.getAdlink());
		adlink.setValid(vo.isValid());
		adlink.setTitle(vo.getTitle());
		adlink.setRemark(vo.getRemark());
		adlink.setCreateBy(vo.getCreateBy());
		adlink.setUpdateBy(vo.getUpdateBy());
		adlink.setVideo(vo.isVideo());
		if(StringUtils.isNotEmpty(vo.getCreateTime())){
			adlink.setCreateTime(DateUtil.fromStringToDate(DateUtil.y_m_dhms, vo.getCreateTime()));
		}
		if(StringUtils.isNotEmpty(vo.getUpdateTime())){
			adlink.setUpdateTime(DateUtil.fromStringToDate(DateUtil.y_m_dhms, vo.getUpdateTime()));
		}
		return adlink;
	}
	
	/***
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public static AdLinkVo toVo(AdLink vo)throws Exception{
		AdLinkVo adlink = new AdLinkVo();
		adlink.setId(vo.getId());
		adlink.setAdvertise(vo.getAdvertise());
		adlink.setAdlink(vo.getAdlink());
		adlink.setValid(vo.isValid());
		adlink.setTitle(vo.getTitle());
		adlink.setRemark(vo.getRemark());
		adlink.setCreateBy(vo.getCreateBy());
		adlink.setUpdateBy(vo.getUpdateBy());
		adlink.setCreateTime(DateUtil.getDateYmdHs(vo.getCreateTime()));
		adlink.setUpdateTime(DateUtil.getDateYmdHs(vo.getUpdateTime()));
		return adlink;
	}
	
	/**
	 * 
	 * @param vo
	 * @return
	 */
	public static Map<String,String> toRecord(AdLink vo){
		Map<String,String> map = Maps.newHashMap();
		map.put("id", vo.getId());
		map.put("advertise",vo.getAdvertise());
		map.put("adlink", vo.getAdlink());
		map.put("valid", vo.isValid()?"是":"否");
		map.put("title", vo.getTitle());
		map.put("remark", vo.getRemark());
		map.put("createBy", vo.getCreateBy());
		map.put("updateBy", vo.getUpdateBy());
		return map;
	}
}
