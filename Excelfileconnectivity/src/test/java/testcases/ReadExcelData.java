 package testcases;

import org.testng.annotations.Test;

import utility.ExcelFileReader;

@Test
public class ReadExcelData {

	public void testReadExcelData() {

		ExcelFileReader data = new ExcelFileReader("./src/test/java/file/TestExecutionData.xlsx");
		
		System.out.println("--------to get the total number of rows-> totalRow(String sheetName)--------");
		
		int rows = data.totalRow("TestingData");
		
		System.out.println("Total Rows->"+rows);
		
		System.out.println("--------to get the total number of columns-> totalColumn(String sheetName)--------");

		int cols = data.totalColumn("TestingData");
		
		System.out.println("Total Columns->"+cols);
		
		System.out.println("--------to get the data from the specific cell-> getData(String SheetName,int rowNum,int colNum)--------");

		String cellData = data.getData("TestingData", 3, 1);
		
		System.out.println(cellData);
		System.out.println(data.getData("TestingData", 2, 2));

		
		System.out.println("--------to set the data into the cell-> setData(String SheetName,int rowNum,int colNum, String data)--------");

		
		data.setData("TestingData", 5, 0, "RegisterTest");
		data.setData("TestingData", 5, 1, "Register Test Description");
		data.setData("TestingData", 5, 2, "Y");
		
	
	}

}
  