package com.itour.base.jdbc.dialect.impl;

import com.itour.base.jdbc.dialect.Dialect;

/**
 * JDBC查询方言DB2实现，主要用于提供分页查询<br>
 */
public class Db2Dialect implements Dialect {

	@Override
	public String getCountSql(String sql) {
		return "select count(*) as COUNT___y from (" + sql + ") T___T";
	}

	private static String getRowNumber(String sql) {
		StringBuffer rownumber = new StringBuffer(50).append("rownumber() over(");
		int orderByIndex = sql.toLowerCase().indexOf("order by");
		if (orderByIndex > 0 && !hasDistinct(sql)) {
			rownumber.append(sql.substring(orderByIndex));
		}
		rownumber.append(") as rownumber_,");
		return rownumber.toString();
	}

	private static boolean hasDistinct(String sql) {
		return sql.toLowerCase().indexOf("select distinct") >= 0;
	}

	@Override
	public String getLimitSql(String sql, int offset, int limit) {
		int startOfSelect = sql.toLowerCase().indexOf("select");
		StringBuilder pagingSelect = new StringBuilder(sql.length() + 100).append(sql.substring(0, startOfSelect)) // add the comment
				.append("select * from ( select ") // nest the main query in an outer select
				.append(getRowNumber(sql)); // add the rownnumber bit into the outer query select list
		if (hasDistinct(sql)) {
			pagingSelect.append(" row_.* from ( ") // add another (inner) nested select
					.append(sql.substring(startOfSelect)) // add the main query
					.append(" ) as row_"); // close off the inner nested select
		} else {
			pagingSelect.append(sql.substring(startOfSelect + 6)); // add the main query
		}
		pagingSelect.append(" ) as temp_ where rownumber_ ");
		// add the restriction to the outer select
		if (offset > 0) {
			pagingSelect.append("between " + (offset + 1) + " and " + (offset + limit));
		} else {
			pagingSelect.append("<= " + limit);
		}
		return pagingSelect.toString();
	}
}
