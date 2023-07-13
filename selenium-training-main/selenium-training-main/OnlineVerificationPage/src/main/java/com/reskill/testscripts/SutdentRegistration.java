package com.reskill.testscripts;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.reskill.actionutility.EnvironmentUtilites;
import com.reskill.actionutility.PageLoadUtility;
import com.reskill.actionutility.SelectWebdriver;
import com.reskill.pages.RegistrationPageLocators;
import com.reskill.reusables.RegistrationPage;

public class SutdentRegistration {
	RegistrationPage studentregistration = new RegistrationPage();
	RegistrationPageLocators locator = new RegistrationPageLocators();
	EnvironmentUtilites environment = new EnvironmentUtilites();
	SelectWebdriver browser = new SelectWebdriver();
	PageLoadUtility pageload = new PageLoadUtility();

	WebDriver driver;
	@BeforeTest
	public void launchBrowser() {
		/*
		 * * Environment SetUp
		 * * OpenWebPage
		 * * Launch URL 
		 */		
		environment.getEnvironment();
		driver = browser.getDriver(browser.getBrowser());
		browser.getUrl();
	}
	
	@Test
	public void studentRegistration(){		
		/*
		 * * Launch Registration Page
		 */
		studentregistration.registration(driver);
	}
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}

}
