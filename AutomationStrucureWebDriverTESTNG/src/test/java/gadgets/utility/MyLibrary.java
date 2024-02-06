 package gadgets.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import gadgets.basepackage.baseinit;

public class MyLibrary extends baseinit{

	public static void SignIn(String email,String pass)
	{
		//driver.findElement(By.linkText("log yourself in")).click();
		//driver.findElement(By.linkText("lnk_loginyourselfin_linkText")).click();
		
		isElementmethod("lnk_loginyourselfin_linkText").click();
		isElementmethod("ip_emailaddress_name").sendKeys(email);
		isElementmethod("ip_password_name").sendKeys(pass);
		isElementmethod("btn_signin_id").click();
		
	}
	
	public static void signout()
	{
		isElementmethod("lnk_logoff_linkText").click();
		isElementmethod("lnk_continue_id").click();
	}
	
	
	public static String getScreenshot(String imageName,WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;

		File srcFile = ts.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots"+imageName+System.currentTimeMillis()+".png";

		//System.out.println(path);

		File destination = new File(path);

		try
		{
			FileHandler.copy(srcFile, destination);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return path;
	}
	
	
}
