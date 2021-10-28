package com.ui.basepage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import com.base.AbstractSetup;

public abstract class AbstractPage extends AbstractSetup {

	public void switch_to_iframe(String iframe) {
		try {
			getDriver().switchTo().frame(iframe);
			reporter().stepPass("Switched to iFrame " + iframe);
		} catch (Exception e) {
			reporter().stepFail("Unable to switch to iFrame " + iframe + "\n\n" + "ERROR MESSAGE " + e.toString());
		}
	}

	public void scroll_to_element(WebElement element, String refKey) {
		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
			reporter().stepPass("Scrolled to " + refKey);
		} catch (Exception e) {
			reporter().stepFail("Unable to scroll to " + refKey + "\n\n" + "ERROR MESSAGE " + e.toString());
		}
	}

	public void setText(String element, String value, String refKey) {
		try {
			findElement(element).sendKeys(value);
			reporter().stepPass("Typed '" + value + "' in " + refKey);
		} catch (Exception e) {
			reporter().stepFail("Unable to type " + value + " in " + refKey + "\n\n" + "ERROR MESSAGE " + e.toString());
		}
	}

	public void setText(WebElement element, String value, String refKey) {
		try {
			element.sendKeys(value);
			reporter().stepPass("Typed '" + value + "' in " + refKey);
		} catch (Exception e) {
			reporter().stepFail("Unable to type " + value + " in " + refKey + "\n\n" + "ERROR MESSAGE " + e.toString());
		}
	}

	public void setTextAndClickEnter(WebElement element, String value, String refKey) {
		try {
			element.sendKeys(value);
			element.sendKeys(Keys.ENTER);
			reporter().stepPass("Typed '" + value + "' in " + refKey + " and clicked Enter");
		} catch (Exception e) {
			reporter().stepFail("Unable to type " + value + " in " + refKey + "\n\n" + "ERROR MESSAGE " + e.toString());
		}
	}

	public void setTextAndClickEnter(String element, String value, String refKey) {
		try {
			findElement(element).sendKeys(value);
			findElement(element).sendKeys(Keys.ENTER);
			reporter().stepPass("Typed '" + value + "' in " + refKey + " and clicked Enter");
		} catch (Exception e) {
			reporter().stepFail("Unable to type " + value + " in " + refKey + "\n\n" + "ERROR MESSAGE " + e.toString());
		}
	}

	public void clickOn(String element, String refKey) {
		try {
			findElement(element).click();
			reporter().stepPass("Clicked on " + refKey);
		} catch (Exception e) {
			reporter().stepFail("Unable to click on " + "\n\n" + "ERROR MESSAGE :: " + e.toString());
		}
	}

	public void clickOn(WebElement element, String refKey) {
		try {
			element.click();
			reporter().stepPass("Clicked on " + refKey);
		} catch (NotFoundException | NullPointerException e) {
			e.printStackTrace();
			reporter().stepFail("Unable to click on " + "\n\n" + "ERROR MESSAGE :: " + e.toString());
		}
	}

	public String getText(String element, String refKey) {

		try {
			String text = findElement(element).getText();
			reporter().stepInfo("Text of " + refKey + " is " + text);
			return text;
		} catch (Exception e) {
			reporter().stepFail("Unable to getText of " + "\n\n" + "ERROR MESSAGE :: " + e.toString());
			return null;
		}
	}

	public WebElement findElement(String element) {
		if (element.startsWith("xpath")) {
			return getDriver().findElement(By.xpath(element.substring(6)));
		} else if (element.startsWith("id")) {
			return getDriver().findElement(By.id(element.substring(3)));
		}
		return null;
	}
}
