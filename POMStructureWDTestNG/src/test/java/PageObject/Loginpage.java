package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/* constructor
 * webelements
 * actions
 */

public class Loginpage {
	
	WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "email_address")
	@CacheLookup
	WebElement emailadd;
	
	public void ip_email(String email)
	{
		emailadd.sendKeys(email);
	}
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement pass;
	
	public void ip_pass(String password)
	{
		pass.sendKeys(password);
	}
	
	@FindBy (id = "tdb1")
	@CacheLookup
	WebElement signin;
	
	public void btn_sign()
	{
		signin.click();
		
	}
	
	
}
