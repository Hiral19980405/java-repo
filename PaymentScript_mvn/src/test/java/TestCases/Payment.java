package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Baseclass.baseinit;
import PageObject.Landingpage;

public class Payment extends baseinit  {
	
	@BeforeClass
	public void setup() throws Exception
	{
		startup();
	}

	@Test
	public void testcasescripts()
	{
		Landingpage lp = new Landingpage(driver);
		lp.btn_signin();
		
		
	}
	
	
	
	

}
