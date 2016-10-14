package com.gmail.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.gmail.dataprovider.GmailConfigData;
import com.gmail.dataprovider.GmailExcelData;
import com.gmail.pages.GmailPageFactoryLogin;
import com.gmail.utilities.CrossBrowserUtilities;
import com.relevantcodes.extentreports.LogStatus;

public class GmailLoginPage extends CrossBrowserUtilities {

	private GmailPageFactoryLogin gmailPageFactoryLogin;

	@Test
	public void TestHome() throws IOException {

		logger = extentReports.startTest("verifyGmailLogin");

		driver.get(GmailConfigData.getConfigData().getKeyValue("url"));

		logger.log(LogStatus.INFO, "Application is up and running");

		gmailPageFactoryLogin = PageFactory.initElements(driver, GmailPageFactoryLogin.class);
		gmailPageFactoryLogin.gmailLogin(GmailExcelData.getExcelConfig().getSExceldata(0, 0, 0),
				GmailExcelData.getExcelConfig().getSExceldata(0, 0, 1));

		logger.log(LogStatus.PASS, "Gmail login successful");
	}

}
