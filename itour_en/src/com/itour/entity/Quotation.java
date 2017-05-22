package com.itour.entity;

import com.itour.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>QuotationEntity<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class Quotation extends BaseEntity {
	
		private java.lang.String id;//   	private java.lang.String name;//   	private java.lang.String orderId;//   	private java.lang.String quotation;//   	private java.util.Date createTime;//   	private java.util.Date updateTime;//   	private java.lang.String remark;//   	private java.lang.String type;//   1= 总价加利润,2= 明细报价	private BigDecimal totalPrice;//   	private java.lang.String formula;// 
	private boolean isValid;
	
	
		public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public java.lang.String getId() {	    return this.id;	}	public void setId(java.lang.String id) {	    this.id=id;	}
	public java.lang.String getName() {
		return name;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.String getOrderId() {
		return orderId;
	}
	public void setOrderId(java.lang.String orderId) {
		this.orderId = orderId;
	}
	public java.lang.String getQuotation() {
		return quotation;
	}
	public void setQuotation(java.lang.String quotation) {
		this.quotation = quotation;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public java.lang.String getFormula() {
		return formula;
	}
	public void setFormula(java.lang.String formula) {
		this.formula = formula;
	}	
}

