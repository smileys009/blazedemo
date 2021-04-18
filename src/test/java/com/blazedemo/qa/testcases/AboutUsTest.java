package com.blazedemo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.qa.base.TestBase;
import com.blazedemo.qa.pages.MainPage;

public class AboutUsTest extends TestBase {
	MainPage mainpage;
	
	@BeforeMethod
	public void driverStart() 
	{
		initialize();
		mainpage = new MainPage(driver);
		mainpage.clickAboutUsLink();
	}

	@Test
	public void verifyAboutUsPromptCanBeOpened() throws Exception 
	{
		Assert.assertEquals(mainpage.getAboutUsLabel(), "Among us");
	}

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	    

}

