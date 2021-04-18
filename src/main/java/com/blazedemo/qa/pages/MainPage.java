package com.blazedemo.qa.pages;

import static org.testng.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.blazedemo.qa.base.TestBase;

public class MainPage extends TestBase {
	WebDriver driver;

	// Header Link
	By signUpLink = By.id("signin2");
	By loginLink = By.id("login2");
	By aboutUsLink = By.xpath("//a[normalize-space()='About us']");

	// Sign up prompt
	By signUpModalLabel = By.id("signInModalLabel");
	By signUpUsernameTextbox = By.id("sign-username");
	By signUpPasswordTextbox = By.id("sign-password");
	By signupButton = By.xpath("//button[normalize-space()='Sign up']");
	By closeButtoninSignUp = By.xpath("//button[normalize-space()='Close']");

	// Login prompt
	By logInModalLabel = By.id("logInModalLabel");
	By loginUsernameTextbox = By.id("loginusername");
	By loginPasswordTextbox = By.id("loginpassword");
	By loginButton = By.xpath("//button[normalize-space()='Log in']");
	By closeButtoninLogin = By.xpath("//div[@id='logInModal']//button[@type='button'][normalize-space()='Close']");
	
	//About us prompt
	By videoModalLabel = By.id("videoModalLabel");
	By videoPlayer = By.id("example-video_html5_api");
			
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	// Header click methods
	public void clickSignUpLink() {
		driver.findElement(signUpLink).click();
		loadingWait(driver, driver.findElement(signUpModalLabel));
	}

	public void clickLoginLink() {
		driver.findElement(loginLink).click();
		loadingWait(driver, driver.findElement(logInModalLabel));
	}

	public void clickAboutUsLink() {
		driver.findElement(aboutUsLink).click();
		loadingWait(driver, driver.findElement(videoModalLabel));
	}

	// signup methods
	public String getSignUpLabel() {
		return driver.findElement(signUpModalLabel).getText();
	}

	public void setSignUp(String un, String pw) {
		driver.findElement(signUpUsernameTextbox).clear();
		driver.findElement(signUpUsernameTextbox).sendKeys(un);

		driver.findElement(signUpPasswordTextbox).clear();
		driver.findElement(signUpPasswordTextbox).sendKeys(pw);

		driver.findElement(signupButton).click();
	}

	public void assertSignUpPromptAppears() throws Exception {
		Assert.assertEquals(getSignUpLabel(), "Sign up");
	}

	//random username generator
	final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
	final java.util.Random rand = new java.util.Random();
	final Set<String> identifiers = new HashSet<String>();

	public String randomIdentifier() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = rand.nextInt(5)+5;
	        for(int i = 0; i < length; i++) {
	            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
	
	

	// login methods
	public String getLoginLabel() {
		return driver.findElement(logInModalLabel).getText();
	}

	public void setLogin(String un, String pw) {
		driver.findElement(loginUsernameTextbox).clear();
		driver.findElement(loginUsernameTextbox).sendKeys(un);

		driver.findElement(loginPasswordTextbox).clear();
		driver.findElement(loginPasswordTextbox).sendKeys(pw);

		driver.findElement(loginButton).click();
	}


	public void assertLoginPromptAppears() throws Exception {
		Assert.assertEquals(getLoginLabel(), "Log in");
	}
	
	
	//About us
	public String getAboutUsLabel() {
		return driver.findElement(videoModalLabel).getText();
	}

	//did not use
	public void assertVideoLink() throws Exception {
		WebElement element =  driver.findElement(videoPlayer);
		Assert.assertEquals(element.getAttribute("src"), "blob:https://www.demoblaze.com/626ae82e-7447-4d5e-a652-a5a8a8e06775");
	}

}