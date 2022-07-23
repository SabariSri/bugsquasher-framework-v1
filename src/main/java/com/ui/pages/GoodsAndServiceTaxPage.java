package com.ui.pages;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.basepage.AbstractPage;

public class GoodsAndServiceTaxPage extends AbstractPage {
	private static final String SCREENSHOTS_DIRECTORY = System.getProperty("user.dir")
			+ "\\Screenshots\\".replaceAll("//", File.separator);

	@FindBy(xpath = "//*[text()='Mobile Number']")
	WebElement newRegLabel;

	public String scrollAndTakeScreenshot() {
		String screenshotPath = "";
		try {
			Thread.sleep(5000);
			((JavascriptExecutor) getDriver()).executeScript("javascript:window.scrollBy(250,350)");
			screenshotPath = SCREENSHOTS_DIRECTORY + "TestCapture" + com.utils.CommonUtility.getDateTime()
					+ ".jpg";
			TakesScreenshot screenshot = ((TakesScreenshot) getDriver());
			File file = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(screenshotPath));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to take screenshot:: " + e);
		}
		return screenshotPath;
	}
}
