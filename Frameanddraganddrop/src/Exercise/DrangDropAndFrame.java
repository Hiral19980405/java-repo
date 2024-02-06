package Exercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DrangDropAndFrame {
	
	WebDriver driver;
	
	String url = "https://jqueryui.com/draggable/";
	


	@BeforeClass
	public void OpenBrowser()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test (priority = 1)
	public void Testmethod() throws InterruptedException
	{
		driver.get(url);
		WebElement framebox = driver.findElement(By.className("demo-frame"));

		
		driver.switchTo().frame(framebox);
				
		
		Thread.sleep(2000);
		
		WebElement drag = driver.findElement(By.id("draggable"));

		Actions act =new Actions(driver);


		act.dragAndDropBy(drag,150,80).build().perform();
		
		Thread.sleep(2000);

		driver.switchTo().defaultContent();
		
		driver.findElement(By.linkText("Droppable")).click();
		
		WebElement framebox1 = driver.findElement(By.className("demo-frame"));

		
		driver.switchTo().frame(framebox1);
		
	
		
		WebElement Source = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		WebElement destination = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		
		String text = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText();
		
		System.out.println(text);
		
		Actions act1 =new Actions(driver);

		
		act1.dragAndDrop(Source,destination).build().perform();
		
		String aftertext=driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText();
		
		System.out.println(aftertext);
	
		if (text != aftertext)
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.linkText("Resizable")).click();
		
	}
	
	
}
