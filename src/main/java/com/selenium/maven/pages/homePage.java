package com.selenium.maven.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;

import com.selenium.maven.base.base;

@Listeners(com.selenium.maven.base.testngListners.class) 
public class homePage extends base{
	public static Logger logger = LogManager.getLogger(homePage.class);
	By searchBox = By.id("twotabsearchtextbox");
	By searchIcon = By.id("nav-search-submit-button");
	By fstRsltItm = By.xpath("//div[@data-component-type='s-search-result'][@data-index='3']//h2//span");
	
	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean verifySearchBarPresence() {
		return driver.findElement(searchBox).isDisplayed();
	}
	
	public void searchProduct(String searchStr) {
		driver.findElement(searchBox).sendKeys(searchStr);
		logger.info("Added Search string in searcch box");
		driver.findElement(searchIcon).click();
		logger.info("Clicked on search icon");
	}
	
	public void openFstItmFrmSrchRslt() {
		String originalWindow = driver.getWindowHandle();
		driver.findElement(fstRsltItm).click();
		logger.info("Clicked on first item from search result");
		
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
	}
}
