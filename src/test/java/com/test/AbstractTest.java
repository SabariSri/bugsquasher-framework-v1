package com.test;

import com.ConfigConstants;
import com.pages.GoogleHomePage;
import com.base.AbstractSetup;
import com.pages.GoogleHomePageSecond;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class AbstractTest extends AbstractSetup {

  protected GoogleHomePage googleHomePage = new GoogleHomePage();
  protected GoogleHomePageSecond googleHomePageSecond = new GoogleHomePageSecond();

  @BeforeMethod
  // @Parameters({"browser"})
  public void launchUrl() {
    try {
      getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      getDriver().get(ConfigConstants.URL);
      getDriver().manage().window().maximize();
      load();
      System.out.println("Completed before test");
    } catch (Exception e) {
      reporter()
          .stepFail(
              "Cant able to launch url :: "
                  + ConfigConstants.URL
                  + "\n\n"
                  + " ERROR MESSAGE :: "
                  + e.toString());
    }
  }

  void load() {
    googleHomePage.loadElements();
    googleHomePageSecond.loadElements();
  }

  @AfterMethod
  public void afterMethod() {
    // reporter().endTest();
    driver.quit();
  }
}
