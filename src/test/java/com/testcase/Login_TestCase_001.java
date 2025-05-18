package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;

public class Login_TestCase_001 extends BaseClass {

	// Valid credentials
	@Test(priority = 1)
	public void validLogin() throws Exception {
		
		loginToApplication("standard_user", "secret_sauce");
		
//		LoginPage loginPage = new LoginPage(driver);
//		String user = "standard_user";
//		String pass = "secret_sauce";
//		loginPage.setUserName(user);
//		loginPage.setPassWord(pass);
//		loginPage.getTextMes();
//		loginPage.setLogin();
//		Assert.assertTrue(loginPage.isLoginSuccessful(), "Login validation failed!");
		System.out.println("-------validLogin() Test Completed---------");
//		String execpted="Swag Labs";
//		String actual=driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
//		Assert.assertEquals(actual, execpted, "Login validation failed!");
//		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed());

	}

	// InValid credentials user name and password are wrong
	@Test(priority = 2)
	public void inValidLogin() throws Exception {

		LoginPage loginPage = new LoginPage(driver);
		String user = "standard_user";
		String pass = "secret_sauceas";
		loginPage.setUserName(user);
		loginPage.setPassWord(pass);
		loginPage.getTextMes();
		loginPage.setLogin();
		loginPage.setErrorMsg();
		Assert.assertTrue(loginPage.isLoginSuccessful(), "Login validation failed!");
		System.out.println("-------inValidLogin() Test Completed---------");

	}

	// InValid credentials user name and password are wrong
	@Test(priority = 3)
	public void emptyLogin() throws Exception {

		LoginPage loginPage = new LoginPage(driver);
		String user = "";
		String pass = "";
		loginPage.setUserName(user);
		loginPage.setPassWord(pass);
		loginPage.getTextMes();
		loginPage.setLogin();
		loginPage.setErrorMsg();
		Assert.assertTrue(loginPage.isLoginSuccessful(), "Login validation failed!");
		System.out.println("-------emptyLogin() Test Completed---------");

	}
}
