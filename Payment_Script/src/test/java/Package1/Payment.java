package Package1;

import java.awt.RenderingHints.Key;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.dom.DOM.PerformSearchResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Payment {
	
	WebDriver driver;
	
	String url="http://122.170.14.195:8080/uth/gadgetsgallery/catalog/";
	
	@BeforeClass
	public void launchbrowser()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test
	public void TestPay() throws Exception
	{
		driver.get(url);
		
		Thread.sleep(2000);
		
		searchproductname("Apple watch A235"); 
		Thread.sleep(2000);
	
		searchproductname("Airpods Pro Case");
		Thread.sleep(2000);
		
		searchproductname("test");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[contains(text(),'Shopping Cart')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[text()='Checkout']")).click();
		Thread.sleep(2000);
		
		boolean login;
		
		try
		{
			login=driver.findElement(By.xpath("//*[text()='Sign In']")).isDisplayed();
		}
		catch (Exception e) 
		{
			login=false;
		}
		
		if (login)
		{
			signin("hiral@yopmail.com","Honey@123");
			Thread.sleep(2000);
		}
		else
		{
			System.out.println("user is already logged in....");
		}
		
		driver.findElement(By.xpath("//*[text()='Continue']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[text()='Cash on Delivery']//parent::td//following-sibling::td/input")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("comments")).sendKeys("I need my order ASAP");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[text()='Continue']")).click();
		Thread.sleep(2000);
		//total
		
		String subtotaltext = driver.findElement(By.xpath("//*[text()='Sub-Total:']//following-sibling::td")).getText();
		
		String t1 =subtotaltext.replace("Rs.","");
		String t2 =t1.replace(",", "");
		Double subtotal = Double.parseDouble(t2); 
		
		String flattext = driver.findElement(By.xpath("//*[text()='Flat Rate (Best Way):']//following-sibling::td")).getText();
		
		String t3=flattext.replace("Rs.","");
		Double flat =Double.parseDouble(t3);
		
		String total = driver.findElement(By.xpath("//*[text()='Total:']//following-sibling::td")).getText();
		
		String t4 = total.replace("Rs.", "");
		String t5=t4.replace(",", "");
		Double actualtotal =Double.parseDouble(t5);
		
		
		
		Double expectedtotal = subtotal+flat;
		
		System.out.println("Actual total value is:"+actualtotal);
		System.out.println("Expected total value is:"+expectedtotal);
		
		if(actualtotal.equals(expectedtotal))
		{
			
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		 
		driver.findElement(By.xpath("//*[text()='Confirm Order']")).click();
		Thread.sleep(2000);
		
		String acttext = driver.findElement(By.xpath("//*[text()='Your Order Has Been Processed!']")).getText();
		
		Assert.assertEquals(acttext,"Your Order Has Been Processed!");
		
		driver.findElement(By.xpath("//*[text()='Continue']")).click();
		Thread.sleep(2000);
		
		signout();	
		Thread.sleep(2000);
		
		closebrowser();
	}
	
	
	//Search product and check if display or not and adding to cart
	public void searchproductname(String prodname)
	{
		driver.findElement(By.name("keywords")).sendKeys(prodname);
		driver.findElement(By.name("keywords")).sendKeys(Keys.ENTER);
		
		try{
			if(driver.findElement(By.xpath("//*[text()='"+prodname+"']")).isDisplayed())
			{
				//click on particular product's buynow button
				driver.findElement(By.xpath("//*[text()='"+prodname+"']//parent::td//following-sibling::td[2]/span/a")).click();
	
				
				System.out.println("product "+prodname+" added in to the cart");
				
				driver.findElement(By.linkText("Home")).click();
			}
		}
		catch (Exception e) 
		{
			System.out.println("product "+prodname+" product is not available");
		}
		
	}
	
	//login 
	public void signin(String email,String password) {
		driver.findElement(By.name("email_address")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
	}
	
	
	//logoff
	public void signout()
	{
		driver.findElement(By.linkText("Log Off")).click();
		driver.findElement(By.xpath("//*[text()='Continue']")).click();
	}
	
	//close the browser
	public void closebrowser() throws Exception
	{
		Thread.sleep(2000);
		driver.close();
	}
}
