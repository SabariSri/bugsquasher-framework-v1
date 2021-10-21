package com.reports;

import java.io.File;

import org.testng.SkipException;

import com.constants.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CustomExtentReports {
	public static ExtentReports extent;
	public static ExtentTest logger;

	public void startReport() {
		extent = new ExtentReports(Constants.REPORT_OUTPUT, true);
		extent.addSystemInfo("Host Name", "BeesKnees").addSystemInfo("Environment", "QA").addSystemInfo("User Name",
				"BugSquashers");
		extent.loadConfig(new File(Constants.REPORT_CONFIG_Path));
	}

	public void startTest(String testcaseName) {
		logger = extent.startTest(testcaseName);
	}

	public void stepPass(String passText) {
		logger.log(LogStatus.PASS, passText);
	}

	public void stepFailErrorStack(Throwable error) {
		logger.log(LogStatus.FAIL, error.fillInStackTrace());
	}
	
	public void stepFail(String failText) {
		logger.log(LogStatus.FAIL, failText);
	}

	public void stepInfo(String infoText) {
		logger.log(LogStatus.INFO, infoText);
	}

	public void stepWarning(String warningText) {
		logger.log(LogStatus.WARNING, warningText);
	}

	public void skipTest() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	public void endTest() {
		extent.endTest(logger);
	}

	public void endReport() {
		extent.flush();
		extent.close();
	}
}
