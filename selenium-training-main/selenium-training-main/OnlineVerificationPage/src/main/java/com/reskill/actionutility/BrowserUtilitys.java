package com.reskill.actionutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class BrowserUtilitys {

	WebDriver driver;

	public Properties readProperties() {

		String browserFilePath = System.getProperty("user.dir");
		File file = new File(browserFilePath + "/src/main/java/com/reskill/testdata/browsers.properties");

//		File file = new File("./src/main/java/com/skillfill/testdata/browsers.properties");
		FileInputStream inputstream = null;
		try {
			inputstream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("browser.properties file not found in given path : ");
		}
		Properties properties = new Properties();
		try {
			properties.load(inputstream);
		} catch (IOException e) {
			System.out.println("test data IO Exception : ");
		}
		return properties;
	}

	public long getPageTimeOut() {
		String sec = readProperties().getProperty("PageTimeOut");
		int seconds = Integer.parseInt(sec);
		return seconds;
	}

	public String getTest() {
		return (String) readProperties().get("test");
	}

	public String getUrl() {
		return (String) readProperties().get("url");
	}

}
