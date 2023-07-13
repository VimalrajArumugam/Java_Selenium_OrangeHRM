package com.reskill.actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckTextField {
	static Logger logger = Logger.getLogger(CheckTextField.class);

	CheckElement elementCheck = new CheckElement();
	
	public void enterText(WebDriver driver, By locator, String elementLabel, String expValueToEnter) {

		if (elementCheck.isElementPresent(driver, locator, elementLabel)) {
			driver.findElement(locator).sendKeys(expValueToEnter);
			logger.info("Entered " + elementLabel + " is: " + expValueToEnter);
		} else {
			logger.info("Enterted " + elementLabel + "is NOT ");
		}

	}
}
