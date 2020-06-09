package com.freecrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;

public class TestLoginFunctionality extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public TestLoginFunctionality()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	
	@Test
	public void testLogin()
	{
		homePage.clickLoginButton();
		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown()
	{
		closeSession();
	}
}
