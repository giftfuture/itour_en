package com.itour.convert;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.itour.base.page.BasePage;
import com.itour.entity.Customers;
import com.itour.vo.CustomerVo;
/**
 * 
 * <br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class CustomerKit {
	
	/**
	 * 
	 * @param vo
	 * @return
	 */
	public static Map<String, Object> toRecord(CustomerVo vo){
		Map<String, Object> record = new HashMap<String, Object>();
		record.put("id", vo.getId());
		record.put("customerId", vo.getCustomerId());
		record.put("createTime", vo.getCreateTime());
		record.put("status", vo.getStatus());
		record.put("updateTime", vo.getUpdateTime());
		record.put("address", vo.getAddress());
		record.put("email", vo.getEmail());
		record.put("scope", vo.getScope());
		record.put("city", vo.getCity());
		record.put("telephone", vo.getTelephone());
		record.put("mobile", vo.getMobile());
		record.put("customerName", vo.getCustomerName());
		record.put("nickName", vo.getNickName());
		record.put("district", vo.getDistrict());
		record.put("introduction", vo.getIntroduction());
		record.put("birthday", vo.getBirthday());
		record.put("isValid", vo.isValid());
		return record;
	}
	public static Map<String, Object> toRecord(Customers vo){
		Map<String, Object> record = new HashMap<String, Object>();
		record.put("id", vo.getId());
		record.put("customerId", vo.getCustomerId());
		record.put("createTime", vo.getCreateTime());
		record.put("status", vo.getStatus());
		record.put("updateTime", vo.getUpdateTime());
		record.put("address", vo.getAddress());
		record.put("email", vo.getEmail());
		record.put("scope", vo.getScope());
		record.put("city", vo.getCity());
		record.put("telephone", vo.getTelephone());
		record.put("mobile", vo.getMobile());
		record.put("customerName", vo.getCustomerName());
		record.put("nickName", vo.getNickName());
		record.put("district", vo.getDistrict());
		record.put("introduction", vo.getIntroduction());
		record.put("birthday", vo.getBirthday());
		record.put("isValid", vo.isValid());
		return record;
	}
}

