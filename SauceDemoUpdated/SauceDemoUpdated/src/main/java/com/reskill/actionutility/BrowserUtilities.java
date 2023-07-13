package com.reskill.actionutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BrowserUtilities {

	static Logger logger = Logger.getLogger(BrowserUtilities.class);

	public void configureLog4j() {
		PropertyConfigurator.configure("src\\main\\resources\\log4j2.properties");
	}

	public Properties readConfig() {

		configureLog4j();

		Properties config = new Properties();

		try {
			config.load(new FileInputStream("config.properties"));
		} catch (FileNotFoundException e) {
			logger.error("File loacation not in clear");

		} catch (IOException e) {
			logger.error("Input Mismatch");
		}
		return config;
	}

	public String getBrowser() {
		return (String) readConfig().get("BrowserName");
	}

	public String getUrlProperty() {
		return (String) readConfig().get("Url");
	}


}
