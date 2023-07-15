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

public class PIMPage extends HelperClass {

	LoginPageActions loginPage = new LoginPageActions();
	DirectoryTabActions directoryTab = new DirectoryTabActions();
	PIMTabActions pimTab = new PIMTabActions();
	AdminTabActions adminTab = new AdminTabActions();
	List<Map<String, String>> input = getExcelData("LoginPage");
	ReadExcel read = new ReadExcel();
	static Logger logger = Logger.getLogger(PIMPage.class);

	@Test(priority = 1, description = "This method is to login to the website")
	public void login() {
		if (pimTab.homePageCheck() == false) {
			try {
				Map<String, String> testDataMap = read.getTestDataInMap(Constants.excelFilePath, "Login", "ORM_03");
				loginPage.validLogin(testDataMap.get("Username"), testDataMap.get("Password"));
			} catch (Exception exception) {

			}
		}else {
			logger.info("Navigated to home page");
		}
	}

	@Test(priority = 2, description = "This method is used to add a new employee in pim")
	public void addEmployee_PIM() {
		pimTab.clickPimTab();
		pimTab.addEmployee();
	}

	@Test(priority = 3, description = "This method is used to verify whether the added employee is displayed")
	public void verifyEmployee_PIM() {
		pimTab.verifyEmployeeDetails();
	}

}
