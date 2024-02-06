package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	
	WebDriver driver;
	
	public WelcomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}
	
	@FindBy(linkText = "Log Off")
	@CacheLookup
	WebElement logofflink;
	
	public void lnk_logoff()
	{
		logofflink.click();
	}
	

}
