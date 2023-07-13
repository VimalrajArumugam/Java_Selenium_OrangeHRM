package org.qa.orangehrm.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.qa.orangehrm.constants.ConstantsValue;
import org.qa.orangehrm.utilities.GeneralMethods;

public class PropertiesFiles {
	static Logger logger = Logger.getLogger(GeneralMethods.class);

	/**
	 * This method is used to read properties in properties files
	 * 
	 * @param locators
	 * @return
	 */

	public static String readLocators(String locators) {
		return (String) readProperties().getProperty(locators);

	}

	/**
	 * This method is used to read the properties
	 * 
	 * @return properties
	 */

	public static Properties readProperties() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(ConstantsValue.configPath));
		} catch (IOException e) {
			logger.error("File Not Found");
			logger.error(e.getLocalizedMessage());
		}
		return properties;
	}
}
