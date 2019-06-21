package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;

import com.nopcommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	
	
	public void logintest() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		logger.info("URL is opened....");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("User provided");//logger msg
		
		lp.setPassword(password);
		logger.info("Password provided");//logger msg
		
		lp.clickLogin();
		logger.info("Login in clicked");//logger msg
		
		Thread.sleep(5000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clickLogout();	
			logger.info("Login Passed");//logger msg
		}	
		else
		{
			captureScreen(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("Login Failed");//logger msg
		}
	}
}
	
	



