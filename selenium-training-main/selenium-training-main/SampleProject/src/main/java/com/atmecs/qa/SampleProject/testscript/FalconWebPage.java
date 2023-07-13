package com.atmecs.qa.SampleProject.testscript;

import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Find;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.enums.BrowserType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.SampleProject.pages.VerifyFalconWebPageNavgationLinks;
import com.atmecs.qa.SampleProject.reusables.ReadFileData;
import com.atmecs.qa.SampleProject.testsuite.SampleTestSuiteBase;

public class FalconWebPage extends SampleTestSuiteBase {
	VerifyFalconWebPageNavgationLinks verifynavigations = new VerifyFalconWebPageNavgationLinks();
	ReportLogService report = new ReportLogServiceImpl(FalconWebPage.class);
	ReadFileData readprop = new ReadFileData();
	
	@Test
	public void webpage() {
		browser.openPage(readprop.falconWebpage("url"), BrowserType.CHROME);
		browser.getWait().pageLoadTimeout(30);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
		Find findElement = browser.getFindFromBrowser();
//		Verify.verifyString(findElement.findElementByXpath(readprop.falconWebpage("pageheader")).getText(), readprop.falconWebpage("pageheadertxt"), "Verify String Message ") ;
//		Verify.verifyBoolean(findElement.findElementByXpath(readprop.falconWebpage("breadcrumbHome")).isDisplayed(), true, "Verify breadcrumb-Home is displayed : ");
//		Verify.verifyBoolean(findElement.findElementByXpath(readprop.falconWebpage("breadcrumbweb")).isDisplayed(), true, "Verify breadcrumb-Falcon-Web is displayed:- ");
//		Verify.verifyBoolean(findElement.findElementByXpath(readprop.falconWebpage("smartlocator")).isDisplayed(), true, "Verify the smartlocator button displayed:- ");
//		Verify.verifyString(findElement.findElementByXpath(readprop.falconWebpage("header")).getText(), readprop.falconWebpage("headertxt"), "Verify String Message:- ");
//		Verify.verifyBoolean(findElement.findElementByXpath(readprop.falconWebpage("lastupdate")).isDisplayed(), true, "Verify Last Update displayed:- ");
//		verifynavigations.overview(browser);
//		verifynavigations.gettingStarted(browser);
		verifynavigations.projectStructure(browser);
		verifynavigations.PlatformServiceGuide(browser);
	}

}
