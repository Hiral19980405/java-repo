package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class welcomepage {

	WebDriver driver;
	
	public welcomepage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(linkText = "Log Off")
	@CacheLookup
	WebElement logofflnk;
	
	
	public void lnk_clicklogoff()
	{
		logofflnk.click();
	}
}
