package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Projectspecificmethods;
import pages.ContactPage;
import pages.LoginPage;

public class UIandResponsivenessTest extends Projectspecificmethods {
	
private static final Logger logger = LogManager.getLogger(UIandResponsivenessTest.class);
	
	@BeforeTest
	public void extentdetails() {
		testname="UI and Responsiveness Test";
		testdescription="Testing buttons alignment ";
		testcategory="Smoke Testing";
		testauthour="Raghul";
	}
	
	@Test(dataProvider="xllogindetails", priority=1)
	public void alignment(String username , String password) {
		
		LoginPage lp=new LoginPage(driver);
		ContactPage cp=new ContactPage(driver);
		
		
		logger.info("username and password is given ");
		lp.Enterusername(username);
		lp.Enterpassword(password);
		lp.loginbutton();
				
		logger.info("page is loggedin ");
		
		cp.addcontactform();
		
		
		 Assert.assertTrue(cp.areFieldsDisplayed());
		    logger.info("All fields are visible");

		    
		    if(cp.areFieldsAlignedProperly()) {
		   
		        logger.info("PASS:All fields are properly aligned on desktop");
		    
		    }else {
		    	
		    	 logger.info("FAIL :All fields are not properly aligned");
		    	
		    }

}
	
	@Test(dataProvider="xllogindetails")
	public void successindicators(String usernmae,String password ) {
		
		LoginPage lp=new LoginPage(driver);
		ContactPage cp=new ContactPage(driver);
		
		logger.info("page is opened ");
		lp.Enterusername(usernmae);
		lp.Enterpassword(password);
		lp.loginbutton();
		String firstname="raghul";
		String Lastname="rasu";
		String phone="987651234";
		String city="tirupur";
		
		logger.info("details added");
		
		cp.addingcontact(firstname, Lastname, phone, city);
		
		cp.Submit();
		logger.info("contact added");
		
		String message = cp.getToastMessage();
		logger.info("Toast message: " + message);


		if (message.equals("Contact added successfully")) {
		    logger.info("Contact added successfully - Toast verified");
		} else {
		    logger.error("Toast message verification failed. Actual message: " + message);
		}
		
	}
	
	
}
