package com.itour.base.page;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.itour.base.collect.Mapx;
import com.itour.base.collect.Mapxs;

public class BasePage<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8046146400130594259L;

	// =================================Fields================================================
	private long page ;
	
	private int rows ;
	
	private String sort;
	
	private String order;
	
	private String groupField;

	/** 开始查询 的数据索引号 (从0开始) */
	private int start = 0;
	/** 每页条数 */
	private int limit = 10;
	/** 总记录数 */
	private long total = 0;
	/** 当前页数据 */
	private List<T> records;
	
	/** 当前页脚数据 */
	private List<T> footer;
	
	private boolean orderDirection;
	
	/** 查询参数 */
	private Mapx filters = Mapxs.newMapx();
	/**
	 * 分页导航
	 */
	private Pager pager = new Pager();
	
	public Pager getPager() {
		pager.setPageId(getPage());
		pager.setPageSize(getRows());
		//pager.setRowCount(getTotal());					
		//pager.doPage();
		String orderField="";
		if(StringUtils.isNotEmpty(sort)){
			orderField = sort;
		}
		pager.setOrderDirection(this.orderDirection);
		if(StringUtils.isNotEmpty(orderField) && StringUtils.isNotEmpty(order)){
			orderField +=" "+ order;		
		}
		
		pager.setOrderField(orderField);
		if(StringUtils.isNotEmpty(groupField)){
			pager.setGroupField(groupField);
		}
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
	// =================================Constructors===========================================
		/**
		 * 构造函数
		 */
		public BasePage() {
			this.records = Lists.newArrayList();
		}

		/**
		 * 构造函数
		 * @param start 记录开始索引号
		 * @param limit 页面最大记录数
		 * @param records 当前页数据
		 * @param total 总记录数
		 */
		public BasePage(int start, int limit, List<T> records, long total) {
			this.start = start;
			this.limit = limit;
			this.records = records;
			this.total = total;
			//this.setTotal(total);
			//this.getPager().setRowCount(total);
			//this.setPager(this.getPager());
		}
		
		public BasePage(int start, int limit, List<T> records, long total,List<T> footer) {
			this.start = start;
			this.limit = limit;
			this.records = records;
			this.total = total;
			this.footer = footer;
		}

		// =================================Methods================================================
		/** 获取从第几条数据开始查询 */
		public int getStart() {
			return start;
		}

		/** 设置从第几条数据开始查询 */
		public void setStart(int start) {
			this.start = start;
		}

		/** 获取每页显示条数 */
		public int getLimit() {
			return limit;
		}

		/** 设置每页显示条数 */
		public void setLimit(int limit) {
			this.limit = limit;
		}

		/** 设置总条数 */
		public void setTotal(long total) {
			this.total = total;
		}

		/** 获取总条数 */
		public long getTotal() {
			return total;
		}

		/** 获取当前页数据 */
		public List<T> getRecords() {
			return records;
		}

		/** 设置当前页数据 */
		public void setRecords(List<T> records) {
			this.records = records;
		}

		public List<T> getFooter() {
			return footer;
		}

		public void setFooter(List<T> footer) {
			this.footer = footer;
		}

		public Mapx getFilters() {
			return filters;
		}

		public void setFilters(Mapx filters) {
			this.filters = filters;
		}
		
		public long getPage() {
			return page;
		}
	
		public void setPage(long page) {
			this.page = page;
		}
	
		public int getRows() {
			return rows;
		}
	
		public void setRows(int rows) {
			this.rows = rows;
		}
	
		public String getSort() {
			return sort;
		}
	
		public void setSort(String sort) {
			this.sort = sort;
		}
	
		public String getOrder() {
			return order;
		}
	
		public void setOrder(String order) {
			this.order = order;
		}

		public String getGroupField() {
			return groupField;
		}

		public void setGroupField(String groupField) {
			this.groupField = groupField;
		}

		public boolean isOrderDirection() {
			return orderDirection;
		}

		public void setOrderDirection(boolean orderDirection) {
			this.orderDirection = orderDirection;
		}
	
}
