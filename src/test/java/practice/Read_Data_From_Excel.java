package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_Data_From_Excel {

	public static void main(String[] args) throws IOException {
		//step 1:Open the document as java readable
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//step 2: Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		//step 3: Navigate to required sheet
		Sheet sh = wb.getSheet("Sheet1");
		//step 4:Navigate to required row
		Row rw = sh.getRow(1);
		//step 5:Navigate to required cell
		Cell cl = rw.getCell(2);
		//step 6: Capture the data inside the cell
		String value = cl.getStringCellValue();
		System.out.println(value);
		
		//get data in single line of program(optional)

		String id = wb.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
		String tc_name = wb.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		String name = wb.getSheet("Sheet1").getRow(0).getCell(2).getStringCellValue();
		System.out.println(id);
		System.out.println(tc_name);
		System.out.println(name);
		//step 7:Close the workbook
		wb.close();



	}

}
