package com.constants;

import java.util.Properties;

public class ConfigConstants {
	private static Properties properties = PropertyInitiator.objectReturn();
	public static String BASE_URL = properties.getProperty("baseURL");
	public static final String EXCEL_Path = System.getProperty("user.dir") + properties.getProperty("excelPath");
	public static final String REPORT_CONFIG_Path = System.getProperty("user.dir") + properties.getProperty("reportConfig");
	public static final String REPORT_OUTPUT = System.getProperty("user.dir") + properties.getProperty("reportOutput");
	
	
	public static String get(String key) {
		return properties.getProperty(key);
	}

}
