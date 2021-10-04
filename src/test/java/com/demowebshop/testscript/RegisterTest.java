package com.demowebshop.testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.Constants;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.RegisterPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilities.ExcelUtility;

public class RegisterTest extends Base{
	String path= properties.getProperty("ExcelPath");
	HomePage home;
	RegisterPage register;
	ExcelUtility excel;
	UserAccountPage useraccount;
	@Test
public void verifyRegisterPageTitle()
{
	extentTest = extent.startTest("verifyRegisterPageTitle","verify  title of register page under test");
	home=new HomePage(driver);
	register=home.clickOnRegisterMenu();
	String actualTitle=register.getRegisterPageTitle();
	String expectedTitle="Demo Web Shop. Register";
	Assert.assertEquals(actualTitle, expectedTitle, expectedTitle);
	
}
	@Test
	public void verifyRegistrationId() throws IOException
	{
		extentTest = extent.startTest("verifyRegistrationId","verify register id of register page under test");
		excel=new ExcelUtility(path,"Sheet2");
		home=new HomePage(driver);
		register=home.clickOnRegisterMenu();
		register.enterFirstName(excel.getStringCellData(1, 0));
		register.enterLastName(excel.getStringCellData(1,1));
		register.enterEmail(excel.getStringCellData(1,2));
		register.enterPassword(excel.getStringCellData(1, 3));
		register.enterConfirmPassword(excel.getStringCellData(1, 4));
		register.clickOnRegister();
		useraccount=new UserAccountPage(driver);
		String actualText=useraccount.userRegisterAccountpageId();
		String expectedText="anumanoj11@gmail.com";
		Assert.assertEquals(actualText, expectedText, "invalid user id");
		
		
	}
}
