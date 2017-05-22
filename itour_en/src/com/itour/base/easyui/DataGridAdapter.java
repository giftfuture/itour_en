package com.itour.base.easyui;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.itour.base.collect.Mapx;
import com.itour.base.convert.ConvertUtil;
import com.itour.base.page.BasePage;
import com.itour.base.page.PageUtil;
import com.itour.base.json.JsonUtils;
/**
 * 分页条件获取工具类,用于从页面组建表格中获得查询的条件.<br>
 * 支持EasyUiGrid组件.<br>
 * @author 
 * @version 0.1 
 */
@Component
public class DataGridAdapter {

	/**
	 * 获得查询条件
	 * @param 查询条件
	 */
	public BasePage getPagination() {
		HttpServletRequest request = getRequest();
		BasePage pagination = new BasePage();
		String sPageNo = request.getParameter("page");
		String sPageSize = request.getParameter("rows");
		String json = StringUtils.isNotEmpty(request.getParameter("filters"))?request.getParameter("filters"): "{}";// 获取查询条件
		Mapx filters = JsonUtils.toMapx(json);// JsonUtils.toMapx(json);
		int pageNo = ConvertUtil.toInteger(sPageNo, 1);
		int limit = ConvertUtil.toInteger(sPageSize, 10);
		int start = PageUtil.getStart(pageNo, limit);
		pagination.setStart(start);
		pagination.setLimit(limit);
		pagination.setFilters(filters);
		return pagination;
	}

	/**
	 * 封装分页结果
	 * @return 封装分页结果
	 */
	public EasyUIGrid wrap(BasePage<?> page) {
		return new EasyUIGrid(page);
	}

	/**
	 * 获得 HTTP请求对象
	 * @return HTTP请求对象
	 */
	private HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
}
