package jenkinsCICD;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.reports.ReporterUtility;

public class Setup extends Global {
	
	
	/*@BeforeSuite
	public void init() {
		grefReporterUtility = new ReporterUtility();
		grefReporterUtility.initialize();
		PropertyConfigurator.configure("./log4j.properties");
		
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
		
	}*/

}
