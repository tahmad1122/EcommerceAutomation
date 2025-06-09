package com.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.BaseClass;



public class CheckoutPage {

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class='payment__type payment__type--cc active']")
	WebElement paymentMethod;
	
	@FindBy(xpath = "//input[@value='4542 9931 9292 2293']")
	WebElement cardNumber;
	
	@FindBy(xpath = "//body//app-root//select[1]")
	WebElement expiryDate;
	
	@FindBy(xpath = "//body//app-root//select[2]")
	WebElement expiryYear;
	
	@FindBy(xpath = "//div[@class='payment__cc']//div[2]//input[1]")
	WebElement cvvCode;
	
	@FindBy(xpath = "//div[@class='payment__cc']//div[3]//input[1]")
	WebElement nameOnCard;
	
	@FindBy(xpath = "//div[@class='payment__cc']//div[4]//input[1]")
	WebElement coupon;
	
	@FindBy(xpath = "//button[normalize-space()='Apply Coupon']")
	WebElement applyCoupon;
	
	@FindBy(xpath = "//input[@class='input txt text-validated ng-valid ng-dirty ng-touched']")
	WebElement email;
	
	@FindBy(css = "input[placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(css = "section.ta-results button.ta-item")
	List<WebElement> countrySuggestions;
	
	@FindBy(xpath = "//a[normalize-space()='Place Order']")
	WebElement placeOrder;
	

	public void setPaymentMethod() {
		String payment=paymentMethod.getText();
		System.out.println("Payment method: "+payment);
		System.out.println("===========================");
	}

	public void setCardNumber() {
		String randomCard = BaseClass.generateRandom16DigitNumber();
		    cardNumber.clear();
		    cardNumber.sendKeys(randomCard);
		    System.out.println("Random Card Number Set: " + randomCard);
		    System.out.println("===========================");
	}

	public void setExpiryDate() {
		Select select=new Select(expiryDate);
		select.selectByIndex(3);
	}
	
	public void setExpiryYear() {
		Select select=new Select(expiryYear);
		select.selectByIndex(3);
	}

	public void setCvvCode() {
		cvvCode.sendKeys("1234");
	}

	public void setNameOnCard() {
		String randomName = BaseClass.generateRandomName();
		nameOnCard.sendKeys(randomName);
		System.out.println("Random Name: " + randomName);
		System.out.println("===========================");
		
	}

	public void setCoupon() {
		coupon.sendKeys("anx");
	}

	public void setApplyCoupon() {
		applyCoupon.click();
	}

	public void setEmail() {
		email.clear();
		email.sendKeys("test@gmail.com");
	}

	public void setSelectCountry() {
		selectCountry.sendKeys("India");
		for (WebElement suggestion : countrySuggestions) {
		    if (suggestion.getText().trim().equalsIgnoreCase("India")) {
		        suggestion.click();
		        break;
		    }
		}
	}
	
	public void placeOrder() {
		placeOrder.click();
	}
	
	
	public void randomString() {
		

	}

}
