package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
1.constructor
2.WebElements
3.Action of webElements
*/ 

public class Homepage {
	
	WebDriver driver;// it's global
	
	public Homepage(WebDriver driver)
	/*webdriver driver is local > we are creating constructor because when we create the obj of homepage class 
	so you will pass something here we are passing the driver*/
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "log yourself in")  //driver.findelement(By.linkText("log yourself in"));
	@CacheLookup 
	WebElement logyourselfin;
	
	@FindBy(linkText = "create an account")
	@CacheLookup
	WebElement createanaccount;
	
	@FindBy(name = "keywords")
	@CacheLookup
	WebElement search;
	
	@FindBy(xpath = "//*[@id=\"left_sidebar\"]/div[3]/div[2]/form/input[3]")
	@CacheLookup
	WebElement find;
	

	public void lnk_clicklogyourselfin()
	{
		logyourselfin.click();
	}
	
	public void lnk_clickcreateanaccount()
	{
		createanaccount.click();
	}
	
	public void Search_ipSearch(String keyword)
	{
		search.sendKeys(keyword);
	}

	public void btn_find()
	{
		find.click();
	}
	
}
