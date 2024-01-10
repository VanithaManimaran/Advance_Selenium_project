package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement addcontactBtn;
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddcontactBtn() {
		return addcontactBtn;
	}
	
	//Business Library
	public void addContact(WebDriver driver)
	{
		addcontactBtn.click();
	}

}
