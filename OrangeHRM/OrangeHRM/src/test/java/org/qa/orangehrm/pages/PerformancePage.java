package org.qa.orangehrm.pages;

import org.openqa.selenium.By;

public class PerformancePage {
	/**
	 * PerformancePage candidate tab Locators
	 */

	public static By Performance = By.xpath("//span[text()='Performance']");
	public static By ManageReviewstab = By.xpath("//span[text()='Manage Reviews ']");
	public static By ManageReviewsLink = By.xpath("//a[text(),'Manage Reviews']");
	public static By addButton = By.xpath("//button[text()=' Add ']");

	public static By EmployeeName = By.xpath("(//label[text()='Employee Name']/following::input)[1]");

	public static By EmployeeNameData(String text) {
		return By.xpath("//div[@class='oxd-autocomplete-option']/span[text()='" + text + "')]");
	}

	public static By SupervisorReviewerr = By
			.xpath("//label[text()='Supervisor Reviewer']/parent::div//following::div[@role='listbox']//span");
	public static By reviewPeriodStartDate = By
			.xpath("//label[text()='Review Period Start Date']//parent::div//following-sibling::div//input");
	public static By reviewPeriodEndDate = By
			.xpath("//label[text()='Review Period End Date']//parent::div//following-sibling::div//input");
	public static By dueDate = By.xpath("//label[text()='Due Date']//parent::div//following-sibling::div//input");

	public static By saveButton = By.xpath("//button[normalize-space()='Save']");
	public static By activateButton = By.xpath("//button[normalize-space()='Activate']");
	public static By manageReviewEdit = By.xpath("//i[@class='oxd-icon bi-pencil-fill']");
	public static By manageReviewsSearchButton = By.xpath("//button[contains(text(),' Search ']");
	public static By manageReviewsDeleteButton = By.xpath("//i[@class='oxd-icon bi-trash']");
	public static By deleteCheckBox = By.xpath("(//button/following::i[@class='oxd-icon bi-trash'])[1]");
	public static By confirmDelete = By.xpath("//button[text()=' Yes, Delete ']");
	/**
	 * PerformancePage EmployeeTrackers tab Locators
	 */
	public static By employeeTrackersButton = By.xpath("//a[text()='Employee Trackers']");
	public static By employementTrackerSearchBox = By
			.xpath("//h5[text()='Employee Performance Trackers']//following::div//input");
	public static By employeeNameTracker = By
			.xpath("//label[text()='Employee Name']/parent::div//following-sibling::div//input");

	public static By performanceTab(String text) {
		return By.xpath(
				"//li[@class='oxd-topbar-body-nav-tab']//parent::ul//following::a[contains(text(),'" + text + "')]");
	}

	public static By employeeTrackersSearchButton = By.xpath("//button[text(),' Search ']");
	public static By employeeTrackersView = By.xpath(
			"//button[@class='oxd-button oxd-button--medium oxd-button--text orangehrm-left-space oxd-table-cell-action-space']");

	public static By dropDownButton = By.xpath("//div[@class='oxd-autocomplete-option']");
	public static By editButton = By.xpath("//i[@class='oxd-icon bi-pencil-fill']");

	public static By calender(String text) {
		return By.xpath("//label[@class='oxd-label oxd-input-field-required' and contains(text(),'" + text
				+ "')]//following::div[@class='oxd-date-input']");
	}
}
