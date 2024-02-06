package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Loginpage {
	
	
	WebDriver driver;
	
	//Create constructor
	public Loginpage(WebDriver driver)
	{
		this.driver = driver;
	}

	//First way to define WebElement
	@FindBy(name="email_address")
	@CacheLookup
	WebElement email;
	
	//Second way to define WebElement  name locator from How class
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(id="tdb1")
	@CacheLookup
	WebElement signin;
	
	@FindBy(linkText = "Password forgotten? Click here.")
	@CacheLookup
	WebElement passwordforgotten;
	
	@FindBy(id="tdb1")
	@CacheLookup
	WebElement con;
	
	//Create methods for actions
	
	public void signin(String emailadd,String psw)
	{
		email.sendKeys(emailadd);
		password.sendKeys(pwd);
		signin.click();
		
	}
	
	public void passwordforgotten()
	{
		passwordforgotten.click();
	}
	
	public void continue()
	{
		con.click();
	}
	
	
	
}
 