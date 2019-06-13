package page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jenkinsCICD.TC001;



public class Loginpage extends TC001 {
	private static Logger logger=Logger.getLogger(Loginpage.class);
	SelenuimActions act = new SelenuimActions();

	public Loginpage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "uid")

	WebElement usernametxt;

	@FindBy(name = "password")

	WebElement pswdtxt;

	@FindBy(name = "btnLogin")

	WebElement loginbtn;

	@FindBy(xpath = "//h2[text()='Guru99 Bank']")
	WebElement verfiyLogin;

	@FindBy(xpath = "//a[text()='Log out']")
	WebElement logoutbtn;

	public String loginTest(String sUserName, String sPassword) {

		String loginstatus = null;
		act.enterText(usernametxt, sUserName);
		grefReporterUtility.log("INFO", "username entrerd"+sUserName);
		logger.info("username entrerd"+sUserName);
		act.enterText(pswdtxt, sPassword);
		grefReporterUtility.log("INFO", "password entrerd"+sPassword);
		logger.info("password entrerd"+sPassword);
		act.clickType(loginbtn);
		String imagepath=grefReporterUtility.getscreenshot(driver, "login");
		grefReporterUtility.addscrenshottoextent(imagepath);
		loginstatus = verfiyLogin.getText();
		return loginstatus;
	
		
	

	}

	public String logout() {
		String logoutstatus = null;
		act.clickjse(driver, logoutbtn);
		act.waitfor(driver, 60);
		act.alerthandling(driver, "accept");
		grefReporterUtility.log("INFO", "logout");
		logger.info("logout");
		logoutstatus = verfiyLogin.getText();
		logger.info("logout successfull");
		return logoutstatus;
		

	}

}
