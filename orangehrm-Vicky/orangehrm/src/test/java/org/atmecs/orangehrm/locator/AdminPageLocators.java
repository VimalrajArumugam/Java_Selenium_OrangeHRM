package org.atmecs.orangehrm.locator;

import org.openqa.selenium.By;

public class AdminPageLocators {
	public static By name = By.xpath("(//input[contains(@class,'oxd-input oxd-input')])[2]");
	public static By searchButton = By.cssSelector("button[type=submit]");
	public static By resetButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--ghost']");
	public static By userCheckBox = By.xpath("(//div[@class='oxd-table-card-cell-checkbox'])[2]");
	public static By deleteCheckBox = By.xpath("(//i[@class='oxd-icon bi-trash'])[2]");
	public static By deletePopUp = By
			.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");
	public static By deleteIcon = By.xpath("//i[@class='oxd-icon bi-trash-fill oxd-button-icon']");
	public static By jobTab = By.xpath("(//span[@class='oxd-topbar-body-nav-tab-item'])[2]");
	public static By employmentStatusTab = By.xpath("//a[(text()='Employment Status')]");
	public static By addButton = By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']");
	public static By saveButton = By.cssSelector("button[type=submit]");
	public static By editButton = By.xpath("(//i[@class='oxd-icon bi-pencil-fill'])[1]");
	public static By editElementText = By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell']//div)[3]");
	public static By workShiftTab = By.xpath("//a[text()='Work Shifts']");
	public static By shiftName = By.xpath("(//input[contains(@class,'oxd-input oxd-input')])[2]");
	public static By workingShiftFrom = By.xpath("(//input[contains(@class,'oxd-input oxd-input')])[3]");
	public static By inTimeHours = By
			.xpath("((//input[contains(@class,'oxd-input oxd-input')])[3]//following::input)[1]");
	public static By inHoursArrow = By.xpath("//i[@class='oxd-icon bi-chevron-up oxd-icon-button__icon oxd-time-hour-input-up']");
	public static By inTimeMinutes = By
			.xpath("((//input[contains(@class,'oxd-input oxd-input')])[3]//following::input)[2]");
	public static By inTimeAM = By.xpath("((//input[contains(@class,'oxd-input oxd-input')])[3]//following::input)[3]");
	public static By inTimePM = By.xpath("((//input[contains(@class,'oxd-input oxd-input')])[3]//following::input)[4]");
	public static By workingShiftTo = By.xpath("(//input[contains(@class,'oxd-input oxd-input')])[4]");
	public static By outTimeHours = By
			.xpath("((//input[contains(@class,'oxd-input oxd-input')])[4]//following::input)[1]");
	public static By outHoursArrow = By.xpath("//i[@class='oxd-icon bi-chevron-up oxd-icon-button__icon oxd-time-hour-input-up']");
	
	public static By outTimeMinutes = By
			.xpath("((//input[contains(@class,'oxd-input oxd-input')])[4]//following::input)[2]");
	public static By outTimeAM = By
			.xpath("((//input[contains(@class,'oxd-input oxd-input')])[4]//following::input)[3]");
	public static By outTimePM = By
			.xpath("((//input[contains(@class,'oxd-input oxd-input')])[4]//following::input)[4]");
	public static By organizationTab = By.xpath("(//span[@class='oxd-topbar-body-nav-tab-item'])[3]");
	public static By locationTab = By.xpath("//a[text()='Locations']");
	public static By city = By.xpath("(//input[contains(@class,'oxd-input oxd-input')])[3]");
	public static By state = By.xpath("(//input[contains(@class,'oxd-input oxd-input')])[4]");
	public static By postalCode = By.xpath("(//input[contains(@class,'oxd-input oxd-input')])[5]");
	public static By phone = By.xpath("(//input[contains(@class,'oxd-input oxd-input')])[6]");
	public static By addCountry = By.xpath("//div[contains(@class,'oxd-select-text oxd-select-text')]");
	public static By addCountryName = By.xpath("//div[contains(@class,'oxd-select-text oxd-select-text')]//following::span[text()='India']");
	public static By searchcountry = By.xpath("//div[@class='oxd-select-text-input']");
	public static By searchCountryName = By
			.xpath("//div[@class='oxd-select-text-input']//following::span[text()='India']");
	public static By entireEmployeeDetails = By.xpath(
			"((//div[@class='oxd-table-cell oxd-padding-cell'])//following::div[not(@class='oxd-table-card-cell-checkbox')]//child::div[not(@class='oxd-table-cell-actions')])");
	public static By messageHeader = By.xpath("(//div[@id='oxd-toaster_1']//following::p)[1]");
	public static By successMessage = By.xpath("(//div[@id='oxd-toaster_1']//following::p)[2]");
	public static By recordsHeader = By.xpath("//div[@class='orangehrm-paper-container']//span");
	public static By exist = By.xpath("//span[text()='Already exists']");
	public static By cancelButton = By.xpath("(//button[@type='button'])[2]");
}
