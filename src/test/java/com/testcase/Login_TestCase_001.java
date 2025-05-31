package com.testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.pages.CartPageDetails;
import com.pages.LoginPage;
import com.pages.ProductFullDetailsPage;

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
				//{ "poxemah619@hazhab.com", "Smile@#!12", false }, // Invalid password
				{ "poxemah619@hazhab.com", "Smile@#!123", true } // Valid credentials

		};
	}

	@Test(priority = 1, dataProvider = "loginData", description = "Login test with multiple credentials")
	public void loginTest(String username, String password, boolean expectedResult) throws Exception {

		String testName = expectedResult ? "Valid Login Test - " + username : "Invalid Login Test - " + username;

		test = extent.createTest(testName);

		LoginPage loginPage = new LoginPage(driver);

		loginPage.setUserName(username);
		loginPage.setPassWord(password);
		Thread.sleep(1000);
		loginPage.getTextMes();
		loginPage.setLogin();
		Thread.sleep(2000);

		boolean actualResult = loginPage.isLoginSuccessful();
		System.out.println("actualResult result: " + actualResult);

		if (expectedResult) {
			System.out.println("expectedResult result: " + expectedResult);
			Assert.assertTrue(actualResult, "❌ Login validation failed for valid credentials.");
			System.out.println("✅ Login successful for user: " + username);
			test.log(Status.PASS, "✅ Login was successful and dashboard loaded.");
		} else {
			Assert.assertFalse(actualResult,
					"❌ Login validation failed: login should not succeed with invalid credentials.");
			System.out.println("✅ Login correctly failed for invalid user: " + username);
			test.log(Status.FAIL, "❌ Login failed - dashboard URL not reached.");
		}

		ProductFullDetailsPage detailsPage = new ProductFullDetailsPage(driver);

		// test.log(Status.INFO, "Viewing product");
		detailsPage.viewProduct();

		test.log(Status.INFO, "Viewing product details");
		detailsPage.productDetails();
		Thread.sleep(1000);

		test.log(Status.INFO, "Adding product to cart");
		detailsPage.addCart();

		test.log(Status.PASS, "✅ Product successfully added to cart.");

		test.log(Status.INFO, "Click to validate cart");
		detailsPage.cartItem();
		Thread.sleep(1000);

		test.log(Status.INFO, "Continue shopping");
		detailsPage.continueBtn();

		test.log(Status.INFO, "Adding again product to cart");
		detailsPage.addAgain();
		Thread.sleep(2000);

		test.log(Status.INFO, "Click to validate cart");
		detailsPage.cartItem();

		test.log(Status.INFO, "Validating cart item");
		detailsPage.itemAvl();
		Thread.sleep(2000);

		CartPageDetails cartPageDetails = new CartPageDetails(driver);
		test.log(Status.INFO, "Validating product details");
		cartPageDetails.productDetails();
		
		test.log(Status.INFO, "Delete cart item");
		cartPageDetails.deleteItemBtn();
		Thread.sleep(2000);
		
		test.log(Status.INFO, "Proceed to checkout");
		cartPageDetails.clickCheckout();
		Thread.sleep(2000);

		System.out.println("-------loginTest() with " + username + " completed---------");

	}

}