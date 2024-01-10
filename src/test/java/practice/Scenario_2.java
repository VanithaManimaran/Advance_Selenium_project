package practice;
//Edit the contact
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Scenario_2 {

	public static void main(String[] args) throws InterruptedException {
		//step 1: Setup browser and load the application
		EdgeDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");

		//step 2: Login to the application
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("(//input[@value='Login'])[2]")).click();

		//step 3: Contact link
		driver.findElement(By.linkText("Contacts")).click();

		//step 4:search for contact
		driver.findElement(By.name("search_text")).sendKeys("vanitha");
		WebElement dropdown = driver.findElement(By.id("bas_searchfield"));
		Select s = new Select(dropdown);
		s.selectByIndex(1);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(5000);

		//step 5:select filtered contact and edit the contact
		driver.findElement(By.name("selected_id")).click();
		driver.findElement(By.xpath("//input[@value='Mass Edit']")).click();
		driver.findElement(By.name("firstname_mass_edit_check")).click();
		driver.findElement(By.name("firstname")).sendKeys("va");
		driver.findElement(By.name("button")).click();
		//step 6:Verify the contact
		String ele =  driver.findElement(By.xpath("(//a[@title='Contacts'])[1]")).getText();
		if(ele.contains("va"))
		{
			System.out.println(ele);
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		//step 7: Logout the application
		WebElement ele1 = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		Actions a = new Actions(driver);
		a.moveToElement(ele1).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		//step 8:Close the browser
		driver.quit();


	}

}
