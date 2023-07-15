package org.atmecs.orangehrm.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.atmecs.orangehrm.constants.Constants;
import org.atmecs.orangehrm.locator.AdminPageLocators;
import org.atmecs.orangehrm.locator.HomePageLocators;
import org.atmecs.orangehrm.locator.LoginPageLocators;
import org.atmecs.orangehrm.locator.PIMPageLocators;
import org.atmecs.orangehrm.reusables.HelperClass;
import org.atmecs.orangehrm.reusables.ReadExcel;
import org.openqa.selenium.WebElement;

public class AdminTabActions extends HelperClass {
	static Logger logger = Logger.getLogger(AdminTabActions.class);
	ReadExcel read = new ReadExcel();

	/**
	 * This method is used to click the Admin tab in the homepage
	 */
	public void clickAdminTab() {
		try {
			waitForElementPresence(HomePageLocators.adminTab);
			clickButton(findWebElement(HomePageLocators.adminTab));
			logger.info("Admin Tab is clicked");
		} catch (Exception e) {
			logger.error("Clicking Admin tab is not performed");
		}
	}

	/**
	 * This method is to check whether the site is navigated to homepage
	 * 
	 * @return
	 */
	public boolean homepagecheck() {
		return findWebElement(HomePageLocators.homePageImage).isEnabled();
	}
	
	/**
	 * This method is to check whether the site is navigated to homepage
	 * 
	 * @return
	 */
	public boolean loginpagecheck() {
		return findWebElement(LoginPageLocators.loginPageimage).isEnabled();
	}

	/**
	 * This method is used to search users in usermanagement tab
	 */
	public void searchUserAdminTab() {
		try {
			Map<String, String> testDataMap = read.getTestDataInMap(Constants.excelFilePath, Constants.admin_Sheet,
					"ORM_01");
			List<String> detail = new ArrayList<String>();
			boolean contains = false;
			waitCondition();
			writeText(findWebElement(AdminPageLocators.name), testDataMap.get("Name"));
			waitCondition();
			clickButton(findWebElement(AdminPageLocators.searchButton));
			waitCondition();
			String container = findWebElement(AdminPageLocators.recordsHeader).getText().trim();
			if (container.equals(Constants.containerHeader)) {
				getSuccessMessage();
			} else {
				List<WebElement> employeeEntries = findWebElements((AdminPageLocators.entireEmployeeDetails));
				for (WebElement employeeDetail : employeeEntries) {
					String text = employeeDetail.getText().toString();
					detail.add(text);
				}
			}

			for (int index = 0; index < detail.size(); index++) {
				contains = detail.contains(testDataMap.get("Name"));
			}
			if (contains == true) {
				logger.info("Admin Tab : '" + testDataMap.get("Name") + "' Employee name found in search criteria");
			} else {
				logger.info("Admin Tab : '" + testDataMap.get("Name") + "' Employee name not found in search criteria");
			}
			clickButton(findWebElement(AdminPageLocators.resetButton));
		} catch (Exception e) {
			logger.error("User name is not found");
		}
	}

	/**
	 * This method is used to get the success message
	 */
	public void getSuccessMessage() {
		waitForElementVisibility(PIMPageLocators.messageHeader);
		String headerMessage = getObjectText(findWebElement(PIMPageLocators.messageHeader));
		logger.info(headerMessage);
		waitForElementVisibility(PIMPageLocators.successMessage);
		String message = getObjectText(findWebElement(PIMPageLocators.successMessage));
		logger.info(message);
	}

	/**
	 * This method is used to delete the user entry by delete icon
	 * 
	 */
	public void deleteUserByIcon() {
		try {
			waitForElementPresence(AdminPageLocators.userCheckBox);
			clickButton(findWebElement(AdminPageLocators.userCheckBox));
			logger.info("User is selected in the found entries of Admin Tab");
			waitCondition();
			clickButton(findWebElement(AdminPageLocators.deleteIcon));
			logger.info("Delete icon is clicked in Admin_User Tab entries");
			clickButton(findWebElement(AdminPageLocators.deletePopUp));
			getSuccessMessage();
			logger.info("Selected User is deleted by delete icon");
		} catch (Exception exception) {
			logger.error("User entry is not deleted by icon");
		}
	}

	/**
	 * This method is used to delete the user entry by delete checkbox
	 * 
	 */
	public void deleteUserByCheckBox() {
		try {
			waitForElementPresence(AdminPageLocators.deleteCheckBox);
			clickButton(findWebElement(AdminPageLocators.deleteCheckBox));
			waitCondition();
			logger.info("User entry is selected for deletion");
			clickButton(findWebElement(AdminPageLocators.deletePopUp));
			getSuccessMessage();
			logger.info("User entry is deleted by checkBox");
		} catch (Exception e) {
			logger.error("User entry cannot be deleted by checkbox");
		}
	}

