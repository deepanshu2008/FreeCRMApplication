package com.freecrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.pages.ContactsPage;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.TestUtil;

public class TestFreeCrmAddContactTestExcelReadData extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactPage;
	
	public TestFreeCrmAddContactTestExcelReadData()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		contactPage = new ContactsPage();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object data[][] = TestUtil.getTestData("Sheet1");
		return data;
	}
	
	
	@Test(dataProvider = "getData")
	public void testReadExcelData(String fName , String lName) throws InterruptedException
	{
		homePage.clickLoginButton().login(prop.getProperty("email"), prop.getProperty("password"));
		contactPage.clickContactsAddNewAndEnterFNLN(fName, lName);
	}
	
	@AfterMethod
	public void tearDown()
	{
		closeSession();
	}

}
