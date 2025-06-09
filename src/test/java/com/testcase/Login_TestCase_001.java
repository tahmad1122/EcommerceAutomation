package com.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.pages.CartPageDetails;
import com.pages.CheckoutPage;
import com.pages.LoginPage;
import com.pages.ProductFullDetailsPage;
import com.pages.VerifyOrderPage;
import com.pages.ViewOrderPage;

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
			
				{ "poxemah619@hazhab.com", "Smile@#!12", false }, // Invalid password
				{ "poxemah619@hazhab.com", "Smile@#!123", true } // Valid credentials

		};
	}

	@Test(priority = 1, dataProvider = "loginData", description = "Login test with multiple credentials")
	public void loginTest(String username, String password, boolean expectedResult) throws Exception {

		String testName = expectedResult ? "Valid Login Test - " + username : "Invalid Login Test - " + username;

		test = extent.createTest(testName)
			.assignCategory("End To End Testing");
//            .assignAuthor("YourName");

		// Step 1: Login
		test.log(Status.INFO, "🔐 Starting login with username: " + username);
		
		LoginPage loginPage = new LoginPage(driver);

		loginPage.setUserName(username);
		loginPage.setPassWord(password);
		test.log(Status.INFO, "📥 Entered username and password");
		
		loginPage.getTextMes();
		loginPage.setLogin();
		test.log(Status.INFO, "➡️ Clicked login button");
		Thread.sleep(1000);

		boolean actualResult = loginPage.isLoginSuccessful();
		System.out.println("actualResult result: " + actualResult);
		

		if (expectedResult) {
			Assert.assertTrue(actualResult, "❌ Login validation failed for valid credentials.");
			test.log(Status.PASS, "✅ Login successful and dashboard loaded for: " + username);
		} else {
			System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Log ']")));
			Assert.assertFalse(actualResult, "❌ Login should fail, but succeeded for invalid credentials.");
			test.log(Status.PASS, "✅ Login correctly failed for invalid user: " + username);
		}
		
		// Only proceed with product/order flow if login was successful
		if (expectedResult) {

			// Step 2: View and Add Product
			ProductFullDetailsPage detailsPage = new ProductFullDetailsPage(driver);
			test.log(Status.INFO, "🛍️ Navigating to product details page");
			detailsPage.viewProduct();
			detailsPage.productDetails();

			test.log(Status.INFO, "➕ Adding product to cart");
			detailsPage.addCart();
			test.log(Status.PASS, "✅ Product added to cart");

			test.log(Status.INFO, "🛒 Checking cart");
			detailsPage.cartItem();
			Thread.sleep(1000);

			test.log(Status.INFO, "🛍️ Continuing shopping");
			detailsPage.continueBtn();

			test.log(Status.INFO, "➕ Adding same product again");
			detailsPage.addAgain();
			Thread.sleep(2000);
			detailsPage.cartItem();
			detailsPage.itemAvl();
			Thread.sleep(2000);

			// Step 3: Cart Details
			CartPageDetails cartPageDetails = new CartPageDetails(driver);
			test.log(Status.INFO, "📦 Validating cart item details");
			cartPageDetails.productDetails();

			test.log(Status.INFO, "🗑️ Deleting one item from cart");
			cartPageDetails.deleteItemBtn();
			Thread.sleep(2000);

			test.log(Status.INFO, "💳 Proceeding to checkout");
			cartPageDetails.clickCheckout();
			Thread.sleep(1000);

			// Step 4: Checkout Process
			CheckoutPage checkoutPage = new CheckoutPage(driver);
			test.log(Status.INFO, "💳 Filling payment details");
			checkoutPage.setPaymentMethod();
			checkoutPage.setCardNumber();
			checkoutPage.setExpiryDate();
			checkoutPage.setExpiryYear();
			checkoutPage.setCvvCode();

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)");

			checkoutPage.setNameOnCard();
			checkoutPage.setCoupon();
			checkoutPage.setApplyCoupon();
			Thread.sleep(3000);
			checkoutPage.setSelectCountry();
			Thread.sleep(2000);
			checkoutPage.placeOrder();
			test.log(Status.PASS, "✅ Order placed successfully");
			Thread.sleep(1000);

			// Step 5: Order Verification
			VerifyOrderPage orderPage = new VerifyOrderPage(driver);
			orderPage.thankYou();
			String storedId = orderPage.orderID();
			test.log(Status.INFO, "🧾 Captured Order ID: " + storedId);

			orderPage.clickOrder();
			orderPage.verifyOderById(storedId);
			orderPage.yourOrder();
			orderPage.tableOrderdata();
			test.log(Status.PASS, "✅ Order ID verified in order history");

			orderPage.viewOrderBtn();

			// Step 6: View Order Summary
			ViewOrderPage viewOrderPage = new ViewOrderPage(driver);
			viewOrderPage.orderSummaryDetails();
			test.log(Status.PASS, "📋 Order summary displayed successfully");
			Thread.sleep(1000);
			
			// Step 7: Sign Out
			test.log(Status.INFO, "🚪 Signing out from application");
			viewOrderPage.signOut();
			test.log(Status.PASS, "✅ User signed out successfully");
		}

		test.log(Status.INFO, "✅ Test case completed for: " + username);
		System.out.println("-------loginTest() with " + username + " completed---------");
	}
		
}