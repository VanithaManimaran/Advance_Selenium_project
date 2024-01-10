package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.Loginpage;

public class BaseClass {
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtilities sUtil = new SeleniumUtilities();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	
	public WebDriver driver;
	@BeforeSuite(alwaysRun = true)//run for all group
	public void bsConfig()
	{
		System.out.println("====DB connection successful====");
		
	}
	//@Parameters("Browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	//public void bcConfig(String Browser) throws IOException
	public void bcConfig() throws IOException
	{
		String URL = pUtil.readDataFromPropertyFile("url");
		
		driver = new EdgeDriver();
		
//		if(Browser.equalsIgnoreCase("Edge"))
//		{
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver(); 
//		}
//		else if(Browser.equalsIgnoreCase("Chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
		
		
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlywait(driver);
		
		driver.get(URL);
		System.out.println("=====Browser Launched=====");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		Loginpage lp = new Loginpage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("=====Login Successfully=====");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws Throwable
	{
		HomePage hp = new HomePage(driver);
		hp.logoutofApp(driver);
		
		System.out.println("=====logout successfully=====");
	}
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("=====Browser Closed=====");
	
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("=====DB connection closed=====");
		
	}
		
	

}
