package com.reskill.actions;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckButtonElement {
	static Logger logger = Logger.getLogger(CheckButtonElement.class);

	public boolean isButtonEnable(WebDriver driver, By locator, String elementLabel) {
		try {
			driver.findElement(locator);
		} catch (NoSuchElementException e) {
			logger.info("Element " + elementLabel + " is NOT Enabled");
			return false;
		}
		logger.info("Element " + elementLabel + " is Enabled");
		return true;
	}
}
