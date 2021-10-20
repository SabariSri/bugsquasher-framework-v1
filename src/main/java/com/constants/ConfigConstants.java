package com.constants;

import java.util.Properties;

public class ConfigConstants {
	
	// Framework Constants
	private static Properties configProperties = PropertyInitiator.objectReturn("ConfigConstants");
	public static final String EXCEL_Path = System.getProperty("user.dir") + configProperties.getProperty("excelPath");
	public static final String REPORT_CONFIG_Path = System.getProperty("user.dir") + configProperties.getProperty("reportConfig");
	public static final String REPORT_OUTPUT = System.getProperty("user.dir") + configProperties.getProperty("reportOutput");
	
	// API Constants
	private static Properties apiProperties = PropertyInitiator.objectReturn("ApiConstants");
	public static String SERVER_URL = apiProperties.getProperty("serverUrl");
	
	// UI Constants
	private static Properties uiProperties = PropertyInitiator.objectReturn("UiConstants");
	public static String BASE_URL = uiProperties.getProperty("baseUrl");

	
	public static String get(Properties properties, String key) {
		return properties.getProperty(key);
	}

}
