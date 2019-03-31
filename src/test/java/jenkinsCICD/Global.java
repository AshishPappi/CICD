package jenkinsCICD;

import java.text.SimpleDateFormat;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.reports.ReporterUtility;

public class Global {

	public static WebDriver driver=null;
	public static String Report_path =null; 
	public static Properties prop= null;
	public static String configfile=System.getProperty("user.dir")+"/Config/Config.properties";
	public static String TestDataPath=System.getProperty("user.dir")+"/Testdata/AutomationDemoSite.xlsx";
	public static String ControllersheetPath=System.getProperty("user.dir")+"/Testdata/ControllerSheet.xlsx";
	public static String Testdata=System.getProperty("user.dir")+"/Testdata/AutomationDemoSite.xlsx";
	public static String gblTCScenarioName;
	public static Class gblTCSclass;
	public static String gstrTimeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new java.util.Date());
	public static ReporterUtility grefReporterUtility;
	public static String gstrExtentConfig_Path=System.getProperty("user.dir")+"/extent-config/extent-config.xml";
	public static String gstrResult_Path = System.getProperty("user.dir") + "\\Test-Artifacts\\Result_" + gstrTimeStamp;
	public static String gstrScreenshot_Path = System.getProperty("user.dir") + "\\Screenshots\\Result_" + gstrTimeStamp;

}
