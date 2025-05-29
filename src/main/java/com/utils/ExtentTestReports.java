package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentTestReports {
	ExtentSparkReporter extentSparkReporter;
	public ExtentReports reports;
	ExtentTest extentTest;
	
	public void startReport() {
		String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
		extentSparkReporter=new ExtentSparkReporter(reportPath);
		
		reports = new ExtentReports();
		reports.attachReporter(extentSparkReporter);
        reports.setSystemInfo("Tester", "Your Name");
        
//        extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setDocumentTitle("Automation Test Results");
		extentSparkReporter.config().setReportName("E-Commerce Automation Report");
		extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
				


	}

}
