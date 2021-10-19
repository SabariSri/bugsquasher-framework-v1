package com.base;

import com.reports.CustomExtentReports;
import com.utils.LoggerClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import java.util.concurrent.TimeUnit;

public class AbstractSetup {

  protected static CustomExtentReports report;
  protected static WebDriver driver;
  protected static Logger log;

  @BeforeSuite
  @Parameters({"browser"})
  public static void driverInitiator(String browser) {
    // report = new CustomExtentReports();
    if (browser.equalsIgnoreCase("chrome")) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    } else if (browser.equalsIgnoreCase("firefox")) {
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
  }

  public static WebDriver getDriver() {
    if (driver != null) {
      return driver;
    }
    return driver;
  }

  public CustomExtentReports reporter() {

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
