package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//*[contains(text(),'JBL T250SI')]//parent::td//following-sibling::td[2]/span/a")
	@CacheLookup
	WebElement buynow;

	public void Click_buynow()
	{
		buynow.click();
	}
}
