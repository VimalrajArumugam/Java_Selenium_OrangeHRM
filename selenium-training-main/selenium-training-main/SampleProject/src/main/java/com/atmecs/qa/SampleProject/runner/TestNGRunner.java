package com.atmecs.qa.SampleProject.runner;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import com.atmecs.falcon.automation.dataprovider.TestDataProvider;
import com.atmecs.falcon.automation.jiracloud.tm.JiraCloudManager;
import com.atmecs.falcon.automation.jiracloud.tm.TestCycleListner;
import com.atmecs.falcon.automation.jiracloud.tm.TestCycleMap;
import com.atmecs.falcon.automation.slack.SlackReportListener;
import com.atmecs.falcon.automation.ui.selenium.CustomListener;
import com.atmecs.falcon.automation.util.main.AbstractTestNGEngine;
import com.atmecs.falcon.automation.util.main.TestNGEngineFactory;
import com.atmecs.falcon.automation.util.main.TestNGEngineTemplateType;
import com.atmecs.falcon.automation.util.parser.PropertyParser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.automation.util.reporter.TestReportUploadClient;
import com.beust.jcommander.internal.Lists;

/**
 * TestNGRunner is the Main Class of MOJO type generates new Xml Suites on runtime for each client
 * for each child suite in the existing parent Xml Suite and executes
 * @author nv092106
 */
public class TestNGRunner {
    private static AbstractTestNGEngine testNGEngine = new TestNGEngineFactory()
            .getTestNGEngine(TestNGEngineTemplateType.DESIRED_SUITE_FOR_GIVEN_MODULES);
    @SuppressWarnings("rawtypes")
    private static List<Class<? extends ITestNGListener>> listners = Lists.newArrayList();
    private static TestNG testng = new TestNG();
    private static List<XmlSuite> suitesToRun = null;
    private static TestDataProvider dataProvider = TestDataProvider.getInstance();
    private static ReportLogService report = new ReportLogServiceImpl(TestNGRunner.class);

    private static void initialize() throws Exception {
        // Custom Listener to testng
    	if (PropertyParser.readEnvOrConfigProperty("jira.testresults").equals("true")) {
			listners.add(TestCycleListner.class);
			initTestCycle();
		} else {
			report.info(
					"Test Results are not uploading to JIRA. If you want to upload please set value of key 'jira.testresults' to 'true' in config.properties");
		}
        listners.add(CustomListener.class);
        listners.add(SlackReportListener.class);
        testng.setListenerClasses(listners);
    }

    /**
     * Purpose: The main method invoked by the Maven plugin that uses the services of TestNGEngine
     * to create new Xml Suites on runtime and executes them
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        initialize();

        suitesToRun =
                testNGEngine.getSuitesToRunFor(PropertyParser.readEnvOrConfigProperty("SuiteFileName"),
                		PropertyParser.readEnvOrConfigProperty("ClientName"),
                		PropertyParser.readEnvOrConfigProperty("ModuleName"),
                		PropertyParser.readEnvOrConfigProperty("BrowserCaps"),
                		PropertyParser.readEnvOrConfigProperty("IncludeGroups"),
                		PropertyParser.readEnvOrConfigProperty("ExcludeGroups"));
        testng.setXmlSuites(suitesToRun);
        testng.setSuiteThreadPoolSize(Integer.parseInt(PropertyParser.readEnvOrConfigProperty("instances")));
        testng.run();
        
        if (PropertyParser.readEnvOrConfigProperty("uploadResults").equalsIgnoreCase("true")) {
        		uploadTestNGResultsXml();
		}else {
		   	report.error("Results are not uploaded because uploadResults flag is set to false");
		}
        

    }

    /** 
     * After test execution this method will post the results to Report Server
     */
    private static void uploadTestNGResultsXml() {
        final String uploadUrl = PropertyParser.readEnvOrConfigProperty("testreport.uploadurl");
        String testNGResultsXmlFilePath =
                System.getProperty("user.dir") + File.separator + "test-output" + File.separator
                        + "testng-results.xml";

        TestReportUploadClient testReportUploadClient = new TestReportUploadClient(uploadUrl);
        try {
            String response =
                    testReportUploadClient.upload(dataProvider.getSessionId(), PropertyParser.readEnvOrConfigProperty("ProjectName"), "WEB",
                            "QA", "Regression", "Local", "Windows 10", "Desktop", "Chrome v84",
                            testNGResultsXmlFilePath);
            report.info("Response : " + response);

        } catch (Exception e) {
            report.error("Unknown error : : Cannot Upload the testng-results.xml " + e.getMessage());
        }
    }
    
