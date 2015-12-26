package com.lgx.web;

import java.util.Properties;

/**
 * 获得系统的配置
 * 
 * @author 
 * @date 
 * @version 
 */
public class Property {

	public  static Properties property;

	private Property() {
	}

	static void init(java.util.Properties props) {
		property = props;
	}

	public static String getProperty(String key) {
		return property.getProperty(key);
	}

	public static String getProperty(String key, String defaultValue) {
		return property.getProperty(key, defaultValue);

	}

}