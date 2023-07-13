package com.reskill.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class RegistrationPageLocators {
	public Properties readProperty() {

		String projectpath = System.getProperty("user.dir");
		FileInputStream inputstream = null;
		try {
			inputstream = new FileInputStream(
					projectpath + "/src/main/java/com/reskill/locators/studentRegistrationPage.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.load(inputstream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.print(properties);
		return properties;
	}

	public int getTargetRowValue() {
		String targetrow = readProperty().getProperty("TargetRows");
		int rownumber = Integer.parseInt(targetrow);
		return rownumber;
	}

	public String getFirstName() {
		String fname = readProperty().getProperty("firstName");
		return fname;
	}

	public String getLastName() {
		String fname = readProperty().getProperty("lastName");
		return fname;
	}

	public String getEmailId() {
		String fname = readProperty().getProperty("emailId");
		return fname;
	}

	public String getGender() {
		return readProperty().getProperty("gender");

	}

	public String getGenderRadioButton() {
		return readProperty().getProperty("genderRadioBtt");
	}

	public String getMobileNumber() {
		String fname = readProperty().getProperty("mobileNumber");
		return fname;
	}

	public String getSubjects() {
		String fname = readProperty().getProperty("subjects");
		return fname;
	}

	public String getHobbies() {
		String fname = readProperty().getProperty("hobbies");
		return fname;
	}

	public String getHobbiesRadioBtt() {
		String fname = readProperty().getProperty("hobbiesRadioBtt");
		return fname;
	}

	public String getCurrentAddress() {
		String fname = readProperty().getProperty("currentAddress");
		return fname;
	}

	public String getStudentFname() {
		return readProperty().getProperty("FirstName");
	}

	public String getStudentLname() {
		String fname = readProperty().getProperty("LastName");
		return fname;
	}

	public String getStudentEmail() {
		String fname = readProperty().getProperty("EmailId");
		return fname;
	}

	public String getStudentSubjects() {
		String fname = readProperty().getProperty("Subjects");
		return fname;
	}

	public String getStudentCuurentAdd() {
		String fname = readProperty().getProperty("CurrentAddres");
		return fname;
	}

	public String getStudentMobile() {
		String fname = readProperty().getProperty("MobileNumber");
		return fname;
	}

	public String selectGender(String name) {

		if (name == "Male") {
			String valueM = readProperty().getProperty("Male");
			return valueM;
		} else if (name == "Female") {
			String valueF = readProperty().getProperty("Female");
			return valueF;
		} else if (name.equalsIgnoreCase("Other")) {
			String valueO = readProperty().getProperty("Other");
			return valueO;
		}

		return null;

	}

	public String selectHobbies(String name) {

		if (name == "Sports") {
			String valueM = readProperty().getProperty("Sports");
			return valueM;
		} else if (name == "Reading") {
			String valueF = readProperty().getProperty("Reading");
			return valueF;
		} else if (name.equalsIgnoreCase("Music")) {
			String valueO = readProperty().getProperty("Other");
			return valueO;
		}

		return null;

	}

	public String getSfirstName() {
		return readProperty().getProperty("sFirstname");
	}

	public String getSlastName() {
		return readProperty().getProperty("sLastname");
	}

	public String getSemailId() {
		return readProperty().getProperty("sEmailId");
	}

	public String getSgender() {
		return readProperty().getProperty("sGender");
	}

	public String getSmobileNumber() {
		return readProperty().getProperty("sMobileNumber");
	}

	public String getSsubjects() {
		return readProperty().getProperty("sSubjects");
	}

	public String getShobbies() {
		return readProperty().getProperty("sHobbies");
	}

	public String getScurrentAddress() {
		return readProperty().getProperty("sCurrentAddres");
	}

}
