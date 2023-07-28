package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite()
	{
		Reporter.log("Setting up reports and Test is getting ready ",true);
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();

		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/FreeCRM" + Helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Done Test can be started ",true);

	}
	
	
	@Parameters({"browser","urlTobeTested"})
	@BeforeClass
	public void setup(String browser,String url)
	{
		Reporter.log("Trying to start Browser and Getting application ready",true);
		
		//driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingURL());
		
		driver=BrowserFactory.startApplication(driver,browser,url);
		
		Reporter.log("Browser and Application is up and running",true);
	
	}
	
	@AfterClass
	public void teardown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException 
	{
		
		Reporter.log("Test is about to end",true);
		
	if(result.getStatus()==ITestResult.FAILURE)	
	{
		
		logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreeshot(driver)).build());
		
	}
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreeshot(driver)).build());
	}
	
	
		
	report.flush();
	Reporter.log("Test Completed >>> Report Generated ",true);
	
	}
	
	
}
