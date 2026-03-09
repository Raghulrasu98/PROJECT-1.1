package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Projectspecificmethods;
import pages.ContactPage;
import pages.LoginPage;

public class EditContactTest extends Projectspecificmethods{
	
	private static final Logger logger = LogManager.getLogger(EditContactTest.class);
	
	@BeforeTest
	public void extentdetails() {
		testname="edit contact Test";
		testdescription="Testing the edit functionality";
		testcategory="Smoke Testing";
		testauthour="Raghul";
	}
	
	
	@Test(dataProvider="xllogindetails", priority=1)
	public void editcontactsbutton(String username , String password ) {
		
		LoginPage lp=new LoginPage(driver);
		ContactPage cp=new ContactPage(driver);
			
		lp.Enterusername(username);
		lp.Enterpassword(password);
		lp.loginbutton();
		
		cp.firstcontact();
		cp.editcontact();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Edit Contact']")).isDisplayed());
		logger.info("edit page is opened");
		
		
	}
		
	@Test(dataProvider="xllogindetails" ,priority=2)
	public void editcontact(String username , String Password) throws InterruptedException {
		
		
			ContactPage cp=new ContactPage(driver);
			LoginPage lp=new LoginPage(driver);
			
			lp.Enterusername(username);
			lp.Enterpassword(Password);
			lp.loginbutton();
			
			cp.firstcontact();
			
			String phnumbefore = cp.getPhoneNumber();
			logger.info("Phone number before edit: " + phnumbefore);
			
			
			cp.editcontact();
			
			cp.phnnum("123456");
			
			cp.cancel();
			
			String phnumafter=cp.getPhoneNumber();
			logger.info("Phone number before edit: " + phnumafter);
			
			if(phnumbefore.equals(phnumafter)) {
				logger.info("No changes is done. NO ERROR");
			}else {
				logger.info("changes are made .ERROR");
				}
				
		}
	
	@Test(dataProvider="xllogindetails", priority=3)
	public void canceledit(String username , String Password) throws InterruptedException {
		
		
			ContactPage cp=new ContactPage(driver);
			LoginPage lp=new LoginPage(driver);
			
			lp.Enterusername(username);
			lp.Enterpassword(Password);
			lp.loginbutton();
			
			cp.firstcontact();
			cp.editcontact();
			cp.clearlastname();	
			cp.Submit();
			
			Assert.assertTrue(cp.errormessage());
			logger.info("Error message displayed successfully");
			
			
					
		}

}

