package com.constants;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyInitiator {

	private PropertyInitiator() {
	}

	public static Properties objectReturn(String propertyName) {
		try {
			Properties obj = new Properties();
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\Properties\\" + propertyName + ".properties");
			obj.load(objfile);
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
