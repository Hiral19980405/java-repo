package set;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

	public static void main(String[] args) throws InterruptedException {
			
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("http://122.170.14.195:8080/uth/gadgetsgallery/catalog/index.php");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[text()='create an account']")).click();
		
		driver.findElement(By.xpath("//*[text()='Continue']")).click();
		
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept(); //click on OK button or YES button
		
		//driver.switchTo().alert().dismiss();//click on CANCEL button or NO button
		
		driver.findElement(By.xpath("//*[@name='gender' and @value='f']")).click();
		
		driver.findElement(By.name("firstname")).sendKeys("honey");
		
		Thread.sleep(2000);
		
		driver.close();
		
		
		
	}

}
