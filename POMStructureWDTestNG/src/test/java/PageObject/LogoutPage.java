package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	WebDriver driver;
	
	public LogoutPage()
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(linkText = "Continue")
	@CacheLookup
	WebElement contin;
	
	public void lnk_continue()
	{
		contin.click();
		
	}
}
