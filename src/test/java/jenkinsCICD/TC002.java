package jenkinsCICD;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.CustomerCreationpage;
import page.Loginpage;



public class TC002 extends Global {
	
	public static WebDriver driver; 
	CustomerCreationpage customerCreationpage =null;
	Loginpage loginpage = null;
	@BeforeClass
	public void initialize() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		System.out.println(driver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://demo.guru99.com/V4/");
	}
	@Test(dataProvider = "customer")

	public void Login(String sUserName, String sPassword, String CustName, String Custaddress,String CustCity,String Custstate,String Custpin,String Custphone,String Custemail,String Custpassword) throws Exception {
		loginpage =new Loginpage(driver);
		loginpage.loginTest(sUserName,sPassword);
		customerCreationpage =new CustomerCreationpage(driver);	
		customerCreationpage.custcreation(CustName,Custaddress,CustCity,Custstate,Custpin,Custphone,Custemail,Custpassword);
		loginpage.logout();
		

	}

	@DataProvider(name = "customer")

	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ExcelUtils
				.getTableArray(Testdata, "CustomerCreation");

		return (testObjArray);

	}

	@AfterClass
	public void close() {
		driver.close();
		System.out.println("driver closed");
	}
	
	

}
