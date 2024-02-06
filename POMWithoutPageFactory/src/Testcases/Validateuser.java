package Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;

public class Validateuser {
	
	WebDriver driver;
	String url ="http://122.170.14.195:8080/uth/gadgetsgallery/catalog/index.php";

	@BeforeTest
	public void openBrowser()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}
	
	@Test
	public void testvalidateUser()
	
	{
			driver.findElement(By.linkText("log yourself in")).click();
			
			//creating obj for login page 
			//passing the constructor parameter because we had created constructor and has parameter 
			
			LoginPage login = new LoginPage(driver);
			
			login.clicksignin("shamsfive@gmail.com","hiral@123");
			
			
			
	}
	
	@AfterTest
	public void closeBrowser() throws Exception
	{
		
		Thread.sleep(2000);
		driver.close();
	}
	
}


