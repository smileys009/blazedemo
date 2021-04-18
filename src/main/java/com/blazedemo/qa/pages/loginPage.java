package com.weframeandwork.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class loginPage {
	WebDriver driver;

	By userName = By.id("email");
	By password = By.id("passwd");
	By header = By.xpath("//h1[@class='page-heading']");
	By registerError = By.xpath("//li[contains(text(),'Invalid email address')]");
	By registerButton = By.id("SubmitCreate");

	public loginPage(WebDriver driver)
	{
		this.driver = driver;
	}    

    public void loginProper(String un, String pw) {
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(un);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pw);
    }
    
    public String getBlankError()
    {
    	driver.findElement(registerButton).click();
        return driver.findElement(registerError).getText();
    }
}