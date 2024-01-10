package contactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateContactPage;
import objectRepository.HomePage;


public class CreateContact_BaseCls extends BaseClass {

	@Test
	public void CreateContactWithMandatoryField() throws Throwable
	 {
		/*Read test data from excel file*/
		ExcelFileUtility eF = new ExcelFileUtility();
		String LASTNAME = eF.readDataFromXlFile("Sheet1", 1, 2);
			
		//step 4: Click on contact link
		HomePage hp = new HomePage(driver);
		hp.ClickOnContactLink();
		//step 5:Click on create contact look image
		ContactPage cp = new ContactPage(driver);
		cp.addContact(driver);
		//step 6: Enter mandatory data
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createNewContact(LASTNAME);
		
		//step 7:Validate
		ContactInfoPage ci = new ContactInfoPage(driver);
		String contactHeader = ci.captureHeadertext();
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println(contactHeader);
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}

	}


}
