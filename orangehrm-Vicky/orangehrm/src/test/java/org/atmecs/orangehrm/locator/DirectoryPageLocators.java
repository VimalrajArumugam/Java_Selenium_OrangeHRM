package org.atmecs.orangehrm.locator;

import org.openqa.selenium.By;

/**
 * This class contains the locators of the DirectoryTab of the website
 * 
 * @author Kalarani.Prasanth
 *
 */
public class DirectoryPageLocators {
	public static By employeeNameField = By
			.xpath("//div[contains(@class,'oxd-autocomplete-text-input oxd-autocomplete-text-input')]");
	public static By employeeNamesSuggestion = By.xpath(
			"//div[contains(@class,'oxd-autocomplete-text-input oxd-autocomplete-text-input')]//following::span[1]");
	public static By actualEmployeeDetail = By
			.xpath("//p[@class='oxd-text oxd-text--p orangehrm-directory-card-header --break-words']");

	public static By jobTitleField = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
	public static By jobsSuggestion = By
			.xpath("((//div[@class='oxd-select-text oxd-select-text--focus']//following::div[8])//child::span)[1]");
	public static By actualJobTitle = By.xpath(
			"//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//following::p[@class='oxd-text oxd-text--p orangehrm-directory-card-subtitle --break-words']");

	public static By locationField = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
	public static By locationsSuggestion = By.xpath("(//div[@class='oxd-select-option'])[3]");
	public static By actualLocation = By.xpath("(//div[@class='orangehrm-directory-card-body']//child::p)[2]");
	public static By searchButton = By.xpath("//button[@type='submit']");
	public static By resetButton = By.xpath("//button[@type='reset']");
	public static By messageHeader = By.xpath("(//div[@id='oxd-toaster_1']//following::p)[1]");
	public static By successMessage = By.xpath("(//div[@id='oxd-toaster_1']//following::p)[2]");
	public static By recordsHeader = By.xpath("//div[@class='orangehrm-paper-container']//span ");
}
