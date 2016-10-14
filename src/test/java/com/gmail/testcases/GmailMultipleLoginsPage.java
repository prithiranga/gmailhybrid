package com.gmail.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gmail.dataprovider.GmailConfigData;
import com.gmail.dataprovider.GmailExcelData;
import com.gmail.pages.GmailPageFactoryLogin;
import com.gmail.utilities.CrossBrowserUtilities;
import com.relevantcodes.extentreports.LogStatus;

public class GmailMultipleLoginsPage extends CrossBrowserUtilities {

	@Test(dataProvider = "multipleLogins")
	public void getMultipleLogins(String userName, String password  ) throws IOException {

		logger = extentReports.startTest("verify Multiple GmailLogins");
		
		driver.get(GmailConfigData.getConfigData().getKeyValue("url"));

		logger.log(LogStatus.INFO, "Application is up and running");

		GmailPageFactoryLogin gmailPageFactoryLogin = PageFactory.initElements(driver, GmailPageFactoryLogin.class);
		
		gmailPageFactoryLogin.gmailLogin(userName, password);
		
		gmailPageFactoryLogin.getComposeWait();
		
		//driver.switchTo().alert().accept();
		
		logger.log(LogStatus.PASS, "Gmail login successful");
	}

	@DataProvider(name = "multipleLogins")
	public Object[][] testMultipleLogins() throws IOException {

		int rows = GmailExcelData.getExcelConfig().getRowCount(0);
		System.out.println("The total no of rows is :" + rows);

		Object[][] data = new Object[rows][2];

		for (int i = 0; i < rows; i++) {
			data[i][0] = GmailExcelData.getExcelConfig().getSExceldata(0, i, 0);
			data[i][1] = GmailExcelData.getExcelConfig().getSExceldata(0, i, 1);
		}
		return data;
	}
}
