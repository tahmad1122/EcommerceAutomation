package com.base;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.pages.LoginPage;
import com.utils.ExtentTestReports;
import com.utils.ScreenshotUtil;

public class BaseClass {
	
	protected WebDriver driver;
	
	public ExtentTestReports reportHelper;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeClass
    public void setupReport() {
        reportHelper = new ExtentTestReports();
        reportHelper.startReport();                     // initialize SparkReporter + ExtentReports
        extent = reportHelper.reports;                  // get ExtentReports instance
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client");
        
    }
    
 
    
    //loginToApplication is reusable and repeated method 
    public void loginToApplication(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(username);
        loginPage.setPassWord(password);
        loginPage.setLogin();
        
    }
    
    @AfterClass
    public void flushReport() {
        extent.flush(); // Save report to disk
    }
    
    @AfterMethod
    public void teardownDriver(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            // Capture the screenshot
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
            
            // Add screenshot to ExtentReport
            test.fail("Test Failed. Screenshot below:")
                .addScreenCaptureFromPath(screenshotPath);
            
            // Log the failure message/exception
            test.fail(result.getThrowable());
        }
        
        // Quit the driver
        driver.quit();
    }
    
    public static String generateRandom16DigitNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // Ensure the first digit is not 0
        sb.append(random.nextInt(9) + 1); // 1–9

        for (int i = 1; i < 16; i++) {
            sb.append(random.nextInt(10)); // 0–9
        }

        return sb.toString();
    }
    
    public static String generateRandomName() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder name = new StringBuilder();

        for (int i = 0; i < 7; i++)  // fixed length: 8
            name.append(letters.charAt((int)(Math.random() * letters.length())));

        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }


}
