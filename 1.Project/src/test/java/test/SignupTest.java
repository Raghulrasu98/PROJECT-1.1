package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Projectspecificmethods;
import pages.SignupPage;


public class SignupTest extends Projectspecificmethods{
	
	private static final Logger logger = LogManager.getLogger(SignupTest.class);
	
	@BeforeTest
	public void extentdetails() {
		testname="signup Test";
		testdescription="Testing the signup functionality with valid and invalid details";
		testcategory="Smoke Testing";
		testauthour="Raghul";
		
		}
	
	
	@Test(dataProvider="xlsignup")
	public void signup(String firstname,String lastname,String username, String userpass) {
		
		SignupPage sp=new SignupPage(driver);
		
		sp.signupbutton();
		
		logger.info("signup page is open");
		
		sp.enterfirstname(firstname);
		sp.enterlastname(lastname);
		sp.Enterusername(username);
		sp.Enterpassword(userpass);
		sp.submitbutton();
		
		
	}
	
}
