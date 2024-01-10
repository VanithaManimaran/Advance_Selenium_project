package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	@FindBy(name="lastname")
	private WebElement lastnameText;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastnameText() {
		return lastnameText;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Busineess Library
	/**
	 * This method will create a new contact and save it
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		lastnameText.sendKeys(LASTNAME);
		saveBtn.click();
	}

}
