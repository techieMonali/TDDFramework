package com.selenium.maven.tests;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.selenium.maven.pages.homePage;


@Listeners(com.selenium.maven.base.testngListners.class)  
public class homePageTest extends homePage{
	homePage obj = new homePage();

	public static Logger logger = LogManager.getLogger(homePageTest.class);
	
	@BeforeSuite
	public void initiate() throws IOException {
		obj.startSession("chrome");
		logger.info("Started session");	
	}

	@Test(priority=0,groups="Regression",description="Verify home page title.")
	@Parameters({"first","second"})
	public void verifyTitle(String first, String second) throws IOException {
		String actualTitle = obj.getPageTitle();
		String expTitle = obj.getProperty("\\src\\test\\resources\\testData.properties", "homePageTitle");
		
		Assert.assertEquals(expTitle,actualTitle);
		logger.info("Verifying title");
		logger.info("Checking tesNG parameter functionality: "+first+" "+second);
	}
	
	@Test(priority=1,groups="Regression",description="Verify search bar.")
	public void verifySearchBar() throws IOException {
		
	    Assert.assertTrue(obj.verifySearchBarPresence());
	    logger.info("Verifying search bar is present");
	}
	
	@Test(priority=2,groups="Regression",description="Verify search bar.")
	public void verifySearchFunc() throws IOException {
		String srchStr = obj.getProperty("\\src\\test\\resources\\testData.properties", "searchTxt");
		obj.searchProduct(srchStr);
		String actualTitle = obj.getPageTitle();
		String expTitle = obj.getProperty("\\src\\test\\resources\\testData.properties", "searchStrPgTitle");
		
		Assert.assertEquals(expTitle,actualTitle);
		logger.info("Verified search functionality");
	}
	
	@Test(priority=3,groups="Regression",description="Verify search result.",dependsOnMethods="verifySearchFunc")
	public void verifySearchResult() throws IOException {
		obj.openFstItmFrmSrchRslt();
	}
	
	@DataProvider
	public Object[][] provideData() {
		return new Object[][] {{2,3},{5,5}};
	}
	
	@Test(dataProvider = "provideData")
	public void printDataProviderData(int a, int b) {
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(a, b);
		logger.info("Soft assert: numbers are not equal");
		logger.info(a+" "+b);
	}
	
	@AfterClass
	public void endSession() {
		obj.closeSession();
		logger.info("Ending session");
	}
}
