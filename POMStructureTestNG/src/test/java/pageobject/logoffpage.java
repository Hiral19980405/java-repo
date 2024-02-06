package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logoffpage {
	
	WebDriver driver;
	
	public logoffpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id = "tdb1")
	@CacheLookup
	WebElement lnkcontinue;
	
	public void lnk_clickcontinue()
	{
		lnkcontinue.click();
	}
}
