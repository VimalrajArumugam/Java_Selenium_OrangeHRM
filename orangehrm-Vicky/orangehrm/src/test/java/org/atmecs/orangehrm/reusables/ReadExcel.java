package org.atmecs.orangehrm.reusables;

import java.util.Map;
import java.util.TreeMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ReadExcel {
	public Map<String, String> getTestDataInMap(String testDataFile, String sheetName, String testcaseId) throws Exception {
	    Map<String, String> TestDataInMap = new TreeMap<String, String>();
	    String query = null;
	    query = String.format("SELECT * FROM %s WHERE Status='True' and TestCaseId='%s'",
	            sheetName, testcaseId);
	    Fillo fillo = new Fillo();
	    Connection conn = null;
	    Recordset recordset = null;
	    try {
	        conn = fillo.getConnection(testDataFile);
	        recordset = conn.executeQuery(query);
	        while (recordset.next()) {
	            for (String field : recordset.getFieldNames()) {
	                TestDataInMap.put(field, recordset.getField(field));
	            }
	        }
	    } catch (FilloException e) {
	        e.printStackTrace();
	        throw new Exception("Test data cannot find . . .");
	    }
	    conn.close();
	    return TestDataInMap;
	}
	
	
	public static void main(String[] args) throws Exception {
//		Map<String,String> testDataMap = getTestDataInMap("D:\\pretium-training\\orangehrm\\src\\main\\resource\\org\\atmecs\\orangehrm\\data\\Test.xlsx","AdminTab","ORM_01");
//		System.out.println(testDataMap.get("Name"));
	}
	


}
