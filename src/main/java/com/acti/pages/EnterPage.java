package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;
/*
 * Name: Enter Page
 * Description: Manages the locators, initializations and method for Enter page
 * Developed by: Arti Barot
 * Reviewed by: Shantosh
 * Date Reviewed: 5-11-2023
 */
public class EnterPage extends DriverScript{
//*******************Page Locators**********************//
@FindBy(id ="username") WebElement usernameTextBox;
@FindBy(name ="pwd") WebElement passwordTextBox;
@FindBy(xpath ="//div[text()= 'Login']") WebElement loginButton;
@FindBy(className ="errormsg") WebElement errmsgText;
@FindBy(linkText ="Forgot your password?") WebElement forgotpasswordLink;
@FindBy(xpath= "//div[@class ='atLogoImg']") WebElement actiImg;

//*******************Page Intializations -constructor**********************//
public  EnterPage() {
	PageFactory.initElements(driver, this);
}
//*******************Page Methods**********************//
//*************must create each methods for the locators 
public void enterUsername(String username) 
{
	usernameTextBox.sendKeys(username);
}
public void enterPassword(String password) 
{
	passwordTextBox.sendKeys(password);
}
public void ClickLoginButton() 
{
	loginButton.click();
}
public String getErrMsgText()
{
	return errmsgText.getText();
}
public boolean verifyForgotpasswordLink() 
{
	return forgotpasswordLink.isDisplayed();
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
