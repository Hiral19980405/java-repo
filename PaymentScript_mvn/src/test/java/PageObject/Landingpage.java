package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {

	WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Account & Lists")
	@CacheLookup
	WebElement signin;
	
	
	public void btn_signin()
	{
		signin.click();
	}


	
	
	
	
}
