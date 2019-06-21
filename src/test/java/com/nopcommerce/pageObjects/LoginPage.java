package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;//create object
	
	public LoginPage(WebDriver rdriver)//Create constractor - come from actual test case
	
	{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Log in']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement lnkLogout;
	// Above all are object identification method
	
	//Action method
	public void setUserName(String uname)// come from actual test case
	{
		txtEmail.sendKeys(uname);
	}
	public void setPassword(String pwd)// come from actual test case
	{
		txtPassword.sendKeys(pwd);
	}
	public void clickLogin()
	{
		btnLogin.click();
	}
	public void clickLogout()
	{
		lnkLogout.click();
}
}