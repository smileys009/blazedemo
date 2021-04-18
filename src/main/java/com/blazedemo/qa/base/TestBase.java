package com.blazedemo.qa.base;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;

	public void initialize()
	{		
		if(System.getProperty("browser") !=null && System.getProperty("browser").equalsIgnoreCase("FIREFOX"))
		{
		    WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();						
		}
		else
		{
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();			
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.demoblaze.com/index.html");
	}
	
	
	
	//waits
	public static void loadingWait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.pollingEvery(Duration.ofSeconds(3));
				wait.until(
						webDriver -> element.isDisplayed()
				);
	}
	
	
	public static String getAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
    	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    	String alertText = alert.getText();
    	alert.accept();
        return alertText;
	}
	
	
	
}
