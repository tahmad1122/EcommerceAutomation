package com.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.pages.LoginPage;

public class BaseClass {
	
	protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        
    }
    
    @AfterMethod
    public void tearDown() {
    	driver.close();
    }
    
    //loginToApplication is reusable and repeated method 
    public void loginToApplication(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(username);
        loginPage.setPassWord(password);
        loginPage.setLogin();
        
    }


}
