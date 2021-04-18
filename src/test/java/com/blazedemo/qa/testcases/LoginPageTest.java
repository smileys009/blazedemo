package com.blazedemo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.qa.base.TestBase;
import com.blazedemo.qa.pages.HomePage;
import com.blazedemo.qa.pages.MainPage;

public class LoginPageTest extends TestBase {
	MainPage mainpage;
	HomePage homepage;
	
	@BeforeMethod
	public void driverStart() 
	{
		initialize();
		mainpage = new MainPage(driver);
		mainpage.clickLoginLink();
	}

	@Test
	public void verifyLoginPromptCanBeOpened() throws Exception 
	{
	mainpage.assertLoginPromptAppears();
	}
	
	
	@Test
	public void verifyBlankErrorforLogin() 
	{
		mainpage.setLogin("", "");
		Assert.assertEquals(getAlert(driver), "Please fill out Username and Password.");

		mainpage.setLogin("", "a");
		Assert.assertEquals(getAlert(driver), "Please fill out Username and Password.");

		mainpage.setLogin("doromaitos", "");
		Assert.assertEquals(getAlert(driver), "Please fill out Username and Password.");
	}
	
	@Test
	public void verifyInvalidCredentialError() 
	{
		mainpage.setLogin("nonexistinguser0927", "a");
		Assert.assertEquals(getAlert(driver), "User does not exist.");
	}
	
	
	@Test
	public void verifyInvalidPasswordError() 
	{
		mainpage.setLogin("a", "incpw");
		Assert.assertEquals(getAlert(driver), "Wrong password.");
	}
	
	@Test
	public void verifyLoginWorks() 
	{
		mainpage.setLogin("a", "a");
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.getWelcomeText(), "Welcome a");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	    

}

