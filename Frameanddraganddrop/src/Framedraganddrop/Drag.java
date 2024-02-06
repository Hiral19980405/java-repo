package Framedraganddrop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Drag {
	
	WebDriver driver;
	
	String url ="https://jqueryui.com/draggable/";
	
	
	@BeforeClass
	public void openbrowser()
	{
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		
	}
	
	@Test
	public void framdrag() throws InterruptedException
	{
		
		driver.get(url);
		
		WebElement framebox = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		
		driver.switchTo().frame(framebox);
		
		Actions act = new Actions(driver);
		
		Thread.sleep(2000);
		
		WebElement obj = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		
		act.dragAndDropBy(obj, 200,80).build().perform();
		
		
	}
	 
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
	

}
