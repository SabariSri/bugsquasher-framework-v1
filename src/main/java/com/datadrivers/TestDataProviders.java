package com.datadrivers;

import org.testng.annotations.DataProvider;

public class TestDataProviders {

	@DataProvider(name = "googleTest")
	public static Object[][] googleTest() throws Exception {
		ExcelUtils excelData = new ExcelUtils();
		return excelData.getTableArray("GoogleTest");
	}
}
