package gadgets.module1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import gadgets.basepackage.baseinit;

public class SelectSpecificProduct extends baseinit{
	                         
	@BeforeTest
	public void setup() throws Exception
	{
		startup();
	}     
	
	
	@Test
	public void testselectspecificproduct()
	{
		driver.findElement(By.linkText("Smartwatches"));
		List<WebElement> prodlinks = driver.findElements(By.xpath("//div[@id='content']/div[2]/div/div[2]/div[1]/div[2]/table/tbody/tr/td[2]/a"));
		
		List<WebElement> prodbtns = driver.findElements(By.xpath("//div[@id='content']/div[2]/div/div[2]/div[1]/div[2]/table/tbody/tr/td[4]/span/a"));
		
		for(int count=1;count<prodlinks.size();count++)
		{
			 String prodText = prodlinks.get(count).getText();
			 
			 if(prodText.equalsIgnoreCase("Apple smart watch A4"))
			 {
				 prodbtns.get(count).click();
				 
				 logs.info(driver.getTitle()+"->"+driver.getCurrentUrl());

				 break;
			 }
		}
	}

}
      