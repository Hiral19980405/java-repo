package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Successorder {

	WebDriver driver;
	
	public Successorder(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="notify[]")
	@CacheLookup
	WebElement checkbox;
	
	@FindBy(id = "tdb1")
	@CacheLookup
	WebElement Continue;
	
	public void select_checkbox()
	{
		checkbox.click();
	}

	public void btn_continue()
	{
		Continue.click();
	}
}
