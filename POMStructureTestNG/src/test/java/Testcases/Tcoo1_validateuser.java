package Testcases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basepackage.baseinit;
import pageobject.Homepage;
import pageobject.loginpage;
import pageobject.logoffpage;
import pageobject.welcomepage;

public class Tcoo1_validateuser extends baseinit{
	
	@BeforeClass
	public void setup() throws Exception
	{
		startup();
	}
	
	@Test
	public void validateuser() throws Exception
	{
		driver.get(sitedata.getProperty("url"));
	
		Homepage home = new Homepage(driver);
		
		home.lnk_clicklogyourselfin();
		
		
		loginpage login = new loginpage(driver);
		
		login.ip_setemail("shamsfive@gmail.com");
		login.ip_setpass("hiral@123");
		login.btn_clicksignin();
		
		boolean checkLogin = true;  //To check logged in is successfully or not check by boolean
		
		try
		{
			driver.findElement(By.linkText("Log Off")).isDisplayed();
			
		} 
		catch (Exception e) 
		{
			checkLogin = false;
		}
		
		if(checkLogin)  //If logged in successfully than go for next process in if part either else part will be execute
		{
		
			System.out.println("User is logged in successfully....");
			
			welcomepage welcome = new welcomepage(driver);
		
			welcome.lnk_clicklogoff();
		
			logoffpage logoff = new logoffpage(driver);
			
			Thread.sleep(5000);
			
			logoff.lnk_clickcontinue(); 
		}
		else
		{
			System.out.println("Invalid login ");
		}
	}

	/*@AfterClass
	public void endScript() throws Exception
	{
		endup();
	}*/
}
