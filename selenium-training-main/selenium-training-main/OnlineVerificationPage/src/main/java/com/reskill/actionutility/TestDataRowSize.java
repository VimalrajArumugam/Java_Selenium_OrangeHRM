package com.reskill.actionutility;

import java.util.List;
import java.util.Map;

import com.reskill.reusables.ExcelUtility;

public class TestDataRowSize {
	ExcelUtility testdata = new ExcelUtility();

	@SuppressWarnings("null")
	public int dataSetRowSize(int givendata) {

		List<Map<String, String>> dataSetTD = null;
		dataSetTD = testdata.readExcelData();
		int rowCount = dataSetTD.size();
		System.out.println("Total Row Count : " + rowCount);
		if (givendata == 0) {
			System.out.println("NO data set found in data table ");
		} else if (rowCount >= givendata) {
			return givendata;
		} else if (rowCount < givendata) {
			givendata = rowCount;
			return givendata;
		}
		return (Integer) null;
	}
}
