package org.atmecs.orangehrm.testscripts;

import java.util.Map;

import org.atmecs.orangehrm.actions.LoginPageActions;
import org.atmecs.orangehrm.constants.Constants;
import org.atmecs.orangehrm.locator.HomePageLocators;
import org.atmecs.orangehrm.reusables.HelperClass;
import org.atmecs.orangehrm.reusables.ReadExcel;
import org.testng.annotations.Test;

public class LoginPage extends HelperClass {

	LoginPageActions loginPage = new LoginPageActions();
	HomePageLocators homePage = new HomePageLocators();
	ReadExcel read = new ReadExcel();

	@Test(priority = 1, description = "This method is used to validate login functionality with invalid credentials")
	public void invalidCredentials() {
		try {
			Map<String, String> testDataMap = read.getTestDataInMap(Constants.excelFilePath, "Login", "ORM_01");
			loginPage.invalidMessage(testDataMap.get("Username"), testDataMap.get("Password"));
		} catch (Exception exception) {

		}
	}

	@Test(priority = 2, description = "This method is used to validate login functionality with empty credentials")
	public void emptyCredentials() {
		try {
			Map<String, String> testDataMap = read.getTestDataInMap(Constants.excelFilePath, "Login", "ORM_02");
			loginPage.requiredMessage(testDataMap.get("Username"), testDataMap.get("Password"));
		} catch (Exception exception) {

		}
	}

	@Test(priority = 3, description = "This method is used to validate login functionality with valid credentials")
	public void validCredentials() {
		try {
			Map<String, String> testDataMap = read.getTestDataInMap(Constants.excelFilePath, "Login", "ORM_03");
			loginPage.validLogin(testDataMap.get("Username"), testDataMap.get("Password"));
		} catch (Exception exception) {

		}
	}

}
