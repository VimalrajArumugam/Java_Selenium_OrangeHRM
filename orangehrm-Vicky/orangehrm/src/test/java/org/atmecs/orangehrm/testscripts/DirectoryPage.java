package org.atmecs.orangehrm.testscripts;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.atmecs.orangehrm.actions.AdminTabActions;
import org.atmecs.orangehrm.actions.DirectoryTabActions;
import org.atmecs.orangehrm.actions.LoginPageActions;
import org.atmecs.orangehrm.actions.PIMTabActions;
import org.atmecs.orangehrm.constants.Constants;
import org.atmecs.orangehrm.reusables.HelperClass;
import org.atmecs.orangehrm.reusables.ReadExcel;
import org.testng.annotations.Test;

public class DirectoryPage extends HelperClass {

	LoginPageActions loginPage = new LoginPageActions();
	DirectoryTabActions directoryTab = new DirectoryTabActions();
	PIMTabActions pimTab = new PIMTabActions();
	AdminTabActions adminTab = new AdminTabActions();
	List<Map<String, String>> input = getExcelData("LoginPage");
	static Logger logger = Logger.getLogger(DirectoryPage.class);
	ReadExcel read = new ReadExcel();

	@Test(priority = 1, description = "This method is to login to the website")
	public void login() {
		if (directoryTab.check() == false) {
			try {
				Map<String, String> testDataMap = read.getTestDataInMap(Constants.excelFilePath, "Login", "ORM_03");
				loginPage.validLogin(testDataMap.get("Username"), testDataMap.get("Password"));
			} catch (Exception exception) {

			}
		}else {
			logger.info("Navigated to home page");
		}
	}

	@Test(priority = 2, description = "This method is to add new employee to the existing entries")
	public void directory_EmployeeName() {
		directoryTab.clickDirectoryTab();
		directoryTab.clickOnEmployeeField();
		directoryTab.addEmployeeNameSuggestion();
		directoryTab.clickSearchButton();
		directoryTab.validateEmployeeName();
		directoryTab.clickReset();
	}

	@Test(priority = 3, description = "This method is to search employee using designation in the existing entries")
	public void directory_JobTitle() {
		directoryTab.selectJobTitle();
		directoryTab.clickSearchButton();
		directoryTab.validateJobTitle();
		directoryTab.clickReset();
	}

	@Test(priority = 4, description = "This method is to search employee using Location in the existing entries")
	public void directory_Location() {
		directoryTab.addLocation();
		directoryTab.clickSearchButton();
		directoryTab.validateLocation();
	}

}
