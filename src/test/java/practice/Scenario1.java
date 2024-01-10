package practice;
//handle alter popups
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1 {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("(//input[@value='Login'])[2]")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
//		driver.findElement(By.xpath("//img[contains(@title,'Create Contact...')]")).click();
//		driver.findElement(By.xpath("//select[@name='salutationtype']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Vanitha");
//		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Manimaran");
//		driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		driver.findElement(By.xpath("(//input[@type='button'])[12]")).click();
		Thread.sleep(2000);
		Alert al = driver.switchTo().alert();
		al.accept();
		WebElement ele = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		



	}

}
