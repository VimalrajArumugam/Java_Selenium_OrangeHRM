package com.reskill.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductPageLocators {
	
	static Logger logger = LogManager.getLogger(UserLoginPageLocators.class);
	
	public Properties readProductPropertiesFile() {
		
		FileInputStream prodlocator = null;
		Properties pordProperties = null;
		try {
			prodlocator = new FileInputStream("src/main/java/com/reskill/locators/products.properties");
			pordProperties = new Properties();
			pordProperties.load(prodlocator);
		} catch (FileNotFoundException e) {
			logger.error("File Not Found");
		} catch (IOException e) {
			logger.error("IOException");
		}
		return pordProperties;
	}
	
	public String getKey(String key) {
		return (String) readProductPropertiesFile().get(key);
	}
	
}
