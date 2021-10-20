package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.constants.ConfigConstants;
import com.reports.CustomExtentReports;
import com.utils.LoggerClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;

public class AbstractSetup {

	private static CustomExtentReports report = new CustomExtentReports();
	private static WebDriver driver;
	public static Logger log;

	@BeforeSuite
	@Parameters({ "browser" })
	public static void beforeSuite(String browser) {
		try {
		report.startReport();
		startLogger();
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("api")) {
			RestAssured.baseURI = ConfigConstants.SERVER_URL;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite() {
		report.endReport();
		if (driver != null)
			driver.quit();
	}

	public static WebDriver getDriver() {
		if (driver != null) {
			return driver;
		}
		return driver;
	}

	public static CustomExtentReports reporter() {
		if (report != null) {
			return report;
		}
		return report;
	}

	private static void startLogger() {
		log = Logger.getLogger(LoggerClass.class);
	}

	public void tearDownMain() {
		driver.manage().deleteAllCookies();
		driver.close();
	}

	public void loadElements() {
		PageFactory.initElements(getDriver(), this);
	}
}
