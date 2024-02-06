package basepackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

//Baseinit is parent class

public class baseinit {
	
	public static WebDriver driver = null;
	
	public static Properties sitedata = null;
	
	
	public void startup() throws Exception
	{
		if(driver == null)
		{
		sitedata =new Properties();
		FileInputStream fi=new FileInputStream("./src/test/java/propertiesdata/WebsiteData.properties");
		sitedata.load(fi);
		
		String browser = sitedata.getProperty("browser");
		String url = sitedata.getProperty("url");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(co);
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("safari"))
		{
			driver = new SafariDriver();
	
		}
		else
		{
			System.out.println("No browser is defined in the properties file");
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
