package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	 By emailadd = By.name("email_address");
	 By pass = By.name("password");
	 By signin = By.id("tdb1");
	 By lnk_passforgotten = By.linkText("Password forgotten? Click here.");
	 By Btn_continue = By.id("tdb2");
	 
	WebDriver driver = null;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
	}

	public void clicksignin(String email,String password)
	{
		driver.findElement(emailadd).sendKeys(email);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(signin).click();
	}
	
	public void clickpasswordforgotten()
	{
		driver.findElement(lnk_passforgotten).click();
	}
	
	public void clickcontinue()
	{
		driver.findElement(Btn_continue).click();
	}
}
