package com.reskill.actionutility;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.reskill.pages.RegistrationPageLocators;
import io.github.bonigarcia.wdm.WebDriverManager;
public class SelectWebdriver {

	BrowserUtilitys browser = new BrowserUtilitys();
	BrowserUtilitys timeout = new BrowserUtilitys();
	RegistrationPageLocators locator = new RegistrationPageLocators();
	WebDriver driver;

	public Object getBrowser() {
		return browser.readProperties().get("browserName");
	}

	public String getURL() {
		return locator.readProperty().getProperty("url");
	}
	

	public WebDriver getDriver(Object browser) {

		if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout.getPageTimeOut()));
		} else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout.getPageTimeOut()));
		}
		return driver;
	}

	public void getUrl() {
		driver.get(getURL());
	}

}
