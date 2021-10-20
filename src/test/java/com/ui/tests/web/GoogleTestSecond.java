package com.ui.tests.web;

import org.testng.annotations.Test;

import com.basetest.AbstractTest;

public class GoogleTestSecond extends AbstractTest {

	@Test
	public void sampleTest() {
		reporter().startTest("Web UI Test - 002");
		googleHomePageSecond.searchText("Rajini");
	}
}
