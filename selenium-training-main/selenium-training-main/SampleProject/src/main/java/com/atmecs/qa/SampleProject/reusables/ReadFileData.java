package com.atmecs.qa.SampleProject.reusables;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFileData {
	public Properties getdata(String filepath) {
		String projectpath = System.getProperty("user.dir");
		File file = new File(projectpath + filepath);
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("Registation properties file not found in given path");
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			System.out.println("IO Exception in registration form");
			e.printStackTrace();
		}
		return prop;
	}

	public String keyvalue(String key) {
		String filePath = "./src/main/resources/locators/atmecs/RegistrationForm.properties";
		return getdata(filePath).getProperty(key);
	}

	public String loginValue(String value) {
		String filePath = "./src/main/resources/locators/atmecs/LoginForm.properties";
		return getdata(filePath).getProperty(value);
	}

	public String homevalue(String value) {
		String filepath = "./src/main/resources/locators/atmecs/HomePage.properties";
		return getdata(filepath).getProperty(value);
	}
	
	public String falconWebpage(String key) {
		String filePath = "./src/main/resources/locators/atmecs/FalconWebPage.properties";
		return getdata(filePath).getProperty(key);
	}
	
	
//	public static void main(String[] args) {
//		ReadFileData runner = new ReadFileData();
//		System.out.println(runner.falconWebpage("url"));
//	}
}

