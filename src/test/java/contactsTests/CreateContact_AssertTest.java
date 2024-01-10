package contactsTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateContactPage;
import objectRepository.HomePage;

//@Listeners(genericUtilities.ListnerImplementation.class)
public class CreateContact_AssertTest extends BaseClass{
	@Test(groups = "SmokeSuite")
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
		
		//Assert.fail();
		//step 7:Validate
		ContactInfoPage ci = new ContactInfoPage(driver);
		String contactHeader = ci.captureHeadertext();
		
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);

	}

	
}
