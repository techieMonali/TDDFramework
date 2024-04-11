package com.selenium.maven.pages;

import org.openqa.selenium.By;

import com.selenium.maven.base.base;

public class homePage extends base{
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
		System.out.println("Added Search string in searcch box");
		driver.findElement(searchIcon).click();
		System.out.println("Clicked on search icon");
	}
	
	public void openFstItmFrmSrchRslt() {
		String prodNm = driver.findElement(fstRsltItm).getText();
		String originalWindow = driver.getWindowHandle();
		System.out.println(originalWindow);
		driver.findElement(fstRsltItm).click();
		System.out.println("Clicked on first item from search result");
		
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        String newWindow = driver.getWindowHandle();
				System.out.println(newWindow);
		        break;
		    }
		}
		
		
		String actualPageTitle = getPageTitle();
		
	}
}
