package com.basetest;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.base.AbstractSetup;
import com.constants.ConfigConstants;
import com.ui.pages.GoogleHomePage;
import com.ui.pages.GoogleHomePageSecond;

public class AbstractTest extends AbstractSetup {

	protected GoogleHomePage googleHomePage = new GoogleHomePage();
	protected GoogleHomePageSecond googleHomePageSecond = new GoogleHomePageSecond();

	@BeforeMethod
	public void launchUrl() {
		try {
			if (getDriver() != null) {
				getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				getDriver().get(ConfigConstants.BASE_URL);
				getDriver().manage().window().maximize();
				loadPages();
			}
			log.info("Completed beforeTest method");
		} catch (Exception e) {
			reporter().stepFail("Unable to launch url :: " + ConfigConstants.BASE_URL + "\n\n" + " ERROR MESSAGE :: "
					+ e.toString());
		}
	}

	@AfterMethod
	public void afterMethod() {
		reporter().endTest();
	}

	private void loadPages() {
		googleHomePage.loadElements();
		googleHomePageSecond.loadElements();
	}
}
