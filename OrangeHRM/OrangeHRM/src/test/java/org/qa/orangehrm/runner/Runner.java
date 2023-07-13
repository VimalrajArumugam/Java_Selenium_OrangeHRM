package org.qa.orangehrm.runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

public class Runner {
	/**
	 * This method is used as runner class
	 * 
	 * 
	 */

	@Test
    public void runner() {
        TestNG testng = new TestNG();
        TestListenerAdapter adapter = new TestListenerAdapter();
        List<String> suites = new ArrayList<String>();
        testng.addListener(adapter);
        suites.add("suite.xml");
        testng.setTestSuites(suites);
        testng.setParallel(XmlSuite.ParallelMode.NONE);
        testng.setSuiteThreadPoolSize(1);
        testng.setOutputDirectory(System.getProperty("user.dir") + "//target");
        testng.run();

    }

}
