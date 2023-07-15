package org.atmecs.orangehrm.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.atmecs.orangehrm.constants.Constants;
import org.atmecs.orangehrm.locator.HomePageLocators;
import org.atmecs.orangehrm.locator.PIMPageLocators;
import org.atmecs.orangehrm.reusables.HelperClass;
import org.openqa.selenium.WebElement;

/**
 * This class is used to add the new employee and check whether the added
 * employee details are shown in entries
 * 
 * @author Kalarani.Prasanth
 *
 */
public class PIMTabActions extends HelperClass {
	static Logger logger = Logger.getLogger(PIMTabActions.class);
	List<Map<String, String>> input = getExcelData(Constants.PIM_Sheet);

	/**
	 * This method is used to click the PIM tab in the homepage
	 */
	public void clickPimTab() {
		try {
			waitForElementPresence(HomePageLocators.pimTab);
			clickButton(findWebElement(HomePageLocators.pimTab));
			logger.info("Clicked PIM Tab");
		} catch (Exception e) {
			logger.error("Could not click PIM tab");
		}
	}

	/**
	 * This method is used to click add button in PIM Tab
	 */
	public void clickAddButton() {
		try {
			waitCondition();
			clickButton(findWebElement(PIMPageLocators.addButton));
			logger.info("Clicked Add Button in PIM Tab");
		} catch (Exception e) {
			logger.error("Add Button in PIM Tab cannot be clicked");
		}
	}

	/**
	 * This method is to check whether the site is navigated to homepage
	 * 
	 * @return
	 */
	public boolean homePageCheck() {
		return findWebElement(HomePageLocators.homePageImage).isEnabled();
	}

	/**
	 * This method is used to click save button
	 */
	public void clickSaveButton() {
		try {
			waitCondition();
			clickButton(findWebElement(PIMPageLocators.saveButton));
			logger.info("Clicked Save Button in PIM Tab");
		} catch (Exception e) {
			logger.error("Save Button in PIM Tab cannot be clicked");
		}
	}

	/**
	 * This method is used to add new employee name in the entries
	 */
	public void addEmployee() {
		try {
			waitCondition();
			for (int index = 0; index < input.size(); index++) {
				clickAddButton();
				waitForElementPresence(PIMPageLocators.firstName);
				writeText(findWebElement(PIMPageLocators.firstName), input.get(index).get("FirstName"));
				waitCondition();
				writeText(findWebElement(PIMPageLocators.middleName), input.get(index).get("MiddleName"));
				waitCondition();
				writeText(findWebElement(PIMPageLocators.lastName), input.get(index).get("LastName"));
				clickSaveButton();
				getSuccessMessage();
				waitCondition();
				clickButton(findWebElement(PIMPageLocators.employeeTab));
				waitCondition();
			}
			logger.info("Employee Detail is successfully added");
		} catch (Exception exception) {
			logger.info("Employee detail is not added");
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
	 * This method is used to get message when the text field is empty
	 */
	public void getRequiredMessage() {
		waitForElementVisibility(PIMPageLocators.requiredMessage);
		String requiredMessage = getObjectText(findWebElement(PIMPageLocators.requiredMessage));
		logger.info(requiredMessage);
	}

	/**
	 * This method is used to validate whether the added employee is visible in the
	 * entries
	 */
	public void verifyEmployeeDetails() {
		List<String> employees = new ArrayList<>();
		waitCondition();
		boolean check = false;
		List<WebElement> employeeEntries = findWebElements(PIMPageLocators.entireEmployeeDetails);
		for (WebElement employeeDetail : employeeEntries) {
			String text = employeeDetail.getText().toString();
			employees.add(text);
		}
		try {
			for (int index = 0; index < input.size(); index++) {
				String firstName = input.get(index).get("FirstName");
				String MiddleName = input.get(index).get("MiddleName");
				String employeeName = firstName + " " + MiddleName;
				boolean contains = employees.contains(employeeName);
				check = contains;
			}
			if (check == false) {
				logger.info("Employee Names are not found in the Entries");
			} else {
				logger.info("Employee Names are found in the Entries");
			}
		} catch (Exception exception) {
			logger.info("Employee Names are not found in the Entries");
		}
	}

}
