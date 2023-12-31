package com.atmecs.qa.SampleProject.testscript;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.jiracloud.tm.TestCase;
import com.atmecs.falcon.automation.jiracloud.tm.TestCycleMap;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

/**
 * Use below class sample code when using Jira Test Results
 * 
 */
public class SampleJiraTestScript {

	private Verify verifyTestStep = new Verify();

	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	@BeforeTest
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void beforeTest(String os, String osVersion, String br, String browserVersion) {
		String key = os + "_" + osVersion + "_" + br + "_" + browserVersion;
		verifyTestStep.setTestCycleKey(TestCycleMap.testCycleMap.get(key + "googlesearch"));
	}

	@Test
	@TestCase(key = "TP-T1", ModuleName = "googlesearch")
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void sampleJiraTest(String os, String osVersion, String br, String browserVersion) {
		report.info("Jira test method");
		
		verifyTestStep.setTestCaseKey("TP-T1");

		verifyTestStep.verifyTrue(true, "step 1 ", true);
		verifyTestStep.verifyTrue(true, "step 2 ", true);
		verifyTestStep.verifyTrue(true, "step 3 ", true);
	}

}
