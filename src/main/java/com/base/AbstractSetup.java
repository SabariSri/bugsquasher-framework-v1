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

import com.reports.CustomExtentReports;
import com.utils.LoggerClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractSetup {

	protected static CustomExtentReports report = new CustomExtentReports();
	protected static WebDriver driver;
	protected static Logger log;

	@BeforeSuite
	@Parameters({ "browser" })
	public static void beforeSuite(String browser) {
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
		}
	}

	@AfterSuite
	public void afterSuite() {
		report.endReport();
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
