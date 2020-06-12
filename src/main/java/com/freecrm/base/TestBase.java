package com.freecrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.freecrm.util.TestUtil;
import com.freecrm.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eventDriver;
	public static WebEventListener eventListener;
	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Deepanshu Singhal\\eclipse-workspace\\FreeCRMApplication"
					+ "\\src\\main\\java\\com\\freecrm\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
 		}
		else if (browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\ChromeDriver\\chromedriver_win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//IMPORTANT******************************
		eventDriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eventDriver.register(eventListener);
		driver = eventDriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public static void sendKeys(WebDriver driver , WebElement element , int timeout , String value)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	public static void click(WebDriver driver , WebElement element , int timeout)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public static void closeSession()
	{
		driver.quit();
	}
	public static boolean isPresentAndDisplayed(WebElement element) throws InterruptedException
	{
		Thread.sleep(5000);
		try 
		{
			if(element.isDisplayed())
			{
				return true;
			}
		}
			catch(Exception e)
			{
				System.out.println("Element not present");
			}
		return false;
	}
}
