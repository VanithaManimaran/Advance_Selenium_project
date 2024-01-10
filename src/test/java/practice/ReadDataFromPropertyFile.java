package practice;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Throwable {
		//step1: open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//step 2: Create Object of property class from java.util
		Properties p = new Properties();
		//step 3: Load the file input stream to property class
		p.load(fis);
		// step 4: Provide key and read the value
		String value = p.getProperty("username");
		String value1 = p.getProperty("password");
		String value2 = p.getProperty("abc");
		System.out.println(value);
		System.out.println(value1);
		System.out.println(value2);

	}

}
