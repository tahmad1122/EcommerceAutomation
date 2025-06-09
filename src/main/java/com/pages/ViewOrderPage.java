package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewOrderPage {

	WebDriver driver;
	
	public ViewOrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[@class='tagline']")
	WebElement orderSummary;
	
	@FindBy(xpath = "//div[@class='email-title']")
	WebElement title;
	
	@FindBy(xpath = "//small[@class='col-title']")
	WebElement orderIdText;
	
	@FindBy(xpath = "//div[@class='col-text -main']")
	WebElement orderId;
	
	@FindBy(xpath = "//div[text()=' Billing Address ']/following-sibling::p")
	List<WebElement> bill;
	
	@FindBy(xpath = "//button[normalize-space()='Sign Out']")
	WebElement signOut;
	
	public void orderSummaryDetails() {
		
		System.out.println("============= Order Summary Details ==============");
		
		String orderHead=orderSummary.getText();
		System.out.println("Thank you message  : " + orderHead);
		
		String titleText=title.getText();
		System.out.println("Summary Title      : " + titleText);
		
		String orderText=orderIdText.getText();
		String order=orderId.getText();
		System.out.println(orderText+"          : " + order);
		
		System.out.println("===== Billing  Address =====");
		
//		List<WebElement> billingDetails = driver.findElements(By.xpath("//div[text()=' Billing Address ']/following-sibling::p"));
		List<WebElement> billingDetails=bill;
	
		String billingEmail = billingDetails.get(0).getText();
		String billingCountry = billingDetails.get(1).getText();
		System.out.println("Billing Email     : " + billingEmail);
		System.out.println("Billing Country   : " + billingCountry);

		System.out.println("===== Delivery Address =====");
		List<WebElement> deliveryDetails = driver.findElements(By.xpath("//div[text()=' Delivery Address ']/following-sibling::p"));
		
		String deliveryEmail = deliveryDetails.get(0).getText().trim();
		String deliveryCountry = deliveryDetails.get(1).getText().trim();
		System.out.println("Delivery Email    : " + deliveryEmail);
		System.out.println("Delivery Country  : " + deliveryCountry);

		//Get Product Name
		WebElement productNameElement = driver.findElement(By.xpath("//div[contains(@class, 'artwork-card-info')]//div[@class='title']"));
		String productName = productNameElement.getText().trim();
		System.out.println("Product Name      : " + productName);

		//Get Price
		WebElement priceElement = driver.findElement(By.xpath("//div[@class='price']"));
		String productPrice = priceElement.getText().trim();
		System.out.println("Product Price     : " + productPrice);
		
		//Get Image
		WebElement prodctImg = driver.findElement(By.xpath("//div[@class='artwork-card-image']//img"));
		String img = prodctImg.getAttribute("src");
		System.out.println("Product Image     : " + img);

	}
	
	public void signOut() throws Exception {
		signOut.click();
		Thread.sleep(1000);
	}

}
