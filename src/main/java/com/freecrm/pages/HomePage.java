package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class HomePage extends TestBase{
	
	//Page factory
		@FindBy(xpath="//a//span[contains(text(),'Log In')]")
		WebElement buttonLogin;
		

		
		public HomePage(){
		{
			PageFactory.initElements(driver, this);
		}
			}

		
		public LoginPage clickLoginButton()
		{
			buttonLogin.click();
			return new LoginPage();
		}
}