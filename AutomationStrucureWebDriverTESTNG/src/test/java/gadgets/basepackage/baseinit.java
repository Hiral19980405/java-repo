package gadgets.basepackage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseinit {
	
	public static Properties sitedata;
	public static WebDriver driver;
	public static Logger logs;

	public void startup() throws Exception
	{
		logs = Logger.getLogger("devpinoyLogger");
		
		logs.info("Properties file will be loaded....."); 
		
		sitedata = new Properties();
		FileInputStream fi =new FileInputStream(".\\src\\test\\resources\\propertiesdata\\sitedata.properties");
		sitedata.load(fi);
		
		logs.info("properties file will bw loaded successfully");
		
		logs.info("Browser is going to open...");
		
		String browserval = sitedata.getProperty("browser");
		
		if(browserval.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			logs.info("chrome browser will be open successfully");
			
		}
		else if(browserval.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			logs.info("firefox browser will be open successfully");
		
		}
		else
		{
			System.out.println("No browser defined in properties file");
			logs.info("No browser defined in properties file");
		}
	
	
		driver.get(sitedata.getProperty("url"));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public static WebElement isElementmethod(String propkey)
	{
		try
		{
			if(propkey.contains("xpath"))
			{
				return driver.findElement(By.xpath(sitedata.getProperty(propkey)));
			}
			else if (propkey.contains("name"))
			{
				return driver.findElement(By.name(sitedata.getProperty(propkey)));
				
			}
			else if(propkey.contains("id"))
			{
				return driver.findElement(By.id(sitedata.getProperty(propkey)));
			}
			else if(propkey.contains("linktext"))
			{
				return driver.findElement(By.linkText(sitedata.getProperty(propkey)));
			}
		}
		
			catch(Exception e)
	   		{
				System.out.println("Element is not present in properties file");
			}
		return null;
	}
	
	

}
