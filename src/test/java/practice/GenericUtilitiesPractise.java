package practice;

import java.io.IOException;

import genericUtilities.PropertyFileUtility;

public class GenericUtilitiesPractise {

	public static void main(String[] args) throws IOException {
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String value = pUtil.readDataFromPropertyFile("username");
		System.out.println(value);
		

	}

}