	/**
	 * This method is used to add employment status in admin tab
	 * 
	 */
	public void addEmploymentStatus() {
		List<Map<String, String>> adminData = getExcelData(Constants.admin_Job_Sheet);
		try {
			waitForElementVisibility(AdminPageLocators.jobTab);
			clickButton(findWebElement(AdminPageLocators.jobTab));
			waitCondition();
			clickButton(findWebElement(AdminPageLocators.employmentStatusTab));
			waitCondition();
			String recordsBeforeAddition = findWebElement(AdminPageLocators.recordsHeader).getText().trim();
			for (int index = 0; index < adminData.size(); index++) {
				waitForElementPresence((AdminPageLocators.addButton));
				clickButton(findWebElement(AdminPageLocators.addButton));
				waitCondition();
				writeText(findWebElement(AdminPageLocators.name), adminData.get(index).get("Employment Status"));
				String message = findWebElement(AdminPageLocators.exist).getText();
				System.out.println(message);
				waitCondition();
				if (message.equals(Constants.existsMessage)) {
					clickButton(findWebElement(AdminPageLocators.cancelButton));
				} else {
					waitCondition();
					clickButton(findWebElement(AdminPageLocators.saveButton));
					getSuccessMessage();
				}
			}
			waitCondition();
			String recordsAfterAddition = findWebElement(AdminPageLocators.recordsHeader).getText().trim();
			if (recordsBeforeAddition.equals(recordsAfterAddition)) {
				logger.info("Employment status is not added in Entry");
			} else {
				logger.info("Employment status added in Entry");
			}
		} catch (Exception exception) {
			logger.error("Employement status cannot be added to the field");
		}
	}

	/**
	 * This method is used to edit employment status in admin tab
	 * 
	 */
	public void editEmployeeStatus() {
		try {
			Map<String, String> testDataMap = read.getTestDataInMap(Constants.excelFilePath, Constants.admin_Sheet,
					"ORM_02");
			waitForElementVisibility(AdminPageLocators.jobTab);
			clickButton(findWebElement(AdminPageLocators.jobTab));
			clickButton(findWebElement(AdminPageLocators.employmentStatusTab));
			waitForElementPresence(AdminPageLocators.editButton);
			waitCondition();
			String editText = getObjectText(findWebElement(AdminPageLocators.editElementText));
			clickButton(findWebElement(AdminPageLocators.editButton));
			waitCondition();
			clickButton(findWebElement(AdminPageLocators.name));
			for (int index = 0; index < editText.length(); index++) {
				waittoDelete();
				pressBackSpace();
			}
			writeText(findWebElement(AdminPageLocators.name), testDataMap.get("Employment Status"));
			clickButton(findWebElement(AdminPageLocators.saveButton));
			getSuccessMessage();
			logger.info(editText + "is edited into " + testDataMap.get("Employment Status"));
		} catch (Exception exception) {
			logger.error("Employee status cannot be edited");
		}
	}

	/**
	 * This method is used to delete employment status in admin tab
	 * 
	 */
	public void deleteEmployeeStatus() {
		try {
			waitForElementVisibility(AdminPageLocators.jobTab);
			clickButton(findWebElement(AdminPageLocators.jobTab));
			clickButton(findWebElement(AdminPageLocators.employmentStatusTab));
			waitForElementPresence(AdminPageLocators.deleteCheckBox);
			clickButton(findWebElement(AdminPageLocators.deleteCheckBox));
			waitCondition();
			clickButton(findWebElement(AdminPageLocators.deletePopUp));
			getSuccessMessage();
			logger.info("Employment status is deleted");
		} catch (Exception exception) {
			logger.error("Employment status is not deleted");
		}
	}

	/**
	 * This method is used to add workshift in admin tab
	 * 
	 */
	public void addWorkShifts() {
		try {
			Map<String, String> testDataMap = read.getTestDataInMap(Constants.excelFilePath, Constants.admin_Sheet,
					"ORM_03");
			waitForElementVisibility(AdminPageLocators.jobTab);
			clickButton(findWebElement(AdminPageLocators.jobTab));
			logger.info("Job tab is clicked on Admin tab ");
			clickButton(findWebElement(AdminPageLocators.workShiftTab));
			logger.info("Workshift dropdown is clicked on Job tab");
			waitCondition();
			String recordsBeforeAddition = findWebElement(AdminPageLocators.recordsHeader).getText().trim();
			waitForElementPresence(AdminPageLocators.addButton);
			clickButton(findWebElement(AdminPageLocators.addButton));
			logger.info("Add Button is clicked on Job tab");
			waitForElementPresence(AdminPageLocators.name);
			writeText(findWebElement(AdminPageLocators.name), testDataMap.get("Shift Name"));
			logger.info("Shift name is entered in the field");
			waitCondition();
			clickButton(findWebElement(AdminPageLocators.workingShiftFrom));
			waitCondition();
			clickButton(findWebElement(AdminPageLocators.inHoursArrow));
			clickButton(findWebElement(AdminPageLocators.inTimeAM));
			waitCondition();
			clickButton(findWebElement(AdminPageLocators.workingShiftTo));
			waitCondition();
			clickButton(findWebElement(AdminPageLocators.outHoursArrow));
			clickButton(findWebElement(AdminPageLocators.outTimePM));
			waitCondition();
			clickButton(findWebElement(AdminPageLocators.saveButton));
			getSuccessMessage();
			waitCondition();
			String recordsAfterAddition = findWebElement(AdminPageLocators.recordsHeader).getText().trim();
			if (recordsBeforeAddition.equals(recordsAfterAddition)) {
				logger.info("Work Shift is not added in Entry");
			} else {
				logger.info("Work Shift is added in Entry");
			}
		} catch (Exception exception) {
			logger.error("Workshift cannot be added to the Admin Job Tab");
		}
	}

