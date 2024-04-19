package com.selenium.maven.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class base {
	public static WebDriver driver = null;

	public void startSession(String browserType) {

		if (browserType == "chrome") {
			driver = new ChromeDriver();
		} else if (browserType == "firefox") {
			driver = new FirefoxDriver();
		} else if (browserType == "edge") {
			driver = new EdgeDriver();
		} else if (browserType == "safari") {
			driver = new SafariDriver();
		} else {
			System.out.println("You forgot to mention Browser name");
		}

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public String getProperty(String filepath, String property) throws IOException {
		Properties prop = new Properties();
		String filePath = System.getProperty("user.dir") + filepath;

		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop.load(fis);
			property = prop.getProperty(property);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return property;
	}


	public void switchToTab() {

	}

	public String takeScreenshot(WebDriver driver, String testName) {
		driver = this.driver;
		TakesScreenshot sc = ((TakesScreenshot) driver); // converting web driver objects to take-screenshot
		File SrcFile = sc.getScreenshotAs(OutputType.FILE);
		String filePath = System.getProperty("user.dir") + "\\test-output\\Screenshots\\" + testName;

		File DestFile = new File(filePath + ".png");
		try {
			if (DestFile.exists()) {
				int cnt = 1;
				do {
					DestFile = new File(filePath + "-(" + cnt + ").png");
					cnt++;
				} while (DestFile.exists());
			}
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DestFile.getPath();
	}

	public void closeSession() {
		driver.quit();
	}
}
