package com.itour.convert;

import java.util.Map;

import com.google.common.collect.Maps;
import com.itour.entity.Areas;
import com.itour.vo.AreasVo;

public class AreasKit {
	public static Areas toEntity(AreasVo vo)throws Exception{
		Areas areas = new Areas();
		areas.setId(vo.getId());
		areas.setAreacode(vo.getAreacode());
		areas.setAreaname(vo.getAreaname());
		areas.setBrief(vo.getBrief());
		areas.setLat(vo.getLat());
		areas.setLevel(vo.getLevel());
		areas.setLng(vo.getLng());
		areas.setParentid(vo.getParentid());
		areas.setPinyin(vo.getPinyin());
		areas.setPosition(vo.getPosition());
		areas.setShortname(vo.getShortname());
		areas.setSortnum(vo.getSortnum());
		areas.setZipcode(vo.getZipcode());
		return areas;
	}
	public static AreasVo toVo(Areas vo)throws Exception{
		AreasVo areas = new AreasVo();
		areas.setId(vo.getId());
		areas.setAreacode(vo.getAreacode());
		areas.setAreaname(vo.getAreaname());
		areas.setBrief(vo.getBrief());
		areas.setLat(vo.getLat());
		areas.setLevel(vo.getLevel());
		areas.setLng(vo.getLng());
		areas.setParentid(vo.getParentid());
		areas.setPinyin(vo.getPinyin());
		areas.setPosition(vo.getPosition());
		areas.setShortname(vo.getShortname());
		areas.setSortnum(vo.getSortnum());
		areas.setZipcode(vo.getZipcode());
		return areas;
	}
	public static Map<String,String> toRecord(Areas vo){
		Map<String,String> map = Maps.newHashMap();
		map.put("id", vo.getId());
		map.put("areacode",vo.getAreacode());
		map.put("areaname", vo.getAreaname());
		map.put("brief", vo.getBrief());
		map.put("lat", vo.getLat());
		map.put("level", vo.getLevel()+"");
		map.put("lng", vo.getLng());
		map.put("parentid",vo.getParentid()+"");
		map.put("pinyin", vo.getPinyin());
		map.put("position", vo.getPosition());
		map.put("shortname", vo.getShortname());
		map.put("sortnum", vo.getSortnum()+"");
		map.put("zipcode",vo.getZipcode());
		return map;
	}
}
