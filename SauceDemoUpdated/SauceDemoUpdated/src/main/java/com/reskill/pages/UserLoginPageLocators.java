package com.reskill.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class UserLoginPageLocators {
	static Logger logger = Logger.getLogger(UserLoginPageLocators.class);
	
	public Properties readPropertiesFile() {
		FileInputStream fileinput = null;
		Properties loginProperties = null;
		try {
			fileinput = new FileInputStream("src/main/java/com/reskill/locators/Loginpage.porperties");
			loginProperties = new Properties();
			loginProperties.load(fileinput);
		} catch (FileNotFoundException e) {
			logger.error("File Not Found");
		} catch (IOException e) {
			logger.error("IOException");
		}
		return loginProperties;
	}
	

	public String getValue(String value) {
		return (String) readPropertiesFile().get(value);
	}
	
	public String getUserName() {
		return (String) readPropertiesFile().getProperty("userNameTextField");
	}
	public String getPassword() {
		return (String) readPropertiesFile().getProperty("passwordTextField");
	}
	
	public String getStandardUserName() {
		return (String) readPropertiesFile().getProperty("standardUserName");
	}

	public String getStandardPassword() {
		return (String) readPropertiesFile().getProperty("standardPassword");
	}
	
	public String getUserLabel() {
		return (String) readPropertiesFile().getProperty("userLabel");
	}
	
	public String getuserPasswordLabel() {
		return (String) readPropertiesFile().getProperty("userPasswordLabel");
	}
	public String getLoginButton() {
		return (String) readPropertiesFile().getProperty("loginButton");
	}
	
	public String getLoginLable() {
		return (String) readPropertiesFile().getProperty("loginLabel");
	}
	
	public String getAcceptedUsernamesText() {
		return (String) readPropertiesFile().getProperty("acceptedUsernames");
	}
	
	public String getPasswordforallUsersText() {
		return readPropertiesFile().getProperty("passwordforallUsers");
	}
	
	public String getLoginName() {
		String loginTxt = readPropertiesFile().getProperty("loginName");
		return loginTxt;			
	}
	
	public String getstandardPasswordlist() {
		String loginTxt = readPropertiesFile().getProperty("usersPassword");
		return loginTxt;			
	}
	
}
