package com.blazedemo.qa.report;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.blazedemo.qa.util.testUtil;

public class testListener implements ITestListener {

	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		extentTestManager.endTest();
		extentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		extentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		extentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		extentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

	
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		extentTestManager.getTest().fail("<details><summary><b><font color=red>Exception Occured, click to see details:"
				+"</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>") +"</details> \n");
		testUtil testUtil = new testUtil();
		String path = testUtil.takeScreenshot(result.getMethod().getMethodName());
		
		try
		{
			extentTestManager.getTest().fail("<b><font color=red>" + "Screenshot of Failure" + "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		catch(IOException e)
		{
			extentTestManager.getTest().fail("Test Failed, cannot attach screenshot");
		}
		
		String logText = "<b>Test Method" + methodName + "Failed</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTestManager.getTest().log(Status.FAIL,m);
	}
	

}