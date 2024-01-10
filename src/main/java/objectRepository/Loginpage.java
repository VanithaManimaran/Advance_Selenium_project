package objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {//Rule 1:
	
	//Rule 2:identificetion/Declaration
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement loginBtn;
	
	//Rule 3: cretae construtor for initialization 
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//step 4: utilization
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//step 5: Busines  Library-Generic method- operate on elements in current pom class only
	//This method will perform login operation
	public void loginToApp(String UN, String PW)
	{
		usernameEdt.sendKeys(UN);
		passwordEdt.sendKeys(PW);
		loginBtn.click();
	}
	

}
