package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utility.BrowserFactory;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;

public class LoginTestCRM extends BaseClass{


	@Test(priority=1)
	public void loginAPP() {
		
		
		//excel.getStringData("Login", 0, 0);
		
		logger=	report.createTest("Login to CRM");
		
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		loginpage.loginToCRM(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		
		//elper.captureScreeshot(driver);
		
		logger.pass("Login Success");
		
		
	}
	
	@Test(priority=2)
	public void loginAPP1() {
		
		logger=report.createTest("Logout");
		
		logger.fail("Logout Fail");
		
		
	}
	
	
	
}
