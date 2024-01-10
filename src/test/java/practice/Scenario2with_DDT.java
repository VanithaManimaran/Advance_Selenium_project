package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2with_DDT {
	public static void main(String[] args) throws IOException {
		
		/*Read common data from property file*/
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL =p.getProperty("url");
		String UN = p.getProperty("username");
		String PW = p.getProperty("password");
		
		/*Read test data from excel file*/
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
		String LASTNAME = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();

		//step 1:Launch the browser
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step 2: Load the Application
		driver.get(URL);
		
		//step 3: Login to application
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PW);
		driver.findElement(By.xpath("(//input[@value='Login'])[2]")).click();
		
		//step 4: Click on contact link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//step 5:Click on create contact look image
		driver.findElement(By.xpath("//img[contains(@title,'Create Contact...')]")).click();
		
		//step 6: Enter mandatory data
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
		
		//step 7: save
		driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		
		//step 8:Validate
		String ele =  driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ele.contains(LASTNAME))
		{
			System.out.println(ele);
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		//step 9:Logout
		WebElement ele1 = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		Actions a = new Actions(driver);
		a.moveToElement(ele1).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		//step 10:Close the browser
		driver.quit();
			

		



	}


}
