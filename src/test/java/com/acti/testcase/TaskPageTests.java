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
		// ***************initializations
		lp.enterUsername("admin");
		lp.enterPassword("manager");
		lp.clickLoginButton();
		String actual = ep.getUserLoggedIn();
		System.out.println(actual);
	    Assert.assertTrue(actual.contains("John Doe"));
		ep.clickTaskMenu();
		tp.clickAddNewButton();
        Helper.sleep();
	    tp.newCustomerOption();
		tp.entercustomerName("TestCustomer");
		tp.enterCustomerDescription("I'm a testing customer creating by automation testing");
		tp.clickCreateCustomer();
		String msg = tp.getSuccessMsg();
		Assert.assertTrue(msg.contains("has been created"));
		System.out.println(msg);
		Helper.sleep();
		ep.clickLogout();
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

