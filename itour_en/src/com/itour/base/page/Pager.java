package com.itour.base.page;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

/**
 * 分页参数
 * @
 */
// oracle,sqlserver,mysql分页技术
public class Pager {

	private long pageId = 1; // 当前页
	private long rowCount = 0; // 总行数
	private int pageSize = 10; // 页大小
	private long pageCount = 0; // 总页数
	private long pageOffset = 0;// 当前页起始记录
	private long pageTail = 0;// 当前页到达的记录
	private String orderField;
	private boolean orderDirection;
	private String groupField;
	// 页面显示分页按钮个数
	private int length = 6;
	// 开始分页数字
	private int startIndex = 0;
	// 结束分页数字
	private long endIndex = 0;

	private long[] indexs;


	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public long[] getIndexs() {
		long len = getEndIndex() - getStartIndex() + 1;
		indexs = new long[(int) len];
		//ArrayList a;
		for (int i = 0; i < len; i++) {
			indexs[i] = (getStartIndex() + i);
		}
		return indexs;
	}

	public void setIndexs(long[] indexs) {
		this.indexs = indexs;
	}

	public int getStartIndex() {
		startIndex =(int) pageId - (length / 2);
		if (startIndex < 1) {
			startIndex = 1;
		}
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public long getEndIndex() {
		if (getStartIndex() < 1) {
			setStartIndex(1);
		}
		endIndex = (getStartIndex() + length) <= getPageCount() ? (getStartIndex() + length)
				: getPageCount();
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public Pager() {
		this.orderDirection = true;
	}
	protected void doPage() {
		// //如果输入也页面编号（pageId）大于总页数，将pageId设置为pageCount;
		// if(this.pageId> this.pageCount)
		// this.pageId = this.pageCount;
		// this.pageOffset=(this.pageId-1)*this.pageSize+1;
		// this.pageTail=this.pageOffset+this.pageSize-1;
		this.pageSize = this.pageSize== 0 ? 10 : this.pageSize;
		this.pageCount = (this.rowCount % this.pageSize == 0) && (this.rowCount/this.pageSize >1) ? this.rowCount / this.pageSize : this.rowCount / this.pageSize + 1;
		// Mysql 算法  
		this.pageOffset = this.pageId >=1? (this.pageId - 1) * this.pageSize : 0;
		this.pageTail = this.pageSize== 0 ? 10 :this.pageSize;//
		//this.pageOffset + this.pageSize > this.rowCount ? this.rowCount%this.pageSize == 0 ? this.pageSize : this.rowCount%this.pageSize :this.pageOffset + this.pageSize;
	}
/*	protected void doPage() {
		// //如果输入也页面编号（pageId）大于总页数，将pageId设置为pageCount;
		// if(this.pageId> this.pageCount)
		// this.pageId = this.pageCount;
		// this.pageOffset=(this.pageId-1)*this.pageSize+1;
		// this.pageTail=this.pageOffset+this.pageSize-1;
		this.pageCount = (this.rowCount % this.pageSize == 0) && pageCount > 1 ? this.rowCount / this.pageSize : this.rowCount / this.pageSize + 1;
		// Mysql 算法  
		this.pageOffset = (this.pageId - 1) * this.pageSize;
		this.pageTail = this.pageOffset + this.pageSize > this.rowCount ? this.rowCount%this.pageSize == 0 ? this.pageSize : this.rowCount%this.pageSize :this.pageOffset + this.pageSize;
	}*/

	public String getOrderCondition() {
		String condition = "";
		if (StringUtils.isNotEmpty(this.orderField) && this.orderField.length() != 0) {
			condition = " order by " + orderField + (orderDirection ? " " : " desc ");
		}
		return condition;
	}
	public String getGroupCondition(){
		String condition = "";
		if (StringUtils.isNotEmpty(this.groupField)) {
			condition = " group by " + orderField ;
		}
		return condition;
	}
	public String getMysqlQueryCondition() {
		doPage();
		//this.pageOffset = (this.pageId - 1) * this.pageSize;
		//this.pageTail= this.pageOffset + this.pageSize > this.rowCount ? this.rowCount%this.pageSize == 0 ? this.pageSize : this.rowCount%this.pageSize :this.pageOffset + this.pageSize;
		String condition = " limit " + pageOffset + "," + pageTail;
		//System.out.println("####################="+condition);
		return condition;
	}

	public void setOrderDirection(boolean orderDirection) {
		this.orderDirection = orderDirection;
	}

	public boolean isOrderDirection() {
		return orderDirection;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public long getPageCount() {
		return pageCount;
	}
	
	public void setPageId(long pageId) {
		this.pageId = pageId;
	}

	public long getPageId() {
		return pageId;
	}

	public void setPageOffset(long pageOffset) {
		this.pageOffset = pageOffset;
	}

	public long getPageOffset() {
		return pageOffset;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageTail(long pageTail) {
		this.pageTail = pageTail;
	}

	public long getPageTail() {
		return pageTail;
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
		this.doPage();
	}

	public long getRowCount() {
		return rowCount;
	}

	public String getGroupField() {
		return groupField;
	}

	public void setGroupField(String groupField) {
		this.groupField = groupField;
	}
	
}