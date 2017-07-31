package com.itour.vo;

import com.itour.base.page.BasePage;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.itour.base.page.BasePage;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * 
 * <br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
//import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)//忽略未知属性  
@JsonInclude(Include.NON_NULL)
public class AdLinkVO extends BasePage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4066569417430193321L;
	private String id;
	private String advertise;
	private String adlink;
	private String title;
    @Min(value = 0, message = "valid 的最小值为0")
    @Max(value = 1, message = "valid 的最大值为1")
	private int valid;
	private String remark;
	private String createBy;
	private String updateBy;
	private String createTime;
	private String updateTime;
	@Min(value = 0, message = "video 的最小值为0")
    @Max(value = 1, message = "video 的最大值为1")
	private int video;
	@Min(value = 0, message = "foot 的最小值为0")
	@Max(value = 1, message = "foot 的最大值为1")
	private int foot;//0=首页链接，1=页脚链接
	 
	public int getFoot() {
		return foot;
	}
	public void setFoot(int foot) {
		this.foot = foot;
	}
	public int getValid() {
		return valid;
	}
	public void setValid(int valid) {
		this.valid = valid;
	}
	public int getVideo() {
		return video;
	}
	public void setVideo(int video) {
		this.video = video;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAdvertise() {
		return advertise;
	}
	public void setAdvertise(String advertise) {
		this.advertise = advertise;
	}
	public String getAdlink() {
		return adlink;
	}
	public void setAdlink(String adlink) {
		this.adlink = adlink;
	}

}
