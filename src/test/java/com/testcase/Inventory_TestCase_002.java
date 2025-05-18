package com.testcase;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.InventoryPage;

public class Inventory_TestCase_002 extends BaseClass {
	
	@Test
	public void inventory() throws Exception {
		loginToApplication("standard_user", "secret_sauce");
		InventoryPage inventoryPage=new InventoryPage(driver);
		inventoryPage.setTitleText();
		inventoryPage.setInventory_Item();
		inventoryPage.printAllProductNames();
		inventoryPage.setImages();
		inventoryPage.setDescription();
		inventoryPage.setPrices();
		inventoryPage.setAddToCart();
		inventoryPage.setFilter();
		Thread.sleep(3000);
		System.out.println("--------------Inventory Test completed-----------");

	}

}
