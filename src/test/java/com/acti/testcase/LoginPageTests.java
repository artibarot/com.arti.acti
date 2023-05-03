package com.acti.testcase;

import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import com.acti.base.DriverScript;
//import com.acti.pages.LoginPage;

//make global variable to use in entire proj



public class LoginPageTests extends BaseTest{
	@Test   //1st test case -Login page title
	public void testLoginPageTitle() throws InterruptedException
	{ 
		
		String actual = "actiTIME - Login";
		String expected = lp.getLoginPageTitle();
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
		Thread.sleep(3000);
	}
	@Test     //2nd test case- ActiImage displayed
	public void testActiImgDisplayed() throws InterruptedException
	{
		boolean flag = lp.VerifyActiImg();
		Assert.assertTrue(flag);
		Thread.sleep(3000);
	}
	
	@Test     //3rd test case- Forgot password displayed
	public void testForgotPasswordedDisplayed() throws InterruptedException
	{
		boolean flag = lp.verifyForgotpasswordLink();
		Assert.assertTrue(flag);
		Thread.sleep(3000);
	}
	@Test     //4th test case- Log in with Admin
	public void testLoginFunction() throws InterruptedException
	{
		lp.enterUsername("admin");
		lp.enterPassword("manager");
	    lp.ClickLoginButton();
    Thread.sleep(3000);
	}
	@Test  //(enabled = True) //5th test case- error message
	public void testLoginInvalidCredientials() throws InterruptedException
	{
		lp.enterPassword("admin");
		lp.ClickLoginButton();
		String errmsg = lp.getErrMsgText();
		Thread.sleep(3000);
		System.out.println(errmsg);
		Assert.assertTrue(errmsg.contains("username or password is invalid"));
	}
}
