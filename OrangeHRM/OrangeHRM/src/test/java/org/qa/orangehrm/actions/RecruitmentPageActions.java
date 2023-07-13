package org.qa.orangehrm.actions;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.qa.orangehrm.constants.ConstantsValue;
import org.qa.orangehrm.pages.RecruitmentPage;
import org.qa.orangehrm.utilities.GeneralMethods;

public class RecruitmentPageActions extends GeneralMethods {
	static Logger logger = Logger.getLogger(RecruitmentPageActions.class);

	/**
	 * This method is for recruitment functionality
	 */

	public void recruitment(HashMap<String, String> data) {
		try {
			addRecruitment(data);
			verifyCreatedCandidate(data);
			searchCandidate(data);
			viewCandidate();
			downloadFile();
			deleteCandidate(data);
			logger.info("Recruitment actions is performed");

		} catch (Exception exception) {
			logger.error("Recruitment actions is not performed"+exception);

		}
	}

	/**
	 * This method is for vacancy functionality
	 */

	public void vacancy(HashMap<String, String> data) {
		try {
			addVacancies(data);
			verifyCandidateVacancy(data);
			editVacancy(data);
			deleteVacancy(data);
			logger.info("Vacancy actions is performed");

		} catch (Exception exception) {
			logger.error("Vacancy actions is not performed"+exception);

		}

	}

	/**
	 * This method is to add the candidate in recruitmenttab
	 */

	public void addRecruitment(HashMap<String, String> data) {
		try {
			clickRecruitmentButton();
			clickrecruitmentAddButton();
			enterCandidateFirstname(data.get("FirstName"));
			enterCandidateMiddlename(data.get("MiddleName"));
			enterCandidateLastname(data.get("LastNamee"));
			ClickVacancyDropDownButton();
			updateVacancyDropDown(data.get("vacancy"));
			entereMail(data.get("eMail"));
			enterContactNumber(data.get("ContactNumber"));
			fileUpload(data.get("FileUpload"));
			elementToBeClickable(RecruitmentPage.recuritmentCandidateSaveButton);
			saveRecruitementCanditate();
			logger.info("Candidate details is added");

		} catch (Exception exception) {
			logger.error("Candidate details is not added"+exception);
		}
	}

	/**
	 * This method is to add the vacancies in recruitmenttab
	 */

	public void addVacancies(HashMap<String, String> data) {
		try {
			click(RecruitmentPage.recruitmentButton);
			click(RecruitmentPage.vacanciesTab);
			click(RecruitmentPage.candidateaddButton);
			enterText(RecruitmentPage.vacancyName, data.get("vacancyName"));
			click(RecruitmentPage.vacancyClick);
			waitForElementPresence(RecruitmentPage.jobTitle);
			selectByIndex(RecruitmentPage.jobTitle, data.get("Job Title"));
			click(RecruitmentPage.supervisorReviewer);
			enterText(RecruitmentPage.supervisorReviewer, data.get("Hiring Manager"));
			selectByIndex(RecruitmentPage.vacancyNameSearchTo, data.get("Hiring Manager"));
			elementToBeClickable(RecruitmentPage.supervisorReviewer);
			click(RecruitmentPage.recuritmentCandidateSaveButton);
			logger.info("Vacancies is added");
		} catch (Exception exception) {
			logger.error("Vacancies is not added"+exception);
		}
	}

	/**
	 * This method is to verify the vacancies created candidate
	 */

	public void verifyCreatedCandidate(HashMap<String, String> candidate) {
		try {
			String expectedValue = candidate.get("FirstName") + " " + candidate.get("MiddleName") + " "
					+ candidate.get("LastNamee");
			if (getText(RecruitmentPage.addedCandidateName).contains(expectedValue)) {
				logger.info("The " + expectedValue + " is added to the list");
			} else {
				logger.error("The " + expectedValue + " is not added to the list");
			}
		} catch (Exception exception) {
			logger.error("Created Candidate is not verified successfully" + exception);

		}
	}

