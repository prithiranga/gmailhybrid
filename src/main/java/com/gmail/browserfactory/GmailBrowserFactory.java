package com.gmail.browserfactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.gmail.dataprovider.GmailConfigData;

public class GmailBrowserFactory {

	private static WebDriver driver;

	// Browser Configuration
	public static  WebDriver getBrowser(String browserName) throws IOException {
		
		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", GmailConfigData.getConfigData().getKeyValue("ChromePath"));
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", GmailConfigData.getConfigData().getKeyValue("IEPath"));
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

}
