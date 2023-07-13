package com.reskill.actionutility;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.reskill.pages.UserLoginPageLocators;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectWebDriver {
	BrowserUtilities browser = new BrowserUtilities();
	
	UserLoginPageLocators login = new UserLoginPageLocators();
	public WebDriver driver;
	static Logger logger = Logger.getLogger(SelectWebDriver.class);

	public WebDriver getDriver() {

		if (browser.getBrowser().contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			this.driver = new ChromeDriver();
			logger.info("Chrome Browser Loaded");
			return driver;
		} else if (browser.getBrowser().contains("edge")) {
			WebDriverManager.edgedriver().setup();
			this.driver = new EdgeDriver();
			logger.info("Edge Browser Loaded");
			return driver;
		} else {
			logger.info("Check the Browser Utility for Valid Browser");
			return null;
		}
	}

	public void getUrl(WebDriver driver) {
		driver.manage().window().maximize();
		try {
			driver.get(browser.getUrlProperty());
		} catch (Exception e) {
			logger.error("User could not get the Browser URL");
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			logger.info("Completed");
		}
	}

	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}

}
