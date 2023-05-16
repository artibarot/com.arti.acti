package com.acti.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.Test;  --Must remove while you remove @Test otherwise, it will executer 2 browser at a time. 

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * Name: DriverScript
 * Description: Manages the driver and browsers related Configurtions
 * Developed by: Arti Barot
 * Reviewed by: Shantosh kumar
 * Date Reviewed: 4-26-2023
 */
public class DriverScript {

public static WebDriver driver;
 Properties prop;

 //created a constructor to load the property files
 /*
  * Construction is responsible for getting the details from the properties files
  */
public DriverScript() {

try
{
File file =new File("./src/test/resources/config/config.properties");
FileInputStream fis=new FileInputStream(file);
prop = new Properties();
prop.load (fis);
}
catch (Exception e)
{
System.out.println("unable to load the config.properties file please check" +e.getMessage());
e.printStackTrace();	  
   }
} 
/*
 * initapplication will get the browser details from the properties file and launch the browser
 */
//intialize the method to fetch url and brower
 // @Test-you use only for testing purpose, then remove it, otherwise it will open the other window and remain open and other browser will perform the action
public void initApplication()
{
	String browser = prop.getProperty("browser"); //"browser"-get it from property file
	if (browser.equalsIgnoreCase("chrome"))
	{
		System.out.println (browser +" : in use");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
	}
	else if(browser.equalsIgnoreCase("firefox"))
	{
		System.out.println (browser+" : in use");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();	
	}
	else if (browser.equalsIgnoreCase("msedge"))
	{
		System.out.println (browser +" : in use");
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();	
	}
	else
	{
		System.out.println(browser +"is not supported browser please check config.properties files");
	}
 driver.manage().window().maximize();
 driver.manage().deleteAllCookies();
 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 LaunchURL ();
}
/*
 * Load the url from the properties file and pass this method to initapplication above
 */
 //creating the method for launch url
 public void LaunchURL ()
 {
 String url = prop.getProperty("url"); //get it from the config properties
 driver.get(url);
}
 /*
  * Quit the driver
  */
 public void quitDriver()
 {
	driver.quit(); 
 }
}
 
                                                  