    /**
	 * Purpose: Method to create a test cycle and update Map with browserCap
	 * along with testCycleKey
	 *
	 * @throws JSONException
	 */
	private static void initTestCycle() throws JSONException {
		String projectKey = PropertyParser.readEnvOrConfigProperty("jira.projectkey");
		String rootFolderName = PropertyParser.readEnvOrConfigProperty("jira.root.folder");
		String testEnvironment = PropertyParser.readEnvOrConfigProperty("testEnvironment");
		String[] moduleNamesArray = PropertyParser.readEnvOrConfigProperty("ModuleName").split(",");

		JiraCloudManager jco = new JiraCloudManager();

		if (jco.projectExistsForKey(projectKey)) {

			int rootFolderId = jco.getRootFolderId(rootFolderName);
			System.out.println("ROOT_FOLDER_ID: " + rootFolderId);

			if (rootFolderId == 0) {
				rootFolderId = jco.createTestCycleFolder(0, rootFolderName, projectKey);
			}

			int runFolderCount = jco.getRunFolderCount(rootFolderId);
			runFolderCount++;
			report.debug("runFolderCount++: " + runFolderCount);
			int runFolderId = jco.createTestCycleFolder(rootFolderId, "Run " + runFolderCount, projectKey);

			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
			String[] arr = PropertyParser.readEnvOrConfigProperty("BrowserCaps").split(",");
			for (String browserCap : arr) {

				int browserFolderId = jco.createTestCycleFolder(runFolderId, getBrowserFolderName(browserCap),
						projectKey);

				for (String moduleName : moduleNamesArray) {
					String moduleFolderName = moduleName.substring(0, 1).toUpperCase()
							+ moduleName.substring(1).toLowerCase();
					int moduleFolderId = jco.createTestCycleFolder(browserFolderId, moduleFolderName, projectKey);
					// String testCycleName =
					// browserCap+"_"+moduleName+"_"+dateFormat.format(new
					// Date());
					String testCycleName = testEnvironment + "-" + moduleFolderName + "-"
							+ dateFormat.format(new Date());
					report.info("Creating Test Cycle " + testCycleName);
					DateFormat plandateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
					String plannedStartDate = plandateFormat.format(new Date());
					String plannedEndDate = plandateFormat.format(new Date());
					String response = jco.createTestCycle(projectKey, testCycleName, "", moduleFolderId);
					System.out.println("Create Cycle Response: " + response);
					JSONObject testCycleJsonObject = new JSONObject(response);
					TestCycleMap.testCycleMap.put(browserCap + moduleName, testCycleJsonObject.getString("key"));
					System.out.println("Runner_testCycleMap:" + TestCycleMap.testCycleMap);
				}
			}
		} else {
			report.info("No Project exists on Jira for Project Key: " + projectKey);
		}

	}

	private static String getBrowserFolderName(String browserCap) {
		String[] browserCapArray = browserCap.split("_");
		String browserName = "";
		String osName = browserCapArray[0].substring(0, 1).toUpperCase()
				+ browserCapArray[0].substring(1).toLowerCase();
		for (int index = 0; index < browserCapArray.length; index++) {
			if (browserCapArray[index].equalsIgnoreCase("chrome") || browserCapArray[index].equalsIgnoreCase("firefox")
					|| browserCapArray[index].equalsIgnoreCase("ie") || browserCapArray[index].equalsIgnoreCase("edge")
					|| browserCapArray[index].equalsIgnoreCase("safari")) {
				if (browserCapArray[index] == "ie") {
					browserName = "IE";
				} else {
					browserName = browserCapArray[index].substring(0, 1).toUpperCase()
							+ browserCapArray[index].substring(1).toLowerCase();
				}
				break;
			}
		}

		return osName + "_" + browserName;
	}
}
