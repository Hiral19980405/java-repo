package Testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateExtentReport {
	
	@Test
	public void GenerateExtentReport() throws InterruptedException
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter(".\\src\\test\\resources\\Reports\\TestResults.html");
		
		//This all are optional
		reporter.config().setDocumentTitle("testReports");
		reporter.config().setReportName("Projectname-Test Results");
		reporter.config().setTheme(Theme.DARK);
		
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Environment","QA");
		reports.setSystemInfo("Team Name","QA");
		reports.setSystemInfo("Tester Name","hiral");
		
		ExtentTest test =  reports.createTest("Testcase 1");
		
		reports.createTest("TestCase 1");
		test.log(Status.INFO, "Statement 1");
		Thread.sleep(2000);
		
		test.log(Status.INFO,"Statement 2");
		Thread.sleep(1000);
		
		test.log(Status.PASS, "Testcase is executed....");
		
		///////////////////////////////////////////////////
		
		test = reports.createTest("TestCase 2");
		test.log(Status.INFO, "Statement 1");
		Thread.sleep(2000);
		
		test.log(Status.INFO, "Statement 2");
		Thread.sleep(1000);
		
		test.log(Status.FAIL, "There is something wrong...");
		
		//////////////////////////////////////////////////////
		
		test = reports.createTest("TestCase 3");
		test.log(Status.INFO,"Statement 1");
		Thread.sleep(2000);
		 
		test.log(Status.INFO,"Statement 3");
		test.log(Status.SKIP,"Skipping testcase...");
		Thread.sleep(2000);
		
		reports.flush();
		
		
		
		
	}

}
