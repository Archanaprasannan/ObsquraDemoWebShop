package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.PageUtility;

public class UserAccountPage {
	WebDriver driver;

	public UserAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _userid="//div[@class='header-links']//ul//li//a[@class='account']";
	@FindBy(xpath=_userid)
	WebElement userLoginid;
	
	private final String _userregisterid="//div[@class='header-links']//ul//li//a[@class='account']";
	@FindBy(xpath=_userregisterid)
	WebElement userRegisterid;
	

	public String userLoginAccountpageId() {
		return PageUtility.getElementText(userLoginid);
	}
	
	public String userRegisterAccountpageId() {
		return PageUtility.getElementText(userRegisterid);
	}
}
