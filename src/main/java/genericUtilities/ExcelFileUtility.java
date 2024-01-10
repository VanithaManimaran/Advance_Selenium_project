package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consists of reusable methods related to excel file
 */
public class ExcelFileUtility {
	/**
	 * This method will read data from excel file and return value to caller
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @throws Throwable
	 */
	
	public String readDataFromXlFile(String sheetName, int rowNum,int cellNum) throws Throwable, Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Scanner s = new Scanner(System.in);
		String value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
		
		
	}
	

}
