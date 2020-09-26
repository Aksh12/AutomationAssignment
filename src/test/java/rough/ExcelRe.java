package rough;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class ExcelRe {
	
	String xData_TS[][];
	int xRows_TD, xCols_TD;
	String xData_TD[][];
	
	public void xlRead_TD(String sPath, int sSheet) throws Exception{
		File myxl = new File(sPath);
		FileInputStream myStream = new FileInputStream(myxl);
		HSSFWorkbook myWB = new HSSFWorkbook(myStream);
		HSSFSheet mySheet = myWB.getSheetAt(sSheet);	// Referring to 2nd sheet

		xRows_TD = mySheet.getLastRowNum()+1;
		xCols_TD = mySheet.getRow(0).getLastCellNum();
		//System.out.println("Rows are " + xRows_TD);
		//System.out.println("Cols are " + xCols_TD);
		xData_TD = new String[xRows_TD][xCols_TD];
        for (int i = 0; i < xRows_TD; i++) {
	           HSSFRow row = mySheet.getRow(i);
	            for (int j = 0; j < xCols_TD; j++) {
	               HSSFCell cell = row.getCell(j); // To read value from each col in each row
	               String value = cellToString(cell);
	               xData_TD[i][j] = value;
	             //  System.out.print(value);
	               System.out.print("  ");
	               }
	            System.out.println("");
	        }	
	}
	
	public static String cellToString(HSSFCell cell) {
		   CellType type = cell.getCellType();
	        Object result;
	        switch (type) {
	            case NUMERIC:
	                result = cell.getNumericCellValue();
	                break;
	            case STRING: 
	                result = cell.getStringCellValue();
	                break;
	            case FORMULA: 
	                throw new RuntimeException("We can't evaluate formulas in Java");
	            case BLANK: 
	                result = "-";
	                break;
	            case BOOLEAN: 
	                result = cell.getBooleanCellValue();
	                break;
	            case ERROR: 
	                throw new RuntimeException ("This cell has an error");
	            default:
	                throw new RuntimeException("We don't support this cell type: " + type);
	        }
	        return result.toString();
	    }
}
