package com.reskill.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginDetails {

	
	
	public String[] getLoginNameDetails(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		String[] lines = element.getText().split("\\n");
		return lines;
	}

}
