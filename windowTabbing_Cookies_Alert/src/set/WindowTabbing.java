package set;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowTabbing {

	public static void main(String[] args) throws InterruptedException {
		
		/*ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--remote-allow-origins=*");
		
        System.setProperty("webdriver.chrome.driver", "D:/seleniumwebdriver/chromedriver_win32 (1)"); */

		
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.airindia.in/");
		
		WebElement menu =driver.findElement(By.xpath("/html/body/form[1]/div[4]/div/div[5]/div/div/div[1]/ul/li[4]/a"));
		
		WebElement submenu = driver.findElement(By.xpath("//div[@id='ContentPlaceHolder1_UserMenuHorizontal1_divMenu']//a[@title='External website that opens in a new window'][normalize-space()='Join Now']"));
	
		Actions act=new Actions(driver);
		
		act.moveToElement(menu).build().perform();
		Thread.sleep(2000);
		
		submenu.click();
		
		Thread.sleep(1000);
		
		Set<String> windowID = driver.getWindowHandles();
		Iterator<String> iter = windowID.iterator();
		
		String mainId = iter.next();
		String tabwinId = iter.next();
		
		driver.switchTo().window(tabwinId);
		
		driver.findElement(By.id("signInName")).sendKeys("test@test.com");
		driver.findElement(By.id("password")).sendKeys("test1234");
		
		Thread.sleep(2000);
		
		driver.close();
		
		driver.switchTo().window(mainId);
		
		Thread.sleep(2000);

		
		driver.close();
	}

}
