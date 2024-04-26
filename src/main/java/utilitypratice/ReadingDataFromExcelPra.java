package utilitypratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcelPra {
	
	public static void main(String[] args) throws Throwable {
		
		String path ="C:\\Users\\Dell\\OneDrive\\Desktop\\AutomationSelenium\\New folder\\Selenium.xlsx.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Login");
		int rowcount= sheet.getLastRowNum();
		int coulcount= sheet.getRow(0).getLastCellNum();
		
		for(int i=0; i<rowcount; i++) {
			XSSFRow row= sheet.getRow(i+1);
			for(int j=0; j<coulcount; j++) {
				XSSFCell cell =row.getCell(j);
				
				switch(cell.getCellType()) {
				case STRING: System.out.print(cell.getStringCellValue());
				      break;
				case NUMERIC: System.out.print(cell.getNumericCellValue());
				     break;
				}
				System.out.print ("   |    ");
				
			}
			System.out.println("");
		}
				
	}

}
