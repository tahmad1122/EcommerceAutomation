package com.testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.pages.LoginPage;

public class Login_TestCase_001 extends BaseClass {

	// Valid credentials
//	@Test(priority = 1, description = "Verify user can login with valid credentials ")
//	public void validLogin() throws Exception {
//		LoginPage loginPage = new LoginPage(driver);
//		String user = "poxemah619@hazhab.com";
//		String pass = "Smile@#!123";
//		loginPage.setUserName(user);
//		loginPage.setPassWord(pass);
//		loginPage.getTextMes();
//		loginPage.setLogin();
//		loginPage.setMessage();
//		Thread.sleep(2000);
//		//Assert.assertTrue(driver.findElement(By.cssSelector("div[aria-label='Login Successfully']")).isDisplayed());
//		Assert.assertTrue(loginPage.isLoginSuccessful(), "Login validation failed!");
//		Thread.sleep(3000);		
//		System.out.println("-------validLogin() Test Completed---------");     	
//
//	}
//	
//	// InValid credentials
//		@Test(priority = 2, description = "Verify user with invalid credentials ")
//		public void InValidLogin() throws Exception {
//			LoginPage loginPage = new LoginPage(driver);
//			String user = "poxemah619@hazhab.com";
//			String pass = "Smile@#!12";
//			loginPage.setUserName(user);
//			loginPage.setPassWord(pass);
//			loginPage.getTextMes();
//			loginPage.setLogin();
//			loginPage.setErrorMsg();
//			Thread.sleep(1000);
//			Assert.assertTrue(loginPage.isLoginSuccessful(), "Login validation failed!");
//			Thread.sleep(1000);		
//			System.out.println("-------InValidLogin() Test Completed---------");     	
//
//		}
	
	 @DataProvider(name = "loginData")
	    public Object[][] getLoginData() {
	        return new Object[][] {
	            // { username, password, expectedResult }
	            { "poxemah619@hazhab.com", "Smile@#!12", false },   // Valid credentials
	            { "poxemah619@hazhab.com", "Smile@#!123", true }   // Invalid password
	        };
	    }
	 
	 @Test(priority = 1, dataProvider = "loginData", description = "Login test with multiple credentials")
	    public void loginTest(String username, String password, boolean expectedResult) throws Exception {
		 
		 test = extent.createTest("Valid Login Test");
	        LoginPage loginPage = new LoginPage(driver);

	        loginPage.setUserName(username);
	        loginPage.setPassWord(password);
	        Thread.sleep(1000);
	        loginPage.getTextMes();
	        loginPage.setLogin();
	        Thread.sleep(3000);
	        

	        boolean actualResult = loginPage.isLoginSuccessful();
	       
	        if (expectedResult) {
	            Assert.assertTrue(actualResult, "❌ Login validation failed for valid credentials.");
	            System.out.println("✅ Login successful for user: " + username);
	            test.log(Status.PASS, "✅ Login was successful and dashboard loaded.");
	        } else {
	            Assert.assertFalse(actualResult, "❌ Login validation failed: login should not succeed with invalid credentials.");
	            System.out.println("✅ Login correctly failed for invalid user: " + username);
	            test.log(Status.FAIL, "❌ Login failed - dashboard URL not reached.");
	        }
	        
	  

	        System.out.println("-------loginTest() with " + username + " completed---------");
	    }
	 
//	 public  void verifyLogin(boolean actualResult, boolean expectedResult) {
//	        String message;
//
//	        if (expectedResult) {
//	            message = "Login should succeed !";
//	        } else {
//	            message = "Login should fail ";
//	        }
//
//	        Assert.assertEquals(actualResult, expectedResult, message);
//	    }

	   
	}