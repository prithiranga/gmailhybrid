package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPageFactoryLogin {

	private WebDriver driver;

	public GmailPageFactoryLogin(WebDriver driver) {
		this.driver = driver;
		System.out.println("driver called : " + this.driver);
	}

	 @FindBy(id = "Email") 
	 WebElement userName;
	 
	 @FindBy(id = "Passwd") 
	 WebElement password;
	 
	 @FindBy(id = "next")
	 WebElement nextButton;

	 @FindBy(id = "signIn")
	 WebElement signIn;
	 
	 @FindBy(xpath="//div[text()='COMPOSE']")
	 WebElement compose;
	 
	 By composeWait = By.xpath("//div[text()='COMPOSE']");

	/*WebElement userName = driver.findElement(By.id("Email"));
	WebElement password = driver.findElement(By.id("Passwd"));
*/
/*	
	 public void gmailLogin(String userName, String password) {
	  
	  System.out.println("----EmailField Exists----" + emailField);
	  this.userName.sendKeys(userName);
	  this.nextButton.click(); 
	  System.out.println("----Password field Exists----" + passwordField);
	  this.password.sendKeys(password); this.signIn.click(); 
	  }*/
	 

	public void gmailLogin(String userName, String password) {
		try {
			System.out.println("----EmailField Exists----" );
			this.userName.sendKeys(userName);
		} catch (Throwable e) {
			System.out.println("Email field not Found :" + e.getMessage());
		}
		this.nextButton.click();
		try {
			System.out.println("----Password field Exists----" );
			this.password.sendKeys(password);
		} catch (Throwable e) {
			System.out.println("Password field not Found :" + e.getMessage());
		}
		this.signIn.click();
	}
	
	public void getComposeWait(){
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(composeWait));
	}

}
