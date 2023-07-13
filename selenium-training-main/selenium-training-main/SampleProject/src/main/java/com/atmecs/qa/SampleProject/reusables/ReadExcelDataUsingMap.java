package com.atmecs.qa.SampleProject.reusables;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataUsingMap {
	public List<Map<String, String>> getTestData() {
		List<Map<String, String>> testDataAllRows = null;
		Map<String, String> testData = null;
		DataFormatter dataformater = new DataFormatter();
//		File file = new File("C:\\Users\\venkata.kalla\\Desktop\\userdata.xlsx");
		File file = new File("./src/main/resources/userRegistrationTestData.xlsx");
		FileInputStream inputstream = null;
		try {
			inputstream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found in the given path: ");
		}
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputstream);
		} catch (IOException e) {
			System.out.println("IO Exception(Input/Output)");
		}
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int lastRownumber = sheet.getLastRowNum();
		int lastCellNumber = sheet.getRow(0).getLastCellNum();

		List<String> list = new ArrayList<>();
		for (int celnum = 0; celnum < lastCellNumber; celnum++) {
			Row row = sheet.getRow(0);
			String rowHeadder = row.getCell(celnum).getStringCellValue().trim();
			list.add(rowHeadder);
//			 System.out.println(rowHeadder);		
		}
//		System.out.println(list.get(0));
		testDataAllRows = new ArrayList<Map<String, String>>();
		for (int rownum = 1; rownum <= lastRownumber; rownum++) {
			Row row = sheet.getRow(rownum);
			testData = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
			for (int colnum = 0; colnum < lastCellNumber; colnum++) {
				String columValue = dataformater.formatCellValue(row.getCell(colnum)).trim();

//				System.out.println(columValue+"------------");
				testData.put((String) list.get(colnum), columValue);
			}
//			System.out.println(testData.get("UserName"));
			testDataAllRows.add(testData);
		}
//		System.out.println(testDataAllRows);
		try {
			workbook.close();
		} catch (IOException e) {
			System.out.println("IO Exception(Input/Output)");
		}

		return testDataAllRows;

	}
}
