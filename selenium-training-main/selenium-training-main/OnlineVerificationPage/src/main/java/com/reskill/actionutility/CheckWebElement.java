package com.reskill.actionutility;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckWebElement {
	public boolean elementPresent(WebDriver driver, WebElement element, String name) {
		/*
		 * * Verify that the web element is displayed or not
		 * * Returned True or False
		 */
		try {
			boolean value = element.isDisplayed();
			System.out.println(name + " : Element is Displayed");
			return value;
		}
		catch (NoSuchElementException e) {
			System.out.println(name + " : Element is not displayed");
			return false;
		}

//		if(element.isDisplayed() == true) {
//		return true;
//		}else 
//		return false;
	}

	public void sendkeys(WebDriver driver, By by, String txt, String name) {
			/*
			 * * Return is true, enter the data into the text field 
			 */
		WebElement element = driver.findElement(by);
		boolean value = elementPresent(driver, element, name);
		if (value == true) {
			element.clear();

			element.sendKeys(txt);
			System.out.println(name + " : Enter the values succussfully");
		} else 
			System.out.println(name + " : Element is Not Displayed");
	}

	public void sendkeys(WebDriver driver, By by, String name) {

		WebElement element = driver.findElement(by);
		boolean value = elementPresent(driver, element, name);
		if (value == true) {

			if (element.isSelected() == true) {
				System.out.println("Is Selected");
			} else
				element.click();
			System.out.println(name + " : Click the button succussfully ");
		} else
			System.out.println(name + " : Element is Not Displayed");
	}
}
