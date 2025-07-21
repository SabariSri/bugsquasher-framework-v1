package com.constants;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyInitiator {

	private PropertyInitiator() {
	}

	public static Properties objectReturn(String propertyName) {
		try {
			Properties obj = new Properties();
			Path path = Paths.get("src", "test", "resources", "Properties", propertyName + ".properties");
			System.out.println("Path: " + path.toAbsolutePath());
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + File.separator + path);
			obj.load(objfile);
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
