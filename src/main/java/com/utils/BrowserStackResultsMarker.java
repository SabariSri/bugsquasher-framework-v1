package com.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BrowserStackResultsMarker {

	public static void markTestStatus(String status, String reason, WebDriver driver) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""
					+ status + "\", \"reason\": \"" + reason + "\"}}");
		} catch (Exception e) {
		}
	}
}
