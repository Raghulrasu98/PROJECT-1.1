package test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Projectspecificmethods;
import pages.ContactPage;
import pages.LoginPage;



public class SessionAndNavigationTest extends Projectspecificmethods{
	
	
	private static final Logger logger = LogManager.getLogger(SessionAndNavigationTest.class);
	
	@BeforeTest
	public void extentdetails() {
		testname="Session and navigation Test";
		testdescription="Testing the logout and refresh functionality";
		testcategory="Smoke Testing";
		testauthour="Raghul";
	}
	
	
	@Test(dataProvider="xllogindetails", priority=1)
	public void redirect(String username , String password) {
		LoginPage lp=new LoginPage(driver);
		
		String befor_title=driver.getTitle();
			
		logger.info("username and password is given ");
		lp.Enterusername(username);
		lp.Enterpassword(password);
		lp.loginbutton();
				
		logger.info("page is loggedin ");
		
		lp.logoutbutton();
		
		String after_title=driver.getTitle();
		
		logger.info("page is loggedout ");
		
		if(befor_title.equals(after_title)) {
		logger.info("PASS:page is redirected to login page");
	}else {
		logger.info("ERROR:page is not logged out");
	}
		
	}
	
	@Test(dataProvider="xllogindetails", priority=2)
	public void refresh(String username , String password){
		LoginPage lp=new LoginPage(driver);
		
			
		logger.info("username and password is given ");
		lp.Enterusername(username);
		lp.Enterpassword(password);
		lp.loginbutton();
		
		logger.info("page is loggedin ");
		
		String before_title= driver.getTitle();
		
		driver.navigate().refresh();
		
		String after_title= driver.getTitle();
		
		if(before_title.equals(after_title)) {
			logger.info("PASS:page remains login and contacts are displayed");
		}else {
			logger.info("ERROR:page is logged out");
		}
	}
		
		
		
	@Test(dataProvider="xllogindetails", priority=3)
	public void verifyurl(String username , String password){
		
		ContactPage cp=new ContactPage(driver);
		
		String before_title=driver.getTitle();
		
		cp.contactUrl();
		
		String after_title=driver.getTitle();
		
		if(before_title.equals(after_title)) {
			logger.info("PASS:page is directed to login page");
		}else {
			logger.info("ERROR:user is directed to contact page and it does not goes to login page");
		}
	
	}
	@Test(dataProvider="xllogindetails", priority=4)
	public void Backbutton(String username , String password){
		LoginPage lp=new LoginPage(driver);
		
			
		logger.info("username and password is given ");
		lp.Enterusername(username);
		lp.Enterpassword(password);
		lp.loginbutton();
		
		logger.info("page is loggedin ");
		
		String before_title= driver.getTitle();
		
		driver.navigate().back();
		
		String after_title= driver.getTitle();
		
		if(before_title.equals(after_title)) {
			logger.info("PASS:page is logged out and goes to login page");
		}else {
			logger.info("ERROR:page gets back to contact page");
		}
	}

}
