package com.acti.testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.*;

import com.acti.utils.Helper;

public class TaskPageTests extends BaseTest{
	
	@Test (priority= 1, enabled = true)
	
public void testCreateCustomer () //throws InterruptedException 
	{
// ***************initializations*******************************
		Logger= report.createTest("Test create Customer");
		lp.enterUsername("admin");
		Logger.pass("Enter Username");
		lp.enterPassword("manager");
		Logger.pass("Enter Password");
		lp.clickLoginButton();
		Logger.pass("Click Login Button");
		String actual = ep.getUserLoggedIn();
		System.out.println(actual);
	    Assert.assertTrue(actual.contains("John Doe"));
	    Logger.pass("Verified the user logged in");
		ep.clickTaskMenu();
		Logger.pass("Clicked Task Menu");
		tp.clickAddNewButton();
		Logger.pass("Clicked New Button");
        Helper.sleep();
	    tp.newCustomerOption();
	    Logger.pass("Enter New Customer Option");
		tp.entercustomerName("TestCustomer");
		Logger.pass("Enter Customer Name");
		tp.enterCustomerDescription("I'm a testing customer creating by automation testing");
		Logger.pass("Enter Customer Description");
		tp.clickCreateCustomer();
		Logger.pass("Clicked Create Customer");
		String msg = tp.getSuccessMsg();
		Assert.assertTrue(msg.contains("has been created"));
		System.out.println(msg);
		Logger.pass("Verified Customer Created Successfully");
		Helper.sleep();
		ep.clickLogout();
		Logger.pass("LOgged out Successfully");
	}
	@Test (priority= 2)
public void testDeleteCustomer() //throws InterruptedException
	{
	lp.enterUsername("admin");
	lp.enterPassword("manager");
	lp.clickLoginButton();
	String actual = ep.getUserLoggedIn();
	System.out.println(actual);
    Assert.assertTrue(actual.contains("John Doe"));
	ep.clickTaskMenu();
	tp.searchCreatedCustomer("TestCustomer");
	tp.clickSearchedCustomer();
	tp.clickEditButton();
	tp.clickAction();
	tp.clickDelete();
	tp.clickDeletePermantely();
	String msg = tp.getSuccessMsg();
//	System.out.println(msg);
	Assert.assertTrue(msg.contains("has been deleted"));
	Helper.sleep();
	ep.clickLogout();
	}

}

