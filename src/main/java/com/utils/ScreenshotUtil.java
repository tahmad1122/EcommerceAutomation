
package com.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotDir = "screenshots/";
        String fileName = testName + "_" + timestamp + ".png";
        String fullPath = screenshotDir + fileName;

        // Ensure the folder exists
        new File(screenshotDir).mkdirs();

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File target = new File(fullPath);
            FileUtils.copyFile(src, target);
            System.out.println("📸 Screenshot saved at: " + target.getAbsolutePath());
            return target.getAbsolutePath();
        } catch (IOException e) {
            System.out.println("❌ Screenshot capture failed: " + e.getMessage());
            return null;
        }
    }
}
