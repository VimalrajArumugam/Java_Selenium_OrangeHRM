package com.reskill.reusables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	DataFormatter dataformater = new DataFormatter();
	List<Map<String, String>> testdata = null;
	Map<String, String> cellValues = null;

	public  List<Map<String, String>> readExcelData()  {

		String porjectpath = System.getProperty("user.dir");
		FileInputStream inputstream = null;
		try {
			inputstream = new FileInputStream( porjectpath + "/src/main/java/com/reskill/testdata/StudentRegistrationTestData.xlsx");
		} catch (FileNotFoundException e) {
			System.out.println("StudentRegistratinTestData fiel not found in given path :");
			e.printStackTrace();
		}
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputstream);
		} catch (IOException e) {
			System.out.println("Test Data IO Exception: ");
		}
		XSSFSheet sheet = workbook.getSheet("RegForm");
		int rowCount = sheet.getLastRowNum();
		int columCount = sheet.getRow(0).getLastCellNum();

		// Heaader Row Values
		List<String> headder = new ArrayList<String>();
		for (int cell = 0; cell < columCount; cell++) {
			String headderrow = dataformater.formatCellValue(sheet.getRow(0).getCell(cell));
			headder.add(headderrow);
		}
		//Each Cell Values
		testdata = new ArrayList<Map<String, String>>();
		for (int row = 1; row <= rowCount; row++) {
			cellValues = new HashMap<String, String>();
			for (int col = 0; col < columCount; col++) {
				String rowvalue = dataformater.formatCellValue(sheet.getRow(row).getCell(col));
				cellValues.put(headder.get(col), rowvalue);
			}
			testdata.add(cellValues);
		}
		try {
			workbook.close();
		} catch (IOException e) {
			System.out.println("Test Data IO Exception: ");
		}
		return testdata;
	}
}
