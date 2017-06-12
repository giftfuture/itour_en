package com.itour.vo;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonIgnoreProperties(ignoreUnknown = true)//忽略未知属性  
@JsonInclude(Include.NON_NULL)
public class CalculateQuoteVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1300472899677326380L;
	private String id;
	private int adults;
	private int children;
	private float adultPrice;
	private float childPrice;
	private float ticketTotalPrice;
	private String rtid;
	private String torderid;
	private float plusSumPrice;
	private float plusDevicePrice;
	private String quoteadults;
	private String quotechildren;
	private String quoteticketadults;
	private String quoteticketchildren;
	private String quotetraveldocadults;
	private String quotetraveldocchildren;
	private String quotetourguideadults;
	private String quotetourguidechildren;
	private String quoteshowHoteladults;
	private String quoteshowHotelchildren;
	private String quoterentcaradults;
	private String quoterentcarchildren;
	private String quotebigtrafficadults;
	private String quotebigtrafficchildren;
	private String quotedinneradults;
	private String quotedinnerchildren;
	private String quoteinsuranceadults;
	private String quoteinsurancechildren;
	private String quotecomphcostadults;
	private String quotecomphcostchildren;
	private String quoterecreationadults;
	private String quoterecreationchildren;
	
	private String quoteitemguidecadults;
	private String quoteitemguidechildren;
	private String quotebathorseadults;
	private String quotebathorsecchildren;
	private String quoteridehorseadults;
	private String quoteridehorsechildren;
	private String quoteclimbregisteradults;
	private String quoteclimbregisterchildren;
	private String quoteclimbnexusadults;
	private String quoteclimbnexuschildren;
	private String quoteelsecostadults;
	private String quoteelseecostchildren;
	
	private String adultsumcost;
	private String childrensumcost;
	private String isShowDetail;
	
	private float adultticketTotalPrice;
	private String adultticketsBlock;
	private String quotetraveldocadultsBlock;
	private String quotetourguideadultsBlock;
	private String quoterentcaradultsBlock;
	private String quotebigtrafficadultsBlock;
	private String quoteinsuranceadultsBlock;
	private String quotecomphcostadultsBlock;
	private String quoterecreationadultsBlock;
	private String quoteitemguidecadultsBlock;
	private String quotebathorseadultsBlock;
	private String quoteridehorseadultsBlock;
	private String quoteclimbregisteradultsBlock;
	private String quoteclimbnexusadultsBlock;
	private String quoteelsecostadultsBlock;
	
	private float quotetraveldocadultsSumCost;
	private float quotetourguideadultsSumCost;
	private float quoterentcaradultsSumCost;
	private float quotebigtrafficadultsSumCost;
	private float quoteinsuranceadultsSumCost;
	private float quotecomphcostadultsSumCost;
	private float quoterecreationadultsSumCost;
	private float quoteitemguidecadultsSumCost;
	private float quotebathorseadultsSumCost;
	private float quoteridehorseadultsSumCost;
	private float quoteclimbregisteradultsSumCost;
	private float quoteclimbnexusadultsSumCost;
	private float quoteelsecostadultsSumCost;
	
	
	public int getAdults() {
		return adults;
	}
	public void setAdults(int adults) {
		this.adults = adults;
	}
	public int getChildren() {
		return children;
	}
	public void setChildren(int children) {
		this.children = children;
	}
	public float getAdultticketTotalPrice() {
		return adultticketTotalPrice;
	}
	public void setAdultticketTotalPrice(float adultticketTotalPrice) {
		this.adultticketTotalPrice = adultticketTotalPrice;
	}
	public String getAdultticketsBlock() {
		return adultticketsBlock;
	}
	public void setAdultticketsBlock(String adultticketsBlock) {
		this.adultticketsBlock = adultticketsBlock;
	}
	public String getQuotetraveldocadultsBlock() {
		return quotetraveldocadultsBlock;
	}
	public void setQuotetraveldocadultsBlock(String quotetraveldocadultsBlock) {
		this.quotetraveldocadultsBlock = quotetraveldocadultsBlock;
	}
	public String getQuotetourguideadultsBlock() {
		return quotetourguideadultsBlock;
	}
	public void setQuotetourguideadultsBlock(String quotetourguideadultsBlock) {
		this.quotetourguideadultsBlock = quotetourguideadultsBlock;
	}
	public String getQuoterentcaradultsBlock() {
		return quoterentcaradultsBlock;
	}
	public void setQuoterentcaradultsBlock(String quoterentcaradultsBlock) {
		this.quoterentcaradultsBlock = quoterentcaradultsBlock;
	}
	public String getQuotebigtrafficadultsBlock() {
		return quotebigtrafficadultsBlock;
	}
	public void setQuotebigtrafficadultsBlock(String quotebigtrafficadultsBlock) {
		this.quotebigtrafficadultsBlock = quotebigtrafficadultsBlock;
	}
	public String getQuoteinsuranceadultsBlock() {
		return quoteinsuranceadultsBlock;
	}
	public void setQuoteinsuranceadultsBlock(String quoteinsuranceadultsBlock) {
		this.quoteinsuranceadultsBlock = quoteinsuranceadultsBlock;
	}
	public String getQuotecomphcostadultsBlock() {
		return quotecomphcostadultsBlock;
	}
	public void setQuotecomphcostadultsBlock(String quotecomphcostadultsBlock) {
		this.quotecomphcostadultsBlock = quotecomphcostadultsBlock;
	}
	public String getQuoterecreationadultsBlock() {
		return quoterecreationadultsBlock;
	}
	public void setQuoterecreationadultsBlock(String quoterecreationadultsBlock) {
		this.quoterecreationadultsBlock = quoterecreationadultsBlock;
	}
	public String getQuoteitemguidecadultsBlock() {
		return quoteitemguidecadultsBlock;
	}
	public void setQuoteitemguidecadultsBlock(String quoteitemguidecadultsBlock) {
		this.quoteitemguidecadultsBlock = quoteitemguidecadultsBlock;
	}
	public String getQuotebathorseadultsBlock() {
		return quotebathorseadultsBlock;
	}
	public void setQuotebathorseadultsBlock(String quotebathorseadultsBlock) {
		this.quotebathorseadultsBlock = quotebathorseadultsBlock;
	}
	public String getQuoteridehorseadultsBlock() {
		return quoteridehorseadultsBlock;
	}
	public void setQuoteridehorseadultsBlock(String quoteridehorseadultsBlock) {
		this.quoteridehorseadultsBlock = quoteridehorseadultsBlock;
	}
	public String getQuoteclimbregisteradultsBlock() {
		return quoteclimbregisteradultsBlock;
	}
	public void setQuoteclimbregisteradultsBlock(String quoteclimbregisteradultsBlock) {
		this.quoteclimbregisteradultsBlock = quoteclimbregisteradultsBlock;
	}
	public String getQuoteclimbnexusadultsBlock() {
		return quoteclimbnexusadultsBlock;
	}
	public void setQuoteclimbnexusadultsBlock(String quoteclimbnexusadultsBlock) {
		this.quoteclimbnexusadultsBlock = quoteclimbnexusadultsBlock;
	}
	public String getQuoteelsecostadultsBlock() {
		return quoteelsecostadultsBlock;
	}
	public void setQuoteelsecostadultsBlock(String quoteelsecostadultsBlock) {
		this.quoteelsecostadultsBlock = quoteelsecostadultsBlock;
	}
	public float getQuotetraveldocadultsSumCost() {
		return quotetraveldocadultsSumCost;
	}
	public void setQuotetraveldocadultsSumCost(float quotetraveldocadultsSumCost) {
		this.quotetraveldocadultsSumCost = quotetraveldocadultsSumCost;
	}
	public float getQuoteelsecostadultsSumCost() {
		return quoteelsecostadultsSumCost;
	}
	public void setQuoteelsecostadultsSumCost(float quoteelsecostadultsSumCost) {
		this.quoteelsecostadultsSumCost = quoteelsecostadultsSumCost;
	}
	public float getQuotetourguideadultsSumCost() {
		return quotetourguideadultsSumCost;
	}
	public void setQuotetourguideadultsSumCost(float quotetourguideadultsSumCost) {
		this.quotetourguideadultsSumCost = quotetourguideadultsSumCost;
	}
	public float getQuoterentcaradultsSumCost() {
		return quoterentcaradultsSumCost;
	}
	public void setQuoterentcaradultsSumCost(float quoterentcaradultsSumCost) {
		this.quoterentcaradultsSumCost = quoterentcaradultsSumCost;
	}
	public float getQuotebigtrafficadultsSumCost() {
		return quotebigtrafficadultsSumCost;
	}
	public void setQuotebigtrafficadultsSumCost(float quotebigtrafficadultsSumCost) {
		this.quotebigtrafficadultsSumCost = quotebigtrafficadultsSumCost;
	}
	public float getQuoteinsuranceadultsSumCost() {
		return quoteinsuranceadultsSumCost;
	}
	public void setQuoteinsuranceadultsSumCost(float quoteinsuranceadultsSumCost) {
		this.quoteinsuranceadultsSumCost = quoteinsuranceadultsSumCost;
	}
	public float getQuotecomphcostadultsSumCost() {
		return quotecomphcostadultsSumCost;
	}
	public void setQuotecomphcostadultsSumCost(float quotecomphcostadultsSumCost) {
		this.quotecomphcostadultsSumCost = quotecomphcostadultsSumCost;
	}
	public float getQuoterecreationadultsSumCost() {
		return quoterecreationadultsSumCost;
	}
	public void setQuoterecreationadultsSumCost(float quoterecreationadultsSumCost) {
		this.quoterecreationadultsSumCost = quoterecreationadultsSumCost;
	}
	public float getQuoteitemguidecadultsSumCost() {
		return quoteitemguidecadultsSumCost;
	}
	public void setQuoteitemguidecadultsSumCost(float quoteitemguidecadultsSumCost) {
		this.quoteitemguidecadultsSumCost = quoteitemguidecadultsSumCost;
	}
	public float getQuotebathorseadultsSumCost() {
		return quotebathorseadultsSumCost;
	}
	public void setQuotebathorseadultsSumCost(float quotebathorseadultsSumCost) {
		this.quotebathorseadultsSumCost = quotebathorseadultsSumCost;
	}
	public float getQuoteridehorseadultsSumCost() {
		return quoteridehorseadultsSumCost;
	}
	public void setQuoteridehorseadultsSumCost(float quoteridehorseadultsSumCost) {
		this.quoteridehorseadultsSumCost = quoteridehorseadultsSumCost;
	}
	public float getQuoteclimbregisteradultsSumCost() {
		return quoteclimbregisteradultsSumCost;
	}
	public void setQuoteclimbregisteradultsSumCost(float quoteclimbregisteradultsSumCost) {
		this.quoteclimbregisteradultsSumCost = quoteclimbregisteradultsSumCost;
	}
	public float getQuoteclimbnexusadultsSumCost() {
		return quoteclimbnexusadultsSumCost;
	}
	public void setQuoteclimbnexusadultsSumCost(float quoteclimbnexusadultsSumCost) {
		this.quoteclimbnexusadultsSumCost = quoteclimbnexusadultsSumCost;
	}
	public float getTicketTotalPrice() {
		return ticketTotalPrice;
	}
	public void setTicketTotalPrice(float ticketTotalPrice) {
		this.ticketTotalPrice = ticketTotalPrice;
	}
	public String getIsShowDetail() {
		return isShowDetail;
	}
	public void setIsShowDetail(String isShowDetail) {
		this.isShowDetail = isShowDetail;
	}
	public String getAdultsumcost() {
		return adultsumcost;
	}
	public void setAdultsumcost(String adultsumcost) {
		this.adultsumcost = adultsumcost;
	}
	public String getChildrensumcost() {
		return childrensumcost;
	}
	public void setChildrensumcost(String childrensumcost) {
		this.childrensumcost = childrensumcost;
	}
	public String getTorderid() {
		return torderid;
	}
	public void setTorderid(String torderid) {
		this.torderid = torderid;
	}
	public String getRtid() {
		return rtid;
	}
	public void setRtid(String rtid) {
		this.rtid = rtid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getAdultPrice() {
		return adultPrice;
	}
	public void setAdultPrice(float adultPrice) {
		this.adultPrice = adultPrice;
	}
	public float getChildPrice() {
		return childPrice;
	}
	public void setChildPrice(float childPrice) {
		this.childPrice = childPrice;
	}
	public String getQuoteadults() {
		return quoteadults;
	}
	public void setQuoteadults(String quoteadults) {
		this.quoteadults = quoteadults;
	}
	public String getQuotechildren() {
		return quotechildren;
	}
	public void setQuotechildren(String quotechildren) {
		this.quotechildren = quotechildren;
	}
	public String getQuoteticketadults() {
		return quoteticketadults;
	}
	public void setQuoteticketadults(String quoteticketadults) {
		this.quoteticketadults = quoteticketadults;
	}
	public String getQuoteticketchildren() {
		return quoteticketchildren;
	}
	public void setQuoteticketchildren(String quoteticketchildren) {
		this.quoteticketchildren = quoteticketchildren;
	}
	public String getQuotetraveldocadults() {
		return quotetraveldocadults;
	}
	public void setQuotetraveldocadults(String quotetraveldocadults) {
		this.quotetraveldocadults = quotetraveldocadults;
	}
	public String getQuotetraveldocchildren() {
		return quotetraveldocchildren;
	}
	public void setQuotetraveldocchildren(String quotetraveldocchildren) {
		this.quotetraveldocchildren = quotetraveldocchildren;
	}
	public String getQuotetourguideadults() {
		return quotetourguideadults;
	}
	public void setQuotetourguideadults(String quotetourguideadults) {
		this.quotetourguideadults = quotetourguideadults;
	}
	public String getQuotetourguidechildren() {
		return quotetourguidechildren;
	}
	public void setQuotetourguidechildren(String quotetourguidechildren) {
		this.quotetourguidechildren = quotetourguidechildren;
	}
	public String getQuoteshowHoteladults() {
		return quoteshowHoteladults;
	}
	public void setQuoteshowHoteladults(String quoteshowHoteladults) {
		this.quoteshowHoteladults = quoteshowHoteladults;
	}
	public String getQuoteshowHotelchildren() {
		return quoteshowHotelchildren;
	}
	public void setQuoteshowHotelchildren(String quoteshowHotelchildren) {
		this.quoteshowHotelchildren = quoteshowHotelchildren;
	}
	public String getQuoterentcaradults() {
		return quoterentcaradults;
	}
	public void setQuoterentcaradults(String quoterentcaradults) {
		this.quoterentcaradults = quoterentcaradults;
	}
	public String getQuoterentcarchildren() {
		return quoterentcarchildren;
	}
	public void setQuoterentcarchildren(String quoterentcarchildren) {
		this.quoterentcarchildren = quoterentcarchildren;
	}
	public String getQuotebigtrafficadults() {
		return quotebigtrafficadults;
	}
	public void setQuotebigtrafficadults(String quotebigtrafficadults) {
		this.quotebigtrafficadults = quotebigtrafficadults;
	}
	public String getQuotebigtrafficchildren() {
		return quotebigtrafficchildren;
	}
	public void setQuotebigtrafficchildren(String quotebigtrafficchildren) {
		this.quotebigtrafficchildren = quotebigtrafficchildren;
	}
	public String getQuotedinneradults() {
		return quotedinneradults;
	}
	public void setQuotedinneradults(String quotedinneradults) {
		this.quotedinneradults = quotedinneradults;
	}
	public String getQuotedinnerchildren() {
		return quotedinnerchildren;
	}
	public void setQuotedinnerchildren(String quotedinnerchildren) {
		this.quotedinnerchildren = quotedinnerchildren;
	}
	public String getQuoteinsuranceadults() {
		return quoteinsuranceadults;
	}
	public void setQuoteinsuranceadults(String quoteinsuranceadults) {
		this.quoteinsuranceadults = quoteinsuranceadults;
	}
	public String getQuoteinsurancechildren() {
		return quoteinsurancechildren;
	}
	public void setQuoteinsurancechildren(String quoteinsurancechildren) {
		this.quoteinsurancechildren = quoteinsurancechildren;
	}
	public String getQuotecomphcostadults() {
		return quotecomphcostadults;
	}
	public void setQuotecomphcostadults(String quotecomphcostadults) {
		this.quotecomphcostadults = quotecomphcostadults;
	}
	public String getQuotecomphcostchildren() {
		return quotecomphcostchildren;
	}
	public void setQuotecomphcostchildren(String quotecomphcostchildren) {
		this.quotecomphcostchildren = quotecomphcostchildren;
	}
	public String getQuoterecreationadults() {
		return quoterecreationadults;
	}
	public void setQuoterecreationadults(String quoterecreationadults) {
		this.quoterecreationadults = quoterecreationadults;
	}
	public String getQuoterecreationchildren() {
		return quoterecreationchildren;
	}
	public void setQuoterecreationchildren(String quoterecreationchildren) {
		this.quoterecreationchildren = quoterecreationchildren;
	}
	public String getQuotebathorseadults() {
		return quotebathorseadults;
	}
	public void setQuotebathorseadults(String quotebathorseadults) {
		this.quotebathorseadults = quotebathorseadults;
	}
	public String getQuotebathorsecchildren() {
		return quotebathorsecchildren;
	}
	public void setQuotebathorsecchildren(String quotebathorsecchildren) {
		this.quotebathorsecchildren = quotebathorsecchildren;
	}
	public String getQuoteitemguidecadults() {
		return quoteitemguidecadults;
	}
	public void setQuoteitemguidecadults(String quoteitemguidecadults) {
		this.quoteitemguidecadults = quoteitemguidecadults;
	}
	public String getQuoteitemguidechildren() {
		return quoteitemguidechildren;
	}
	public void setQuoteitemguidechildren(String quoteitemguidechildren) {
		this.quoteitemguidechildren = quoteitemguidechildren;
	}
	public String getQuoteridehorseadults() {
		return quoteridehorseadults;
	}
	public void setQuoteridehorseadults(String quoteridehorseadults) {
		this.quoteridehorseadults = quoteridehorseadults;
	}
	public String getQuoteridehorsechildren() {
		return quoteridehorsechildren;
	}
	public void setQuoteridehorsechildren(String quoteridehorsechildren) {
		this.quoteridehorsechildren = quoteridehorsechildren;
	}
	public String getQuoteclimbregisteradults() {
		return quoteclimbregisteradults;
	}
	public void setQuoteclimbregisteradults(String quoteclimbregisteradults) {
		this.quoteclimbregisteradults = quoteclimbregisteradults;
	}
	public String getQuoteclimbregisterchildren() {
		return quoteclimbregisterchildren;
	}
	public void setQuoteclimbregisterchildren(String quoteclimbregisterchildren) {
		this.quoteclimbregisterchildren = quoteclimbregisterchildren;
	}
	public String getQuoteclimbnexusadults() {
		return quoteclimbnexusadults;
	}
	public void setQuoteclimbnexusadults(String quoteclimbnexusadults) {
		this.quoteclimbnexusadults = quoteclimbnexusadults;
	}
	public String getQuoteclimbnexuschildren() {
		return quoteclimbnexuschildren;
	}
	public void setQuoteclimbnexuschildren(String quoteclimbnexuschildren) {
		this.quoteclimbnexuschildren = quoteclimbnexuschildren;
	}
	public String getQuoteelsecostadults() {
		return quoteelsecostadults;
	}
	public void setQuoteelsecostadults(String quoteelsecostadults) {
		this.quoteelsecostadults = quoteelsecostadults;
	}
	public String getQuoteelseecostchildren() {
		return quoteelseecostchildren;
	}
	public void setQuoteelseecostchildren(String quoteelseecostchildren) {
		this.quoteelseecostchildren = quoteelseecostchildren;
	}
	public float getPlusSumPrice() {
		return plusSumPrice;
	}
	public void setPlusSumPrice(float plusSumPrice) {
		float sum = 0f;
		sum+=StringUtils.isNotEmpty(this.quoteadults)?Float.parseFloat(this.quoteadults):0f;
		sum+=StringUtils.isNotEmpty(this.quotebathorseadults)?Float.parseFloat(this.quotebathorseadults):0f;
		sum+=StringUtils.isNotEmpty(this.quotebigtrafficadults)?Float.parseFloat(this.quotebigtrafficadults):0f;
		sum+=StringUtils.isNotEmpty(this.quoteclimbnexusadults)?Float.parseFloat(this.quoteclimbnexusadults):0f;
		sum+=StringUtils.isNotEmpty(this.quoteclimbregisteradults)?Float.parseFloat(this.quoteclimbregisteradults):0f;
		sum+=StringUtils.isNotEmpty(this.quotecomphcostadults)?Float.parseFloat(this.quotecomphcostadults):0f;
		sum+=StringUtils.isNotEmpty(this.quotedinneradults)?Float.parseFloat(this.quotedinneradults):0f;
		sum+=StringUtils.isNotEmpty(this.quoteelsecostadults)?Float.parseFloat(this.quoteelsecostadults):0f;
		sum+=StringUtils.isNotEmpty(this.quoteinsuranceadults)?Float.parseFloat(this.quoteinsuranceadults):0f;
		sum+=StringUtils.isNotEmpty(this.quoteitemguidecadults)?Float.parseFloat(this.quoteitemguidecadults):0f;
		sum+=StringUtils.isNotEmpty(this.quotetraveldocadults)?Float.parseFloat(this.quotetraveldocadults):0f;
		sum+=StringUtils.isNotEmpty(this.quoterecreationadults)?Float.parseFloat(this.quoterecreationadults):0f;
		sum+=StringUtils.isNotEmpty(this.quoterentcaradults)?Float.parseFloat(this.quoterentcaradults):0f;
		sum+=StringUtils.isNotEmpty(this.quoteridehorseadults)?Float.parseFloat(this.quoteridehorseadults):0f;
		sum+=StringUtils.isNotEmpty(this.quoteshowHoteladults)?Float.parseFloat(this.quoteshowHoteladults):0f;
		sum+=StringUtils.isNotEmpty(this.quoteticketadults)?Float.parseFloat(this.quoteticketadults):0f;
		sum+=StringUtils.isNotEmpty(this.quotetourguideadults)?Float.parseFloat(this.quotetourguideadults):0f;
		this.plusSumPrice = sum;
	}
	public float getPlusDevicePrice() {
		return plusDevicePrice;
	}
	public void setPlusDevicePrice(float plusDevicePrice) {
		float sum = 0f;
		sum+=StringUtils.isNotEmpty(this.quotechildren)?Float.parseFloat(this.quotechildren):0f;
		sum+=StringUtils.isNotEmpty(this.quotebathorsecchildren)?Float.parseFloat(this.quotebathorsecchildren):0f;
		sum+=StringUtils.isNotEmpty(this.quotebigtrafficchildren)?Float.parseFloat(this.quotebigtrafficchildren):0f;
		sum+=StringUtils.isNotEmpty(this.quoteclimbnexuschildren)?Float.parseFloat(this.quoteclimbnexuschildren):0f;
		sum+=StringUtils.isNotEmpty(this.quoteclimbregisterchildren)?Float.parseFloat(this.quoteclimbregisterchildren):0f;
		sum+=StringUtils.isNotEmpty(this.quotecomphcostchildren)?Float.parseFloat(this.quotecomphcostchildren):0f;
		sum+=StringUtils.isNotEmpty(this.quotedinnerchildren)?Float.parseFloat(this.quotedinnerchildren):0f;
		sum+=StringUtils.isNotEmpty(this.quoteelseecostchildren)?Float.parseFloat(this.quoteelseecostchildren):0f;
		sum+=StringUtils.isNotEmpty(this.quoteinsurancechildren)?Float.parseFloat(this.quoteinsurancechildren):0f;
		sum+=StringUtils.isNotEmpty(this.quoteitemguidechildren)?Float.parseFloat(this.quoteitemguidechildren):0f;
		sum+=StringUtils.isNotEmpty(this.quotetraveldocchildren)?Float.parseFloat(this.quotetraveldocchildren):0f;
		sum+=StringUtils.isNotEmpty(this.quoterecreationchildren)?Float.parseFloat(this.quoterecreationchildren):0f;
		sum+=StringUtils.isNotEmpty(this.quoterentcarchildren)?Float.parseFloat(this.quoterentcarchildren):0f;
		sum+=StringUtils.isNotEmpty(this.quoteridehorsechildren)?Float.parseFloat(this.quoteridehorsechildren):0f;
		sum+=StringUtils.isNotEmpty(this.quoteshowHotelchildren)?Float.parseFloat(this.quoteshowHotelchildren):0f;
		sum+=StringUtils.isNotEmpty(this.quoteticketchildren)?Float.parseFloat(this.quoteticketchildren):0f;
		sum+=StringUtils.isNotEmpty(this.quotetourguidechildren)?Float.parseFloat(this.quotetourguidechildren):0f;
		this.plusDevicePrice = sum;
	}
	
}
