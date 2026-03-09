package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import base.Projectspecificmethods;
import pages.LoginPage;

public class LoginTest extends Projectspecificmethods{
	
	private static final Logger logger = LogManager.getLogger(LoginTest.class);
	
	@BeforeTest
	public void extentdetails() {
		testname="Login Test";
		testdescription="Testing the login up functionality with valid and invalid details";
		testcategory="Smoke Testing";
		testauthour="Raghul";
	}
	
	
	
	@Test(dataProvider="xllogin")
	public void loginprac(String username,String password,String Testtype, String Expected) {
		
		logger.info("test has started");
		LoginPage lp=new LoginPage(driver);
		
		lp.Enterusername(username);
		lp.Enterpassword(password);
		lp.loginbutton();
		
		lp.validatelogin( Testtype ,Expected);
		
		
		logger.info("test is completed");
	
		
		
	}
	
	

}
