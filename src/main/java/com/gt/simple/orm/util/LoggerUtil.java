package com.gt.simple.orm.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {

	private static Logger logger;
	
	/**
	 * 
	* @Title: loggerInfo 
	* @Description: TODO(输出info级别的日志信息) 
	* @param @param clazz 需要打日志的对象
	* @param @param mark  日志标签
	* @param @param obj   日志信息对象
	* @return void    返回类型 
	* @throws
	 */
	public static void loggerInfo(Class clazz,String mark , Object obj) {
		logger = LoggerFactory.getLogger(clazz);
		logger.info(mark, obj);
	}
	
	/**
	 * 
	* @Title: loggerError 
	* @Description: TODO(输出error级别的日志信息) 
	* @param @param clazz 需要打日志的对象
	* @param @param mark  日志标签
	* @param @param obj   日志信息对象
	* @return void    返回类型 
	* @throws
	 */
	public static void loggerError(Class clazz,String mark , Object obj) {
		logger = LoggerFactory.getLogger(clazz);
		logger.info(mark, obj);
	}
	
	/**
	 * 
	* @Title: loggerWarn 
	* @Description: TODO(输出warn级别的日志信息) 
	* @param @param clazz 需要打日志的对象
	* @param @param mark  日志标签
	* @param @param obj   日志信息对象
	* @return void    返回类型 
	* @throws
	 */
	public static void loggerWarn(Class clazz,String mark , Object obj) {
		logger = LoggerFactory.getLogger(clazz);
		logger.warn(mark, obj);
	}
	
	
	/**
	 * 
	* @Title: getLogger 
	* @Description: TODO(获得一个日志对象) 
	* @param @param clazz 需要打日志的对象
	* @param @param mark  日志标签
	* @param @param obj   日志信息对象
	* @return void    返回类型 
	* @throws
	 */
	public static Logger getLogger(Class clazz) {
		Logger logger = LoggerFactory.getLogger(clazz);
		return logger;
	}
}
