package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class SeleniumUtilities {
	/**
	 * This method will maximize the browser
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the browser
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method used to launch the browser in fullscreen
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	/**
	 * This method will wait for 10 seconds for all the web element to load
	 * @param driver
	 */
	public void addImplicitlywait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait for 10 seconds for a particular web element to become visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait for 10 seconds for a particular web element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will handle drop down by index
	 * @param element
	 * @param Index
	 */
	public void handleDropdown(WebElement element,int Index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(Index);
	}
	/**
	 * This method will handle drop down by value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will handle drop down by text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByValue(text);
	}
	/**This method will perform mouse over action on a web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**This method will perform right click action on a web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**This method will perform double click action on a web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param srcEle
	 * @param dstEle
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcEle, WebElement dstEle)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcEle, dstEle).perform();
	}
	/**
	 * This method will scroll down for 500 units
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,500);","");//java script snippet
	}
	/**
	 * This method will scroll up for 500 units
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,-500);","");//java script snippet
	}
	
	/** 
	 * This method will accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/** 
	 * This method will dismiss alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/** 
	 * This method will get the text in alert popup and return it to caller
	 * @param driver
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method will handle Frame By frame index
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver, int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	/**
	 * This method will handle Frame By frame Name or ID
	 * @param driver
	 * @param frameNameID
	 */
	public void handleFrame(WebDriver driver, String frameNameID)
	{
		driver.switchTo().frame(frameNameID);
	}
	/**
	 * This method will handle Frame By frame Element
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	/**
	 * This method will capture the screen shot and return the path to caller
	 * @param driver
	 * @param screenShotname
	 * @return
	 * @throws IOException 
	 */
	
	public String captureScreenShot(WebDriver driver, String screenShotname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);//temporary location
		File dst = new File(".\\Screenshots\\"+screenShotname+".png");//createContact-08-12-23-17-56.png
		Files.copy(src,dst);
		
		return dst.getAbsolutePath();
	}
	/**
	 * This method will switch the control to requires window based on Title
	 * @param driver
	 * @param exPartialTitle
	 */
	
	public void handleWindows(WebDriver driver, String exPartialTitle)
	{
		//capture all windows IDs
		Set<String> allWinIds= driver.getWindowHandles();
		
		//Navigate through each window ID
		for(String WinID:allWinIds)
		{
			//switch to each window ID and capture the title
			String actTitle = driver.switchTo().window(WinID).getTitle();
			
			//Compare the window Titles
			if(actTitle.contains(exPartialTitle))
			{
				break;
			}
		}
	}
	
	

}
