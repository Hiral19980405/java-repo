package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Paymentpage {
	
	WebDriver driver;
	
	public Paymentpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@name='payment'][@value='cod']")
	@CacheLookup
	WebElement cod;
	
	@FindBy(name="comments")
	@CacheLookup
	WebElement paycomm;
	
	@FindBy(id = "tdb2")
	@CacheLookup
	WebElement conti;
	
	public void select_cod()
	{
		cod.click();
	}
	
	public void ip_comment(String comm)
	{
		paycomm.sendKeys(comm);
	}
	
	public void btn_conti()
	{
		conti.click();
	}
	

}
