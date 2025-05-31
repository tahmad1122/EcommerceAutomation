package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductFullDetailsPage {

	WebDriver driver;

	public ProductFullDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='container']//div[1]//div[1]//div[1]//button[1]")
	WebElement viewProduct;

	@FindBy(xpath = "//div[@class='container mt-5']")
	WebElement ProductDetails;

	@FindBy(xpath = "//img[@class='img-fluid']")
	WebElement productImage;

	@FindBy(css = "div[class='col-lg-6 rtl-text'] div h2")
	WebElement productTitle;

	@FindBy(css = "div[class='col-lg-6 rtl-text'] div h3")
	WebElement productPrice;

	@FindBy(xpath = "//button[normalize-space()='Add to Cart']")
	WebElement addCart;

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartItem;

	@FindBy(xpath = "//div[@class='cart']")
	List<WebElement> itemAvl;

	@FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
	WebElement continuebtn;

	@FindBy(xpath = "//div[@class='row']//div[2]//div[1]//div[1]//button[2]")
	WebElement addAgain;

	public void viewProduct() {
		viewProduct.click();
	}

	public void productDetails() {

		System.out.println("---------- Product Details #--------");

		try {
			String imageUrl = productImage.getAttribute("src");
			String name = productTitle.getText();
			String price = productPrice.getText();
			String cartBtnText = addCart.getText();

			System.out.println("Image URL     : " + imageUrl);
			System.out.println("Product Name  : " + name);
			System.out.println("Price         : " + price);
			System.out.println("Cart Button   : " + cartBtnText);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("⚠️ Mismatch in product data at index: " + e);
		}
	}

//	public void productImage() {
//		String url=productImage.getAttribute("src");
//		System.out.println(url);
//
//	}
//	
//	public void productTitle() {
//		String text=productTitle.getText();
//		System.out.println(text);
//
//	}
//	
//	public void productPrice() {
//		String price=productPrice.getText();
//		System.out.println(price);
//
//	}

	public void addCart() {
		addCart.click();

	}

	public void cartItem() {
		cartItem.click();

	}

	public void itemAvl() {
		if (itemAvl.size() > 0) {
			System.out.println("Item is present in the cart.");
		} else {
			System.out.println("Item is NOT present in the cart.");
		}

	}

	public void continueBtn() {
		continuebtn.click();

	}

	public void addAgain() {
		addAgain.click();

	}

}
