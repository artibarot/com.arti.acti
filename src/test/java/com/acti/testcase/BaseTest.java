package com.acti.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.acti.base.DriverScript;
import com.acti.pages.EnterPage;
import com.acti.pages.LoginPage;
import com.acti.pages.TaskPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest extends DriverScript {
//make global variable to use in entire 
public static ExtentHtmlReporter extent;
public static ExtentReports report;
public static ExtentTest Logger;

LoginPage lp;
EnterPage ep;
TaskPage tp ;

@BeforeSuite
public void reportSetup()
{
	extent= new ExtentHtmlReporter("./reports/actiindex.html");
	report = new ExtentReports();
	report.attachReporter(extent);
}

	
	@BeforeMethod
	public void preTest() 
	{
		initApplication(); // init method-launch browser and url all
		lp = new LoginPage();  //create an object
		ep=new EnterPage();
		tp= new TaskPage();
	}
	@AfterMethod
	public void tearDown()
	{
		report.flush();
		quitDriver();
	}

}
