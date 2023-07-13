package com.reskill.testscripts;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAreaChart;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.reskill.actions.CheckButtonAction;
import com.reskill.actions.CheckElement;
import com.reskill.actions.CheckTextField;
import com.reskill.actions.LoginDetails;
import com.reskill.actionutility.SelectWebDriver;
import com.reskill.pages.UserLoginPageLocators;

public class SauceDemoLoginTest {
	
	LoginDetails loginName = new LoginDetails();
			
	static Logger logger = Logger.getLogger(SauceDemoLoginTest.class);

	SelectWebDriver resDriver = new SelectWebDriver();

	CheckElement elementCheck = new CheckElement();

	UserLoginPageLocators userLoginPage = new UserLoginPageLocators();

	CheckTextField textFiledCheck = new CheckTextField();

	CheckButtonAction buttonCheck = new CheckButtonAction();
	
	public WebDriver driver;

	@BeforeTest
	public void selectBrowser() {
		driver = resDriver.getDriver();
		resDriver.getUrl(driver);
	}

	@Test
	public void CheckUserNamesandPasswordTextPresent() {
		
		String acceptedUsernamesText = "Accepted usernames are:";
		String standardUserText = "standard_user";
		String lockedOutUserText = "locked_out_user";
		String problemUserText = "problem_user";
		String performanceGlitchUserText = "performance_glitch_user";
		String passwordforallusersText = "Password for all users:";
		String secretSauceText = "secret_sauce";
		
		String[] acceptedUsernamess = loginName.getLoginNameDetails(driver, By.xpath(userLoginPage.getLoginName()));
		String[] passwordforallusers = loginName.getLoginNameDetails(driver, By.xpath(userLoginPage.getstandardPasswordlist()));
		
		
		Assert.assertEquals(acceptedUsernamesText, acceptedUsernamess[0], "Text Missmatched");
		logger.info(acceptedUsernamess[0] + " Text is Present");
		
		Assert.assertEquals(standardUserText, acceptedUsernamess[1], "Text Missmatched");
		logger.info(acceptedUsernamess[1] + " Text is Present");
		
		Assert.assertEquals(lockedOutUserText, acceptedUsernamess[2], "Text Missmatched");
		logger.info(acceptedUsernamess[2] + " Text is Present");
		
		Assert.assertEquals(problemUserText, acceptedUsernamess[3], "Text Missmatched");
		logger.info(acceptedUsernamess[3] + " Text is Present");
		
		Assert.assertEquals(performanceGlitchUserText, acceptedUsernamess[4], "Text Missmatched");
		logger.info(acceptedUsernamess[4] + " Text is Present");
			
		Assert.assertEquals(passwordforallusersText, passwordforallusers[0], "Text Missmatched");
		logger.info(passwordforallusers[0] + " Text is Present");
		
		Assert.assertEquals(secretSauceText, passwordforallusers[1], "Text Missmatched");
		logger.info(passwordforallusers[1] + " Text is Present");
	}
	
	@Test
	public void validLoginTest() {
		textFiledCheck.enterText(driver, By.xpath(userLoginPage.getUserName()), userLoginPage.getUserLabel(), userLoginPage.getStandardUserName());
		textFiledCheck.enterText(driver, By.xpath(userLoginPage.getPassword()), userLoginPage.getuserPasswordLabel(), userLoginPage.getStandardPassword());
		buttonCheck.loginButton(driver, By.xpath(userLoginPage.getLoginButton()), userLoginPage.getLoginLable());
	}

	@AfterTest
	public void closeDriver() {
		resDriver.closeBrowser(driver);
	}

}
