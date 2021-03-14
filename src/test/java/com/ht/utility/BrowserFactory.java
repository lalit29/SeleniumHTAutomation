package com.ht.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public static WebDriver startApp( WebDriver driver,String browserName,String url) {
		
		if (browserName.equals("Chrome")) {
			
			 System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");

			driver = new ChromeDriver();
			
		}
		
		else if (browserName.equals("Firefox")) {
			
			 System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver");

				driver = new FirefoxDriver();
			
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
