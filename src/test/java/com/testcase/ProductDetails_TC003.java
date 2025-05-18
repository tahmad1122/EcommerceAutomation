package com.testcase;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.ProductDetailsPage;

public class ProductDetails_TC003 extends BaseClass {
	
	@Test
	public void viewDetails() {
		loginToApplication("standard_user", "secret_sauce");
		ProductDetailsPage detailsPage=new ProductDetailsPage(driver);
		System.out.println("--------------Product Details-------------");
		detailsPage.setItmeClick();
		detailsPage.setProductImage();
		detailsPage.setProductTitle();
		detailsPage.setProductDescription();
		detailsPage.setProductPrice();
		detailsPage.setCartBtn();
		detailsPage.setRemoveCart();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
