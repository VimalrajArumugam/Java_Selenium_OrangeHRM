package com.atmecs.qa.SampleProject.testscript;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import com.atmecs.falcon.automation.ui.selenium.*;
import com.atmecs.falcon.automation.ui.seleniuminterfaces.WindowHandler;
import com.atmecs.falcon.automation.util.enums.BrowserType;
import com.atmecs.falcon.automation.util.enums.LocatorType;
//import com.atmecs.falcon.automation.ui.selenium.Alerts;
//import com.atmecs.falcon.automation.ui.selenium.Click;
//import com.atmecs.falcon.automation.ui.selenium.TextField;
//import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.SampleProject.constant.FilePathConstants;
import com.atmecs.qa.SampleProject.pages.VerifyUserRegistration;
import com.atmecs.qa.SampleProject.reusables.ReadExcelDataUsingMap;
import com.atmecs.qa.SampleProject.reusables.ReadFileData;
import com.atmecs.qa.SampleProject.testsuite.SampleTestSuiteBase;

import net.bytebuddy.implementation.bind.annotation.BindingPriority;

public class RegistrationAndLoginTestScript extends SampleTestSuiteBase {
	ReportLogServiceImpl report = new ReportLogServiceImpl(RegistrationAndLoginTestScript.class);
	ReadExcelDataUsingMap readdata = new ReadExcelDataUsingMap();
	VerifyUserRegistration registration = new VerifyUserRegistration();
	ReadFileData readprop = new ReadFileData();

	@Test(priority=0)
	public void launchApplication() {
		report.info("Opening browser: ");
		browser.openPage(readprop.keyvalue("url"), BrowserType.CHROME);		
		report.info("Maximizing browser window");
		browser.maximizeWindow();
	}

	@Test (priority=1)
	public void userRegistration() {
		Click click = browser.getClick();
		click.performClick(LocatorType.XPATH, readprop.keyvalue("register"));
		String text = browser.getFindFromBrowser().findElementByXpath(readprop.keyvalue("header")).getText();
		report.info("Registration Form HeadLine: " + text);
		Verify.verifyString(text, "Register Here", "Verifing String message ");
		registration.registrationWithMultipleDataSets(browser);
	}

	@Test (priority=2)
	public void userLogin() throws InterruptedException {
		Thread.sleep(3000);
		List<Map<String, String>> testdata = readdata.getTestData();
		Find findbrowser = browser.getFindFromBrowser();
		String logintxt = findbrowser.findElementByXpath(readprop.loginValue("header")).getText();
		Verify.verifyString(logintxt, "Login Here", "Verifing String Message: ");
		TextField entertext = browser.getTextField();
		entertext.enterTextField(LocatorType.ID, readprop.loginValue("EmailId"), testdata.get(1).get("EmailId"));
		report.info("User EmailId: " + testdata.get(1).get("EmailId"));
		entertext.enterTextField(LocatorType.XPATH, readprop.loginValue("Password"), testdata.get(1).get("Password"));
		report.info("password: " + testdata.get(1).get("Password"));
		browser.getClick().performClick(LocatorType.XPATH, readprop.loginValue("Login"));
		browser.captureScreenshot();
		String alerttxt = findbrowser.findElementById(readprop.loginValue("Alertbox")).getText();
		report.info("Get Text from Alert: " + alerttxt);
		Alerts alert = browser.getAlert();
		boolean checkalert = alert.verifyAlertPresent(0);
		report.info("Verify Alert present: " + checkalert);
	}
}
