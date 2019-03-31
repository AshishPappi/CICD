package com.reports;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import jenkinsCICD.Setup;

public class ReporterUtility extends Setup {
	public static ExtentReports extent;
	public static ExtentTest test;

	
	public void initialize(){
		 	
		extent= new ExtentReports(gstrResult_Path+"//ExtentReport.html", true);
		extent.loadConfig(new File(gstrExtentConfig_Path));
		
					
	}
	

	public void startTest(){
		
			test=extent.startTest("test  started");
		
		
		
	}
	
	public void log( String strLogStatus, String strLogContent){
		
				switch (strLogStatus) {
					case "INFO":
						test.log(LogStatus.INFO, strLogContent);
						break;
					case "ERROR":
						test.log(LogStatus.ERROR, strLogContent);
						break;
					case "WARNING":
						test.log(LogStatus.WARNING, strLogContent);
						break;
					case "PASS":
						test.log(LogStatus.PASS, strLogContent);
						break;
					case "FAIL":
						test.log(LogStatus.FAIL, strLogContent);
						break;
					case "SKIP":
						test.log(LogStatus.SKIP, strLogContent);
						break;
					default:
						Assert.assertTrue(false, " Reporter-Log-ExtentReport : No matching log status ");
				}
			
		
			
	}
	
	public void endTest(String strType){
		switch (strType) {
		case "ExtentReport":
			extent.endTest(test);
			break;
	
		default:
			Assert.assertTrue(false, " Reporter-EndTest : No matching reporting type ");
		}
	}
	
	
	public void flush(String strType) throws IOException{
		switch (strType) {
		case "ExtentReport":
			extent.flush();
			extent.close();
			break;
		default:
			Assert.assertTrue(false, " Reporter-Flush : No matching reporting type ");
		}
	}
	
	
	public String getscreenshot(WebDriver driver,String screenshotname) {
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=gstrScreenshot_Path+"//"+screenshotname;
		File destPath= new File(destination);
		try {
			FileUtils.copyFile(src, destPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destination;
		
	}
	
	public void addscrenshottoextent(String imagepath) {
		test.log(LogStatus.FAIL, gblTCScenarioName);
		test.log(LogStatus.FAIL, test.addScreenCapture(imagepath));
	}
	
	
}
