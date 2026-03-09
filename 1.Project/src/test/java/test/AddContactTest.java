package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Projectspecificmethods;
import pages.ContactPage;
import pages.LoginPage;

public class AddContactTest extends Projectspecificmethods{
	
	private static final Logger logger = LogManager.getLogger(AddContactTest.class);
	
	@BeforeTest
	public void extentdetails() {
		testname="Add contact Test";
		testdescription="Testing the addcontact functionality";
		testcategory="Smoke Testing";
		testauthour="Raghul";
		
		}
	
	@Test(dataProvider="xladdcontact")
	public void AddContact(String usernmae,String password , String Firstname,String Lastname, String phone,String city,String TestType, String Expected) {
		
		LoginPage lp=new LoginPage(driver);
		ContactPage ac=new ContactPage(driver);
		
		logger.info("page is opened ");
		lp.Enterusername(usernmae);
		lp.Enterpassword(password);
		lp.loginbutton();
		
		ac.addingcontact(Firstname, Lastname, phone, city);
		
		ac.Submit();
		
	
		
		
	}

}
