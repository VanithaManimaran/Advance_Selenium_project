package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtilities;

public class HomePage extends SeleniumUtilities {
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement LogoutImg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement SignoutLink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getLogoutImg() {
		return LogoutImg;
	}

	public WebElement getSignoutLink() {
		return SignoutLink;
	}
	
	//Businees library
	/**
	 * This method will click on contacts link
	 */
	public void ClickOnContactLink()
	{
		contactLink.click();
	}
	/**
	 * This method will perform sign-out operation
	 * @param driver
	 * @throws InterruptedException
	 */
	
	public void logoutofApp(WebDriver driver) throws InterruptedException
	{
		mouseOverAction(driver, LogoutImg);
		Thread.sleep(1000);
		SignoutLink.click();
	}
	
	

}
