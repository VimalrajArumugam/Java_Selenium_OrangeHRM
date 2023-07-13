package com.atmecs.qa.SampleProject.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.selenium.Click;
import com.atmecs.falcon.automation.ui.selenium.TextField;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.SampleProject.reusables.ReadExcelDataUsingMap;
import com.atmecs.qa.SampleProject.reusables.ReadFileData;
import com.atmecs.qa.SampleProject.testscript.RegistrationAndLoginTestScript;

public class VerifyUserRegistration {
	ReportLogServiceImpl report = new ReportLogServiceImpl(RegistrationAndLoginTestScript.class);
	ReadExcelDataUsingMap usertestdata = new ReadExcelDataUsingMap();
	ReadFileData readprop = new ReadFileData();
	
	public void registrationWithMultipleDataSets(Browser browser) {
		List<Map<String, String>> testdataset = usertestdata.getTestData();
		TextField entertext = browser.getTextField();
		Click click = browser.getClick();
		for (Map<String, String> testdata : testdataset) {
			entertext.enterTextField(LocatorType.NAME, readprop.keyvalue("username"), testdata.get("UserName"));
			entertext.enterTextField(LocatorType.XPATH, readprop.keyvalue("email"), testdata.get("EmailId"));
			entertext.enterTextField(LocatorType.XPATH, readprop.keyvalue("password"), testdata.get("Password"));
			entertext.enterTextField(LocatorType.NAME, readprop.keyvalue("confirmpassword"), testdata.get("ConfirmPassword"));
			click.performClick(LocatorType.ID, readprop.keyvalue("submit"));
			WebElement alerttext = browser.getFindFromBrowser().findElementById(readprop.keyvalue("alert"));
			report.info("Get Text from Alert: " + alerttext.getText());
			report.info("Alert message box displayed or not: " + alerttext.isDisplayed());
			browser.captureScreenshot();
			browser.getWait().waitForElementPresence(LocatorType.XPATH, readprop.keyvalue("register"), 10);
			click.performClick(LocatorType.XPATH, readprop.keyvalue("register"));
		}
	}

}
