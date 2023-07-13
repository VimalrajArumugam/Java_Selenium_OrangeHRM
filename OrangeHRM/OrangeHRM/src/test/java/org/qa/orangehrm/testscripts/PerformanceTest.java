package org.qa.orangehrm.testscripts;

import java.util.HashMap;

import org.qa.orangehrm.actions.LoginPageActions;
import org.qa.orangehrm.actions.PerformancePageActions;
import org.qa.orangehrm.basetest.BaseTest;
import org.qa.orangehrm.testdata.ReadExcelData;
import org.testng.annotations.Test;

public class PerformanceTest extends BaseTest {
	LoginPageActions loginPage = new LoginPageActions();
	PerformancePageActions performancePage = new PerformancePageActions();

	@Test(description = "This method is used to perform actions in performance tab")

	public void performanceTab() {
		HashMap<String, String> data = ReadExcelData.getUserData("TC03");
		loginPage.login(data);
		performancePage.manageReviewsFunctionlity(data);

	}

}