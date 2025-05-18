package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {

	WebDriver driver;

	public InventoryPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='app_logo']")
	WebElement titleText;

	@FindBy(className = "inventory_item")
	List<WebElement> inventory_item;

	@FindBy(xpath = "//div[@class='inventory_item_img']//img")
	List<WebElement> images;

	@FindBy(xpath = "//div[contains(@class, 'inventory_item_name')]")
	List<WebElement> inventory_item_name;

	@FindBy(xpath = "//div[@class='inventory_item_desc']")
	List<WebElement> description;

	@FindBy(xpath = "//div[@class='inventory_item_price']")
	List<WebElement> prices;

	@FindBy(xpath = "//button[text()='Add to cart']")
	List<WebElement> addToCart;

	// product filter
	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement filter;

	public void setTitleText() {
		String text = titleText.getText();
		System.out.println("Title is: " + text);
	}

	public void setInventory_Item() {
		int value = inventory_item.size();
		System.out.println("Total Product available is:  " + value);
	}

//	public void printAllProductNames() {
//		
//		int a=1;
//		for (WebElement webElement : inventory_item_name) {
//			setImages();
//			String name=webElement.getText();
//			System.out.println("Product names are:"+a+"- "+name);
//			a++;	
//		}	
//	}

	// optimize way
	@SuppressWarnings("deprecation")
	public void printAllProductNames() {
		int total = inventory_item.size();

		for (int i = 0; i < total; i++) {
			System.out.println("---------- Product #" + (i + 1) + " ----------");

			try {
				String imageUrl = images.get(i).getAttribute("src");
				String name = inventory_item_name.get(i).getText();
				String desc = description.get(i).getText();
				String price = prices.get(i).getText();
				String cartBtnText = addToCart.get(i).getText();

				System.out.println("Image URL     : " + imageUrl);
				System.out.println("Product Name  : " + name);
				System.out.println("Description   : " + desc);
				System.out.println("Price         : " + price);
				System.out.println("Cart Button   : " + cartBtnText);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("⚠️ Mismatch in product data at index: " + i);
			}
		}
	}

		@SuppressWarnings("deprecation")
		public void setImages() {
			System.out.println("-----------Image URL--------------");
			for (WebElement img : images) {
				String url = img.getAttribute("src");
				System.out.println(url);
				System.out.println();
			}
	
		}
	
		public void setDescription() {
			System.out.println("--------Description------------");
			for (WebElement descp : description) {
				String text = descp.getText();
				System.out.println(text);
				System.out.println();
	
			}
		}
	
		public void setPrices() {
			System.out.println("---------Price---------------");
			for (WebElement prc : prices) {
				String price = prc.getText();
				System.out.println(price);
				System.out.println();
			}
		}
	
		public void setAddToCart() {
			System.out.println("-----------Cart Button ---------");
			for (WebElement cart : addToCart) {
				String addCart = cart.getText();
				System.out.println(addCart);
				System.out.println();
			}
		}
	
		public void setFilter() {
			filter.click();
			Select select = new Select(filter);
			List<WebElement> options = select.getOptions();
			System.out.println("--------Dropdown Size " + options.size() + " --------");
			for (int i = 0; i < options.size(); i++) {
				System.out.println("---------- Options #" + (i + 1) + " ----------");
	
				select = new Select(filter);
				options = select.getOptions();
	
				String textTitle = options.get(i).getText();
				System.out.println("Sort By       : " + textTitle);
	
				select.selectByIndex(i);
	
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				printAllProductNames();
	
			}
	
		}

}
