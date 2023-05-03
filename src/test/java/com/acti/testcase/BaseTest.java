package com.acti.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.acti.base.DriverScript;
import com.acti.pages.LoginPage;

public class BaseTest extends DriverScript {
	//make global variable to use in entire proj
LoginPage lp;
	
	@BeforeMethod
	public void preTest() 
	{
		initApplication(); // init method-launch browser and url all
		lp = new LoginPage();  //create an object
	}
	@AfterMethod
	public void tearDown()
	{
		quitDriver();
	}

}
