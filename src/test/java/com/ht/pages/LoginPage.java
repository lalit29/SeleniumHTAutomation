package com.ht.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	
		//divl[contains(text(), "Password ")]
		
		//input[@type="text" and @class="Input-tbll8j-0 djSSHH"]
		//input[@type="password" and @class="Input-tbll8j-0 djSSHH"]
		//button[@class="Buttons__Button-sc-1t83isl-0 lprDVA"]
		
		
	@FindBy(xpath="//input[@type=\"text\" and @class=\"Input-tbll8j-0 djSSHH\"]") WebElement w1;
	@FindBy(xpath="//input[@type=\"password\" and @class=\"Input-tbll8j-0 djSSHH\"]") WebElement w2;
	@FindBy(xpath="//button[@class=\"Buttons__Button-sc-1t83isl-0 lprDVA\"]") WebElement w3;
	
	public void loginHt(String userName , String password) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		w1.sendKeys(userName);
		w2.sendKeys(password);
		w3.click();
		
	}

}
