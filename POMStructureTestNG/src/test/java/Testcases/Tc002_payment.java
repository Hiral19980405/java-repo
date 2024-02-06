package Testcases;

import java.sql.Driver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basepackage.baseinit;
import pageobject.Homepage;
import pageobject.Paymentpage;
import pageobject.ProductPage;
import pageobject.Shippingpage;
import pageobject.Shoppingcart;
import pageobject.Successorder;
import pageobject.loginpage;
import pageobject.logoffpage;
import pageobject.orderconfirmation;
import pageobject.welcomepage;

public class Tc002_payment extends baseinit
{
	@BeforeClass
	public void Setup() throws Exception
	{
		startup();
	}
	
	@Test
	public void Testpayment() throws Exception 
	{
		
		//driver.get(sitedata.getProperty("url"));
		
		Homepage home = new Homepage(driver);
		home.Search_ipSearch("jbl");
		Thread.sleep(2000);
		home.btn_find();
		
		ProductPage product =new ProductPage(driver);
		product.Click_buynow();
		
		Shoppingcart shop = new Shoppingcart(driver);
		shop.ip_quntity("2");
		shop.btn_clickupdate();
		shop.btn_clickcheckout();
		
		loginpage login = new loginpage(driver);
		login.ip_setemail("shamsfive@gmail.com");
		login.ip_setpass("hiral@123");
		login.btn_clicksignin();
		
		Shippingpage ship = new Shippingpage(driver);
		ship.ip_comment("Text");
		ship.btn_con();
		
		Paymentpage pay = new Paymentpage(driver);
		//pay.select_cod();
		//Thread.sleep(1000);
		//pay.ip_comment("I need my order ASAP");
		pay.btn_conti();
		
		orderconfirmation order = new orderconfirmation(driver);
		order.btn_confirm();
		
		Successorder success =new Successorder(driver);
		success.select_checkbox();
		success.btn_continue();
		
		welcomepage welcome1 =new welcomepage(driver);
		welcome1.lnk_clicklogoff();
		
		logoffpage log =new logoffpage(driver);
		log.lnk_clickcontinue();
	}
	
	@AfterClass
	
	public void endscript() throws Exception 
	{
		endup();
	}

}
