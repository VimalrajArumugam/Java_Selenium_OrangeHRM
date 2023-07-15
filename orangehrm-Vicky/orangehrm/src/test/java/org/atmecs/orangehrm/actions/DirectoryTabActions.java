package org.atmecs.orangehrm.actions;

import java.util.List;

import org.apache.log4j.Logger;
import org.atmecs.orangehrm.constants.Constants;
import org.atmecs.orangehrm.locator.DirectoryPageLocators;
import org.atmecs.orangehrm.locator.HomePageLocators;
import org.atmecs.orangehrm.reusables.HelperClass;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * This class helps to validate the details of the employee by searching
 * different criteria
 * 
 * @author Kalarani.Prasanth
 *
 */
public class DirectoryTabActions extends HelperClass {
	static Logger logger = Logger.getLogger(DirectoryTabActions.class);

	String expectedEmployee = null;
	String expectedLocation = null;
	String expectedJobTitle = null;

	/**
	 * This method is used to enter into the Directory Tab
	 */
	public void clickDirectoryTab() {
		try {
			waitForElementPresence(HomePageLocators.directoryTab);
			clickButton(findWebElement(HomePageLocators.directoryTab));
			logger.info("Directory Tab is clicked in homepage");
		} catch (Exception e) {
			logger.info("Cannot click on Directory tab");
		}
	}

	/**
	 * This method is to check whether the site is navigated to homepage
	 * 
	 * @return
	 */
	public boolean check() {
		return findWebElement(HomePageLocators.homePageImage).isDisplayed();
	}

	/**
	 * This method is used to click on employee name field
	 */
	public void clickOnEmployeeField() {
		try {
			waitForElementPresence(DirectoryPageLocators.employeeNameField);
			clickButton(findWebElement(DirectoryPageLocators.employeeNameField));
			logger.info("Employee field is clicked on Directory tab");
		} catch (Exception e) {
			logger.error("Cannot click on Employee field");
		}
	}

	/**
	 * This method is used to add employee name in its the text field
	 */
	public void addEmployeeNameSuggestion() {
		try {
			virtualKey.keyPress(Constants.employeeNameSuggestion);
			waitCondition();
			pressDownKey();
			waitForElementVisibility(DirectoryPageLocators.employeeNamesSuggestion);
			expectedEmployee = getObjectText(findWebElement(DirectoryPageLocators.employeeNamesSuggestion));
			clickButton(findWebElement(DirectoryPageLocators.employeeNamesSuggestion));
		} catch (Exception exception) {
			logger.error("Cannot add suggestion to the employee field");
		}
	}

	/**
	 * This method is used to click search Button
	 */
	public void clickSearchButton() {
		try {
			clickButton(findWebElement(DirectoryPageLocators.searchButton));
			logger.info("Clicked search button");
			waitCondition();
		} catch (Exception e) {
			logger.info("Cannot click search button");
		}
	}

	/**
	 * This method is used to validate the employee names in the entire list of
	 * employees
	 */
	public void validateEmployeeName() {
		try {
			String actualEmployee = getObjectText(findWebElement(DirectoryPageLocators.actualEmployeeDetail));
			Assert.assertEquals(actualEmployee, expectedEmployee);
			logger.info("Expected Employee name: '" + expectedEmployee + "' matches with the "
					+ " Actual Employee name: '" + actualEmployee + "'");
		} catch (Exception e) {
			logger.error("Actual and Expected employee name didn't match");
		}
	}

	/**
	 * This method is used to click on reset button
	 */
	public void clickReset() {
		try {
			waitCondition();
			clickButton(findWebElement(DirectoryPageLocators.resetButton));
			logger.info("Clicked Reset button");
		} catch (Exception e) {
			logger.error("Cannot click on Reset button");
		}
	}

	/**
	 * This method is used to select Job Title from the dropdown
	 */
	public void selectJobTitle() {
		try {
			RefreshBrowser();
			waitForElementPresence(DirectoryPageLocators.jobTitleField);
			clickButton(findWebElement(DirectoryPageLocators.jobTitleField));
			mouseHoverAndClick(findWebElement(DirectoryPageLocators.jobsSuggestion));
			expectedJobTitle = findWebElement(DirectoryPageLocators.jobTitleField).getText();
			logger.info("Job Title is selected in field");
			waitCondition();
		} catch (Exception e) {
			logger.error("Cannot select Job Title");
		}
	}

	/**
	 * This method is used to validate the Job selected in the entire list of
	 * employees
	 */
	public void validateJobTitle() {
		String actualJobTitle = null;
		String container = findWebElement(DirectoryPageLocators.recordsHeader).getText().trim();
		if (container.equals(Constants.containerHeader)) {
			getSuccessMessage();
		} else {
			List<WebElement> jobs = findWebElements(DirectoryPageLocators.actualJobTitle);
			waitCondition();
			for (int index = 0; index < jobs.size(); index++) {
				actualJobTitle = jobs.get(index).getText();
				if (actualJobTitle.equals(expectedJobTitle)) {
					do {
						Assert.assertEquals(actualJobTitle, expectedJobTitle);
						logger.info("Expected Job : '" + expectedJobTitle + "' matches with the " + " Actual Job : '"
								+ actualJobTitle + "'");
					} while (index == jobs.size());
				} else {
					logger.info("Job Title Doesn't match");
				}
			}
		}
	}

	/**
	 * This method is used to select location from the dropdown list
	 */
	public void addLocation() {
		try {
			waitForElementPresence(DirectoryPageLocators.locationField);
			clickButton(findWebElement(DirectoryPageLocators.locationField));
			mouseHoverAndClick(findWebElement(DirectoryPageLocators.locationsSuggestion));
			logger.info("Location is selected in the Directory Tab");
			waitCondition();
		} catch (Exception e) {
			logger.info("Location cannot be selected in the Directory Tab");
		}
	}

	/**
	 * This method is used to validate the location selected in the entire list of
	 * employees
	 */
	public void validateLocation() {
		String actualLocation = null;
		expectedLocation = findWebElement(DirectoryPageLocators.locationField).getText();
		List<WebElement> location = findWebElements(DirectoryPageLocators.actualLocation);
		for (int index = 0; index < location.size(); index++) {
			waitCondition();
			actualLocation = location.get(index).getText();
			if (actualLocation.equals(expectedLocation)) {
				do {

					Assert.assertEquals(actualLocation, expectedLocation);
					logger.info("Expected Location : '" + expectedLocation + "' matches with the "
							+ " Actual Location : '" + actualLocation + "'");
				} while (index == location.size());
			}
			else {
				logger.info("Location Doesn't match");
			}
		}
		waitCondition();
	}

	/**
	 * This method is used to get the success message
	 */
	public void getSuccessMessage() {
		waitForElementVisibility(DirectoryPageLocators.messageHeader);
		String headerMessage = getObjectText(findWebElement(DirectoryPageLocators.messageHeader));
		logger.info(headerMessage);
		waitForElementVisibility(DirectoryPageLocators.successMessage);
		String message = getObjectText(findWebElement(DirectoryPageLocators.successMessage));
		logger.info(message);
	}
}
