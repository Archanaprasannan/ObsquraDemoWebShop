package com.demowebshop.automationcore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



import io.github.bonigarcia.wdm.WebDriverManager;

import com.demowebshop.constants.Constants;
import com.demowebshop.extentreport.ExtentReportSetUp;
import com.demowebshop.utilities.WaitUtility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Base extends ExtentReportSetUp{
	public WebDriver driver;
	public static Properties properties;
	FileReader f;
	
	public Base()  {
		
		try {
			f = new FileReader(System.getProperty("user.dir") + Constants.CONFIG_FILE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(System.getProperty("user.dir"));
		// System.out.println(Constants.CONFIG_FILE);
		properties = new Properties();
		try {
			properties.load(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testInitialize(String browserName, String url) throws Exception {
		if (browserName.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// properties.getProperty("chromepath") + Constants.CHROMEPATH);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			// System.setProperty("webdriver.gecko.driver",
			// properties.getProperty("geckopath") + Constants.GECKOPATH);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equals("edge")) {
			// System.setProperty("webdriver.edge.driver",
			// properties.getProperty("edgepath") + Constants.EDGEPATH);
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else {
			throw new Exception("Invalid Browser Name");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(WaitUtility.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		driver.get(url);

	}

	/*@BeforeMethod
@Parameters("browser")
	public void setUp(String browserName) throws Exception {
		String browsername = browserName;
		String url = properties.getProperty("url");
		testInitialize(browsername, url);
	}*/
	
	@BeforeMethod
		public void setUp() throws Exception {
			String browsername = properties.getProperty("browser");
			String url = properties.getProperty("url");
			testInitialize(browsername, url);
		}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = ExtentReportSetUp.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + "verifyHometiltle");

		}
		
		
		
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		driver.quit();
	}
}
