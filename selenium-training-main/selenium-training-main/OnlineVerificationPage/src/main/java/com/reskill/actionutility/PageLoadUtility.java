package com.reskill.actionutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PageLoadUtility {

	public Properties readProperty() {
		String projectpath = System.getProperty("user.dir");
		FileInputStream inputstream = null;
		try {
			inputstream = new FileInputStream(projectpath + "/Source/config.properties");
		} catch (FileNotFoundException e) {
			System.out.println("cofig.properties file not found on given path");
		}
		Properties properties = new Properties();
		try {
			properties.load(inputstream);
		} catch (IOException e) {
			System.out.println("IO Exception : ");
		}
		return properties;
	}

	public long getPageTimeOut() {
		String sec = readProperty().getProperty("PageTimeOut");
		int seconds = Integer.parseInt(sec);
		return seconds;
	}
}
