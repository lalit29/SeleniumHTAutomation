package com.ht.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.ht.pages.BaseClass;
import com.ht.pages.LoginPage;
import com.ht.utility.BrowserFactory;
import com.ht.utility.ExcelDataProvider;
import com.ht.utility.Helper;

public class LoginTest extends BaseClass {

	@Test
	public void loginApp() {



		logger = report.createTest("Login to HT");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		logger.info("Start App");

		loginPage.loginHt("lalit@hometown.in","123456");
		//loginPage.loginHt(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));

		logger.pass("Login Success");

	}

}
