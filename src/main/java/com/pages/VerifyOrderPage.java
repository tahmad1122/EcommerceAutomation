package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyOrderPage {
	 private String storedOrderId;
	WebDriver driver;
	
	public VerifyOrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".hero-primary")
	WebElement thankYou;
	
	@FindBy(css = "label[routerlink='/dashboard/myorders']")
	WebElement clickOrder;
	
	@FindBy(css = "label[class='ng-star-inserted']")
	WebElement orderId;
	
//	@FindBy(tagName = "table")
//	WebElement table;
//	
//	@FindBy(tagName = "tr" )
//	List<WebElement> row;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Orders']")
	WebElement yourOrder;
	
	@FindBy(xpath = "//body[1]/app-root[1]/app-myorders[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/button[1]")
	WebElement viewOrderBtn;
	
	public void thankYou() {
		String msg=thankYou.getText();
		System.out.println(msg);
	}
	
	public String  orderID() {
	   storedOrderId=orderId.getText();
	   storedOrderId = storedOrderId.replace("|", "").trim();
		System.out.println("Order Id : "+storedOrderId);
		return storedOrderId;
	}
	
	public void clickOrder() {
		clickOrder.click();
	}
	
	public void yourOrder() {
		String order=yourOrder.getText();
		System.out.println("======= "+order.toUpperCase()+ "  DETAILS"+" =======");
	}
	
	public void verifyOderById(String expectedOrderId) throws Exception {
		
		 WebElement tableElement = driver.findElement(By.tagName("table"));
		    List<WebElement> rows = tableElement.findElements(By.tagName("tr"));

		    boolean found = false;

		    for (WebElement listrow : rows) {
		        try {
		            WebElement orderIdCell = listrow.findElement(By.xpath("./th"));
		            String actualOrderId = orderIdCell.getText().trim();
		            
		            if (actualOrderId.trim().equals(storedOrderId.trim())) {
		                System.out.println("✅ Order ID found in table: " + actualOrderId);
		                System.out.println("===========================");
		                found = true;
		                break;
		            }
		        } catch (Exception e) {
		            System.out.println(e);
		        }
		    }

		    if (!found) {
		        System.out.println("❌ Order ID NOT found in table: " + expectedOrderId);
		        throw new AssertionError("Order ID not found in order history!");
		    }
	}
	
	
		
	public void tableOrderdata() {
	    // Locate the table element
	    WebElement tableElement = driver.findElement(By.tagName("table"));

	    // Get all the rows in the table
	    List<WebElement> rows = tableElement.findElements(By.tagName("tr"));

	    // Loop through each row
	    for (WebElement rowElement : rows) {
	        // Get all <th> and <td> cells in the row
	        List<WebElement> headers = rowElement.findElements(By.tagName("th"));
	        List<WebElement> cells = rowElement.findElements(By.tagName("td"));

	        // Combine headers and cells into one list for generic processing
	        List<WebElement> allCells = new ArrayList<>();
	        allCells.addAll(headers);
	        allCells.addAll(cells);

	        // Print each cell's text
	        for (WebElement cellElement : allCells) {
	            String cellData = cellElement.getText().trim();
	            System.out.print(cellData + "\t");
	        }

	        System.out.println(); // move to next line after each row
	    
	
	    }
	}
	
	public void viewOrderBtn() {
		viewOrderBtn.click();
	}
}
