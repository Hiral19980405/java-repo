package mousehover;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class menusubmenu {
	
	WebDriver driver;
	
	
	
	String url="https://www.myntra.com/";
	
	@BeforeClass
	public void openbrowser()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void mousehover() throws InterruptedException
	{
		
		driver.get(url);
		WebElement menu =driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/nav/div/div[4]/div/a"));
		WebElement submenu = driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/nav/div/div[4]/div/div/div/div/li[2]/ul/li[5]/a"));
		
		Actions act =new Actions(driver);
		
		act.moveToElement(menu).build().perform();
		
		Thread.sleep(2000);
		
		submenu.click();
	}
	
	@AfterClass
	public void Closebrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
}
