package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//input[@name='email']") WebElement uname;
	
	@FindBy(xpath="//input[@name='password']") WebElement pass;

	@FindBy(xpath="//div[@class='ui fluid large blue submit button']") WebElement loginButton;
	
	
	public void loginToCRM(String usernameApplication,String passwordApplication) 
	
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) 
		{
			
		}
		
		uname.sendKeys(usernameApplication);
		pass.sendKeys(passwordApplication);
		loginButton.click();
		
	}
	
}
