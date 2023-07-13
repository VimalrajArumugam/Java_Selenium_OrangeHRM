package org.qa.orangehrm.testscripts;

import java.util.HashMap;

import org.qa.orangehrm.actions.LoginPageActions;
import org.qa.orangehrm.actions.RecruitmentPageActions;
import org.qa.orangehrm.basetest.BaseTest;
import org.qa.orangehrm.testdata.ReadExcelData;
import org.testng.annotations.Test;

public class VacancyTest extends BaseTest {

	RecruitmentPageActions 	recruitmentPageActions = new RecruitmentPageActions();
	LoginPageActions loginPageActions = new LoginPageActions();

	@Test(priority = 0, description = "This method is used to add the vacancy")
	public void addVacancy() {

		HashMap<String, String> data = ReadExcelData.getUserData("TC04");

		loginPageActions.login(data);
		recruitmentPageActions.vacancy(data);

	}

	@Test(priority = 1, description = "This method is used to add the vacancy")
	public void addVacancyOne() {

		HashMap<String, String> data = ReadExcelData.getUserData("TC05");
		recruitmentPageActions.vacancy(data);

	}

	@Test(priority = 2, description = "This method is used to add the vacancy")
	public void addVacancyTwo(String testID) {

		HashMap<String, String> data = ReadExcelData.getUserData("TC06");

		recruitmentPageActions.vacancy(data);

	}

}
