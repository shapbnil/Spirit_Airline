package pageFactory;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperation {
	public XSSFSheet readDataFromExcel(String filePath, String sheetName) {
		XSSFSheet sheet =null;
		
		try {
			FileInputStream file = new FileInputStream(new File(filePath));
			
			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			// First get desired sheet form the workbook
			sheet = workbook.getSheet(sheetName);
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Read operations File InputStream
		return sheet;
		
	}

}
