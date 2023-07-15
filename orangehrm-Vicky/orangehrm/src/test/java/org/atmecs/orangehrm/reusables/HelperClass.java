package org.atmecs.orangehrm.reusables;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.atmecs.orangehrm.constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class helps in assisting the entire program with the reusable codes
 * 
 * @author Kalarani.Prasanth
 *
 */
public class HelperClass {
	protected static WebDriver driver;
	public static Robot virtualKey;

	static Logger logger = Logger.getLogger(HelperClass.class);

	/**
	 * This method initialize the browser
	 */
	@BeforeTest
	@Parameters("browser")
	public void selectBrowser(String browser) {
		PropertyConfigurator.configure("D:\\pretium-training\\orangehrm\\log4j.properties");
		try {
			virtualKey = new Robot();
		} catch (AWTException awtException) {
		}
		if (readConfig("ChromeBrowser").equals(browser)) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Thread ID of Chrome Browser: " + Thread.currentThread().getId());
			driver.manage().window().maximize();
			getUrl();
		} else if (readConfig("EdgeBrowser").equals(browser)) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Thread ID of Edge Browser: " + Thread.currentThread().getId());
			driver.manage().window().maximize();
			getUrl();
		}
		else if (readConfig("FirefoxBrowser").equals(browser)) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Thread ID of Edge Browser: " + Thread.currentThread().getId());
			driver.manage().window().maximize();
			getUrl();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Thread ID of Chrome Browser: " + Thread.currentThread().getId());
			driver.manage().window().maximize();
			getUrl();
		}
	}
	
	public boolean displayed(By locator) {
		return findWebElement(locator).isDisplayed();		
	}

	/**
	 * This keyword navigate to the url to be automated
	 */
	public void getUrl() {
		try {
			driver.get(readConfig("url"));
		}catch (Exception exception) {
			logger.error("User could not get the Browser URL");
		}
	}

	/**
	 * This keyword helps to find a web element
	 * 
	 * @param locator: is passed as a parameter to find the web element
	 * @return : It returns a web element
	 */
	public WebElement findWebElement(By locator) {
		try {
			return driver.findElement(locator);
		} catch (Exception exception) {
			return null;
		}
	}

	/**
	 * This method returns a webelement by relative locator below
	 * 
	 * @param actualElementLocator    : This locator is the actual webelement need
	 *                                to find
	 * @param ReferenceElementLocator : This locator is the reference for the
	 *                                element to be found
	 * @return
	 */
	public WebElement belowRelativeLocator(By actualElementLocator, By ReferenceElementLocator) {
		try {
			return driver.findElement(with(actualElementLocator).below(ReferenceElementLocator));
		} catch (Exception exception) {
			return null;
		}
	}

	/**
	 * This method returns a webelement by relative locator below
	 * 
	 * @param actualElementLocator    : This locator is the actual webelement need
	 *                                to find
	 * @param ReferenceElementLocator : This locator is the reference for the
	 *                                element to be found
	 * @return
	 */
	public WebElement aboveRelativeLocator(By actualElementLocator, By ReferenceElementLocator) {
		try {
			return driver.findElement(with(actualElementLocator).above(ReferenceElementLocator));
		} catch (Exception exception) {
			return null;
		}
	}

	/**
	 * This method returns a webelement by relative locator below
	 * 
	 * @param actualElementLocator    : This locator is the actual webelement need
	 *                                to find
	 * @param ReferenceElementLocator : This locator is the reference for the
	 *                                element to be found
	 * @return
	 */
	public WebElement leftRelativeLocator(By actualElementLocator, By ReferenceElementLocator) {
		try {
			return driver.findElement(with(actualElementLocator).toLeftOf(ReferenceElementLocator));
		} catch (Exception exception) {
			return null;
		}
	}

	/**
	 * This method returns a webelement by relative locator below
	 * 
	 * @param actualElementLocator    : This locator is the actual webelement need
	 *                                to find
	 * @param ReferenceElementLocator : This locator is the reference for the
	 *                                element to be found
	 * @return
	 */
	public WebElement rightRelativeLocator(By actualElementLocator, By ReferenceElementLocator) {
		try {
			return driver.findElement(with(actualElementLocator).toRightOf(ReferenceElementLocator));
		} catch (Exception exception) {
			return null;
		}
	}

	/**
	 * This method returns a webelement by relative locator below
	 * 
	 * @param actualElementLocator    : This locator is the actual webelement need
	 *                                to find
	 * @param ReferenceElementLocator : This locator is the reference for the
	 *                                element to be found
	 * @return
	 */
	public WebElement nearRelativeLocator(By actualElementLocator, By ReferenceElementLocator) {
		try {
			return driver.findElement(with(actualElementLocator).near(ReferenceElementLocator));
		} catch (Exception exception) {
			return null;
		}
	}

	/**
	 * This keyword helps to find a web elements
	 * 
	 * @param locator: is passed as a parameter to find the web element
	 * @return : It returns a list of web element
	 */
	public List<WebElement> findWebElements(By locator) {
		try {
			return driver.findElements(locator);
		} catch (Exception exception) {
			return null;
		}
	}

	/**
	 * This keyword helps reading a config file
	 * 
	 * @param key: helps in accessing the value of a given key
	 * @return
	 */
	public String readConfig(String key) {
		String value = null;
		try {
			Properties config = new Properties();
			config.load(new FileReader(Constants.configPath));
			value = config.getProperty(key);
		} catch (FileNotFoundException fileNotFoundException) {
			logger.error("File location is not clear");
		} catch (IOException ioException) {
			logger.error("Input Mismatch");
		}
		return value;
	}

	/**
	 * This keyword allow to click, clear and write a text in the text field
	 * 
	 * @param element: It is passed to locate the exact web element
	 * @param data:    This parameter is writeen in the text box
	 */
	public void clearAndWriteText(WebElement element, String data) {
		try {
			element.click();
			element.clear();
			element.sendKeys(data);
		} catch (Exception exception) {
			logger.info("Text is not entered in the field");
		}
	}

	/**
	 * This keyword allow to click, clear and write a text in the text field
	 * 
	 * @param element: It is passed to locate the exact web element
	 * @param data:    This parameter is writeen in the text box
	 */
	public void writeText(WebElement element, String data) {
		try {
			element.sendKeys(data);
		} catch (Exception exception) {
			logger.info("Text is not entered in the field");
		}
	}

	/**
	 * This keyword allow to click the button
	 * 
	 * @param element: It is passed to locate the exact web element
	 */
	public void clickButton(WebElement element) {
		try {
			element.click();
		} catch (Exception exception) {
			logger.info("Element is not clicked");
		}
	}

	/**
	 * This keyword allow to click the Link
	 * 
	 * @param data: The data is passed to locate the exact web element
	 */
	public void clickLink(String data) {
		try {
			driver.findElement(By.linkText(data));
		} catch (Exception exception) {
			logger.info("Link is not clicked");
		}
	}

	/**
	 * This keyword clears the value of specified Edit box.
	 *
	 * @param element: It is passed to locate the exact web element
	 */
	public void ClearEditField(WebElement element) {
		try {
			element.clear();
		} catch (Exception exception) {
			logger.info("Text Box is not cleared");
		}
	}

	/**
	 * This keyword is used to get the title of the page
	 * 
	 * @return
	 */
	public String getPageTitle() {
		try {
			return driver.getTitle();
		} catch (Exception exception) {
			logger.info("Title is not fetched");
			return null;
		}
	}

	/**
	 * This keyword helps is used to get the text of a specfied locator
	 * 
	 * @param element: It is passed to locate the exact web element
	 * @return
	 */
	public String getObjectText(WebElement element) {
		try {
			return element.getText();
		} catch (Exception exception) {
			logger.info("Get text is not performed");
			return null;
		}
	}

	/**
	 * This method is used to get Internal text
	 *
	 * @param element: It is passed to locate the exact web element
	 * @return
	 */
	public String getobjectValue(WebElement element) {
		try {
			return element.getAttribute("value");
		} catch (Exception exception) {
			logger.info("Get Attribute is not performed");
			return null;
		}
	}

	/**
	 * This keyword compares the actual string with the expected string
	 * 
	 * @param actual    : Actual text is passed as parameter
	 * @param expected: Expected text is passed as parameter
	 * @return: It returns a boolean value
	 */
	public boolean compareString(String actual, String expected) {
		if (actual.equalsIgnoreCase(expected)) {
			logger.info(actual + " matches " + expected);
			return true;
		} else
			logger.info(actual + " did not matches " + expected);
		return false;
	}

	/**
	 * This keyword verifies whether the actual string contains the expected string
	 * 
	 * @param actual    : Actual text is passed as parameter
	 * @param expected: Expected text is passed as parameter
	 * @return: It returns a boolean value
	 */
	public boolean containsString(String actual, String expected) {
		if (actual.contains(expected)) {
			logger.info(actual + " contains " + expected);
			return true;
		} else
			logger.info(actual + " did not contain " + expected);
		return false;
	}

	/**
	 * This keyword waits for a page to load
	 */
	public void waitForPageLoad() {
		try {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.waitDuration));
		} catch (Exception exception) {
			logger.info("Page is not loaded");
		}
	}

	/**
	 * This keyword waits for the presence of a element in the page
	 * 
	 * @param locator: It is passed to locate the exact web element
	 */
	public void waitForElementPresence(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.waitDuration));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception exception) {
			logger.info("Element is not present");
		}
	}

	/**
	 * This keyword waits for the visibilty of a element in the page
	 * 
	 * @param locator: It is passed to locate the exact web element
	 */
	public void waitForElementVisibility(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.waitDuration));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception exception) {
			logger.info("Element is not visible");
		}
	}

	/**
	 * This keyword waits for the specified web element to be clickable
	 * 
	 * @param locator: It is passed to locate the exact web element
	 */
	public void waitForClickable(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.waitDuration));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception exception) {
			logger.error("Element is not clickable");
		}
	}

	/**
	 * This keyword is used to wait for a specified period without any condition
	 */
	public void timeoutWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * This method is used to wait
	 */
	public void waitCondition() {
		try {
			TimeUnit.MILLISECONDS.sleep(4000);
		} catch (InterruptedException interruptedException) {
		}
	}
	
	/**
	 * This method is used to wait
	 */
	public void waittoDelete() {
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException interruptedException) {
		}
	}

	/**
	 * This mehod is used to wait for particular time period ignoring exception
	 */
	public void waitAndIgnoreCondition() {
		new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(Constants.waitDuration))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
	}

	/**
	 * This keyword helps moving a cursor to the specified webelement
	 * 
	 * @param element: It is passed to locate the exact web element
	 */
	public void mouseHover(WebElement element) {
		try {
			new Actions(driver).moveToElement(element).build().perform();
		} catch (Exception exception) {
			logger.info("Mouse Hover is not perfomed");
		}
	}

	/**
	 * This keyword helps moving a cursor to the specified webelement and click on
	 * it
	 * 
	 * @param element: It is passed to locate the exact web element
	 */
	public void mouseHoverAndClick(WebElement element) {
		try {
			new Actions(driver).moveToElement(element).click().build().perform();
		} catch (Exception exception) {
			logger.info("Mouse hover and click is not perfomed");
		}
	}

	/**
	 * This keyword helps to right click on a specified webelement it
	 * 
	 * @param element: It is passed to locate the exact web element
	 */
	public void rightClick(WebElement element) {
		try {
			new Actions(driver).contextClick(element).click().build().perform();
		} catch (Exception exception) {
			logger.info("Right click is not performed");
		}
	}

	/**
	 * This keyword helps to select a element in the dropdown by the specified index
	 * 
	 * @param element: It is passed to locate the exact web element
	 * @param index:   It is used to enter the specified index for the element to be
	 *                 chosen
	 */
	public void selectByIndex(WebElement element, int index) {
		try {
			mouseHoverAndClick(element);
			new Select(element).selectByIndex(index);
		} catch (Exception exception) {
			logger.info("Select from the dropdown is unsuccessful");
		}
	}

	/**
	 * This keyword helps to select a element in the dropdown by the specified value
	 * 
	 * @param element: It is passed to locate the exact web element
	 * @param value:   It is used to enter the specified value for the element to be
	 *                 chosen
	 */
	public void selectByValue(WebElement element, String value) {
		try {
			mouseHoverAndClick(element);
			new Select(element).selectByValue(value);
		} catch (Exception exception) {
			logger.info("Select from the dropdown is unsuccessful");
		}
	}

	/**
	 * This keyword helps to select a element in the dropdown by the specified text
	 * 
	 * @param element: It is passed to locate the exact web element
	 * @param text:    It is used to enter the specified text for the element to be
	 *                 chosen
	 */
	public void selectByVisibleText(WebElement element, String text) {
		try {
			mouseHoverAndClick(element);
			new Select(element).selectByVisibleText(text);
		} catch (Exception exception) {
			logger.info("Select from the dropdown is unsuccessful");
		}
	}

	/**
	 * This keyword helps in pressing down key
	 */
	public void pressDownKey() {
		try {
			new Robot().keyPress(KeyEvent.VK_DOWN);
		} catch (AWTException awtexception) {
			logger.info("Down Key is not pressed");
		}
	}
	
	/**
	 * This keyword helps in pressing down key
	 */
	public void pressBackSpace() {
		try {
			new Robot().keyPress(KeyEvent.VK_BACK_SPACE);
		} catch (AWTException awtexception) {
			logger.info("Down Key is not pressed");
		}
	}

	/**
	 * This keyword helps in pressing down key
	 */
	public void pressKey(int keyCode) {
		try {
			new Robot().keyPress(keyCode);
		} catch (AWTException awtexception) {
			logger.info("Down Key is not pressed");
		}
	}

	/**
	 * This keyword helps in pressing Enter key
	 */
	public void pressEnter() {
		try {
			new Robot().keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException awtexception) {
			logger.info("Enter Key is not pressed");
		}
	}

	/**
	 * This keyword helps in pressing Escape key
	 */
	public void pressEsc() {
		try {
			new Robot().keyPress(KeyEvent.VK_ESCAPE);
		} catch (AWTException awtexception) {
			logger.info("Escape Key is not pressed");
		}
	}

	/**
	 * This keyword refreshes the current browser session.
	 *
	 * @return
	 */
	public boolean RefreshBrowser() {
		try {
			driver.navigate().refresh();
			return true;
		} catch (Exception e) {
			logger.info("Page is not refreshed");
			return false;
		}
	}

	/**
	 * This keyword is used to upload a file in the webpage
	 * 
	 * @param filePath: This is used to locate the path of the file to be uploaded
	 */
	public void uploadFile(String filePath) {
		try {
			Robot robot = new Robot();
			StringSelection selection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			logger.info("File is uploaded");
		} catch (AWTException e) {
			logger.info("File is not uploaded");
		}
	}

	/**
	 * This method is used to take a screenshot
	 */
	public void screenshot() {
		String fileName = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss'.png'").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				Constants.userDirectory + File.separator + Constants.screenshotFolder + File.separator + fileName);
		try {
			FileUtils.copyFile(sourceFile, destination);
		} catch (IOException ioException) {
			logger.info("Screenshot Action is not performed");
		}
	}

	/**
	 * This method is used to read data from excel file
	 * 
	 * @param sheetName: This parameter is used to select the particular sheet from
	 *                   the excel sheet
	 * @return
	 */
	public static List<Map<String, String>> getExcelData(String sheetName) {
		List<Map<String, String>> testDataAllRows = null;
		Map<String, String> testData = null;
		String filePath = Constants.userDirectory + File.separator + Constants.excelFilePath;
		try {
			FileInputStream fielInput = new FileInputStream(filePath);
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook(fielInput);
			Sheet sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getPhysicalNumberOfRows();
			int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
			List<String> headers = new ArrayList<String>();
			for (int index = 0; index < columnCount; index++) {
				Row titleRow = sheet.getRow(0);
				Cell titleCell = titleRow.getCell(index);
				String headerData = titleCell.getStringCellValue();
				headers.add(headerData);
			}
			testDataAllRows = new ArrayList<Map<String, String>>();

			for (int row = 1; row < rowCount; row++) {
				Row rowData = sheet.getRow(row);
				testData = new LinkedHashMap<String, String>();
				for (int column = 0; column < columnCount; column++) {
					Cell cell = rowData.getCell(column);
					String data = cell.getStringCellValue();
					testData.put(headers.get(column), data);
				}
				testDataAllRows.add(testData);
			}

		} catch (FileNotFoundException fileNotFoundException) {
			logger.info("File not found Exception occured on excel file read");
		} catch (IOException ioException) {
			logger.info("IO exception occured on excel file read");
		} catch (Exception exception) {
			logger.info("Excel read is not performed");
		}
		return testDataAllRows;
	}

	/**
	 * This method is used to quit the browser
	 */
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	public static void main(String[] args) {
		List<Map<String, String>> excelData = getExcelData("Admin");
		System.out.println(excelData.size());
	}
}
