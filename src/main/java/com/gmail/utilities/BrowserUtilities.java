package com.gmail.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.gmail.browserfactory.GmailBrowserFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BrowserUtilities {

	protected WebDriver driver;
	protected ExtentReports extentReports;
	protected ExtentTest logger;

	@BeforeMethod
	public void setup() throws IOException {
		extentReports = new ExtentReports("./GmailReports/GmailLoginPage.html", true);
		driver = GmailBrowserFactory.getBrowser("chrome");

	}

	@AfterMethod
	public void cleanup() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		extentReports.endTest(logger);
		extentReports.flush();
	}
	
	@AfterMethod
	public void verifyResult(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE){
			ScreenShot.captureScreenShot(driver, result.getName());
		}
	}
}
