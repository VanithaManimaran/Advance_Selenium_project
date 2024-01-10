package contactsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateContactPage;
import objectRepository.HomePage;

public class CreateContact_LeadSourcxe extends BaseClass{
	
	@Test(groups = {"RegressionSuite","SmokeSuite"})
	public void createContactwithLead() throws Throwable
	{
		String LASTNAME = eUtil.readDataFromXlFile("Sheet1", 4, 2);
		eUtil.readDataFromXlFile("Sheet1", 4, 3);
			
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
		
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
	}
	

}
