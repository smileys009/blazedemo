package com.weframeandwork.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testBase {
	public static WebDriver driver;

	public void initialize()
	{		
		if(System.getProperty("browser") !=null && System.getProperty("browser").equalsIgnoreCase("CHROME"))
		{
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();			
		}
		else
		{
		    WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();						
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php?controller=authentication");
	}
	
	
}
