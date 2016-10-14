package com.gmail.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.gmail.browserfactory.GmailBrowserFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class CrossBrowserUtilities {

	protected WebDriver driver;
	protected ExtentReports extentReports;
	protected ExtentTest logger;

	@BeforeMethod
	@Parameters("browser")
	public void setup(String browserName) throws IOException {
		
		extentReports = new ExtentReports("./GmailReports/GmailLoginPage.html", true);

		if (browserName.equalsIgnoreCase("firefox"))
			driver = GmailBrowserFactory.getBrowser("firefox");
		
		else if (browserName.equalsIgnoreCase("chrome"))
			driver = GmailBrowserFactory.getBrowser("chrome");
		
		else if (browserName.equalsIgnoreCase("IE"))
			driver = GmailBrowserFactory.getBrowser("IE");

	}

	@AfterMethod
	public void cleanup() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		extentReports.endTest(logger);
		extentReports.flush();
	}

	@AfterMethod
	public void verifyResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			ScreenShot.captureScreenShot(driver, result.getName());
		}
	}
}
