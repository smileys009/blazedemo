package com.weframeandwork.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.weframeandwork.qa.base.testBase;
import com.weframeandwork.qa.pages.loginPage;

public class loginPageTest extends testBase {
	@BeforeMethod
	public void driverStart() 
	{
		initialize();
	}

	@Test
	public void exampleofPassedTestCase() 
	{
		loginPage loginPage = new loginPage(driver);
		Assert.assertEquals(loginPage.getBlankError(), "Invalid email address.");
	}

	@Test
	public void exampleofFailedTestCase() 
	{
		loginPage loginPage = new loginPage(driver);
		Assert.assertEquals(loginPage.getBlankError(), "Invalid email address.");
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	    

}

