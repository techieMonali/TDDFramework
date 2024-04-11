package com.selenium.maven.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import com.selenium.maven.pages.homePage;

public class homePageTest extends homePage{
	homePage obj = new homePage();
	
	@BeforeSuite
	public void initiate() {
		obj.startSession("chrome");
		System.out.println("Starting session");
	}

	@Test(priority=0,groups="Regression",description="Verify home page title.")
	public void verifyTitle() throws IOException {
		String actualTitle = obj.getPageTitle();
		String expTitle = obj.getProperty("\\src\\test\\resources\\testData.properties", "homePageTitle");
		
		Assert.assertEquals(expTitle,actualTitle);
		System.out.println("Verifying title");
	}
	
	@Test(priority=1,groups="Regression",description="Verify search bar.")
	public void verifySearchBar() throws IOException {
		Assert.assertTrue(obj.verifySearchBarPresence());
		System.out.println("Verifying search bar is present");
	}
	
	@Test(priority=2,groups="Regression",description="Verify search bar.")
	public void verifySearchFunc() throws IOException {
		String srchStr = obj.getProperty("\\src\\test\\resources\\testData.properties", "searchTxt");
		obj.searchProduct(srchStr);
		String actualTitle = obj.getPageTitle();
		String expTitle = obj.getProperty("\\src\\test\\resources\\testData.properties", "searchStrPgTitle");
		
		Assert.assertEquals(expTitle,actualTitle);
		System.out.println("Verified search functionality");
	}
	
	@Test(priority=3,groups="Regression",description="Verify search result.",dependsOnMethods="verifySearchFunc"
			, alwaysRun=false)
	public void verifySearchResult() throws IOException {
		obj.openFstItmFrmSrchRslt();
	}
	
	@AfterClass
	public void endSession() {
		obj.closeSession();
		System.out.println("Ending session");
	}
}
