package com.itour.base.jdbc.dialect.impl;

import com.itour.base.jdbc.dialect.Dialect;

/**
 * JDBC查询方言mysql实现，主要用于提供分页查询<br>
 */
public class MySqlDialect implements Dialect {
	@Override
	public String getCountSql(String sql) {
		return "select count(*) as COUNT___y from (" + sql + ") T___T";
	}

	@Override
	public String getLimitSql(String sql, int start, int limit) {
		return sql + " limit " + start + "," + limit;
	}
}
