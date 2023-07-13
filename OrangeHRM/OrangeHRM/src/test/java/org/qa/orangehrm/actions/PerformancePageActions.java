package org.qa.orangehrm.actions;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.qa.orangehrm.pages.PerformancePage;
import org.qa.orangehrm.testdata.ReadExcelData;
import org.qa.orangehrm.utilities.GeneralMethods;

public class PerformancePageActions extends GeneralMethods {
	static Logger logger = Logger.getLogger(PerformancePageActions.class);

	ReadExcelData excelTestData = new ReadExcelData();

	/**
	 * This method is for manageReviewsFunctionality.
	 */

	public void manageReviewsFunctionlity(HashMap<String, String> data) {
		try {
			addmanageReviews(data);
			editReviews(data);
			searchReviews(data);
			deleteReviews(data);
			viewEmployeeTrackers(data);
			logger.info("Manage review functionality is worked");

		} catch (Exception exception) {
			logger.error("Manage review functionality is not worked" + exception);
		}
	}

	/**
	 * This method is to add the manage reviews
	 */

	public void addmanageReviews(HashMap<String, String> data) {
		try {
			click(PerformancePage.Performance);
			click(PerformancePage.ManageReviewstab);
			click(PerformancePage.ManageReviewsLink);
			click(PerformancePage.addButton);
			enterText(PerformancePage.EmployeeName, data.get("EmployeeName"));
			selectByIndex(PerformancePage.dropDownButton, "EmployeeName");
			enterText(PerformancePage.SupervisorReviewerr, "SupervisorReviewer");
			click(PerformancePage.SupervisorReviewerr);
			enterText(PerformancePage.reviewPeriodStartDate, "ReviewStartDate");
			enterText(PerformancePage.reviewPeriodEndDate, "ReviewEndDate");
			enterText(PerformancePage.dueDate, "DueDate");
			click(PerformancePage.activateButton);
			logger.info("ManageReviews added successfully");
		} catch (Exception exception) {
			logger.error("Manage Reviews is not added sucessfully" + exception);
		}
	}

	/**
	 * This method is to edit the manage reviews
	 */

	public void editReviews(HashMap<String, String> data) {
		try {
			click(PerformancePage.ManageReviewsLink);
			click(PerformancePage.manageReviewEdit);
			elementToBeClickable(PerformancePage.EmployeeName);
			enterText(PerformancePage.EmployeeName, data.get("EmployeeName"));
			click(PerformancePage.saveButton);
			logger.info("Reviews are edited");

		} catch (Exception exception) {
			logger.error("Reviews are not edited" + exception);
		}

	}

	/**
	 * This method is to search the manage reviews
	 */

	public void searchReviews(HashMap<String, String> data) {
		try {
			click(PerformancePage.ManageReviewsLink);
			String expectedName = data.get("EmployeeName") + " ";
			enterText(PerformancePage.EmployeeName, expectedName);
			elementToBeClickable(PerformancePage.EmployeeName);
			selectByIndex(PerformancePage.dropDownButton, data.get("EmployeeName"));
			click(PerformancePage.manageReviewsSearchButton);
			logger.info("Reviews got searched");
		} catch (Exception exception) {
			logger.error("Search reviews is not done" + exception);
		}
	}

	/**
	 * This method is to delete the manage reviews
	 */

	public void deleteReviews(HashMap<String, String> data) {
		try {
			searchReviews(data);
			click(PerformancePage.deleteCheckBox);
			click(PerformancePage.confirmDelete);
			logger.info("ManageReviews is deleted");
		} catch (Exception exception) {
			logger.error("ManageReviews is not Deleted" + exception);
		}

	}

	/**
	 * This method is to view the employee trackers
	 */

	public void viewEmployeeTrackers(HashMap<String, String> data) {
		try {
			click(PerformancePage.Performance);
			click(PerformancePage.employeeTrackersButton);
			enterText(PerformancePage.employeeNameTracker, data.get("EmployeeTrackername"));
			click(PerformancePage.employeeTrackersSearchButton);
			click(PerformancePage.employeeTrackersView);
			logger.info("Employee Trackers is viewed");
		} catch (Exception exception) {
			logger.error("Employee Trackers is not viewed" + exception);
		}
	}

}
