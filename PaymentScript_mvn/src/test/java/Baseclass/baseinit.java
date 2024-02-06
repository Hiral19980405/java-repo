package Baseclass;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class baseinit {
	
	public static WebDriver driver = null;
	public static Properties sitedata =null;
	
	public void startup() throws Exception
	{
		if(driver==null)
		{
			sitedata = new Properties();
			FileInputStream fo = new FileInputStream("./src/test/java/Propertiesdata/websitedata.properties");
			sitedata.load(fo);
			
			String browser =sitedata.getProperty("browser");
			String url = sitedata.getProperty("url");
			
			if (browser.equalsIgnoreCase("Chrome"))
			{
				ChromeOptions co= new ChromeOptions();
				co.addArguments("--remote-allow-origins=*");
				driver=new ChromeDriver();
				System.out.println("chrome browser will be lunched..");
			}
			
			else if(browser.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			
			else if(browser.equalsIgnoreCase("safari"))
			{
				driver = new SafariDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	}
	
	public void endup() throws Exception
	{
		Thread.sleep(2000);
		driver.close();
	}

}
