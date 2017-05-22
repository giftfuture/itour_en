package com.itour.base.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.itour.base.page.BasePage;


/**
 * JDBC模板
 */
public class JdbcTemplatex extends JdbcTemplate {

	// ==============================Fields===========================================
	@Autowired
	private DataSource dataSource;

	// ==============================Constructors=====================================
	/**
	 * 构造函数
	 * @see #setDataSource
	 */
	protected JdbcTemplatex() {
		super();
	}
	
	
	/**
	 * 构造函数
	 * @param dataSource 数据源
	 */
	protected JdbcTemplatex(DataSource dataSource) {
		super(dataSource);
	}

	// ==============================Methods==========================================
	/**
	 * 判断数据是否存在
	 * @param sql 查询语句
	 * @param args 查询参数
	 * @param jdbcTemplate JDBC模板
	 * @return 有一条数据则返回true,否则返回false.
	 */
	// select '1' from dual where exists( select '1' from {table} )
	public boolean exists(String sql, Object[] args) {
		return JdbcDaoHelper.exists(sql, args, this);
	}

	/**
	 * 分页查询
	 * @param sql 查询语句
	 * @param args 查询参数
	 * @param start 第一条记录索引
	 * @param limit 每页显示记录数
	 * @param rowMapper 行映射
	 * @return 分页查询結果
	 */
	public <T> BasePage<T> pagedQuery(String sql, Object[] args, int start, int limit, RowMapper<T> rowMapper) {
		return JdbcDaoHelper.pagedQuery(sql, args, start, limit, rowMapper, this);
	}

	/**
	 * 分页查询
	 * @param sql 查询语句
	 * @param args 查询参数
	 * @param start 第一条记录索引
	 * @param limit 每页显示记录数
	 * @param rowMapper 行映射
	 * @return 分页查询結果
	 */
	public <T> BasePage<T> pagedQuery(CharSequence sql, List<Object> args, int start, int limit, RowMapper<T> rowMapper) {
		return JdbcDaoHelper.pagedQuery(sql.toString(), args.toArray(), start, limit, rowMapper, this);
	}

	/**
	 * 查询单个记录
	 * @param sql 查询单个数据
	 * @param rowMapper 行映射
	 * @param jdbcTemplate JDBC模板
	 * @return 分页查询結果
	 */
	public <T> T queryOne(String sql, RowMapper<T> rowMapper) {
		return JdbcDaoHelper.getSingleResult(super.query(sql, rowMapper));
	}

	/**
	 * 查询单个记录
	 * @param sql 查询单个数据
	 * @param args 查询参数
	 * @param rowMapper 行映射
	 * @param jdbcTemplate JDBC模板
	 * @return 分页查询結果
	 */
	public <T> T queryOne(String sql, Object[] args, RowMapper<T> rowMapper) {
		return JdbcDaoHelper.getSingleResult(super.query(sql, args, rowMapper));
	}

	/**
	 * 查询单个记录
	 * @param sql 查询单个数据
	 * @param args 查询参数
	 * @param rowMapper 行映射
	 * @param jdbcTemplate JDBC模板
	 * @return 分页查询結果
	 */
	public <T> T queryOne(CharSequence sql, List<Object> args, RowMapper<T> rowMapper) {
		return queryOne(sql.toString(), args.toArray(), rowMapper);
	}

	/**
	 * 查询单个记录
	 * @param sql 查询单个数据
	 * @param args 查询参数
	 * @param rowMapper 行映射
	 * @param jdbcTemplate JDBC模板
	 * @return 分页查询結果
	 */
	public <T> T queryOne(String sql, Object[] args, Class<T> requiredType) throws DataAccessException {
		return JdbcDaoHelper.queryOne(sql, args, super.getSingleColumnRowMapper(requiredType), this);
	}

	/**
	 * 获得 BeanPropertyRowMapper
	 * @param mappedClass 需要映射的Bean类型
	 * @return BeanPropertyRowMapper
	 */
	protected <T> BeanPropertyRowMapper<T> getBeanPropertyRowMapper(Class<T> mappedClass) {
		return new BeanPropertyRowMapper<T>(mappedClass);
	}
	
}
