package com.blazedemo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import com.blazedemo.qa.base.TestBase;

public class HomePage extends TestBase {
	WebDriver driver;

	
	By welcomeUserText = By.id("nameofuser");
	By logoutLink = By.xpath("//a[normalize-space()='Log out']");

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	//login Proper methods
	public String getWelcomeText() {
		String welcomeText;
	    try
	    {
	    	loadingWait(driver, driver.findElement(logoutLink));
	    	welcomeText = driver.findElement(welcomeUserText).getText();
	    }
	      catch(StaleElementReferenceException e)
	    {
	    	  loadingWait(driver, driver.findElement(logoutLink));
	    	  welcomeText =  driver.findElement(welcomeUserText).getText();
	    }	    
		return welcomeText;
	}
	

}