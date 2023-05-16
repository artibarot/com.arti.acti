package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acti.base.DriverScript;
import com.acti.utils.Helper;

/*
 * Name: Task Page
 * Description: Manages the locators, initializations and method for Task page
 * Developed by: Arti Barot
 * Reviewed by: Shantosh
 * Date Reviewed: 5-12-2023, 5-15-2023
 */
public class TaskPage extends DriverScript {
//******************************************Page Locators*****************************************//
	@FindBy (xpath = "//div[text() ='Add New']") WebElement addNewButton;
	@FindBy (xpath = "//div[@class='item createNewCustomer']") WebElement newCustomerOption;
	@FindBy (xpath= "//input[@class='inputFieldWithPlaceholder newNameField inputNameField']") WebElement customerNameTb;
	@FindBy (xpath = "//textarea[@placeholder='Enter Customer Description']") WebElement customerDescriptionArea;
	@FindBy (xpath= "//div[contains(text(),'Create Customer')]") WebElement createCustomerButton;
	@FindBy (xpath ="//span[@class='innerHtml']") WebElement getSuccessMsg;
	@FindBy (xpath= "//input [@placeholder='Start typing name ...']") WebElement textboxStartTyping;
	@FindBy (xpath = "//div[@class='filteredContainer']//div[@class= 'title']") WebElement searchedCreatedCustomer;
	@FindBy (xpath = "//div [@class= 'title']") WebElement searchedCustomer;
	@FindBy (xpath = "//div[@class='titleEditButtonContainer']//div[@class= 'editButton']") WebElement buttonEdit;
	@FindBy (xpath= "//div[@class= 'editCustomerPanelHeader']//div[@class= 'action'][normalize-space()= 'ACTIONS']") WebElement buttonAction;
    @FindBy (xpath= "//div[@class='taskManagement_customerPanel']//div[@class='title'][normalize-space()='Delete']") WebElement buttonDelete;
	@FindBy (xpath= "//span[normalize-space()='Delete permanently']") WebElement buttonDeletePermanently;
//*******************Page Initializations -constructor**********************//
public  TaskPage() 
{
	PageFactory.initElements(driver, this);
	}
//*******************Page Methods***************must create each methods for the locators 
 public void clickAddNewButton ()
 {
	 addNewButton.click();
 }
 public void newCustomerOption ()
 {
	 newCustomerOption.click();
 }
 public void entercustomerName(String customername)
 {
	 customerNameTb.sendKeys(customername); 
 }
 public void enterCustomerDescription(String customername)
 {
	 customerDescriptionArea.sendKeys(customername);
 }
 public void clickCreateCustomer()
 {
	 createCustomerButton.click();
 }
public String getSuccessMsg()
{
	return getSuccessMsg.getText() ;
}
public void searchCreatedCustomer(String customername)
{
	textboxStartTyping.sendKeys(customername);
}
public void clickSearchedCustomer()
{
	searchedCreatedCustomer.click();
}
public void clickAction()
{
	buttonAction.click();
	Helper.sleep();
}
public void clickEditButton()
{
	buttonEdit.click();
	Helper.sleep();
}
public void clickDelete()
{
	buttonDelete.click();
	Helper.sleep();
}

public void clickDeletePermantely()
{
	buttonDeletePermanently.click();
	Helper.sleep();
	
}

}