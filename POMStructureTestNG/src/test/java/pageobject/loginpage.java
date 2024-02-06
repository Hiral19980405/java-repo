//'
package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class loginpage {
	
	WebDriver driver;
		
	public loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(name="email_address")
	@CacheLookup
	WebElement email;
	
	@FindBy(name= "password")
	@CacheLookup
	WebElement pass;
	
	@FindBy(id = "tdb1")
	@CacheLookup
	WebElement signin;
	
	
	public void ip_setemail(String emailadd)
	{
		email.sendKeys(emailadd);
	}
	
	public void ip_setpass(String password)
	{
		pass.sendKeys(password);
	}
	
	public void btn_clicksignin()
	{
		signin.click();
	}
	
	
}
