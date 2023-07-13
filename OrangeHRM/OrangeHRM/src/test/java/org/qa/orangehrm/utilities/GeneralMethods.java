package org.qa.orangehrm.utilities;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qa.orangehrm.basetest.BaseTest;
import org.qa.orangehrm.constants.ConstantsValue;
import org.qa.orangehrm.pages.RecruitmentPage;
import org.qa.orangehrm.properties.PropertiesFiles;
/**
 * This class helps in assisting the entire program with the reusable codes
 * 
 * @author Saravanan.Ramu
 *
 */

public class GeneralMethods extends BaseTest {
	static Logger logger = Logger.getLogger(GeneralMethods.class);
	static WebDriverWait wait;

	/**
	 * This method is used to click function
	 * @param
	 * This method is used to wait explicitly until element is to be selected
	 */

	public static void click(By locator) {
		try {
			driver.findElement((locator)).click();
			logger.info("Element got clicked");
		} catch (Exception e) {
			logger.error("Element not clicked");
		}
	}

	/**
	 * This method is used to enter function
	 */

	public void pressEnter() {
		try {
			new Robot().keyPress(KeyEvent.VK_ENTER);
			logger.info("Virtual Key is entered");
		} catch (AWTException awtexception) {
			logger.error("Virtual Key is not entered");
		}
	}

	/**
	 * This method is used to enterText
	 * @param locator-It is used to locate the webelement
	 * This method is used to wait explicitly until element is to be selected
	 * 
	 * 
	 */

	public static void enterText(By locator, String text) {
		try {
			driver.findElement(locator).sendKeys(text);
			logger.info("Text is entered");
		} catch (Exception exception) {
			logger.error("Text not get entered"+exception);

		}
	}

	/**
	 * This method is used to click function using mouse actions
	 * 
	 * @param element which performs mouse actions using actions class
	 */

	public void mouseHoverAndClick(WebElement element) {
		try {
			new Actions(driver).moveToElement(element).click().build().perform();
			logger.info("Mousehovered and Element got clicked");

		} catch (Exception exception) {
			logger.error("MousseHover actions not performed" + exception);
		}

	}

	/**
	 * This method is used to get text
	 * 
	 * @param locator-It is used to locate element
	 * @gettext method is used to get the text
	 */

	public static String getText(By locator) {
		try {
			return driver.findElement(locator).getText();
		} catch (Exception exception) {
			logger.error("Text not shown" + exception);
			return getText(locator);
		}
	}

	/**
	 * This method is used to wait until element to presence
	 * 
	 * @param locator-It is used to locate the webelement
	 * 
	 */

	public void waitForElementPresence(By locator) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(ConstantsValue.duration));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			logger.info("Element is present");
		} catch (Exception exception) {
			logger.error("Element is not present" + exception);
		}
	}

	/**
	 * This method is used to wait explicitly until element is click able
	 * 
	 * @param locator is used to locate the webelement
	 */

	public static boolean elementToBeClickable(By Locator) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(ConstantsValue.duration));
			explicitWait().until(ExpectedConditions.elementToBeClickable(Locator));
			return true;
		} catch (Exception exception) {
			logger.error("Unable to clickable the element" + exception);
			return false;
		}
	}

	/**
	 * This method is used to get pageTitle
	 * 
	 */

	public String getPageTitle() {
		try {
			return driver.getTitle();
		} catch (Exception exception) {
			logger.error("Title is not fetched" + exception);
			return null;
		}
	}

	/**
	 * This method is used to implicitWait
	 */

	public static void waitImplicit() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConstantsValue.duration));
			logger.info("Wait conditon is worked");
		} catch (Exception exception) {
			logger.error("wait condition is not worked");
		}
	}

	/**
	 * This method is used to define expicit wait
	 */

	public static WebDriverWait explicitWait() {
		return wait = new WebDriverWait(driver,
				Duration.ofSeconds(Integer.parseInt(PropertiesFiles.readLocators("explicitWait"))));
	}

	/**
	 * @param locator-It is used to locate the webelement
	 * This method is used to wait explicitly until element is to be selected
	 *  
	 */

	public static boolean elementToBeSelected(By Locator) {
		try {
			explicitWait().until(ExpectedConditions.elementToBeSelected(Locator));
			return true;
		} catch (Exception exception) {
			logger.error("Unable to select the element" + exception);
			return false;
		}
	}

	/**
	 * This method is used to wait until element is visible
	 * 
	 * This method is used to wait explicitly until element is to be selected
	 */

	public void waitconditionElementVisibility(By locator) {
		try {
			explicitWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception exception) {
			logger.error("wait conditon is not worked");
		}
	}

	/**
	 * This method is used to wait explicitly until element is to be selected
	 * This method is used to wait until element is present
	 *
	 */

	public static boolean presenceOfElementLocated(By Locator) {
		try {
			explicitWait().until(ExpectedConditions.presenceOfElementLocated(Locator));
			return true;
		} catch (Exception exception) {
			logger.error("Element is not present " + exception);
			return false;
		}
	}

	/**
	 * This method is used to wait explicitly until element is to be selected
	 * This method is used to check element is present or not 
	 * 
	 */

	public void elementPresent(By locator) {
		try {
			driver.findElement(locator).isDisplayed();
			logger.info("Element is present");
		} catch (Exception e) {
			logger.error("Element is not present");
		}
	}

	/**
	 * This method is used to get values from drop down
	 * 
	 * This method is used to wait explicitly until element is to be selected
	 * 	 * @param value
	 */

	public static void selectByIndex(By locator, String value) {
		try {
			List<WebElement> dropdown = driver.findElements((locator));
			for (int index = 0; index < dropdown.size(); index++) {
				String name = dropdown.get(index).getText();
				if (name.contains(value)) {
					dropdown.get(index).click();
					break;
				}
			}
			logger.info("selectByIndex is worked");

		} catch (Exception e) {
			logger.error("selectByIndex is not worked");
		}
	}

	/**
	 * @param
	 * This method is used to wait explicitly until element is to be selected
	 * This method is used to perform javaScript click
	 */

	public void jsclick(By locator) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", locator);

		} catch (Exception e) {
			logger.error("JS click is not performed");
		}
	}

	/**
	 * @param
	 * This method is used to wait explicitly until element is to be selected
	 * This method is used to wait explicitly until text to appear
	 */
	public void waitForTextToAppear(String textToAppear, By locator) {
		explicitWait().until(ExpectedConditions.textToBePresentInElementLocated(locator, textToAppear));
	}

	/**
	 * * This keyword is used to upload a file in the webpage
	 * 
	 * @param Path: This is used to locate the path of the file to be uploaded
	 */

	public void fileUpload(String path) {
		try {
			StringSelection stringSelection = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			click(RecruitmentPage.browseUpload);
			Robot robot = new Robot();
			robot.delay(ConstantsValue.duration);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			logger.info("File is uploaded");

		} catch (Exception exception) {
			logger.error("File is not uploaded" + exception);
		}
	}
}
