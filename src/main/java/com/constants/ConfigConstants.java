package com.constants;

import java.util.Properties;

public class ConfigConstants {
	
	// Framework Constants
	private static Properties configProperties = PropertyInitiator.objectReturn();
	public static final String EXCEL_Path = System.getProperty("user.dir") + configProperties.getProperty("excelPath");
	public static final String REPORT_CONFIG_Path = System.getProperty("user.dir") + configProperties.getProperty("reportConfig");
	public static final String REPORT_OUTPUT = System.getProperty("user.dir") + configProperties.getProperty("reportOutput");
	
	// API Constants
	
	
	// UI Constants
	private static Properties uiProperties = PropertyInitiator.objectReturn();
	public static String BASE_URL = uiProperties.getProperty("baseURL");

	
	public static String get(String key) {
		return properties.getProperty(key);
	}

}
