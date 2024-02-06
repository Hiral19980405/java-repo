package testcases;

import utility.ExcelFileReader;

public class ReadAllData {

	public static void main(String[] args) {

		String sheetName = "TestingData";
		ExcelFileReader data = new ExcelFileReader("./src/test/java/file/TestExecutionData.xlsx");
		
		int rows = data.totalRow(sheetName);
		int cols = data.totalColumn(sheetName);
		
		for(int row=1;row<rows;row++)
		{
			for(int col=0;col<cols;col++)
			{
				System.out.print(data.getData(sheetName, row, col)+"     ");
			}
			
			System.out.println();
		}
		
	}

}
