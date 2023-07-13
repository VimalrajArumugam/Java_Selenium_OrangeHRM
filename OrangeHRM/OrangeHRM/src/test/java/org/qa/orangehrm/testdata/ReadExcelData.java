package org.qa.orangehrm.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.qa.orangehrm.basetest.BaseTest;
import org.qa.orangehrm.constants.ConstantsValue;

public class ReadExcelData {
	/**
	 * This method is used for read data from Excel
	 * @param-TestcaseID
	 * 
	 */

	static Logger logger = Logger.getLogger(BaseTest.class);

	static HashMap<String, String> data = null;

	public static HashMap<String, String> getUserData(String TestCaseID) {
		try {
			File file = new File(ConstantsValue.testDataPath);
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet(ConstantsValue.testDataSheet);
			data = new HashMap<String, String>();

			for (int row = 0; row <= sheet.getLastRowNum(); row++) {

				// Unique Field for particular test case
				String testCase = sheet.getRow(row).getCell(0).getStringCellValue();

				if (testCase.contains(TestCaseID)) {
					for (int index = 1; index < sheet.getRow(0).getLastCellNum(); index++) {

						String key = sheet.getRow(0).getCell(index).getStringCellValue();
						Cell CellValue = sheet.getRow(row).getCell(index);

						String value = null;
						if (CellValue != null) {
							value = CellValue.getStringCellValue();
						}
						data.put(key, value);
					}
				}
			}
			workbook.close();

		} catch (Exception e) {
//			logger.error("Excel read is not performed");
		}

		return data;
	}
	/**
	 * This method is used for read data from Excel
	 * @param-SheetName
	 * @param-TestCaseID
	 * 
	 * 
	 */

	public static HashMap<String, String> getUserData(String TestCaseID, String sheetName) {
		try {
			File file = new File(ConstantsValue.testDataPath);
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			data = new HashMap<String, String>();

			for (int row = 0; row <= sheet.getLastRowNum(); row++) {

				// Unique Field for particular test case
				String testCase = sheet.getRow(row).getCell(0).getStringCellValue();

				if (testCase.contains(TestCaseID)) {
					for (int index = 1; index < sheet.getRow(0).getLastCellNum(); index++) {

						String key = sheet.getRow(0).getCell(index).getStringCellValue();
						Cell CellValue = sheet.getRow(row).getCell(index);

						String value = null;
						if (CellValue != null) {
							value = CellValue.getStringCellValue();
						}
						data.put(key, value);
					}
				}
			}
			workbook.close();

		} catch (Exception e) {
			logger.error("Exception");
		}

		return data;
	}
	/**
	 * This method is used for read data from Excel
	 * @param-SheetName
	 * 
	 * 
	 */


	public static List<Map<String, String>> getExcelData(String sheetName) {
		List<Map<String, String>> testDataAllRows = null;
		Map<String, String> testData = null;
		String filePath = ConstantsValue.testDataPath;
		try {
			FileInputStream fielInputStream = new FileInputStream(filePath);
			Workbook workbook = new XSSFWorkbook(fielInputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getPhysicalNumberOfRows();
			int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
			List<String> headers = new ArrayList<String>();
			for (int index = 0; index < columnCount; index++) {
				Row titleRow = sheet.getRow(0);
				Cell titleCell = titleRow.getCell(index);
				String headerData = titleCell.getStringCellValue();
				headers.add(headerData);
			}
			testDataAllRows = new ArrayList<Map<String, String>>();

			for (int row = 1; row < rowCount; row++) {
				Row rowData = sheet.getRow(row);
				testData = new LinkedHashMap<String, String>();
				for (int column = 0; column < columnCount; column++) {
					Cell cell = rowData.getCell(column);
					String data = cell.getStringCellValue();
					testData.put(headers.get(column), data);
				}
				testDataAllRows.add(testData);
			}
			workbook.close();
		} catch (FileNotFoundException fileNotFoundException) {
			logger.error("File not found Exception occured on excel file read");
		} catch (IOException ioException) {
			logger.error("IO exception occured on excel file read");
		} catch (Exception exception) {
			logger.error("Excel read is not performed");
		}
		return testDataAllRows;
	}
}
