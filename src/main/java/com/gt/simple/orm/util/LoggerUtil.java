package com.gt.simple.orm.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {

	private static Logger logger;
	
	/**
	 * 
	* @Title: loggerInfo 
	* @Description: TODO(���info�������־��Ϣ) 
	* @param @param clazz ��Ҫ����־�Ķ���
	* @param @param mark  ��־��ǩ
	* @param @param obj   ��־��Ϣ����
	* @return void    �������� 
	* @throws
	 */
	public static void loggerInfo(Class clazz,String mark , Object obj) {
		logger = LoggerFactory.getLogger(clazz);
		logger.info(mark, obj);
	}
	
	/**
	 * 
	* @Title: loggerError 
	* @Description: TODO(���error�������־��Ϣ) 
	* @param @param clazz ��Ҫ����־�Ķ���
	* @param @param mark  ��־��ǩ
	* @param @param obj   ��־��Ϣ����
	* @return void    �������� 
	* @throws
	 */
	public static void loggerError(Class clazz,String mark , Object obj) {
		logger = LoggerFactory.getLogger(clazz);
		logger.info(mark, obj);
	}
	
	/**
	 * 
	* @Title: loggerWarn 
	* @Description: TODO(���warn�������־��Ϣ) 
	* @param @param clazz ��Ҫ����־�Ķ���
	* @param @param mark  ��־��ǩ
	* @param @param obj   ��־��Ϣ����
	* @return void    �������� 
	* @throws
	 */
	public static void loggerWarn(Class clazz,String mark , Object obj) {
		logger = LoggerFactory.getLogger(clazz);
		logger.warn(mark, obj);
	}
	
	
	/**
	 * 
	* @Title: getLogger 
	* @Description: TODO(���һ����־����) 
	* @param @param clazz ��Ҫ����־�Ķ���
	* @param @param mark  ��־��ǩ
	* @param @param obj   ��־��Ϣ����
	* @return void    �������� 
	* @throws
	 */
	public static Logger getLogger(Class clazz) {
		Logger logger = LoggerFactory.getLogger(clazz);
		return logger;
	}
}
