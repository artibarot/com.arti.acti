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
@FindBy(id="logoutLink") WebElement logoutLink;
@FindBy(xpath ="//a[@class= 'userProfileLink username ']" ) WebElement userloggedText;
@FindBy(xpath = "//div[@id='container_tasks']") WebElement menuTask;
@FindBy(xpath ="//div[@id='container_reports']") WebElement menuReports;
@FindBy(xpath ="//div[@id='container_users']") WebElement menuUsers;

//*******************Page Intializations -constructor**********************//
public  EnterPage() {
	PageFactory.initElements(driver, this);
}
//*******************Page Methods***************must create each methods for the locators 
public void clickLogout()
{
	logoutLink.click();
}
public String getUserLoggedIn()
{
	return userloggedText.getText();
}
public void clickTaskMenu()
{
	menuTask.click();
}
}
