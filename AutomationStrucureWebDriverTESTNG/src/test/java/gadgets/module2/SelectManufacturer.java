package gadgets.module2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import gadgets.basepackage.baseinit;

public class SelectManufacturer extends baseinit
{

	@BeforeTest
	public void setuup() throws Exception
	{
		startup();
	}
	

	@Test
	public void testselectmenufacturer()
	{
		WebElement manufacturer =isElementmethod("dd_manufactures_xpath");
		
		List<WebElement> manuvalues	= manufacturer.findElements(By.tagName("option"));
		
		for (int count=1; count<manuvalues.size();count++)
		{
			String manutext= manuvalues.get(count).getText();
			
			if(manutext.equalsIgnoreCase("motorola"))
			{
				manuvalues.get(count).getText();
				logs.info(driver.getTitle()+"->"+driver.getCurrentUrl());
				
				break;
			}  
		}
		
	}
	

}
