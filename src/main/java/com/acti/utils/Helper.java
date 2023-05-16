package com.acti.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.acti.base.DriverScript;

/*
 * Helper class
 */
public class Helper extends DriverScript 
{
	// This method is used to support the wait whenever needed
	public static void sleep()
	{
		try
		{
			Thread.sleep(3000);
		}
		
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	/*
	 * This method used to capture the screenshots 
	 */
	public static String captureScreen(WebDriver driver)   {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  //TakesScreenShot & driverinterfaces--getscreenshot-method put into OUtPUT type is source file
		String dest = "./reports/screens/acti.png";     //screen shot path with relative path-- target where exactly the screenshot saves
		try
		{
			FileHandler.copy(src, new File(dest));  //File handler's job to copy the file from source to destination
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return dest;
	}
}

