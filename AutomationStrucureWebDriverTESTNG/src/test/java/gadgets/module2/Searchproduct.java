package gadgets.module2;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import gadgets.basepackage.baseinit;
import gadgets.utility.MyLibrary;

public class Searchproduct extends baseinit{
	
	@BeforeTest
	public void setup() throws Exception {
		startup();
	}
	  
	@Test
	public void testSearchproduct()
	{
		isElementmethod("ip_keyboard_name").sendKeys("Samsung");
		logs.info("Samsung is selected");
		
		isElementmethod("ip_keyboard_name").sendKeys(Keys.ENTER);
		MyLibrary.getScreenshot("Searchproduct", driver);
	}

}
