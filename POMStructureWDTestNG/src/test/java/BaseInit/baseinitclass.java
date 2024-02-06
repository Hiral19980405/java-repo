package BaseInit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
 
public class baseinitclass {
	
	public static WebDriver driver=null;
	public static Properties sitedata = null;
	
	public void startup() throws Exception
	{
		sitedata = new Properties();
		FileInputStream fi = new FileInputStream("./src/test/java/PropertiesData/WebsiteData.PropertiesData");
		
		sitedata.load(fi);
		
		String browser = sitedata.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			
			ChromeOptions co =new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(co);
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
		
			driver = new FirefoxDriver();
			
		}
		else if (browser.equalsIgnoreCase("safari"))
		{
			driver =new SafariDriver(); 
		}
		else
		{
			System.out.println("NO browser defined in the properties file");
		} 
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		
	}
	
	
	

}
