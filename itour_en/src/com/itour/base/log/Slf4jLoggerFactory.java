package com.itour.base.log;


/**
 * 基于Slf4jLogger实现的日志工厂类
 */

public class Slf4jLoggerFactory implements ILoggerFactory {

	public Logger getLogger(Class<?> clazz) {
		return new Slf4jLogger(clazz);
	}

	public Logger getLogger(String name) {
		return new Slf4jLogger(name);
	}
}
