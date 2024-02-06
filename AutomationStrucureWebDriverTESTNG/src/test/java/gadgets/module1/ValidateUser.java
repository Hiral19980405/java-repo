package gadgets.module1;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import gadgets.basepackage.baseinit;
import gadgets.utility.MyLibrary;

public class ValidateUser extends baseinit{
	
	@BeforeTest
	public void setup() throws Exception
	{
		startup();
	}
	
	@Test
	public void testvalidateUser()
	{
		MyLibrary. SignIn(sitedata.getProperty("username"),sitedata.getProperty("password"));
		
		try
		{
			boolean checklogin = isElementmethod("lnk_loginyourselfin_linkText").isDisplayed();
			System.out.println("User logged in successfully");
			MyLibrary.getScreenshot("Loggedinscreenshot", driver);
			logs.info("User logged in successfully");
			
			MyLibrary.signout();
			
			
			
		}
		catch(Exception e)
		{
			driver.findElement(By.linkText("Home")).click();
			System.out.println("Invalid email address and password");
			MyLibrary.getScreenshot("Couldnot login", driver);
			logs.info("Invalid email address and password");
			
		}
	
	
	
	}

	



}
