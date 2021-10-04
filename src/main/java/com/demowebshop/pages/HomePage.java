package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.PageUtility;
import com.relevantcodes.extentreports.ExtentTest;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _loginMenu = "//a[@class=\"ico-login\"]";
	@FindBy(xpath = _loginMenu)
	WebElement loginMenu;
	
	private final String _registerMenu="//a[@class='ico-register']";
	@FindBy(xpath=_registerMenu)
	WebElement registerMenu;

	public String getHomePageTitle() {
		return PageUtility.getPageTitle(driver);
	}

	public LoginPage clickOnLoginMenu() {
		PageUtility.clickOnElement(loginMenu);
		return new LoginPage(driver);
	}
	
	public RegisterPage clickOnRegisterMenu()
	{
		PageUtility.clickOnElement(registerMenu);
		return new RegisterPage(driver);
	
	}
}
