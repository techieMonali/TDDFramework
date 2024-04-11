package com.selenium.maven.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class base {
	public WebDriver driver = null;
	
	public void startSession(String browserType) {
		
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public String getProperty(String filepath, String property) throws IOException {
		Properties prop = new Properties();
		String filePath = System.getProperty("user.dir")+filepath;

		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop.load(fis);
			property= prop.getProperty(property);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return property;
	}
	
	public void switchToTab() {
		
	}
	
	public void closeSession() {
		driver.quit();
	}
}

