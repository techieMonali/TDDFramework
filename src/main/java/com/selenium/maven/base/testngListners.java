package com.selenium.maven.base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testngListners implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
// TODO Auto-generated method stub  
	}

	@Override
	public void onTestSuccess(ITestResult result) {
// TODO Auto-generated method stub  
		System.out.println("Success of test cases and its details are : " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
// TODO Auto-generated method stub  
		System.out.println("Failure of test cases and its details are : " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
// TODO Auto-generated method stub  
		System.out.println("Skip of test cases and its details are : " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
// TODO Auto-generated method stub  
		System.out.println("Failure of test cases and its details are : " + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart");
// TODO Auto-generated method stub  
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
// TODO Auto-generated method stub  
	}
}
