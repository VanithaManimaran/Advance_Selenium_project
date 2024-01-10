package practice;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;

public class GenericUtilitiesExcel {

	public static void main(String[] args) throws Throwable {
		ExcelFileUtility Eu = new ExcelFileUtility();
		String value = Eu.readDataFromXlFile("Sheet1",1,1);
		System.out.println(value);
		
		JavaUtility ju = new JavaUtility();
		String date = ju.getSystemDate();
		System.out.println(date);

	}

}
