package com.demowebshop.testscript;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.Constants;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage home;
	LoginPage login;
	ExcelUtility excel;
	UserAccountPage useraccount;
	String path = properties.getProperty("ExcelPath");

	@Test
	public void verifyLoginPageTitle() {
		extentTest = extent.startTest("verifyLoginTitle","verify title of login page under test");
		home = new HomePage(driver);
		login = home.clickOnLoginMenu();
		String actualTitle = login.getLoginPageTitle();
		String expectedTitle = "Demo Web Shop. Login";
		Assert.assertEquals(actualTitle, expectedTitle, "Invalid loginpage title");
	}
@Test
	public void verifyLoginId() throws IOException {
	extentTest = extent.startTest("verifyLoginId","verify login id of login page under test");
		excel = new ExcelUtility(path, "Sheet1");
		home = new HomePage(driver);
		login = home.clickOnLoginMenu();
		login.enterUserName(excel.getStringCellData(1, 0));
		login.enterPassword(excel.getStringCellData(1, 1));
		login.clickOnLoginButton();
		useraccount=new UserAccountPage(driver);
		String actualText = useraccount.userLoginAccountpageId();
		String expectedText = "anumanoj11@gmail.com";
		Assert.assertEquals(actualText, expectedText, "invalid user id");
	}

}
