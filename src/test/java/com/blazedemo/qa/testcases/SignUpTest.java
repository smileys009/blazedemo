package com.blazedemo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.qa.base.TestBase;
import com.blazedemo.qa.pages.HomePage;
import com.blazedemo.qa.pages.MainPage;

public class SignUpTest extends TestBase {
	MainPage mainpage;
	HomePage homepage;
	
	@BeforeMethod
	public void driverStart() 
	{
		initialize();
		mainpage = new MainPage(driver);
		mainpage.clickSignUpLink();
	}

	@Test
	public void verifySignUpPromptCanBeOpened() throws Exception 
	{
	mainpage.assertSignUpPromptAppears();
	}
	
	
	@Test
	public void verifyBlankErrorforSignUp() 
	{
		mainpage.setSignUp("", "");
		Assert.assertEquals(getAlert(driver), "Please fill out Username and Password.");

		mainpage.setSignUp("", "a");
		Assert.assertEquals(getAlert(driver), "Please fill out Username and Password.");

		mainpage.setSignUp("nonexistinguser0928", "");
		Assert.assertEquals(getAlert(driver), "Please fill out Username and Password.");
	}
	
	@Test
	public void verifyExistingUserErrorforSignup() 
	{
		mainpage.setSignUp("a", "a");
		Assert.assertEquals(getAlert(driver), "This user already exist.");

		mainpage.setSignUp("b", "a");
		Assert.assertEquals(getAlert(driver), "This user already exist.");
	}
	
	
	@Test
	public void verifyRegisterUserWorks() 
	{
		String un = mainpage.randomIdentifier();
		mainpage.setSignUp(un, "demoblazePW");
		Assert.assertEquals(getAlert(driver), "Sign up successful.");

		mainpage.clickLoginLink();
		mainpage.setLogin(un, "demoblazePW");
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.getWelcomeText(), "Welcome " +un);
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	    

}

