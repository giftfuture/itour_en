package com.itour.base.jdbc.dialect;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * JDBC查询方言(代理支持类)<br>
 * @author 
 * @version  
 * @see Dialect
 */
public class DialectProxy implements Dialect, InitializingBean {

	/**
	 * 代理的方言类
	 */
	private Dialect delegate;

	/**
	 * 查询总数
	 */
	public String getCountSql(String sql) {
		return delegate.getCountSql(sql);
	}

	/**
	 * 分页查询
	 */
	public String getLimitSql(String sql, int offset, int limit) {
		return delegate.getLimitSql(sql, offset, limit);
	}

	/**
	 * 运行前检验
	 */
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(delegate);
	}

	/**
	 * 设置方言Class
	 * @param className 方言CLASS
	 */
	public void setDialectClass(String className) {
		try {
			delegate = (Dialect) Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
