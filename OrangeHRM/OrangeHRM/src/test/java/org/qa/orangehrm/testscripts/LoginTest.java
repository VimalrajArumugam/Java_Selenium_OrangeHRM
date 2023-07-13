package org.qa.orangehrm.testscripts;

import java.util.HashMap;

import org.qa.orangehrm.actions.LoginPageActions;
import org.qa.orangehrm.basetest.BaseTest;
import org.qa.orangehrm.testdata.ReadExcelData;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class LoginTest extends BaseTest {
	static Logger logger = Logger.getLogger(LoginTest.class);

	LoginPageActions loginPageActions = new LoginPageActions();
	@Test(description = "This method is used to validate login functionality with invalid credentials")

	public void validCredentials() {
		try {
			HashMap<String, String> data = ReadExcelData.getUserData("TC01");
			loginPageActions.login(data);
			loginPageActions.logOut(data);
			logger.info("Successfully login");
		} catch (Exception exception) {
			logger.error("Unsuccessfully login" + exception);
		}
	}

	@Test(priority = 1, description = "This method is used to validate login functionality with invalid credentials")
	public void inValidCredentials() {
		try {
			HashMap<String, String> data = ReadExcelData.getUserData("TC02");
			loginPageActions.login(data);
			logger.info("UnSuccessfully Login");
		} catch (Exception exception) {
			logger.error("Error occurs" + exception);
		}
	}

	@Test(priority = 2, description = "This method is used to validate login functionality with invalid credentials")


	public void invalidCredentials() {
		try {
			HashMap<String, String> data = ReadExcelData.getUserData("TC03");
			loginPageActions.login(data);
			logger.info("UnSuccessfully login");
		} catch (Exception exception) {
			logger.error("Error occurs" + exception);
		}
	}

}
