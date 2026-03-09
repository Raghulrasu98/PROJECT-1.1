package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Projectspecificmethods;
import pages.ContactPage;
import pages.LoginPage;

public class InputvalidationTest extends Projectspecificmethods{
	
private static final Logger logger = LogManager.getLogger(InputvalidationTest.class);
	
	@BeforeTest
	public void extentdetails() {
		testname="Input validation Test";
		testdescription="Testing irregulat input for validation ";
		testcategory="Smoke Testing";
		testauthour="Raghul";
	}

	@Test(dataProvider="xllogindetails")
	public void successindicators(String usernmae,String password ) throws InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		ContactPage cp=new ContactPage(driver);
		
		logger.info("page is opened ");
		lp.Enterusername(usernmae);
		lp.Enterpassword(password);
		lp.loginbutton();
		
		cp.addcontactform();
		
		String firstname="raghul".repeat(350);
		
		logger.info("long word is added");
		
		cp.addfirstname(firstname); 
		
		int actualLength = cp.getFirstNameLength();
		logger.info("Actual entered length: " + actualLength);

		if (actualLength <= 50) {   
		    logger.info("PASS:Field restricts input properly");
		} else {
		    logger.error("FAIL:Field is not restricting input");
		}
		
	}
	
	@Test(dataProvider="xllogindetails")
	public void addingemoji(String usernmae,String password ) {
		
		LoginPage lp=new LoginPage(driver);
		ContactPage cp=new ContactPage(driver);
		
		logger.info("page is opened ");
		lp.Enterusername(usernmae);
		lp.Enterpassword(password);
		lp.loginbutton();
		
		String firstname="arultharum";
		String Lastname="muruga";
		String phone="987651234";
		String city="tirupur";	
		String emojiaddress = "☺️☺️☺️☺️☺️☺️☺️☺️";
		cp.addingcontact(firstname, Lastname, phone, city);
		
		cp.Street1(emojiaddress);
		
		cp.Submit();
		
		String addressadded=cp.addressdetails();
		
		if (addressadded.equals(emojiaddress)) {
			logger.info("System accepts emoji and displays them correctly");
		}else {
			logger.info("cannot added special characters");
		}
		
	}
	
}
