package com.ui.tests.web;

import org.testng.annotations.Test;

import com.basetest.AbstractTest;

public class GoogleTestSecond extends AbstractTest {

	@Test
	public void sampleTest() {
		report.startTest("Random Test - 002");
		googleHomePageSecond.searchText("Rajini");
	}
}
