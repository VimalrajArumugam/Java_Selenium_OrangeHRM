package org.atmecs.orangehrm.locator;

import org.openqa.selenium.By;

/**
 * This class contains the locators of the HomePage of the website
 * 
 * @author Kalarani.Prasanth
 *
 */
public class HomePageLocators {
	public static By searchTab = By.xpath("//input[@class ='oxd-input oxd-input--active']");
	public static By directoryTab = By.xpath("//span[text()='Directory']");
	public static By pimTab = By.xpath("//span[text()='PIM']");
	public static By recruitmentTab = By.xpath("//span[text()='Recruitment']");
	public static By performanceTab = By.xpath("//span[text()='Performance']");
	public static By adminTab = By.xpath("//span[text()='Admin']");
	public static By homePageImage = By.xpath("//img[@alt='client brand banner']");
	public static By loginPageImage = By.xpath("//div[@class='orangehrm-login-branding']");
}
