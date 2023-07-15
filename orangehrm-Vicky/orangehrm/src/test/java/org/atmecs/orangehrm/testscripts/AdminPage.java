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

public class AdminPage extends HelperClass {

	LoginPageActions loginPage = new LoginPageActions();
	DirectoryTabActions directoryTab = new DirectoryTabActions();
	PIMTabActions pimTab = new PIMTabActions();
	AdminTabActions adminTab = new AdminTabActions();
	List<Map<String, String>> input = getExcelData("LoginPage");
	ReadExcel read = new ReadExcel();
	static Logger logger = Logger.getLogger(AdminPage.class);

	@Test(priority = 1, description = "This method is to login to the website")
	public void login() {
		if (adminTab.homepagecheck() == false) {
			try {
				Map<String, String> testDataMap = read.getTestDataInMap(Constants.excelFilePath, "Login", "ORM_03");
				loginPage.validLogin(testDataMap.get("Username"), testDataMap.get("Password"));
			} catch (Exception exception) {

			}
		}
		else {
			logger.info("Navigated to home page");
		}
	}

	@Test(priority = 2, description = "This method is used to search the user in the entries")
	public void searchUser_Admin_User() {
		adminTab.clickAdminTab();
		adminTab.searchUserAdminTab();
	}

	@Test(priority = 3, description = "This method is used to delete the user in the entries")
	public void deleteUser_Admin_User() {
		adminTab.deleteUserByIcon();
		adminTab.deleteUserByCheckBox();
	}

	@Test(priority = 4, description = "This method is used to add employment status in the field")
	public void addStatus_Admin_Job() {
		adminTab.addEmploymentStatus();

	}

	@Test(priority = 5, description = "This method is used to edit the employment status in the entries")
	public void editStatus_Admin_Job() {

		adminTab.editEmployeeStatus();
	}

	@Test(priority = 6, description = "This method is used to delete the employment status in the entries")
	public void deleteStatus_Admin_Job() {
		adminTab.deleteEmployeeStatus();

	}

	@Test(priority = 7, description = "This method is used to add new work shift in the entries")
	public void addShift_Admin_Job() {
		adminTab.addWorkShifts();
	}

	@Test(priority = 8, description = "This method is used to delete the work shift in the entries")
	public void deleteShift_Admin_Job() {
		adminTab.deleteWorkShifts();
	}

	@Test(priority = 9, description = "This method is used to add new location to the entries")
	public void addLocation_Admin_Location() {
		adminTab.addLocation();
	}

	@Test(priority = 10, description = "This method is used to search the location in the entries")
	public void searchLocation_Admin_Location() {
		adminTab.searchLocation();
	}

}
