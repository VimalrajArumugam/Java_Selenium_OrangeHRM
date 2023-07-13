package org.qa.orangehrm.testscripts;

import java.util.HashMap;

import org.qa.orangehrm.actions.LoginPageActions;
import org.qa.orangehrm.actions.RecruitmentPageActions;
import org.qa.orangehrm.basetest.BaseTest;
import org.qa.orangehrm.testdata.ReadExcelData;
import org.testng.annotations.Test;

public class RecruitmentTest extends BaseTest {
	RecruitmentPageActions recruitmentpageactions = new RecruitmentPageActions();
	LoginPageActions loginPageactions = new LoginPageActions();

	@Test(priority =0,description="This method is used to add the candidate and recruitment functonalities")
	public void addCandidateOne() {

		HashMap<String, String> data = ReadExcelData.getUserData("TC04");

		loginPageactions.login(data);
		recruitmentpageactions.recruitment(data);
	}

	@Test(priority =1,description="This method is used to add the second candidate" )
    public void addCandidateTwo() {

		HashMap<String, String> data = ReadExcelData.getUserData("TC05");
		recruitmentpageactions.recruitment(data);

	}
	
	
	@Test(priority =2,description="This method is used to add the third candidate" )
    public void addCandidateThree() {

		HashMap<String, String> data = ReadExcelData.getUserData("TC06");
		recruitmentpageactions.recruitment(data);

	}
}
