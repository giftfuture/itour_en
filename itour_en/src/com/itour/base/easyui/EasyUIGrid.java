package com.itour.base.easyui;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;
import com.itour.base.page.BasePage;

/**
 * 分页表格数据模型<br>
 */
@SuppressWarnings("serial")
public class EasyUIGrid implements Serializable {
	// =================================Fields================================================
	/** 当前页中存放的记录 */

	private List<?> rows;
	/** 总记录数 */
	private long total;
	
	private List<?> footer;

	// =================================Constructors===========================================
	/**
	 * 构造函数
	 * @param page 分页对象
	 */
	public EasyUIGrid(BasePage<?> page) {
		this.rows = page.getRecords();
		this.total = page.getTotal();
		this.footer = page.getFooter();
	}

	/**
	 * 默认构造函数
	 */
	public EasyUIGrid() {
		this.rows = Lists.newArrayList();
		this.footer = Lists.newArrayList();
		this.total = 0;
	}
	
	// =================================Methods================================================
	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	

	public List<?> getFooter() {
		return footer;
	}

	public void setFooter(List<?> footer) {
		this.footer = footer;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
