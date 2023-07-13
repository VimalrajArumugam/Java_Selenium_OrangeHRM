package org.qa.orangehrm.pages;

import org.openqa.selenium.By;

public class LoginPage {
	/**
	 * Login Page Locators
	 */

	public static By userName= By.xpath("//label[text()='Username']//parent::div//following-sibling::div/input");
	public static By passWord= By.xpath("//label[text()='Password']//parent::div//following-sibling::div/input");
    public static By logInButton= By.xpath("//button[@type='submit']");
    public static By logInProfile = By.xpath("//img[@alt='profile picture']//following-sibling::p");
    public static By profileClick=By.xpath("//span[@class='oxd-userdropdown-tab']");
    public static By logOutButton=By.xpath("//a[contains(text(),'Logout')]");
	public static By invalidCredentials = By.xpath("//p[text()='Invalid credentials']");

}

