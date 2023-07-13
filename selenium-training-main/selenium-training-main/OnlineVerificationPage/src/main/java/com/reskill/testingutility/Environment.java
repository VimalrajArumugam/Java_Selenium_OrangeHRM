package com.reskill.testingutility;

import com.reskill.actionutility.EnvironmentUtilites;

public class Environment {
	EnvironmentUtilites environment = new EnvironmentUtilites();

	public void setEnvironment(String test) {

		if (test.equals("UnitTesting")) {
			System.out.println("UnitTesting");
			System.err.println(environment.getEnvironment());
		} else if (test.equals("IntegrationTesting")) {
			System.out.println("IntegrationTesting");
			System.err.println(environment.getEnvironment());
		} else if (test.equals("RegressionTesting")) {
			System.out.println("RegressionTesting");
			System.err.println(environment.getEnvironment());
		}
	}
}
