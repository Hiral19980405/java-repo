package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderconfirmation {
	
	WebDriver driver;
	
	public orderconfirmation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id= "tdb3")
	@CacheLookup
	WebElement confirmorder;
	
	public void btn_confirm()
	{
		confirmorder.click();
	}
	
	
}
