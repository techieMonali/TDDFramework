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

	public static void launchBrowser(String browserType) {
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
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.quit();
	}
	
	
}

