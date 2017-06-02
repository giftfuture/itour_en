package com.itour.convert;

import com.itour.base.util.DateUtil;
import com.itour.entity.Quotation;
import com.itour.vo.QuotationVO;
/**
 * 
 * <br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class QuotationKit {
	public static QuotationVO toRecord(Quotation qu){
		QuotationVO vo = new QuotationVO();
		vo.setCreateTime(DateUtil.getDateYmdHs(qu.getCreateTime()));
		vo.setFormula(qu.getFormula());
		vo.setId(qu.getId());
		vo.setName(qu.getName());
		vo.setOrderId(qu.getOrderId());
		vo.setQuotation(qu.getQuotation());
		vo.setRemark(qu.getRemark());
		vo.setTotalPrice(qu.getTotalPrice());
		vo.setType(qu.getType());
		vo.setUpdateTime(DateUtil.getDateYmdHs(qu.getUpdateTime()));
		vo.setValid(qu.getValid());
		return vo;
	}
}

