package com.itour.base.log;


/**
 * Logger 日志工具类接口，用于处理DEBUG,INFO,WARN,ERROR等级别的系统日志<br>
 * 日志级别：DEBUG > INFO > WARN > ERROR
 * @author  
 * @version  
 */
public abstract class Logger {

	// 日志记录器工厂类
	private static volatile ILoggerFactory factory;
	static {
		factory = new Slf4jLoggerFactory();
	}

	/**
	 * 设置日志记录器工厂类
	 * @param loggerFactory 日志记录器工厂类
	 */
	public static void setLoggerFactory(ILoggerFactory loggerFactory) {
		if (loggerFactory != null)
			Logger.factory = loggerFactory;
	}

	/**
	 * 获得日志记录器
	 * @param clazz 日志所属类
	 * @return 日志记录器
	 */
	public static Logger getLogger(Class<?> clazz) {
		return factory.getLogger(clazz);
	}

	/**
	 * 获得日志记录器
	 * @param name 日志名称
	 * @return 日志记录器
	 */
	public static Logger getLogger(String name) {
		return factory.getLogger(name);
	}

	/**
	 * 输出调试日志
	 * @param message 日志信息
	 */
	public abstract void debug(String message);

	/**
	 * 输出调试日志
	 * @param message 日志信息
	 * @param args 参数
	 */
	public abstract void debug(String message, Object... args);

	/**
	 * 输出调试日志
	 * @param message 日志信息
	 * @param error 异常对象
	 */
	public abstract void debug(String message, Throwable error);

	/**
	 * 输出提示日志
	 * @param message 日志信息
	 */
	public abstract void info(String message);

	/**
	 * 输出提示日志
	 * @param message 日志信息
	 * @param args 参数
	 */
	public abstract void info(String message, Object... args);

	/**
	 * 输出提示日志
	 * @param message 日志信息
	 * @param error 异常对象
	 */
	public abstract void info(String message, Throwable error);

	/**
	 * 输出警告日志
	 * @param message 日志信息
	 */
	public abstract void warn(String message);

	/**
	 * 输出警告日志
	 * @param message 日志信息
	 * @param args 参数
	 */
	public abstract void warn(String message, Object... args);

	/**
	 * 输出警告日志
	 * @param message 日志信息
	 * @param error 异常对象
	 */
	public abstract void warn(String message, Throwable error);

	/**
	 * 输出错误日志
	 * @param message 日志信息
	 */
	public abstract void error(String message);

	/**
	 * 输出错误日志
	 * @param message 日志信息
	 * @param args 参数
	 */
	public abstract void error(String message, Object... args);

	/**
	 * 输出错误日志
	 * @param message 日志信息
	 * @param error 异常对象
	 */
	public abstract void error(String message, Throwable error);

	/**
	 * 是否允许输出调试级别日志
	 * @return 如果允许输出调试级别日志则返回true.
	 */
	public abstract boolean isDebugEnabled();

	/**
	 * 是否允许输出提示级别日志
	 * @return 如果允许输出提示级别日志则返回true.
	 */
	public abstract boolean isInfoEnabled();

	/**
	 * 是否允许输出警告级别日志
	 * @return 如果允许输出警告级别日志则返回true.
	 */
	public abstract boolean isWarnEnabled();

	/**
	 * 是否允许输出错误级别日志
	 * @return 如果允许输出错误级别日志则返回true.
	 */
	public abstract boolean isErrorEnabled();
}
