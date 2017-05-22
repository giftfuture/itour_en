package com.itour.base.log;

import org.slf4j.LoggerFactory;

public class Slf4jLogger extends Logger {

	private org.slf4j.Logger logger;

	public Slf4jLogger(Class<?> clazz) {
		logger = LoggerFactory.getLogger(clazz);
	}

	public Slf4jLogger(String name) {
		logger = LoggerFactory.getLogger(name);
	}

	public void debug(String message) {
		logger.debug(message);
	}

	public void debug(String message, Object... args) {
		logger.debug(message, args);
	}

	public void debug(String message, Throwable error) {
		logger.debug(message, error);
	}

	public void info(String message) {
		logger.info(message);
	}

	public void info(String message, Object... args) {
		logger.info(message, args);
	}

	public void info(String message, Throwable error) {
		logger.info(message, error);
	}

	public void warn(String message) {
		logger.warn(message);
	}

	public void warn(String message, Object... args) {
		logger.warn(message, args);
	}

	public void warn(String message, Throwable error) {
		logger.warn(message, error);
	}

	public void error(String message) {
		logger.error(message);
	}

	public void error(String message, Object... args) {
		logger.error(message, args);
	}

	public void error(String message, Throwable error) {
		logger.error(message, error);
	}

	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	public boolean isWarnEnabled() {
		return logger.isWarnEnabled();
	}

	public boolean isErrorEnabled() {
		return logger.isErrorEnabled();
	}


}
