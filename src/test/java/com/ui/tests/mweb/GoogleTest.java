package com.ui.tests.mweb;

import org.testng.annotations.Test;

import com.basetest.AbstractTest;
import com.utils.BrowserStackResultsMarker;

public class GoogleTest extends AbstractTest {

	@Test
	public void sampleTest() {
		try {
			reporter().startTest("Mweb Test - 001");
			googleHomePage.searchText("NTR");
			BrowserStackResultsMarker.markTestStatus("passed", "Passed Successfully", getDriver());
		} catch (Exception e) {
			BrowserStackResultsMarker.markTestStatus("failed", e.getStackTrace().toString(), getDriver());

		}
	}
}
