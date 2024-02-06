package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shoppingcart {
	
	WebDriver driver;
	
	public Shoppingcart(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "cart_quantity[]")
	@CacheLookup
	WebElement quntity;

	@FindBy(id = "tdb1")
	@CacheLookup
	WebElement update;
	
	@FindBy(id = "tdb2")
	@CacheLookup
	WebElement checkout;
	
	public void ip_quntity(String qun)
	{
		quntity.clear();
		quntity.sendKeys(qun);
	}

	public void btn_clickupdate()
	{
		update.click();
	}
	
	public void btn_clickcheckout()
	{
		checkout.click();
	}

	
}

