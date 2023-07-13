package org.qa.orangehrm.basetest;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.qa.orangehrm.properties.PropertiesFiles;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	static Logger logger = Logger.getLogger(BaseTest.class);

	static public WebDriver driver;

	/**
	 * To select different browser based on user preference.
	 * 
	 * @param browser = Declaration of browser type.
	 */
	@BeforeTest
	@Parameters({ "browserName" })
	public void browserLaunch(String browserName) {
		try {
			switch (browserName.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--remote-allow-origins=*");
				chromeOptions.addArguments("start-maximized");

				driver = new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			default:
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			}
			driver.get(PropertiesFiles.readLocators("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(Integer.parseInt(PropertiesFiles.readLocators("implicitWait"))));
			Assert.assertEquals(driver.getCurrentUrl(), PropertiesFiles.readLocators("url"));
		} catch (Exception exception) {
			logger.error("Exception is not handled" + exception);
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		logger.info("The Browser got closed");
	}

}
