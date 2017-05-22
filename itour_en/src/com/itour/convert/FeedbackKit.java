package com.itour.convert;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;

import com.itour.base.util.DateUtil;
import com.itour.entity.Feedback;
import com.itour.vo.FeedbackVo;
/**
 * 
 * <br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class FeedbackKit{
	
	public static FeedbackVo toRecord(Feedback fb){
		FeedbackVo vo = new FeedbackVo();
		vo.setContent(fb.getContent());
		if(fb.getCreateTime() !=null){	
			vo.setCreateTime(DateUtil.getDateYmdHs(fb.getCreateTime()));
		}
		vo.setCustomerId(fb.getCustomerId());
		vo.setCustomerName(fb.getCustomerName());
		vo.setEmail(fb.getEmail());
		vo.setId(fb.getId());
		vo.setMobile(fb.getMobile());
		vo.setResult(fb.getResult());
		vo.setStatus(fb.getStatus());
		vo.setTitle(fb.getTitle());
		vo.setName(fb.getName());
		vo.setTeamPersons(fb.getTeamPersons());
		if(fb.getPreferedDate() !=null){	
			vo.setPreferedDate(DateUtil.getDateYmdHs(fb.getPreferedDate()));
		}
		if(fb.getUpdateTime() !=null){
			vo.setUpdateTime(DateUtil.getDateYmdHs(fb.getUpdateTime()));
		}
		vo.setValid(fb.isValid());
		vo.setRoute(fb.getRoute());
		vo.setSex(fb.isSex());
		vo.setPublicShow(fb.isPublicShow());
		return vo;
	}
	
	public static Feedback toEntity(FeedbackVo fb){
		Feedback bean = new Feedback();
		try {
			bean.setContent(fb.getContent());
			if(StringUtils.isNotEmpty(fb.getCreateTime())){				
				bean.setCreateTime(DateUtil.fromStringToDate(DateUtil.ymdhm, fb.getCreateTime()));
			}
			bean.setCustomerId(fb.getCustomerId());
			bean.setCustomerName(fb.getCustomerName());
			bean.setEmail(fb.getEmail());
			bean.setId(fb.getId());
			bean.setMobile(fb.getMobile());
			bean.setResult(fb.getResult());
			bean.setStatus(fb.getStatus());
			bean.setTitle(fb.getTitle());
			bean.setName(fb.getName());
			bean.setTeamPersons(fb.getTeamPersons());
			if(StringUtils.isNotEmpty(fb.getPreferedDate())){
				bean.setPreferedDate(new Timestamp(DateUtil.fromStringToDate(DateUtil.ymdhm, fb.getPreferedDate()).getTime()));
			}
			if(StringUtils.isNotEmpty(fb.getUpdateTime())){
				bean.setUpdateTime(DateUtil.fromStringToDate(DateUtil.ymdhm, fb.getUpdateTime()));
			}
			bean.setValid(fb.isValid());
			bean.setRoute(fb.getRoute());
			bean.setSex(fb.isSex());
			bean.setPublicShow(fb.isPublicShow());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return bean;
	}
}

