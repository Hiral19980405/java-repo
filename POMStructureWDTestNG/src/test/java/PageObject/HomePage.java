package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test

public class HomePage {
	
	WebDriver driver; //global driver
	
	public HomePage(WebDriver driver) //local driver
	{
		this.driver = driver;
		PageFactory.initElements(driver,this );
		
	}
	
	@FindBy(linkText = "log yourself in")
	@CacheLookup
	WebElement loginyrselfin;
	
	public void lnk_loginyrself()
	{
		loginyrselfin.click();
	}
	
	@FindBy(linkText = "create an account")
	@CacheLookup
	WebElement createyracc;
	
	public void lnk_createanaccount()
	{
		createyracc.click();
	}

}
