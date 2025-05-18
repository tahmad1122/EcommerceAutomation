package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	//initializes all the @FindBy WebElements
	public LoginPage( WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Web element by @FindBy annotation.
	@FindBy(id = "user-name")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement passWord;
	
	@FindBy(id = "login-button")
	WebElement login;
	
	@FindBy(xpath = "//div[@class='error-message-container error']")
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
	
	
	 public boolean isLoginSuccessful() {
		 try {
			return driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
		} catch (Exception e) {
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
