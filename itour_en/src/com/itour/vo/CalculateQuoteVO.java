package com.itour.vo;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class CalculateQuoteVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1300472899677326380L;
	private String id;
	private int adults;
	private int children;
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
	
	private String quotebathorseadults;
	private String quotebathorsecchildren;
	private String quoteitemguidecadults;
	private String quoteitemguidechildren;
	
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
