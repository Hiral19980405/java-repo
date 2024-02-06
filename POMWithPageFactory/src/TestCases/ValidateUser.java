 package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.description.ModifierReviewable.OfAbstraction;

public class ValidateUser {
	
	WebDriver driver;
	
	String url="http://122.170.14.195:8080/uth/gadgetsgallery/catalog/index.php";
	
	@BeforeTest
	public void openbrowser()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)));
		driver.get(url);
	}
	
	@Test
	public void testValidateUser()
	{
		driver.findElement(By.linkText("log yourself in")).click();
		
		Loginpage login = PageFactory.initElements(driver,Loginpage.class);
		
		login.signin("shamsfive@gmail.com","hiral@123");
			
		
	}
	
	@AfterTest
	public void closebrowser()
	{
		Thread.sleep(2000);
		driver.close();
		
	}
	
}



