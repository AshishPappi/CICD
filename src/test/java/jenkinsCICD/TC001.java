package jenkinsCICD;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.reports.ReporterUtility;


import page.Loginpage;

public class TC001 extends Global {
	public static WebDriver driver;
	Loginpage loginpage = null;
	private static Logger logger=Logger.getLogger(TC001.class);

	
	@BeforeSuite
	public void init() {
		grefReporterUtility = new ReporterUtility();
		grefReporterUtility.initialize();
		logger.info("Extent report started");
		grefReporterUtility.startTest();
		PropertyConfigurator.configure("./log4j.properties");
		logger.info("start test");
		
	}
	
	
	
	
	
	@AfterSuite
	
	public void teardown() {
		
		try {
			grefReporterUtility.endTest("ExtentReport");
			grefReporterUtility.flush("ExtentReport");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@BeforeClass
	public void initialize() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://demo.guru99.com/V4/");
		grefReporterUtility.log("INFO", "browser launched with given url");
		logger.info("browser launched with given url");
	}

	@Test(dataProvider = "login")

	public void Login(String sUserName, String sPassword) throws Exception {

		loginpage =new Loginpage(driver);
		if (loginpage.loginTest(sUserName,sPassword)=="") {
			
			grefReporterUtility.log("FAIL", "TC01 testcase failed");
			
		}else {
			grefReporterUtility.log("INFO", "login passed");
			loginpage.logout();
			grefReporterUtility.log("INFO", "logout passed");
		}
		
		
		

	}

	@DataProvider(name = "login")

	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ExcelUtils
				.getTableArray(Testdata, "LOGIN");

		return (testObjArray);

	}
	
	@AfterClass
	public void close() {
		driver.close();
		System.out.println("driver closed");
	}

}
