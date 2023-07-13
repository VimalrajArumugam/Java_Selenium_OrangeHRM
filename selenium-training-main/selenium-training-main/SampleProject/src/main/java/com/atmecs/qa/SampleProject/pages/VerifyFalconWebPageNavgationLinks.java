package com.atmecs.qa.SampleProject.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.selenium.Click;
import com.atmecs.falcon.automation.ui.selenium.Find;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.SampleProject.reusables.ReadFileData;
import com.atmecs.qa.SampleProject.testscript.FalconWebPage;

public class VerifyFalconWebPageNavgationLinks {
	ReportLogService report = new ReportLogServiceImpl(FalconWebPage.class);
	ReadFileData readprop = new ReadFileData();
	
	public void overview(Browser browser) {
		Find findElement = browser.getFindFromBrowser();
		findElement.findElementByXpath(readprop.falconWebpage("overviewobj")).click();
		Verify.verifyString(findElement.findElementByXpath(readprop.falconWebpage("overviewheaer")).getText(), readprop.falconWebpage("overviewheadertxt"), "Verified String Message:- ");
		findElement.findElementByXpath(readprop.falconWebpage("locatorGenObj")).click();
		Verify.verifyString(findElement.findElementByXpath(readprop.falconWebpage("locatorGenHeader")).getText(), readprop.falconWebpage("locatorGenTxt"), "Verified String Message:- ");
		Verify.verifyBoolean(findElement.findElementByXpath(readprop.falconWebpage("downloadlocator")).isDisplayed(), true, "Download Locator Generator displayed:- ");
		findElement.findElementByXpath(readprop.falconWebpage("automationPlatform")).click();
		Verify.verifyString(findElement.findElementByXpath(readprop.falconWebpage("automationPfromHeader")).getText(), readprop.falconWebpage("automationPformtxt"), "Verified String Message:- ");
	}
	
	public void gettingStarted(Browser browser) {
		Find findElement = browser.getFindFromBrowser();
		findElement.findElementByXpath(readprop.falconWebpage("getStartedObj")).click();
		Verify.verifyString(findElement.findElementByXpath(readprop.falconWebpage("getStartedHeader")).getText(), readprop.falconWebpage("getStartTxt"), "Verified String Message:- ");
		findElement.findElementByXpath(readprop.falconWebpage("envSetUpObj")).click();
		Verify.verifyString(findElement.findElementByXpath(readprop.falconWebpage("envSetUpHeader")).getText(), readprop.falconWebpage("envSetUpTxt"), "Verified String Message:- ");
		findElement.findElementByXpath(readprop.falconWebpage("projectSetup")).click();
		Verify.verifyString(findElement.findElementByXpath(readprop.falconWebpage("projSetUpHeader")).getText(), readprop.falconWebpage("propSetUpTxt"), "Verified String Message:- ");
		List<WebElement> imglinks = findElement.findElementsBy(By.xpath(readprop.falconWebpage("imgLinks")));
		for(WebElement imglink : imglinks) {
			
			Verify.verifyBoolean(imglink.isDisplayed(), true, "Verify Project Setup Images are displayed:- ");
		}
	}
	
	public void projectStructure(Browser browser) {
		Find findElement = browser.getFindFromBrowser();
		Click click = browser.getClick();
		click.performClick(LocatorType.XPATH, readprop.falconWebpage("projectStrecture"));
		Verify.verifyString(findElement.findElementByXpath(readprop.falconWebpage("proStrectureHeader")).getText(), readprop.falconWebpage("proStrecturetxt"), "Verify String Message:- ");
		click.performClick(LocatorType.XPATH, readprop.falconWebpage("underPropStrecture"));
		Verify.verifyString(findElement.findElementByXpath(readprop.falconWebpage("underPropSttectureHeader")).getText(), readprop.falconWebpage("underPropSttectureTxt"), "Verify String Message:- ");
		List<WebElement> images = findElement.findElementsBy(By.xpath(readprop.falconWebpage("propStrectureImages")));
		for (WebElement image : images) {
			Verify.verifyBoolean(image.isDisplayed(), true, "Verify Project Structure document images displayed:- ");
		}
		click.performClick(LocatorType.XPATH, readprop.falconWebpage("underconfigprop"));
		Verify.verifyString(findElement.findElementByXpath(readprop.falconWebpage("underconfigpropHead")).getText(), readprop.falconWebpage("underconfigpropTxt"), "Verify String Message:- ");
		click.performClick(LocatorType.XPATH, readprop.falconWebpage("writeUrFirstTest"));
		Verify.verifyString(findElement.findElementByXpath(readprop.falconWebpage("writeUrFirstHader")).getText(), readprop.falconWebpage("writeUrFirstHeaderTxt"), "Verify String Message:- ");
		List<WebElement> firstTetstImgs = findElement.findElementsBy(By.xpath(readprop.falconWebpage("writeUrFirstTestImges")));
		for (WebElement firstImg : firstTetstImgs) {
			Verify.verifyBoolean(firstImg.isDisplayed(), true, "Writing Your First Test documet images are displayed:- ");
			report.info("----");
		}
	}
	
	public void PlatformServiceGuide(Browser browser) {
		Find findElement = browser.getFindFromBrowser();
		Click click = browser.getClick();
		click.performClick(LocatorType.XPATH, readprop.falconWebpage("platformSerGuide"));
		Verify.verifyString(findElement.findElementByXpath(readprop.falconWebpage("platformSerGuideHeader")).getText(), readprop.falconWebpage("platformSerGuideHeaderTxt"), "Verify String Messaage");
		List<WebElement> listOfClassPaths = findElement.findElementsBy(By.xpath("listOfClassXpath"));
		for (WebElement listOfClassPath : listOfClassPaths) {
			report.info("--------");
			report.info( listOfClassPath.getText());
		}
	}

}
