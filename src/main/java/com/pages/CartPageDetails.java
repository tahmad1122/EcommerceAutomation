package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPageDetails {
	
	WebDriver driver;
	
	public CartPageDetails(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@class='cartWrap ng-star-inserted']")
	List<WebElement> avalibaleCartItem;
	
	@FindBy(xpath = "//li[@class='items even ng-star-inserted']//img[@class='itemImg']")
	List<WebElement> itemImage;
	
	@FindBy(css = "li[class='items even ng-star-inserted'] h3")
	List<WebElement> itemTitle;
	
	@FindBy(css = "li[class='items even ng-star-inserted'] p:nth-child(4)")
	List<WebElement> mrp;
	
	@FindBy(css = "li[class='items even ng-star-inserted'] p:nth-child(5)")
	List<WebElement> inStock;
	
	@FindBy(xpath = "(//div[@class='prodTotal cartSection'])[1]")
	List<WebElement> price;
	
	@FindBy(xpath = "//li[@class='items even ng-star-inserted']//button[@class='btn btn-primary'][normalize-space()='Buy Now']")
	List<WebElement> buyButton;
	
	@FindBy(xpath = "//li[@class='items even ng-star-inserted']//button[@class='btn btn-danger']")
	List<WebElement> delButton;
	
	@FindBy(xpath = "//div[@class='subtotal cf ng-star-inserted']//ul")
	WebElement subTotal;
	
	@FindBy(xpath = "")
	WebElement total;
	
	@FindBy(xpath = "//button[normalize-space()='Checkout']")
	WebElement checkout;
	
	@FindBy(xpath = "//i[@class='fa fa-trash-o']")
	WebElement deleteItemBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Checkout']")
	WebElement clickCheckout;
	

//	public void setAvalibaleCartItem() {
//		int i=avalibaleCartItem.size();
//		System.out.println(i);
//	}

//	public void productDetails() {
//		int item=avalibaleCartItem.size();
//		System.out.println(item);
//		System.out.println("---------- Cart Product Details #"+item+" --------");
//		
//		for (int i = 0; i < item; i++) {
//			System.out.println("\n📦 Cart Product #" + (i + 1));
//
//		try {
//			String imageUrl = itemImage.get(i).getAttribute("src");
//			String name = itemTitle.get(i).getText();
//			String price = mrp.get(i).getText();
//			String stock=inStock.get(i).getText();
//			String buy=buyButton.get(i).getText();
//			String del=delButton.get(i).getText();
//			String subtol=subTotal.getText();
//			String check=checkout.getText();
//
//			
//			System.out.println("🖼️  Image URL       : " + imageUrl);
//            System.out.println("📛  Product Name    : " + name);
//            System.out.println("💲  Price           : " + price);
//            System.out.println("📦  Stock Status    : " + stock);
//            System.out.println("🛒  Buy Button Text : " + buy);
//            System.out.println("🗑️  Delete Button   : " + del);
//            System.out.println("💵  Item Subtotal   : " + subtol);
//            System.out.println("✅ Checkout Button  : " + check);
//            
//		} catch (IndexOutOfBoundsException e) {
//			System.out.println("⚠️ Mismatch in product data at index: " + e);
//		}
//		}
//	}
	
	public void productDetails() {
	    int itemCount = avalibaleCartItem.size();
	    System.out.println("---------- Cart Product Details: Total Items = " + itemCount + " ----------");

	    for (int i = 0; i < itemCount; i++) {
	        WebElement item = avalibaleCartItem.get(i);

	        System.out.println("\n📦 Cart Product #" + (i + 1));

	        try {
	            String imageUrl = item.findElement(By.cssSelector(".itemImg")).getAttribute("src");
	            String name = item.findElement(By.tagName("h3")).getText();
	            String price = item.findElement(By.xpath(".//p[contains(text(), 'MRP')]")).getText();
	            String stock = item.findElement(By.cssSelector(".stockStatus")).getText();
	            String buy = item.findElement(By.xpath(".//button[contains(text(),'Buy Now')]")).getText();
	            String del = item.findElement(By.cssSelector(".btn-danger")).getText();
	            String subTotalText = item.findElement(By.cssSelector(".prodTotal.cartSection > p")).getText();

	            System.out.println("🖼️  Image URL       : " + imageUrl);
	            System.out.println("📛  Product Name    : " + name);
	            System.out.println("💲  Price           : " + price);
	            System.out.println("📦  Stock Status    : " + stock);
	            System.out.println("🛒  Buy Button Text : " + buy);
	            System.out.println("🗑️  Delete Button   : " + del);
	            System.out.println("💵  Item Subtotal   : " + subTotalText);

	           
	        } catch (Exception e) {
	            System.out.println("⚠️  Error reading product #" + (i + 1) + ": " + e.getMessage());
	        }
	    }
	}

	public void deleteItemBtn() {
		deleteItemBtn.click();
	}
	
	public void clickCheckout() {
		clickCheckout.click();
	}	
	
	

//	public void setSubTotal(WebElement subTotal) {
//		this.subTotal = subTotal;
//	}
//
//	public void setTotal(WebElement total) {
//		this.total = total;
//	}
//
//	public void setCheckout(WebElement checkout) {
//		this.checkout = checkout;
//	}
	
	

}