	/**
	 * This method is used to delete workshift in admin tab
	 * 
	 */
	public void deleteWorkShifts() {
		try {
			waitForElementVisibility(AdminPageLocators.jobTab);
			clickButton(findWebElement(AdminPageLocators.jobTab));
			logger.info("Job tab is clicked on Admin tab");
			clickButton(findWebElement(AdminPageLocators.workShiftTab));
			logger.info("Workshift dropdown is clicked on Job tab ");
			waitForElementPresence((AdminPageLocators.deleteCheckBox));
			clickButton(findWebElement(AdminPageLocators.deleteCheckBox));
			waitCondition();
			clickButton(findWebElement(AdminPageLocators.deletePopUp));
			getSuccessMessage();
			logger.info("Work Shift deleted from Entry");
		} catch (Exception exception) {
			logger.error("Work shifts are not added to the entry");
		}
	}

	/**
	 * This method is used to add location in admin tab
	 * 
	 */
	public void addLocation() {
		try {
			List<Map<String, String>> adminData = getExcelData(Constants.admin_Organization);
			waitForElementPresence(AdminPageLocators.organizationTab);
			clickButton(findWebElement(AdminPageLocators.organizationTab));
			clickButton(findWebElement(AdminPageLocators.locationTab));
			waitCondition();
			String recordsBeforeAddition = findWebElement(AdminPageLocators.recordsHeader).getText().trim();
			for (int index = 0; index < adminData.size(); index++) {
				waitCondition();
				clickButton(findWebElement(AdminPageLocators.addButton));
				waitCondition();
				waitForElementPresence(AdminPageLocators.name);
				writeText(findWebElement(AdminPageLocators.name), adminData.get(index).get("Name"));
				waitCondition();
				writeText(findWebElement(AdminPageLocators.city), adminData.get(index).get("City"));
				waitCondition();
				writeText(findWebElement(AdminPageLocators.state), adminData.get(index).get("State"));
				waitCondition();
				clickButton(findWebElement(AdminPageLocators.addCountry));
				clickButton(findWebElement(AdminPageLocators.addCountryName));
				waitCondition();
				clickButton(findWebElement(AdminPageLocators.saveButton));
				getSuccessMessage();
			}
			waitCondition();
			String recordsAfterAddition = findWebElement(AdminPageLocators.recordsHeader).getText().trim();
			if (recordsBeforeAddition.equals(recordsAfterAddition)) {
				logger.info("Location is not added in Entry");
			} else {
				logger.info("Location is added in Entry");
			}
		} catch (Exception exception) {
			logger.error("Location cannot be added");
		}
	}

	/**
	 * This method is used to search in admin tab
	 * 
	 */
	public void searchLocation() {
		List<String> detail = new ArrayList<String>();
		List<Map<String, String>> adminData = getExcelData(Constants.admin_Organization);
		boolean contains = false;
		try {
			waitForElementPresence(AdminPageLocators.organizationTab);
			clickButton(findWebElement(AdminPageLocators.organizationTab));
			clickButton(findWebElement(AdminPageLocators.locationTab));
			waitCondition();
			String container = findWebElement(AdminPageLocators.recordsHeader).getText().trim();
			waitCondition();
			clickButton(findWebElement(AdminPageLocators.searchcountry));
			clickButton(findWebElement(AdminPageLocators.searchCountryName));
			waitCondition();
			clickButton(findWebElement(AdminPageLocators.searchButton));
			waitCondition();
			if (container.equals(Constants.containerHeader)) {
				getSuccessMessage();
			} else {
				List<WebElement> employeeEntries = findWebElements((AdminPageLocators.entireEmployeeDetails));

				for (WebElement employeeDetail : employeeEntries) {
					String text = employeeDetail.getText().toString();
					detail.add(text);
				}
				for (int index = 0; index < detail.size(); index++) {
					contains = detail.contains(adminData.get(2).get("Country"));
				}
			}
			if (contains == true) {
				logger.info("Country found in search criteria");
			} else {
				logger.info("Country not found in search criteria");
			}
		} catch (Exception exception) {
			logger.error("Location cannot be searched");
		}

	}
}
