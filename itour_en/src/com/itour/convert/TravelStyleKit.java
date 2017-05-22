package com.itour.convert;

import com.itour.entity.TravelStyle;
import com.itour.vo.TravelStyleVo;
/**
 * 
 * <br>
 * <b>功能：</b>TravelStyleEntity<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class TravelStyleKit{
	  public static TravelStyleVo toRecord(TravelStyle ts){
		  TravelStyleVo tv = new TravelStyleVo();
		  tv.setAlias(ts.getAlias());
		  tv.setId(ts.getId());
		  tv.setRemark(ts.getRemark());
		  tv.setType(ts.getType());
		  tv.setValid(ts.isValid());
		  tv.setDescrip(ts.getDescrip());
		  tv.setCover(ts.getCover());
		  tv.setCreateBy(ts.getCreateBy());
		  tv.setUpdateBy(ts.getUpdateBy());
		  tv.setCreateTime(ts.getCreateTime());
		  tv.setUpdateTime(ts.getUpdateTime());
		  return tv;
	  }
}

