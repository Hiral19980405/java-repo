package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shippingpage {
	
	WebDriver driver;
	
	public Shippingpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "comments")
	@CacheLookup
	WebElement comment;
	
	@FindBy(id = "tdb2")
	@CacheLookup
	WebElement con;
	
	public void ip_comment(String comm)
	{
		comment.sendKeys(comm);
	}
	
	public void btn_con()
	{
		con.click();
	}

}
