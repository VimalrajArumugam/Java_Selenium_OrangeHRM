package org.atmecs.orangehrm.actions;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.atmecs.orangehrm.constants.Constants;
import org.atmecs.orangehrm.locator.LoginPageLocators;
import org.atmecs.orangehrm.reusables.HelperClass;
import org.atmecs.orangehrm.reusables.ReadExcel;
import org.testng.Assert;

/**
 * This class is to validate the Login Page with different username and password
 * 
 * @author Kalarani.Prasanth
 *
 */
public class LoginPageActions extends HelperClass {
	static Logger logger = Logger.getLogger(LoginPageActions.class);
	List<Map<String, String>> input = getExcelData("LoginPage");
	ReadExcel read = new ReadExcel();

	/**
	 * This method passes valid credentails to the login page and check whether the
	 * login is successful
	 */
	public void validLogin(String username, String password) {
		try {
			Map<String, String> testDataMap = read.getTestDataInMap(Constants.excelFilePath, Constants.Login_Sheet,
					"ORM_03");
			RefreshBrowser();
			waitForElementPresence(LoginPageLocators.username);
			writeText(findWebElement(LoginPageLocators.username), username);
			clearAndWriteText(findWebElement(LoginPageLocators.password), password);
			clickButton(findWebElement(LoginPageLocators.loginButton));
			waitCondition();
			String pageTitle = getPageTitle();
			Assert.assertEquals(pageTitle, testDataMap.get("Page Title"));
			logger.info("Successful Login");
			logger.info("Page Title : " + pageTitle);
		} catch (Exception exception) {
			logger.error("Login Functionality could not be handled");
		}
	}

	/**
	 * This method passes invalid credentails to the login page and check whether
	 * the login is successful
	 */
	public void invalidMessage(String username, String password) {
		try {
			Map<String, String> testDataMap = read.getTestDataInMap(Constants.excelFilePath, Constants.Login_Sheet,
					"ORM_01");
			RefreshBrowser();
			waitForElementPresence(LoginPageLocators.username);
			clearAndWriteText(findWebElement(LoginPageLocators.username), username);
			clearAndWriteText(findWebElement(LoginPageLocators.password), password);
			waitCondition();
			clickButton(findWebElement(LoginPageLocators.loginButton));
			waitCondition();
			String acutalError = getObjectText(findWebElement(LoginPageLocators.invalidCredentials));
			Assert.assertEquals(acutalError, testDataMap.get("Error Message"));
			logger.info("Error Message :" + acutalError);
		} catch (Exception exception) {
			logger.error("Login Functionality could not be handled");
		}
	}

	/**
	 * This method passes empty credentails to the login page and check whether the
	 * login is successful
	 */
	public void requiredMessage(String username, String password) {
		try {
			Map<String, String> testDataMap = read.getTestDataInMap(Constants.excelFilePath, Constants.Login_Sheet,
					"ORM_02");
			RefreshBrowser();
			waitForElementPresence(LoginPageLocators.username);
			clearAndWriteText(findWebElement(LoginPageLocators.username), username);
			clearAndWriteText(findWebElement(LoginPageLocators.password), password);
			waitCondition();
			clickButton(findWebElement(LoginPageLocators.loginButton));
			waitForElementPresence(LoginPageLocators.required);
			String acutalError = getObjectText(findWebElement(LoginPageLocators.required));
			Assert.assertEquals(acutalError, testDataMap.get("Error Message"));
			logger.info("Error Message :" + acutalError);
		} catch (Exception exception) {
			logger.error("Login Functionality could not be handled");
		}
	}
}
