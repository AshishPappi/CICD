package page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelenuimActions {
		
	public void enterText(WebElement ele,String str){
		
		try{
			
			if (ele.isDisplayed()&&ele.isEnabled()){
				ele.sendKeys(str);
			}
			else{
				
				System.out.println(ele+"element is not displayed or enabled");
			}
			
		}catch(Exception e){
			
			System.out.println("Exception occured::" +e);
		}
		
	}
	

	public void clickType(WebElement ele){
		
		try{
			
			if (ele.isDisplayed()&&ele.isEnabled()){
				ele.click();
			}
			else{
				
				System.out.println(ele+"element is not displayed or enabled");
			}
			
		}catch(Exception e){
			
			System.out.println(e.getMessage());
		}
		
	}
	

	
	
	public void selectDropdown(WebDriver driver,WebElement value){
		
		
	Actions action = null;
		
		try{
			
		action = new Actions(driver);
		action.moveToElement(value).build().perform();
			
			
		}catch(Exception e ){
			
		}
		
	}
	
	
	public void alerthandling(WebDriver driver,String action) {
		
		Alert alert=null;
		
		try {
			
			alert=driver.switchTo().alert();
			if (action.equalsIgnoreCase("accept"))
			alert.accept();
			else {
				alert.dismiss();
			}
			
			
		}catch(Exception e) {
			
			System.out.println("Exception occured in alert handling::" + e);
			
		}
		
	}
	

	
	
	public void keyboard() {
		
		 try {
			Robot robot = new Robot();
			//robot.keyPress(KeyEvent.);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
public void sendkeyjse(WebDriver driver ,WebElement element,String value) {
	
	JavascriptExecutor js =null;
	
	try {
		
		js = (JavascriptExecutor)driver;
		
		String args= "arguments[0].value='"+value+"'";
		js.executeScript(args, element);
		
		
		
	}catch(Exception e ) {
		
		System.out.println("Exception occured while entering date"+e);
		
	}
	
}
public void clickjse(WebDriver driver ,WebElement element) {
	
	JavascriptExecutor js =null;
	
	try {
		
		js = (JavascriptExecutor)driver;
		
		String args= "arguments[0].click()";
		js.executeScript(args, element);
		
		
		
	}catch(Exception e ) {
		
		System.out.println("Exception occured while entering date"+e);
		
	}
	
}
	

	public void waitfor(WebDriver driver,long timeout) {
		
		WebDriverWait wait= new WebDriverWait(driver,timeout);
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		
	}
	

}
