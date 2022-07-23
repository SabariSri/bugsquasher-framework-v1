package com.ui.tests.web;

import org.testng.annotations.Test;

import com.basetest.AbstractTest;

public class FormComparator extends AbstractTest {

	@Test
	public void sampleTest() {
		reporter().startTest("Form Comparator Test");
		String screenShot = goodsAndServiceTaxPage.scrollAndTakeScreenshot();
		formRecognizer.uploadScreenshot(screenShot);
	}

}
