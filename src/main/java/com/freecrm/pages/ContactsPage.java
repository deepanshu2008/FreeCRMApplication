package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class ContactsPage extends TestBase{

	
	@FindBy(xpath ="//span[contains(text(),'Contacts')]")
	WebElement labelContacts;
	
	@FindBy(xpath ="//button[@class='ui linkedin button' and contains(text(),'New')]")
	WebElement buttonAddNewContact;
	
	@FindBy(name ="first_name")
	WebElement textboxFirstName;
	
	@FindBy(name ="last_name")
	WebElement textboxLastName;
	
	@FindBy(xpath ="//button[@class='ui linkedin button' and contains(text(),'Save')]")
	WebElement buttonSaveContact;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickContactsAddNewAndEnterFNLN(String fName , String lName) throws InterruptedException
	{
		Thread.sleep(3000);
		click(driver, labelContacts, 3);
		Thread.sleep(3000);
		click(driver, buttonAddNewContact, 5);
		sendKeys(driver, textboxFirstName, 3, fName);
		sendKeys(driver, textboxLastName, 3, lName);
		click(driver, buttonSaveContact, 5);
		Thread.sleep(3000);
	}
	
}
