package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement continfoText;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getContinfoText() {
		return continfoText;
	}
	
	//Business Library
	/**
	 * This method will capture the header text and return it to caller
	 * @return
	 */
	
	public String captureHeadertext()
	{
		return continfoText.getText();
	}

}
