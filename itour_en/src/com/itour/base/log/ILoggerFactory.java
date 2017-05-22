package com.itour.base.log;

/**
 * 日志工厂类
 */
public interface ILoggerFactory {

	/**
	 * 根据类名获取日志记录器
	 * @param clazz 类名
	 * @return 日志记录器
	 */
	public Logger getLogger(Class<?> clazz);

	/**
	 * 根据名词获取日志记录器
	 * @param name 日志名
	 * @return 日志记录器
	 */
	public Logger getLogger(String name);
}
