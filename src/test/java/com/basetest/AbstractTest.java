package com.basetest;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.base.AbstractSetup;
import com.constants.Constants;
import com.ui.pages.GoogleHomePage;
import com.ui.pages.GoogleHomePageSecond;

public class AbstractTest extends AbstractSetup {

	protected GoogleHomePage googleHomePage = new GoogleHomePage();
	protected GoogleHomePageSecond googleHomePageSecond = new GoogleHomePageSecond();

	@BeforeMethod
	@Parameters({ "browser" })
	public void launchUrl(String browser) {
		try {
			if (!browser.equalsIgnoreCase("api")) {
				getDriver().get(Constants.BASE_URL);
				loadPages();
				if (browser.equalsIgnoreCase("chrome")) {
					getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					getDriver().manage().window().maximize();
				}
			}
			log.info("Completed beforeTest method");
		} catch (Exception e) {
			reporter().stepFail(
					"Unable to launch url :: " + Constants.BASE_URL + "\n\n" + " ERROR MESSAGE :: " + e.toString());
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
