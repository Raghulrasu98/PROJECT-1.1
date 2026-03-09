package test;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Projectspecificmethods;
import pages.ContactPage;
import pages.LoginPage;

public class DeleteContactTest extends Projectspecificmethods{
	
	private static final Logger logger = LogManager.getLogger(DeleteContactTest.class);
	
	
	@BeforeTest
	public void extentdetails() {
		testname="delete contact Test";
		testdescription="Testing the delete functionality";
		testcategory="Smoke Testing";
		testauthour="Raghul";
	}
	
	@Test(dataProvider="xllogindetails", priority=1)
	public void deletecontact(String username , String password ) {
		
		LoginPage lp=new LoginPage(driver);
		ContactPage cp=new ContactPage(driver);
			
		lp.Enterusername(username);
		lp.Enterpassword(password);
		lp.loginbutton();
		
		cp.firstcontact();
		cp.deletebutton();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		alert.accept();
		logger.info("alert is displayed");

}
	
	@Test(dataProvider="xllogindetails", priority=2)
	public void deletealert(String username , String password ) {
		
		LoginPage lp=new LoginPage(driver);
		ContactPage cp=new ContactPage(driver);
			
		lp.Enterusername(username);
		lp.Enterpassword(password);
		lp.loginbutton();
		
		cp.firstcontact();
		cp.deletebutton();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		String alerttext=alert.getText();
		
		logger.info("alert message ="+alerttext);
	
		Assert.assertEquals(alerttext, "Are you sure you want to delete this contact?");
		
		alert.accept();
		
		logger.info("Delete confirmed successfully");
}
	

	@Test(dataProvider="xllogindetails", priority=3)
	public void deleteconformation(String username , String password ) {
		
		LoginPage lp=new LoginPage(driver);
		ContactPage cp=new ContactPage(driver);
			
		lp.Enterusername(username);
		lp.Enterpassword(password);
		lp.loginbutton();
		
		String contactName = cp.getContactName();
		   logger.info("Contact selected: " + contactName);
		cp.firstcontact();
		cp.deletebutton();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());

	      driver.switchTo().alert().accept();
		
		 driver.navigate().refresh();
		  logger.info("Page refreshed");

		 Assert.assertFalse(cp.isContactPresent(contactName));
		    logger.info("Contact successfully removed from list");
		
		
		
	}
}
