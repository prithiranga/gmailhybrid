package com.gmail.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	public static String captureScreenShot(WebDriver driver, String testcaseName){
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String des = ("./GmailScreenShots/"+testcaseName+System.currentTimeMillis()+".png");
		try {
			FileUtils.copyFile(src, new File(des));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return des;
		
	}

}
