package com.reskill.reusables;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.reskill.actionutility.ScrollByUtility;
import com.reskill.actionutility.TestDataRowSize;
import com.reskill.actionutility.CheckWebElement;
import com.reskill.pages.RegistrationPageLocators;

public class RegistrationPage { 
	TestDataRowSize testDataRS = new TestDataRowSize();
	RegistrationPageLocators locator = new RegistrationPageLocators();
	CheckWebElement sendkeys = new CheckWebElement();
	ScrollByUtility scrollby = new ScrollByUtility();
	ExcelUtility testdata = new ExcelUtility();

	public void registration(WebDriver driver){
		/*
		 * * Excel data is integrated with script parameters  
		 * * The same test case is repeated with multiple test data
		 */
		List<Map<String, String>> studentdata = testdata.readExcelData();
		int givenTestRows = testDataRS.dataSetRowSize(locator.getTargetRowValue());
		System.out.println("Given Row count is :"+givenTestRows );
		
			for (int row = 0; row < givenTestRows; row++) {
				System.err.println("row count : " + (row + 1));
				System.err.println("----------------------------------");
				sendkeys.sendkeys(driver, By.xpath(locator.getFirstName()), studentdata.get(row).get("FirstName"), locator.getSfirstName());
				sendkeys.sendkeys(driver, By.xpath(locator.getLastName()), studentdata.get(row).get("LastName"), locator.getSlastName());
				sendkeys.sendkeys(driver, By.xpath(locator.getEmailId()), studentdata.get(row).get("EmailId"), locator.getSemailId());
				sendkeys.sendkeys(driver, By.xpath(locator.selectGender("Female")), locator.getSgender());
				scrollby.scrollBy(driver);
				sendkeys.sendkeys(driver, By.xpath(locator.getMobileNumber()), studentdata.get(row).get("MobileNumber"), locator.getSmobileNumber());
				sendkeys.sendkeys(driver, By.xpath(locator.getSubjects()), studentdata.get(row).get("Subjects"), locator.getSsubjects());
				sendkeys.sendkeys(driver, By.xpath(locator.selectHobbies("Sports")), locator.getShobbies());
				sendkeys.sendkeys(driver, By.xpath(locator.getCurrentAddress()), studentdata.get(row).get("CurrentAddress"), locator.getScurrentAddress());
			}
	}

}
