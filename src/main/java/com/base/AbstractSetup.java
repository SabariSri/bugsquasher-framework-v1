package com.base;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.constants.*;
import com.reports.CustomExtentReports;
import com.utils.LoggerClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
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
				RestAssured.baseURI = Constants.SERVER_URL;
			} else if (browser.equalsIgnoreCase("mobilechrome")) {
				DesiredCapabilities capabilities = DesiredCapabilities.android();
				capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
				capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel Emulator");
				capabilities.setCapability(MobileCapabilityType.VERSION, "11");
				capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
				URL url = new URL(Constants.APPIUM_SERVER_URL);
				driver = new AndroidDriver(url, capabilities);
			}
		} catch (Exception e) {
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
