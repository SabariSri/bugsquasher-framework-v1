package com.datadrivers;

import org.testng.annotations.DataProvider;

public class TestDataProviders {

	@DataProvider(name = "uiTestData")
	public static Object[][] getUiTestData() throws Exception {
		ExcelUtils excelData = new ExcelUtils();
		return excelData.getTableArray("UiTestData");
	}
	
	@DataProvider(name = "apiTestData")
	public static Object[][] getApiTestData() throws Exception {
		ExcelUtils excelData = new ExcelUtils();
		return excelData.getTableArray("ApiTestData");
	}
}
