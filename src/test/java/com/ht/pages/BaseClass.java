package com.ht.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ht.utility.BrowserFactory;
import com.ht.utility.ConfigDataProvider;
import com.ht.utility.ExcelDataProvider;
import com.ht.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite() {
		
	    excel= new ExcelDataProvider();
	    config= new ConfigDataProvider();
	    
	    ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/HomeTown"+Helper.getCurrentDateTime()+".html"));
	    report= new ExtentReports();
	    report.attachReporter(extent);
	}
	
	
	@BeforeClass
	public void setUp() {
		
		driver = BrowserFactory.startApp(driver, "Chrome","https://www.hometown.in/login/?redirect=/");
	    //driver = BrowserFactory.startApp(driver, config.getBrowser(),config.getUrl());
		
	}
	
	@AfterClass
	public void tearDown() {
		
		BrowserFactory.quitBrowser(driver);
		
	}
	
	@AfterMethod
	public void tesrDownMethod(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			Helper.captureScreenshot(driver);
			logger.pass("Test passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		
		report.flush();
	}
	
//	@AfterSuite
//	public void sendEmail() {
//		
//	}

}
