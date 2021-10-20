package com.datadrivers;

import org.testng.annotations.DataProvider;

import com.datadrivers.ExcelUtils;

public class TestDataProviders {

	@DataProvider(name = "sampleTest")

	public static Object[][] sampleTest() throws Exception {

		ExcelUtils excelData = new ExcelUtils();
		return excelData.getTableArray("Sheet1");

	}
}
