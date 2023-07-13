package com.atmecs.qa.SampleProject.testscript;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.atmecs.falcon.automation.ui.selenium.Find;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.enums.BrowserType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.SampleProject.reusables.ReadFileData;
import com.atmecs.qa.SampleProject.testsuite.SampleTestSuiteBase;

public class HomePage extends SampleTestSuiteBase {
	ReportLogService report = new ReportLogServiceImpl(HomePage.class);
	ReadFileData readprop = new ReadFileData();

	@Test
	public void homescreen() throws InterruptedException {

		browser.openPage(readprop.homevalue("url"), BrowserType.CHROME);
		browser.getWait().pageLoadTimeout(30);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
		Find findElement = browser.getFindFromBrowser();
		Verify.verifyBoolean(findElement.findElementByClassName(readprop.homevalue("logo")).isDisplayed(), true,
				"Logo Displayed: ");
		Verify.verifyString(findElement.findElementByXpath(readprop.homevalue("falcontitle")).getText(),
				readprop.homevalue("falcontitletxt"), "Title Displayed or not: ");
		Verify.verifyString(findElement.findElementByXpath(readprop.homevalue("tagline1")).getText(),
				readprop.homevalue("tagline1txt"), "Tagline1: ");
		Verify.verifyString(findElement.findElementByXpath(readprop.homevalue("tagline2")).getText(),
				readprop.homevalue("tagline2txt"), "Tagline2 Text: ");
		Verify.verifyString(findElement.findElementByXpath(readprop.homevalue("header")).getText(),
				readprop.homevalue("headertxt"), "Header Text: ");

		browser.getPageScroll().down(600);
		String[] webelements = { "web", "mobile", "api", "faqs", "showcase", "license" };
		for (String weblement : webelements) {
			findElement.findElementByXpath("//a[@href='/" + weblement + "']").click();
			String doctitle = findElement.findElementByClassName("doc-title").getText();
			report.info("Webpage title: " + doctitle);
			browser.getNavigate().back();
		}
		String headertxt = findElement.findElementByClassName(readprop.homevalue("header2")).getText();
		Verify.verifyString(headertxt, readprop.homevalue("header2txt"), "Verify String Message ");
		browser.getPageScroll().down(1200);
//		Verify.verifyBoolean(findElement.findElementByClassName("ytp-cued-thumbnail-overlay-image").isEnabled(), true, "Youtube Video displayed:- ");
//		browser.getPageScroll().down(1200);
		findElement.findElementByXpath("//a[text()='ATMECS']").click();
		report.info("click the window");
		browser.wait(5000);
		Set<String> windows = browser.getWindowHandler().getWindowHandles();

		for (String window : windows) {
			WebDriver windowele = browser.getDriver().switchTo().window(window);
			String child = windowele.getTitle();
			report.info("before if" + child);
			if (child.contains("Home")) {
				windowele.close();
				report.info("child window closed");
				break;

			}

		}

	}

}
