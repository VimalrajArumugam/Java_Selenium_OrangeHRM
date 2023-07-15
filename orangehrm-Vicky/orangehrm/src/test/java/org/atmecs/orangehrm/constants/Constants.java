package org.atmecs.orangehrm.constants;

import java.awt.event.KeyEvent;
import java.io.File;

/**
 * This class contains the constant values
 * 
 * @author Kalarani.Prasanth
 *
 */
public class Constants {
	public static String userDirectory = System.getProperty("user.dir");
	public static String configPath = "src" + File.separator + "main" + File.separator + "resource" + File.separator
			+ "org" + File.separator + "atmecs" + File.separator + "orangehrm" + File.separator + "data"
			+ File.separator + "config.properties";
	public static String screenshotFolder = "screenshot";
	public static String excelFilePath = "src" + File.separator + "main" + File.separator + "resource" + File.separator
			+ "org" + File.separator + "atmecs" + File.separator + "orangehrm" + File.separator + "data"
			+ File.separator + "TestData.xlsx";
	public static int waitDuration = 20;
	public static String Login_Sheet = "Login";
	public static String PIM_Sheet = "PIMTab";
	public static String admin_Sheet = "Admin";
	public static String admin_Job_Sheet = "Admin_Job";
	public static String admin_Organization = "Admin_Organization";
	public static int employeeNameSuggestion = KeyEvent.VK_A;
	public static String containerHeader = "No Records Found"; 
	public static String existsMessage = "Already exists"; 
	
}
