package set;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class cookies {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("http://122.170.14.195:8080/uth/gadgetsgallery/catalog");
		
		//driver.manage().deleteAllCookies();
		
		System.out.println("*****************before login***************");
		
		Set<Cookie> cookies = driver.manage().getCookies();
		
		
		for(Cookie c:cookies)
		{
			System.out.println("Domain name: "+c.getDomain());
			System.out.println("Cookie path: "+c.getPath());
			System.out.println("Cookie Nmae: "+c.getName());
			System.out.println("Cookie value: "+c.getValue());			
		}
		
		driver.findElement(By.linkText("log yourself in")).click();
		
		driver.findElement(By.name("email_address")).sendKeys("hiral@yopmail.com");
		driver.findElement(By.name("password")).sendKeys("Honey@123");
		driver.findElement(By.id("tdb1")).click();
		System.out.println("user logged in successfully...");
		
		
		System.out.println("**************************Cookies after Login***************************");
		
		cookies =driver.manage().getCookies();
		
		for(Cookie c:cookies)
		{
			System.out.println("Domain name: "+c.getDomain());
			System.out.println("Cookie path: "+c.getPath());
			System.out.println("Cookie Nmae: "+c.getName());
			System.out.println("Cookie value: "+c.getValue());	
		}
			
		driver.manage().deleteAllCookies();
		
		Thread.sleep(5000);
		
		driver.navigate().refresh();
		
		Thread.sleep(2000);
		
		driver.close();
		
	}
}