	/**
	 * This method is to verify the vacancies created candidate vacancy
	 */

	public void verifyCandidateVacancy(HashMap<String, String> data) {
		try {
			click(RecruitmentPage.vacanciesTab);
			elementToBeClickable(RecruitmentPage.vacanciesTab);
			click(RecruitmentPage.searchHiringManager);
			selectByIndex(RecruitmentPage.hiringManager(data.get("Hiring Manager")), data.get("Hiring Manager"));
			click(RecruitmentPage.searchButton);
			String expectedValue = data.get("Hiring Manager");
			elementToBeClickable(RecruitmentPage.searchHiringManagerTo);
			if (getText(RecruitmentPage.searchHiringManagerTo).contains(expectedValue)) {
				logger.info("The " + expectedValue + " is added to the list");
			} else {
				logger.error("The " + expectedValue + " is not added to the list");
			}
		} catch (Exception exception) {
			logger.error("Candidate vacancy is not verified" + exception);
		}
	}

	/**
	 * This method is to search the created candidate
	 */

	public void searchCandidate(HashMap<String, String> data) {
		try {
			click(RecruitmentPage.candidatestab);
			String expectedName = data.get("FirstName" + " ");
			elementToBeClickable(RecruitmentPage.canditateNameSearchTextBox);
			enterText(RecruitmentPage.canditateNameSearchTextBox, expectedName);
			selectByIndex(RecruitmentPage.canditateNameSearchTo, expectedName);
			ClickVacancyDropDownButton();
			updateVacancyDropDown(data.get("vacancy"));
			click(RecruitmentPage.candidateSearchButton);
			logger.info("candidate got searched");
		} catch (Exception exception) {
			logger.error("Search Candidate is not done" + exception);
		}

	}

	/**
	 * This method is to delete the candidate
	 */

	public void deleteCandidate(HashMap<String, String> data) {
		try {
			searchCandidate(data);
			click(RecruitmentPage.deleteCheckBox);
			click(RecruitmentPage.deleteFile);
			click(RecruitmentPage.confirmDelete);
			logger.info("candidate is deleted");
		} catch (Exception exception) {
			logger.error("Candidate is not Deleted" + exception);
		}

	}

	/**
	 * This method is to delete the vacancy
	 */

	public void deleteVacancy(HashMap<String, String> data) {
		try {

			click(RecruitmentPage.vacanciesTab);
			elementToBeClickable(RecruitmentPage.searchHiringManager);
			click(RecruitmentPage.searchHiringManager);
			selectByIndex(RecruitmentPage.hiringManager(data.get("Hiring Manager")), data.get("Hiring Manager"));
			click(RecruitmentPage.searchButton);
			elementToBeClickable(RecruitmentPage.deleteCheckBox);
			click(RecruitmentPage.deleteCheckBox);
			click(RecruitmentPage.confirmDelete);
			click(RecruitmentPage.deleteSelected);
			click(RecruitmentPage.confirmDelete);
			logger.info("Candidate vacancy successfully deleted");
		} catch (Exception exception) {
			logger.error("Candidate vacancy is not Deleted" + exception);

		}
	}

	/**
	 * This method is to view the vacancy
	 */

	public void viewCandidate() {
		try {
			click(RecruitmentPage.viewRecord);
			click(RecruitmentPage.downloadFile);
			logger.info("Added candidate is Viewed");
		} catch (Exception exception) {
			logger.error("Added candidate is not Viewed" + exception);
		}
	}

	/**
	 * This method is to edit the vacancy
	 */

	public void editVacancy(HashMap<String, String> data) {
		try {

			click(RecruitmentPage.vacancyEdit);
			elementToBeClickable(RecruitmentPage.vacancyEditDescription);
			enterText(RecruitmentPage.vacancyEditDescription, data.get("Description"));
			click(RecruitmentPage.vacanciesSaveButton);
			logger.info("Candidate vacancy is edited");

		} catch (Exception exception) {
			logger.error("Candidate vacancy is not edited" + exception);

		}
	}

