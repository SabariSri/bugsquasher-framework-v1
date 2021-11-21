package com.constants;

import java.util.Properties;

public class Constants {

	private static final String sourcePath = System.getProperty("user.dir");

	// Framework Constants
	public static Properties configProperties = PropertyInitiator.objectReturn("ConfigConstants");
	public static final String EXCEL_Path = sourcePath + configProperties.getProperty("excelPath");
	public static final String REPORT_CONFIG_Path = sourcePath + configProperties.getProperty("reportConfig");
	public static final String REPORT_OUTPUT = sourcePath + configProperties.getProperty("reportOutput");

	// API Constants
	private static Properties apiProperties = PropertyInitiator.objectReturn("ApiConstants");
	public static String SERVER_URL = apiProperties.getProperty("serverUrl");

	// UI Constants
	private static Properties uiProperties = PropertyInitiator.objectReturn("UiConstants");
	public static String BASE_URL = uiProperties.getProperty("baseUrl");
	public static String APPIUM_SERVER_DEFAULT_URL = uiProperties.getProperty("appiumDefaultServerUrl");
	public static String ANDROID_CHROME_DRIVER = sourcePath + uiProperties.getProperty("androidChromeDriver");
	public static String CHROME_DRIVER = sourcePath + uiProperties.getProperty("chromeDriverPath");
	public static String CHROME_DRIVER_MAPPING = sourcePath + uiProperties.getProperty("chromeDriverMapping");
	public static String DRIVERS_REPO = sourcePath + uiProperties.getProperty("resourcesDriverRepo");

	public static String get(Properties properties, String key) {
		return properties.getProperty(key);
	}

}
