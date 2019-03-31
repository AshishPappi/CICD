package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jenkinsCICD.TC002;



public class CustomerCreationpage extends TC002 {
	SelenuimActions act= new SelenuimActions();
	
 public CustomerCreationpage(WebDriver driver) {
		 
		 TC002.driver= driver;
		 
		 PageFactory.initElements(driver,this);
		 
	 }
	
	
	 @FindBy(xpath="//a[text()='New Customer']")
	 WebElement newcustomerLink;
	 
	 
	 @FindBy(name="name")
	 WebElement customerTxt ;
	 
	 
	 @FindBy(xpath="//input[@value='m']")
	 WebElement radBtn;
	 
	 @FindBy(id="dob")
	 WebElement datetxt;
	 
	 
	 @FindBy(name="addr")
	 WebElement addrTxt ;
	 
	 
	 @FindBy(name="city")
	 WebElement cityTxt ;
	 
	 
	 @FindBy(name="state")
	 WebElement stateTxt ;
	 
	 
	 @FindBy(name="pinno")
	 WebElement pinTxt ;
	 
	 
	 @FindBy(name="telephoneno")
	 WebElement phoneTxt ;
	 
	 
	 @FindBy(name="emailid")
	 WebElement emailTxt ;
	 
	 
	 @FindBy(name="password")
	 WebElement passwordTxt ;
	 
	 
	 @FindBy(name="sub")
	 WebElement submitBtn ;
	 
	 @FindBy(xpath="//p[@class='heading3']")
	 WebElement custsuccestxt;	

public String custcreation(String CustName,String Custaddress,String CustCity,String Custstate,String Custpin,String Custphone,String Custemail,String Custpassword) {
		 
		
		 
		 String customersucces=null;
		
		 act.clickType(newcustomerLink);
		 act.enterText(customerTxt, CustName);
		 act.sendkeyjse(driver, datetxt, "1793-08-02");
		 act.clickType(datetxt);
		 act.enterText(addrTxt, Custaddress);
		 act.enterText(cityTxt, CustCity);
		 act.enterText(stateTxt, Custstate);
		 act.enterText(pinTxt, Custpin);
		 act.enterText(phoneTxt, Custphone);
		 act.enterText(emailTxt, Custemail);
		 act.enterText(passwordTxt, Custpassword);
		 act.clickType(submitBtn);
		 customersucces=custsuccestxt.getText();
		 return customersucces;
		 
		
		
		 
		 
	 } 
	 
}

