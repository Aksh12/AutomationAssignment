package utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {

	public static ExcelReader excel = new ExcelReader(Constants.SUITE_XL_PATH);
	
	@DataProvider
	public static Object[][] getData() {
		String sheetName = "Data";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for( int rowNum=2; rowNum<=0; rowNum++) {
			
			for( int colNum=2; colNum<=0; colNum++) {
				data [rowNum-2] [colNum] = excel.getCellData(sheetName, colNum, rowNum);
				
			}
		}
		
		return data;

		
	
	}
	
}
