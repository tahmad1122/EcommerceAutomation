package com.testcase;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.CheckoutPage;

public class CheckoutPage_TestCase005 extends BaseClass {
	
	@Test
	public void verifyCheckout() {
		loginToApplication("poxemah619@hazhab.com", "Smile@#!123");
		
		
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		checkoutPage.setPaymentMethod();
		checkoutPage.setCardNumber();
		checkoutPage.setExpiryDate();
		checkoutPage.setExpiryYear();
		checkoutPage.setCvvCode();
		checkoutPage.setNameOnCard();
		checkoutPage.setCoupon();
		checkoutPage.setApplyCoupon();
		checkoutPage.setEmail();
		checkoutPage.setSelectCountry();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
