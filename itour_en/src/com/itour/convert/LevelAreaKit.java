package com.itour.convert;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;
import com.itour.base.util.DateUtil;
import com.itour.entity.LevelArea;
import com.itour.vo.LevelAreaVO;

public class LevelAreaKit {
	/**
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public static LevelArea toEntity(LevelAreaVO vo)throws Exception{
		LevelArea areas = new LevelArea();
		areas.setId(vo.getId());
		areas.setLevel1Area(vo.getLevel1Area());
		areas.setLevel2Area(vo.getLevel2Area());
		areas.setTravelItem(vo.getTravelItem());
		areas.setCreateBy(vo.getCreateBy());
		areas.setUpdateBy(vo.getUpdateBy());
		if(StringUtils.isNotEmpty(vo.getCreateTime())){
			areas.setCreateTime(DateUtil.fromStringToDate(DateUtil.y_m_dhms, vo.getCreateTime()));
		}
		if(StringUtils.isNotEmpty(vo.getUpdateTime())){
			areas.setUpdateTime(DateUtil.fromStringToDate(DateUtil.y_m_dhms, vo.getUpdateTime()));
		}
		areas.setRemark(vo.getRemark());
		areas.setAliasCode(vo.getAliasCode());
		areas.setValid(vo.getValid());
		areas.setRouteTemplate(vo.getRouteTemplate());
		return areas;
	}
	/**
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public static LevelAreaVO toVo(LevelArea vo)throws Exception{
		LevelAreaVO areas = new LevelAreaVO();
		areas.setId(vo.getId());
		areas.setLevel1Area(vo.getLevel1Area());
		areas.setLevel2Area(vo.getLevel2Area());
		areas.setTravelItem(vo.getTravelItem());
		areas.setCreateBy(vo.getCreateBy());
		areas.setUpdateBy(vo.getUpdateBy());
		areas.setCreateTime(DateUtil.getDateYmdHs(vo.getCreateTime()));
		areas.setUpdateTime(DateUtil.getDateYmdHs(vo.getUpdateTime()));
		areas.setRemark(vo.getRemark());
		areas.setAliasCode(vo.getAliasCode());
		areas.setValid(vo.getValid());
		areas.setRouteTemplate(vo.getRouteTemplate());
		return areas;
	}
	/**
	 * 
	 * @param vo
	 * @return
	 */
	public static Map<String,String> toRecord(LevelArea vo){
		Map<String,String> map = Maps.newHashMap();
		map.put("id", vo.getId());
		map.put("level1Area",vo.getLevel1Area());
		map.put("level2Area", vo.getLevel2Area());
		map.put("travelItem", vo.getTravelItem());
		map.put("remark", vo.getRemark());
		map.put("createBy", vo.getCreateBy());
		map.put("updateBy", vo.getUpdateBy());
		map.put("createTime", DateUtil.getDateYmdHs(vo.getCreateTime()));
		map.put("updateTime", DateUtil.getDateYmdHs(vo.getUpdateTime()));
		map.put("aliasCode", vo.getAliasCode());
		map.put("valid", vo.getValid()==1?"是":"否");
		map.put("routeTemplate", vo.getRouteTemplate());
		return map;
	}
	/**
	 * 
	 * @param vo
	 * @return
	 */
	public static Map<String,String> votoRecord(LevelAreaVO vo){
		Map<String,String> map = Maps.newHashMap();
		map.put("id", vo.getId());
		map.put("level1Area",vo.getLevel1Area());
		map.put("level2Area", vo.getLevel2Area());
		map.put("travelItem", vo.getTravelItem());
		map.put("remark", vo.getRemark());
		map.put("createBy", vo.getCreateBy());
		map.put("updateBy", vo.getUpdateBy());
		map.put("createTime", vo.getCreateTime());
		map.put("updateTime", vo.getUpdateTime());
		map.put("aliasCode", vo.getAliasCode());
		map.put("valid", vo.getValid()==1?"是":"否");
		map.put("item", vo.getItem());
		map.put("alias", vo.getAlias());
		map.put("title", vo.getTitle());
		map.put("routeTemplate", vo.getRouteTemplate());
		return map;
	}
}
