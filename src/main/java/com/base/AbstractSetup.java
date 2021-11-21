package com.base;

import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.constants.Constants;
import com.reports.CustomExtentReports;
import com.utils.AppiumServerCapabalities;
import com.utils.LoggerClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;

public class AbstractSetup {

	private static CustomExtentReports report = new CustomExtentReports();
	private static Random randomNumber = new Random();
	private static WebDriver driver;
	public static Logger log;
	private static String browserStackUserName = Constants.get(Constants.configProperties, "bsAutomateUserName");
	private static String browserStackAccessKey = Constants.get(Constants.configProperties, "bsAutomateAccessKey");
	private static String browserStackServer = Constants.get(Constants.configProperties, "bsAutomateServer");
	private static final String URL = "https://" + browserStackUserName + ":" + browserStackAccessKey
			+ browserStackServer;

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
			} else if (browser.contains("browser-stack")) {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("realMobile", "true");
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability("browserstack.networkLogs", "true");
				caps.setCapability("name", "BugSquasher Sample Test"); // test name
				caps.setCapability("build", "BugSquasher Build - " + randomNumber.nextInt(1000));
				if (browser.equals("ios-browser-stack")) {
					caps.setCapability("browserName", "iPhone");
					caps.setCapability("device", "iPhone 11");
					caps.setCapability("os_version", "14.0");
				} else if (browser.equals("android-browser-stack")) {
					caps.setCapability("browserName", "Android");
					caps.setCapability("device", "Samsung Galaxy S9 Plus");
					caps.setCapability("os_version", "9.0");
				}
				driver = new RemoteWebDriver(new URL(URL), caps);
			} else if (browser.equalsIgnoreCase("androidchrome")) {
				String appiumLocalServerUrl = AppiumServerCapabalities.startServer();
				DesiredCapabilities capabilities = DesiredCapabilities.android();
				capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
				capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel Emulator");
				capabilities.setCapability(MobileCapabilityType.VERSION, "10");
				capabilities.setCapability("chromedriverChromeMappingFile", Constants.CHROME_DRIVER_MAPPING);
				capabilities.setCapability("chromedriverExecutableDir", Constants.DRIVERS_REPO);
				// capabilities.setCapability("chromedriverExecutable",
				// Constants.CHROME_DRIVER);
				// capabilities.setCapability("showChromedriverLog", true);
				capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
				URL url = new URL(appiumLocalServerUrl);
				driver = new AndroidDriver(url, capabilities);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite() {
		AppiumServerCapabalities.stopServer();
		report.endReport();
		if (driver != null) {
			driver.close();
			driver.quit();
		}
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
