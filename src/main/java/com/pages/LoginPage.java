package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	
	//initializes all the @FindBy WebElements
	public LoginPage( WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Web element by @FindBy annotation.
	@FindBy(xpath = "//input[@id='userEmail']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement passWord;
	
	@FindBy(xpath =  "//input[@id='login']")
	WebElement login;
	
	@FindBy(css ="div[aria-label='Login Successfully']")
	WebElement message;
	
	@FindBy(css = "div[aria-label='Incorrect email or password.']")
	WebElement errorMsg;

	//Action methods
	public void setUserName(String name) {
		userName.sendKeys(name);
		System.out.println(userName.getText());
	}

	public void setPassWord(String passWord) {
		this.passWord.sendKeys(passWord);;
	}

	public void setLogin() {
		login.click();
	}
	
	public void setMessage() throws Exception {
		 String loginMsg=message.getText();
		 Thread.sleep(2000);
	        System.out.println("Login message: " + loginMsg );
	}
	
	
	 public boolean isLoginSuccessful() {
		 try {
		        String currentUrl = driver.getCurrentUrl();
		        System.out.println("🔍 Current URL after login: " + currentUrl);
		        return currentUrl.equals("https://rahulshettyacademy.com/client/dashboard/dash");
		    } catch (Exception e) {
		        System.out.println("❌ Error while checking login URL: " + e.getMessage());
		        return false;
		    }
		
	 }
	 
	 //getText() does not work on <input> fields
	 @SuppressWarnings("deprecation")
	public void getTextMes() {
		    String username = userName.getAttribute("value");  
	        String password = passWord.getAttribute("value");  
	        String result = "Username: " + username + " | Password: " + password;
	        System.out.println(result);			
		}
	 
	 //getting user name and password error text
	 public void setErrorMsg() {
		String text=errorMsg.getText();
		System.out.println("Error message: "+text);
	}
	
	
	
	
}
