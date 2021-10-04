package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.PageUtility;
import com.demowebshop.utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _email = "Email";
	@FindBy(id = _email)
	private WebElement userName;

	private final String _loginPassword = "Password";
	@FindBy(id = _loginPassword)
	private WebElement password;

	private final String _loginClick = "//input[@class='button-1 login-button']";
	@FindBy(xpath = _loginClick)
	WebElement loginButton;

	public String getLoginPageTitle() {
		return PageUtility.getPageTitle(driver);
	}

	public void enterUserName(String uName) {
		PageUtility.enterText(userName, uName);
	}

	public void enterPassword(String pName) {
		PageUtility.enterText(password, pName);
	}

	public UserAccountPage clickOnLoginButton() {
		PageUtility.clickOnElement(loginButton);
		return new UserAccountPage(driver);
		
	}

}
