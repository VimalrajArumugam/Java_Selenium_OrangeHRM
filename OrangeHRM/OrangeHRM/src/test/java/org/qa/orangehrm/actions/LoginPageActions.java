package org.qa.orangehrm.actions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.qa.orangehrm.pages.LoginPage;
import org.qa.orangehrm.utilities.GeneralMethods;

public class LoginPageActions extends GeneralMethods {
	static Logger logger = Logger.getLogger(LoginPageActions.class);

	/**
	 * This method is to login functionality
	 */

	public void login(Map<String, String> data) {
		try {
			enterText(LoginPage.userName, data.get("username"));
			enterText(LoginPage.passWord, data.get("password"));
			click(LoginPage.logInButton);
			String actResult = driver.getCurrentUrl();
			String expResult = data.get("LoginValidation");
			if (expResult.equals(actResult)) {
				logger.info("Login successful");

			} else {
				actResult = getText(LoginPage.invalidCredentials);
				if (expResult.equals(actResult)) {
					logger.error("Login is not Successful");
				}
			}

		} catch (Exception exception) {
			logger.error("Unable to login" + exception);
		}
	}

	/**
	 * This method is to logout functionality
	 */

	public void logOut(Map<String, String> data) {
		try {
			String actResult = driver.getCurrentUrl();
			String expResult = data.get("LoginValidation");
			if (expResult.equals(actResult)) {
				click(LoginPage.profileClick);
				click(LoginPage.logOutButton);
			}
		} catch (Exception exception) {
			logger.error("Unable to logout" + exception);
		}
	}

}
