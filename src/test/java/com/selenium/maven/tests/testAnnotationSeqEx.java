package com.selenium.maven.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(com.selenium.maven.base.testngListners.class) 
public class testAnnotationSeqEx {
	
	@BeforeSuite
	public void bfSuite() {
		System.out.println("Before suite: Launching driver");
	}
	
	@BeforeClass
	public void bfCls() {
		System.out.println("Before class");
	}
	
	@BeforeMethod
	public void bfM() {
		System.out.println("Before method");
	}
	
	@AfterMethod
	public void afM() {
		System.out.println("After method");
	}
	
	@BeforeTest
	public void bfTest() {
		System.out.println("Before test");
	}
	
	@BeforeGroups("grp1")
	public void bfgrp() {
		System.out.println("Before grps");
	}
	
	@Test(groups = "grp1")
	public void test() {
		System.out.println("Test");
	}
	
	
	
	@Test(groups = "grp2")
	public void test1() {
		System.out.println("Test1");
	}
	
	@AfterTest
	public void afTest() {
		System.out.println("After test");
	}
	
	@BeforeTest
	public void bfTest1() {
		System.out.println("Before test1");
	}
	
	@AfterClass
	public void afCls() {
		System.out.println("After class");
	}
	
	@AfterSuite
	public void deleteAllCookies() {
		System.out.println("After suite");
	}
}
