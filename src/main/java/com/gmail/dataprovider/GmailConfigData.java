package com.gmail.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GmailConfigData {

	private Properties pro;

	public GmailConfigData() throws IOException {

		FileInputStream fis = null;

		File src = new File("./GmailConfigData/gmailConfig.properties");
		try {
			fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("The Exception is :" + e.getStackTrace());
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			if (fis != null)
				fis.close();
		}
	}

	public String getKeyValue(String key) {
		return pro.getProperty(key);
	}

	public static GmailConfigData getConfigData() throws IOException{
		return new GmailConfigData();
	}
}
