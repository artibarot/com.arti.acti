package com.acti.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.acti.base.DriverScript;
import com.acti.pages.EnterPage;
import com.acti.pages.LoginPage;
import com.acti.pages.TaskPage;

public class BaseTest extends DriverScript {
	//make global variable to use in entire proj
LoginPage lp;
EnterPage ep;
TaskPage tp ;
	
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
		quitDriver();
	}

}
