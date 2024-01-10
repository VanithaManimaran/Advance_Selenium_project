package contactsTests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtilities;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateContactPage;
import objectRepository.HomePage;
import objectRepository.Loginpage;

public class CreateContact {
	public static void main(String[] args) throws Throwable {
		/*Read common data from property file*/
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("url");
		String UN = pUtil.readDataFromPropertyFile("username");
		String PW = pUtil.readDataFromPropertyFile("password");
		
		/*Read test data from excel file*/
		ExcelFileUtility eF = new ExcelFileUtility();
		String LASTNAME = eF.readDataFromXlFile("Sheet1", 1, 2);

		//step 1:Launch the browser
		WebDriver driver = new EdgeDriver();
		SeleniumUtilities su = new SeleniumUtilities();
		su.maximizeWindow(driver);
		su.addImplicitlywait(driver);
		
		//step 2: Load the Application
		driver.get(URL);
		
		//step 3: Login to application
//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(UN);
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PW);
//		driver.findElement(By.xpath("(//input[@value='Login'])[2]")).click();
		
		Loginpage lp = new Loginpage(driver);
		lp.getUsernameEdt().sendKeys(UN);
		lp.getPasswordEdt().sendKeys(PW);
		lp.getLoginBtn().click();
		
		//lp.loginToApp(UN, PW);
		
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
		//step 8:Logout
		hp.logoutofApp(driver);
		
		//step 9:Close the browser
		driver.quit();

	}


}
