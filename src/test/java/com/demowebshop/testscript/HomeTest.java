package com.demowebshop.testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class HomeTest extends Base {
	HomePage home;

	@Test
	public void verifyHomeTitle() {
		extentTest = extent.startTest("verifyHomeTitle","verify title of home page under test");
		home = new HomePage(driver);
		String actualTitle=home.getHomePageTitle();
		String expectedTitle = "Demo Web Shop";
		Assert.assertEquals(actualTitle, expectedTitle,"Invalid home page title");

	}
}
