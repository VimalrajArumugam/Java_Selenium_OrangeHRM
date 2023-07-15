package org.atmecs.orangehrm.locator;

import org.openqa.selenium.By;

/**
 * This class contains the locators of the LoginPage of the website
 * 
 * @author Kalarani.Prasanth
 *
 */
public class LoginPageLocators {

	public static By username = By.name("username");
	public static By password = By.name("password");
	public static By passwordTag = By.tagName("input");
	public static By loginButton = By.xpath("//button[@type= 'submit']");
//	Implementing css selector
	public static By loginCSS = By.cssSelector("button[type='submit']");
	public static By required = By.xpath("//span[text()='Required']");
	public static By invalidCredentials = By.xpath("//p[text()='Invalid credentials']");
	public static By loginPageimage = By.xpath("//div[@class='orangehrm-login-branding']");


}
