package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class LoginPage extends TestBase{

	
	
	@FindBy(name="email")
	WebElement textboxEmail;
	
	@FindBy(name="password")
	WebElement textboxPassword;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement buttonLogin_LoginPage;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String email , String password) throws InterruptedException
	{
		Thread.sleep(5000);
		textboxEmail.sendKeys(email);
		textboxPassword.sendKeys(password);
		buttonLogin_LoginPage.click();
		return new HomePage();
	}
}
