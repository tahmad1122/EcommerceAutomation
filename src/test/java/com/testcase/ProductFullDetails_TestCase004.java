package com.testcase;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.pages.CartPageDetails;
import com.pages.CheckoutPage;
import com.pages.ProductFullDetailsPage;
import com.pages.VerifyOrderPage;
import com.pages.ViewOrderPage;

public class ProductFullDetails_TestCase004 extends BaseClass {

	@Test
	public void addToCart() {
		test = extent.createTest("TestCase004 - Add Product to Cart");
//	                     .assignCategory("Smoke")
//	                     .assignAuthor("YourName");

		try {
			test.log(Status.INFO, "Logging into the application");
			loginToApplication("poxemah619@hazhab.com", "Smile@#!123");
			test.log(Status.PASS, "Login successful");

			ProductFullDetailsPage detailsPage = new ProductFullDetailsPage(driver);

			Thread.sleep(1000);
			test.log(Status.INFO, "Viewing product");
			detailsPage.viewProduct();

			test.log(Status.INFO, "Viewing product details");
			detailsPage.productDetails();
			Thread.sleep(1000);

//	            test.log(Status.INFO, "Validating product image");
//	            detailsPage.productImage();
//	   
//	            test.log(Status.INFO, "Validating product title");
//	            detailsPage.productTitle();
//
//	            test.log(Status.INFO, "Validating product price");
//	            detailsPage.productPrice();

			test.log(Status.INFO, "Adding product to cart");
			detailsPage.addCart();

			test.log(Status.PASS, "✅ Product successfully added to cart.");

			test.log(Status.INFO, "Click to validate cart");
			detailsPage.cartItem();
			Thread.sleep(1000);
			detailsPage.continueBtn();

			detailsPage.addAgain();
			Thread.sleep(2000);
			detailsPage.cartItem();

			test.log(Status.INFO, "Validating cart item");
			detailsPage.itemAvl();
			Thread.sleep(2000);

			CartPageDetails cartPageDetails = new CartPageDetails(driver);
			cartPageDetails.productDetails();
			
			test.log(Status.INFO, "Delete cart item");
			cartPageDetails.deleteItemBtn();
			Thread.sleep(2000);
			
			test.log(Status.INFO, "Proceed to checkout");
			cartPageDetails.clickCheckout();
			Thread.sleep(2000);
			
			//Step CheckOut Details Page
			CheckoutPage checkoutPage=new CheckoutPage(driver);
			checkoutPage.setPaymentMethod();
			checkoutPage.setCardNumber();
			checkoutPage.setExpiryDate();
			checkoutPage.setExpiryYear();
			checkoutPage.setCvvCode();
			Thread.sleep(2000);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)");
			checkoutPage.setNameOnCard();
			checkoutPage.setCoupon();
			checkoutPage.setApplyCoupon();
			Thread.sleep(3000);
//			checkoutPage.setEmail();
			
			checkoutPage.setSelectCountry();
			Thread.sleep(2000);
			checkoutPage.placeOrder();
			Thread.sleep(2000);
			
			//VerifyOderPage
			VerifyOrderPage orderPage=new VerifyOrderPage(driver);
			orderPage.thankYou();
//			orderPage.orderID();
			String storedId = orderPage.orderID(); 
			orderPage.clickOrder();
			orderPage.verifyOderById(storedId);
			orderPage.yourOrder();
			orderPage.tableOrderdata();
			orderPage.viewOrderBtn();
			
			//ViewOrderDetails
			ViewOrderPage viewOrderPage=new ViewOrderPage(driver);
			viewOrderPage.orderSummaryDetails();

		} catch (Exception e) {
			// test.log(Status.FAIL, "❌ Test failed: " + e.getMessage());
			e.printStackTrace();
			assert false : "Test failed due to exception: " + e.getMessage();
		}
	}

}
