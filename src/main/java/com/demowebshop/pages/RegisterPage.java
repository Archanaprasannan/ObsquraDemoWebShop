package com.demowebshop.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.PageUtility;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getRegisterPageTitle() {
		return PageUtility.getPageTitle(driver);
	}
	
	private final String _gender="gender-female";
	@FindBy(id=_gender)
	WebElement gender;


	private final String _firstName = "FirstName";
	@FindBy(id = _firstName)
	WebElement firstName;

	private final String _lastName = "LastName";
	@FindBy(id = _lastName)
	WebElement lastName;

	private final String _email = "Email";
	@FindBy(id = _email)
	WebElement eMail;

	private final String _password = "Password";
	@FindBy(id = _password)
	WebElement password;

	private final String _confirmpassword = "ConfirmPassword";
	@FindBy(id = _confirmpassword)
	WebElement confirmpassword;

	private final String _register = "register-button";
	@FindBy(id = _register)
	WebElement registerButton;
	
	public void clickOnGender() {
		PageUtility.clickOnElement(gender);
	}


	public void enterFirstName(String fName) {
		PageUtility.enterText(firstName, fName);
	}

	public void enterLastName(String lName) {
		PageUtility.enterText(lastName, lName);
	}

	public void enterEmail(String email) {
		PageUtility.enterText(eMail, email);
	}

	public void enterPassword(String pass) {
		PageUtility.enterText(password, pass);
	}

	public void enterConfirmPassword(String cpass) {
		PageUtility.enterText(confirmpassword, cpass);
	}

	public UserAccountPage clickOnRegister() {
		PageUtility.clickOnElement(registerButton);
		return new UserAccountPage(driver);
	}

}
