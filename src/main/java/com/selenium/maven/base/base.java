package com.selenium.maven.base;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {

	public static void launchBrowser(String browserType) throws InterruptedException {
		WebDriver driver = null;
		if(browserType=="chrome") {
			driver = new ChromeDriver();
		}else if(browserType=="firefox") {
			driver = new FirefoxDriver();
		}else if(browserType=="edge") {
			driver = new EdgeDriver();
		}else if(browserType=="safari") {
			driver = new SafariDriver();
		}else {
			System.out.println("You forgot to mention Browser name");
		}
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//implicit wait in selenium 4
		//before : driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		
		//explicit wait
		//before : WebDriverWait wait = new WebDriverWait(driver,10);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myElement")));
		//fluent wait
		//before : Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
		//		.withTimeout(30, TimeUnit.SECONDS)
		//		.pollingEvery(5, TimeUnit.SECONDS)
		//		.ignoring(NoSuchElementException.class);
		
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class);
		WebElement ele = fWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myElement")));
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		launchBrowser("edge");
		
	}
	
}

