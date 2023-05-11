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
		
		String actual = "actiTIME - Login";
		String expected = lp.getLoginPageTitle();
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
		Thread.sleep(3000);
	}
	@Test   (enabled = true)  //2nd test case- ActiImage displayed
	public void testActiImgDisplayed() throws InterruptedException
	{
		boolean flag = lp.VerifyActiImg();
		Assert.assertTrue(flag);
		Thread.sleep(3000);
	}
	@Test  (enabled = true)   //3rd test case- Forgot password displayed
	public void testForgotPasswordedDisplayed() throws InterruptedException
	{
		boolean flag = lp.verifyForgotpasswordLink();
		Assert.assertTrue(flag);
		Thread.sleep(3000);
	}
	@Test  (enabled = true)   //4th test case- Log in with Admin
	public void testLoginFunction() throws InterruptedException
	{
		lp.enterUsername("admin");
		lp.enterPassword("manager");
		lp.ClickLoginButton();
        Thread.sleep(3000);
	}
	@Test  (enabled = true) //5th test case- error message
	public void testLoginInvalidCredientials() throws InterruptedException
	{
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.ClickLoginButton();
		Thread.sleep(3000);
		String errmsg = lp.getErrMsgText();
		System.out.println(errmsg);
		Assert.assertTrue(errmsg.contains("Username or Password is invalid"));		
	}
}

