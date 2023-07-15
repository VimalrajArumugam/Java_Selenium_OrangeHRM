package org.atmecs.orangehrm.locator;

import org.openqa.selenium.By;

/**
 * This class contains the locators of the PIMTab of the website
 * 
 * @author Kalarani.Prasanth
 *
 */
public class PIMPageLocators {
	public static By addButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
	public static By firstName = By.xpath("(//input[contains(@class,'oxd-input oxd-input')])[2]");
	public static By middleName = By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-middlename']");
	public static By lastName = By.xpath("(//input[contains(@class,'oxd-input oxd-input')])[4]");
	public static By employeeID = By.xpath("(//input[contains(@class,'oxd-input oxd-input')])[5]");
	public static By saveButton = By
			.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
	public static By employeeTab = By.xpath("(//a[@class='oxd-topbar-body-nav-tab-item'])[1]");
	public static By entireEmployeeDetails = By.xpath(
			"((//div[@class='oxd-table-cell oxd-padding-cell'])//following::div[not(@class='oxd-table-card-cell-checkbox')]//child::div[not(@class='oxd-table-cell-actions')])");
	public static By messageHeader = By.xpath("(//div[@id='oxd-toaster_1']//following::p)[1]");
	public static By successMessage = By.xpath("(//div[@id='oxd-toaster_1']//following::p)[2]");
	public static By requiredMessage = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");
	public static By recordsHeader = By.xpath("//div[@class='orangehrm-paper-container']//span ");
}
