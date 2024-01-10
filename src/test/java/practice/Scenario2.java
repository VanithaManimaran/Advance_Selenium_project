package practice;
//save the contact
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2 {

	public static void main(String[] args) {
		//step 1:Launch the browser
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step 2: Load the Application
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		
		//step 3: Login to application
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("(//input[@value='Login'])[2]")).click();
		
		//step 4: Click on contact link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//step 5:Click on create contact look image
		driver.findElement(By.xpath("//img[contains(@title,'Create Contact...')]")).click();
		//driver.findElement(By.xpath("//select[@name='salutationtype']")).click();
		
		//step 6: Enter mandatory data
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Vanitha");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Manimaran");
		
		//step 7: save
		driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		
		//step 8:Validate
		String ele =  driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ele.contains("Manimaran Vanitha"))
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
