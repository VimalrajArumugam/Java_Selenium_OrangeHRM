package com.reskill.actions;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.reskill.pages.UserLoginPageLocators;

public class CheckElement {
	static Logger logger = Logger.getLogger(CheckElement.class);
	UserLoginPageLocators login = new UserLoginPageLocators();
	String expUserName;

	public boolean isElementPresent(WebDriver driver, By locator, String elementLabel) {
		try {
			driver.findElement(locator);
		} catch (NoSuchElementException e) {
			logger.info("Element " + elementLabel + " is NOT Present ");
			return false;
		}
		logger.info("Element " + elementLabel + " is Present ");
		return true;
	}

}
