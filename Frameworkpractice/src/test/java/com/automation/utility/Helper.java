package com.automation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	//Screenshots , alert, frames , windows , sync issue , javascript executor
	public static  String captureScreeshot(WebDriver driver)
	{
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPathString =System.getProperty("user.dir")+"/Screenshots/FREECRM_"+getCurrentDateTime()+".png";
		
		try {
			FileHandler.copy(src, new File(screenshotPathString));
			System.out.println("Screenshot Captured");
			
		} catch (IOException e) {
			
			
			System.out.println("Unable to capture screenshot"+ e.getMessage());
		}
		return screenshotPathString;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HHH_mm_ss");
		Date currentDate=new Date();
		return customFormat.format(currentDate);
		
	}
	
}
