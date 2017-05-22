package com.itour.base.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.google.common.collect.Lists;
import com.itour.base.jdbc.dialect.Dialect;
import com.itour.base.jdbc.dialect.impl.MySqlDialect;
import com.itour.base.page.BasePage;


/**
 * 基于JDBC的数据访问层支持工具类.
 */
public class JdbcDaoHelper {
	// ==============================Fields===========================================
	private static transient Dialect jdbcDialect = new MySqlDialect();

	// ==============================Methods==========================================
	/**
	 * 判断数据是否存在
	 * @param sql 查询语句
	 * @param args 查询参数
	 * @param jdbcTemplate JDBC模板
	 * @return 有一条数据则返回true,否则返回false.
	 */
	// select '1' from dual where exists( select '1' from {table} )
	public static boolean exists(String sql, Object[] args, JdbcTemplate jdbcTemplate) {
		return jdbcTemplate.queryForObject("select count(1) from dual where exists( " + sql + " )", args, Long.class)
				.longValue() > 0L;
	}

	/**
	 * 分页查询
	 * @param sql 查询语句
	 * @param args 查询参数
	 * @param start 第一条记录索引
	 * @param limit 每页显示记录数
	 * @param rowMapper 行映射
	 * @param jdbcTemplate JDBC模板
	 * @return 分页查询結果
	 */
	public static <T> BasePage<T> pagedQuery(String sql, Object[] args, int start, int limit, RowMapper<T> rowMapper,
			JdbcTemplate jdbcTemplate) {
		long count = jdbcTemplate.queryForObject(jdbcDialect.getCountSql(sql), args, Long.class).longValue();
		if (count == 0) {
			return new BasePage<T>(start, limit, Lists.<T> newArrayList(), 0);
		}
		List<T> records = jdbcTemplate.query(jdbcDialect.getLimitSql(sql, start, limit), args, rowMapper);
		return new BasePage<T>(start, limit, records, count);
	}

	/**
	 * 查询单个记录
	 * @param sql 查询单个数据
	 * @param args 查询参数
	 * @param rowMapper 行映射
	 * @param jdbcTemplate JDBC模板
	 * @return 分页查询結果
	 */
	public static <T> T queryOne(String sql, Object[] args, RowMapper<T> rowMapper, JdbcTemplate jdbcTemplate) {
		return getSingleResult(jdbcTemplate.query(sql, args, rowMapper));
	}

	// ==============================Tools_Methods====================================
	public static <T> T getSingleResult(List<T> multipleResult) {
		return (multipleResult == null || multipleResult.isEmpty()) ? null : multipleResult.get(0);
	}

	public static Object[] toArray(List<?> list) {
		return (list == null || list.isEmpty()) ? new Object[0] : list.toArray(new Object[list.size()]);
	}

	// ==============================Spring_Ioc=======================================
	/**
	 * @param dialect the jdbcDialect to set
	 */
	@Autowired
	public void setJdbcDialect(Dialect dialect) {
		JdbcDaoHelper.jdbcDialect = dialect;
	}
}
