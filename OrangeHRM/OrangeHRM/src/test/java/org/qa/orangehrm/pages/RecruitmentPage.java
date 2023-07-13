package org.qa.orangehrm.pages;

import org.openqa.selenium.By;

/**
 * RecruitmentPage Locators
 */

public class RecruitmentPage {
	/**
	 * RecruitmentPage candidate tab Locators
	 */

	public static By recruitmentButton = By.xpath("//a//span[normalize-space()='Recruitment']");
	public static By candidatestab = By.xpath("//a[text()='Candidates']");
	public static By candidateaddButton = By.xpath("//button[text()=' Add ']");
	public static By firstName = By.xpath("//input[@name='firstName']");
	public static By lastName = By.xpath("//input[@name='lastName']");
	public static By middleName = By.xpath("//input[@name='middleName']");

	public static By candidateVacany(String text) {
		return By.xpath("//div[@role='option']//child::span[contains (text(),'')]");
	}

	public static By eMail = By.xpath("	//label[text()='Email']/parent::div//following-sibling::div//input");
	public static By ContactNumber = By
			.xpath("//label[text()='Contact Number']/parent::div//following-sibling::div/input");
	public static By browseUpload = By.xpath("//div[text()='Browse']/parent::div//child::i");
	public static By keywords = By.xpath("//label[text()='Keywords']//parent::div//following-sibling::div/input");
	public static By dateOfApplicant = By
			.xpath("//label[text()='Date of Application']//parent::div//following-sibling::div//input");
	public static By notes = By.xpath("//label[text()='Notes']//parent::div//following-sibling::div//textarea");
	public static By candidateSaveButton = By.xpath("//button[text()=' Save ']");
	public static By canditateNamevalidation = By
			.xpath("//div[@class='oxd-table-cell oxd-padding-cell'][@role='cell'][3]");
	public static By canditateNameSearchTextBox = By
			.xpath("//label[text()='Candidate Name']//parent::div//following-sibling::div//input");

	public static By canditateNameSearchTo = By
			.xpath("//label[text()='Candidate Name']//parent::div//following-sibling::div//div[@role='option']");
	public static By candidateSearchButton = By.xpath("//button[@type='submit']");
	public static By candidateSuccessTextSearch = By.xpath("//span[text()='No Records Found']");
	public static By addedCandidateName = By.xpath("//label[text()='Name']//parent::div//following-sibling::div/p");

	public static By viewRecord = By.xpath("(//button/following::i[@class='oxd-icon bi-eye-fill'])[1]");

	public static By downloadFile = By.xpath("//label[text()='Resume']//parent::div//following-sibling::div//p//i");

	public static By deleteFile = By.xpath("(//button/following::i[@class='oxd-icon bi-trash'])[1]");
	public static By deleteSelected = By.xpath("//button[text()=' Delete Selected ']");

	public static By vacancyEdit = By.xpath("(//button/following::i[@class='oxd-icon bi-pencil-fill'])[1]");

	public static By vacancyEditDescription = By
			.xpath("//label[text()='Description']//parent::div//following-sibling::div//textarea");
	public static By confirmDelete = By.xpath("//button[text()=' Yes, Delete ']");
	public static By deleteCheckBox = By.xpath("(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[2]");

	public static By dashboardLink = By.xpath("//span[text()='Dashboard']");
	public static By vacancyJobTitle = By.xpath("//div[@class='oxd-select-option']//child::span");
	public static By confirmDeleteAlert = By.xpath("//button/i[@class='oxd-icon bi-trash oxd-button-icon']");

	public static By recuritmentCandidateSaveButton = By
			.xpath("//div[@class='oxd-form-actions']//button[@type='submit' and text()=' Save ']");
	public static By candidateNameSearch = By
			.xpath("//div[@class='oxd-autocomplete-text-input--before']//following-sibling::input");

	public static By recuritmentSearch(String text) {
		return By.xpath("//div[@class='oxd-select-text--after']//preceding::label[text()='" + text + "')]");
	}

	public static By recruitmentTab(String text) {
		return By.xpath(
				"//li[@class='oxd-topbar-body-nav-tab --visited']//parent::ul//following::a[text()='" + text + "')]");
	}

	public static By recruitmentDropDown = By.xpath("//div[@class='oxd-autocomplete-option']");
	/**
	 * RecruitmentPage vacancy tab Locators
	 */

	public static By vacanciesTab = By.xpath("//a[text()='Vacancies']");
	public static By vacancyName = By.xpath("//label[text()='Vacancy Name']/parent::div//following-sibling::div/input");
	public static By vacancyClick = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']");
	public static By jobTitle = By.xpath("//div[@role='option'][@class='oxd-select-option']/span");
	public static By supervisorReviewer = By
			.xpath("//label[text()='Hiring Manager']/parent::div//following-sibling::div//input");
	public static By supervisorReviewerdropdown = By.xpath("//div[@class='oxd-autocomplete-option']//span");
	public static By vacanciesSaveButton = By
			.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
	public static By vacancyNameSearchTo = By
			.xpath("//label[text()='Hiring Manager']//parent::div//following-sibling::div//div[@role='option']");
	public static By vacancySaveButton = By.xpath("//button[text()=' Save ')]");
	public static By searchButton = By.xpath("//button[text()=' Search ']");
	public static By searchHiringManager = By
			.xpath("//label[contains(text(),'Hiring Manager']//parent::div//following-sibling::div//i");

	public static By hiringManager(String managerName) {
		return By.xpath(
				"//label[text()='Hiring Manager']//parent::div//following-sibling::div//div[@role='option']//span[text()='"
						+ managerName + "')]");
	}

	public static By searchHiringManagerTo = By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell'][4])[1]//div");

	public static By vacancyDropDown = By.xpath("//div[@class='oxd-select-text--after']");
	public static By vacancy = By
			.xpath("//label[text()'Vacancy']/parent::div//following-sibling::div//div[@role='listbox']//div//span");

}
