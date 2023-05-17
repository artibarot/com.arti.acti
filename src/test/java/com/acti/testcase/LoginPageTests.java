package com.acti.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.acti.base.DriverScript;
import com.acti.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;

//make global variable to use in entire proj


public class LoginPageTests extends BaseTest  
{
	@Test   //1st test case -Login page title
	public void testLoginPageTitle() throws InterruptedException
	{ 
		Logger= report.createTest("Test Login Page Title");
		String actual = "actiTIME - Login";
		String expected = lp.getLoginPageTitle();
		Logger.pass("Captured Page Title");
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
		Thread.sleep(3000);
		Logger.pass("Verified the Login Page Title");
	}
	@Test   (enabled = true)  //2nd test case- ActiImage displayed
	public void testActiImgDisplayed() throws InterruptedException
	{
		Logger= report.createTest("Test acti image displayed");
		boolean flag = lp.verifyActiImg();
		Logger.pass("Identify the image");
		Assert.assertTrue(flag);
		Thread.sleep(3000);
		Logger.pass("Verified logo is Displayed");
	}
	@Test  (enabled = true)   //3rd test case- Forgot password displayed
	public void testForgotPasswordedDisplayed() throws InterruptedException
	{
		Logger= report.createTest("Test Forgot passwordLink is displayed");
		boolean flag = lp.verifyForgotpasswordLink();
		Logger.pass("Identify the Forgotpassword Link");
		Assert.assertTrue(flag);
		Thread.sleep(3000);
		Logger.pass("Identify Forgot passwordLink is displayed");
	}
	@Test  (enabled = true)   //4th test case- Log in with Admin
	public void testLoginFunction() throws InterruptedException
	{
		Logger= report.createTest("Test created Customer");
//		lp.enterUsername("admin");
//		Logger.pass("Enter Username");
		lp.enterPassword("manager");
		Logger.pass("Enter without Username");
		lp.clickLoginButton();
		Logger.pass("Click Login Button");
		String actual = ep.getUserLoggedIn();
		System.out.println(actual);
	    Assert.assertTrue(actual.contains("John Doe"));
	    Logger.pass("Verified the user logged in");
		Thread.sleep(3000);
		ep.clickLogout();
		Logger.pass("Logged out Successfully");
	}
	@Test  (enabled = true) //5th test case- error message
	public void testLoginInvalidCredientials() throws InterruptedException
	{
		Logger= report.createTest("Test Login for Invalid Credientials");
		lp.enterUsername("admin");
		Logger.pass("Enter Username");
		lp.enterPassword("admin");
		Logger.pass("Enter Password");
		lp.clickLoginButton();
		Logger.pass("Clicked Login with wrong password");
		Thread.sleep(3000);
		String errmsg = lp.errMsgText();
		System.out.println(errmsg);
		Logger.pass("Capture the error message");
		Assert.assertTrue(errmsg.contains("Username or Password is invalid"));		
		Logger.pass("Verified the Error Message");
	}
	@Test  (enabled = true) //5th test case- error message
	public void testLoginInvalidCredientials1() throws InterruptedException
	{
		Logger= report.createTest("Test Login for Invalid Credientials 1");
		lp.enterUsername("admin");
		Logger.pass("Enter Username");
		lp.enterPassword("Damager");
		Logger.pass("Enter Password");
		lp.clickLoginButton();
		Logger.pass("Clicked Login button");
		Thread.sleep(3000);
		String actual = ep.getUserLoggedIn();
		System.out.println(actual);
	    Assert.assertTrue(actual.contains("John Doe"));
	    Logger.pass("Verified the user logged in");
		Thread.sleep(3000);
		ep.clickLogout();
		Logger.pass("Logged out Successfully");	
	}
}