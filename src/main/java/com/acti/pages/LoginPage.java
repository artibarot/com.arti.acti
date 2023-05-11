package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;
/*
 * Name: Login Page
 * Description: Manages the locators, initializations and method for Login page
 * Developed by: Arti Barot
 * Reviewed by: Shantosh kumar
 * Date Reviewed: 5-11-2023
 */

public class LoginPage extends DriverScript {

//*******************Page Locators**********************//
	@FindBy(id ="username") WebElement usernameTextBox;
	@FindBy(name ="pwd") WebElement passwordTextBox;
//	@FindBy(xpath ="//div[@text()= 'Login']") WebElement loginButton; //it was giving me the err for xpath
	@FindBy(id ="loginButton") WebElement loginButton;
	@FindBy(className ="errormsg") WebElement errmsgText;
	@FindBy(linkText ="Forgot your password?") WebElement forgotpasswordLink;
//	@FindBy(id ="forgotPasswordFormContainer") WebElement forgotpasswordLink;
	@FindBy(xpath= "//div[@class ='atLogoImg']") WebElement actiImg;

//*******************Page Intializations**********************//
public LoginPage() {
		PageFactory.initElements(driver, this);
	}
//*******************Page Methods**********************//
//*************There should be a methods for the each locators 
public void enterUsername(String username)
{
	usernameTextBox.sendKeys(username);
}
public void enterPassword(String password)
{
	passwordTextBox.sendKeys(password);
}
public void clickLoginButton()
{
	loginButton.click();
}
public String errMsgText()
{
	return errmsgText.getText();
}
public  boolean verifyForgotpasswordLink()
{
	return	forgotpasswordLink.isDisplayed();
}
public boolean verifyActiImg()
{
	return actiImg.isDisplayed();
}
public String getLoginPageTitle()
{
	return driver.getTitle();
}
}