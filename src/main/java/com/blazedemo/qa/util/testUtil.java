package com.blazedemo.qa.util;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.blazedemo.qa.base.TestBase;

public class testUtil extends TestBase {
	public String takeScreenshot(String methodName)
	{
		String fileName = getScreenshotName(methodName);
		String directory = System.getProperty("user.dir") + "/screenshots/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		try
		{
			File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));
			System.out.println("*******");
			System.out.println("Located at " +path);

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return path;
	}

	public String getScreenshotName(String methodName)
	{
		Date d = new Date();
		String filename = methodName + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
		return filename;
	}

}