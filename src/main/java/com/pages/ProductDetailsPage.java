package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

	WebDriver driver;

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "item_4_title_link")
	WebElement itmeClick;
	
	@FindBy(xpath = "//div[@class='inventory_details_img_container']//img")
	WebElement productImage;
	
	@FindBy(xpath = "//div[@class='inventory_details_name large_size']")
	WebElement productTitle;
	
	@FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
	WebElement productDescription;
	
	@FindBy(xpath = "//div[@class='inventory_details_price']")
	WebElement productPrice;
	
	@FindBy(xpath = "//button[@id='add-to-cart']")
	WebElement cartBtn;
	
	@FindBy(xpath = "//button[@id='remove']")
	WebElement removeCart;

	public void setItmeClick() {
		itmeClick.click();
	}

	@SuppressWarnings("deprecation")
	public void setProductImage() {
		String url=productImage.getAttribute("src");
		System.out.println("Image URL         : " + url);
	}

	public void setProductTitle() {
		String text=productTitle.getText();
		System.out.println("Title             : " + text);
	}

	public void setProductDescription() {
		String description=productDescription.getText();
		System.out.println("Description       : " + description);
	}

	public void setProductPrice() {
		String price=productPrice.getText();
		System.out.println("Price             : " + price);
	}

	public void setCartBtn() {
		cartBtn.click();
		boolean isAdded = removeCart.isDisplayed();
		System.out.println("Item added to cart: " + isAdded);
		
	}

	public void setRemoveCart() {
		String cart=removeCart.getText();
		System.out.println("Add to cart Text  : " + cart);
		System.out.println("--------Added Successfully------------");
	}
	
	
}