	/**
	 * This method is to download the file
	 */

	public void downloadFile() {
		try {
			click(RecruitmentPage.downloadFile);
			logger.info("File is downloaded");

		} catch (Exception exception) {
			logger.error("File is not downloaded" + exception);
		}
	}

	public void clickRecruitmentButton() {
		try {
			WebElement recruitmentbutton = driver.findElement((RecruitmentPage.recruitmentButton));
			recruitmentbutton.click();
			logger.info("Recruitment button is clicked");

		} catch (Exception exception) {
			logger.error("Recruitment button is not clicked" + exception);
		}

	}

	public void clickrecruitmentAddButton() {
		try {
			WebElement recruitmentAddButton = driver.findElement((RecruitmentPage.candidateaddButton));
			recruitmentAddButton.click();
			logger.info("RecruitmentAddButton is clicked");
		} catch (Exception exception) {
			logger.error("RecruitmentAddButton is not clicked" + exception);

		}

	}

	public void enterCandidateFirstname(String text) {
		try {
			enterText(RecruitmentPage.firstName, text);
			logger.info("CandidateFirstName is entered ");

		} catch (Exception exception) {
			logger.error("CandidateFirstNameis not entered " + exception);

		}
	}

	public void enterCandidateLastname(String text) {
		try {
			enterText(RecruitmentPage.lastName, text);
			logger.info("Candidate LastName is entered ");
		} catch (Exception exception) {
			logger.error("Candidate LastName is not entered " + exception);
		}
	}

	public void enterCandidateMiddlename(String text) {
		try {
			enterText(RecruitmentPage.middleName, text);
			logger.info("Candidate MiddleName is entered ");

		} catch (Exception exception) {
			logger.error("Candidate MiddleName is not entered " + exception);

		}
	}

	public void ClickVacancyDropDownButton() {
		try {
			WebElement vacancydropdownbutton = driver.findElement((RecruitmentPage.vacancyDropDown));
			vacancydropdownbutton.click();
			logger.info("Vacancy Dropdown Button is entered ");

		} catch (Exception exception) {
			logger.error("Vacancy Dropdown Button is not clicked" + exception);

		}
	}

	public void updateVacancyDropDown(String text) {
		try {

			selectByIndex(RecruitmentPage.vacancy, text);
			logger.info("Update Vacancy dropdown is clicked");
		} catch (Exception exception) {
			logger.error("Update Vacancy dropdown not clicked" + exception);

		}
	}

	public void entereMail(String text) {
		try {
			enterText(RecruitmentPage.eMail, text);
			logger.info("Email is entered");
		} catch (Exception exception) {
			logger.error("Email is not entered" + exception);

		}
	}

	public void enterContactNumber(String text) {
		try {
			waitForElementPresence(RecruitmentPage.ContactNumber);
			enterText(RecruitmentPage.ContactNumber, text);
			logger.info("Contactnumber is entered");

		} catch (Exception exception) {
			logger.error("Contact number is not entered" + exception);

		}
	}

	/**
	 * This method is to upload the file.
	 */

	public void uploadFile(String text) {
		try {
			waitForElementPresence(RecruitmentPage.browseUpload);
			click(RecruitmentPage.browseUpload);
			fileUpload(ConstantsValue.filePath);
			logger.info("File is uploaded");

		} catch (Exception exception) {
			logger.error("File is not uploaded" + exception);

		}
	}

	public void saveRecruitementCanditate() {
		try {

			click(RecruitmentPage.recuritmentCandidateSaveButton);
			logger.info("Recruitment save button is clicked");

		} catch (Exception exception) {
			logger.error("Recruitment Save Button is not clicked" + exception);

		}
	}

}
