package com.ui.tests.web;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.basetest.AbstractTest;

public class GoogleTest extends AbstractTest {

	@Test
	public void sampleTest() {
		reporter().startTest("Web UI Test - 001");
		googleHomePage.searchText("NTR");
	}

	@Test(dataProvider = "uiTestData", dataProviderClass = com.datadrivers.TestDataProviders.class)
	public void sampleTest(HashMap<String, String> data) {
		reporter().startTest(data.get("TestName"));
		googleHomePage.searchText(data.get("SearchKey"));
	}

}
