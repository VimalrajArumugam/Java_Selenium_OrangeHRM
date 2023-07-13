package com.reskill.actionutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentUtilites {

	public Properties readProperties() {

		String browserFilePath = System.getProperty("user.dir");
		File file = new File(browserFilePath + "/Source/config.properties");

		FileInputStream inputstream = null;
		try {
			inputstream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("config.properties file not found in the given path: ");
		}
		Properties properties = new Properties();
		try {
			properties.load(inputstream);

		} catch (IOException e) {
			System.out.println("TestData IO Exception :");
		}
		return properties;
	}

	public String getEnvironment(){

		if (readProperties().containsKey("qaURL")) {
//			System.out.println(readProperties().containsKey("qaURL"));
			System.out.println("QA Testing");
			String qaUrl = readProperties().getProperty("qaURL");
			System.out.println(qaUrl);
//			return qaUrl;
		}else if (readProperties().containsKey("integURL")) {
//			System.out.println(readProperties().containsKey("integURL"));
			System.out.println("Integration Testing");
			String inteUrl = readProperties().getProperty("integURL");
			System.out.println(inteUrl);
//			return inteUrl;
		}else if (readProperties().containsKey("preProdURL")) {
//			System.out.println(readProperties().containsKey("preProdURL"));
			System.out.println("PreProduction");
			String preProdUrl = readProperties().getProperty("preProdURL");
			System.out.println(preProdUrl);
//			return preProdUrl;
		}

		return null;
	}
}
