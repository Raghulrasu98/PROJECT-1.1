package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.Projectspecificmethods;

public class SignupPage extends Projectspecificmethods{
	
	WebDriver driver;
	
	By signup=By.xpath("//button[@id='signup']");
	By firstname=By.xpath("//input[@id='firstName']");
	By lastname=By.xpath("//input[@id='lastName']");
	By email=By.xpath("//input[@id='email']");
	By logout=By.xpath("//button[@id='logout']");
	By password=By.xpath("//input[@id='password']");
	By submit=By.xpath("//button[@id='submit']");

	
	public SignupPage(WebDriver driver) {
		this.driver=driver;
	}

	public void signupbutton() {
		driver.findElement(signup).click();
	}
	
	public void enterfirstname(String fn) {
		driver.findElement(firstname).sendKeys(fn);;
	}
	
	public void enterlastname(String ln) {
		driver.findElement(lastname).sendKeys(ln);;
	}
	
	public void Enterusername(String un) {
		driver.findElement(email).sendKeys(un);
	}
	
	public void Enterpassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	public void submitbutton() {
		driver.findElement(submit).click();
	}
	public void loginbutton() {
		driver.findElement(submit).click();
	}
	
	
	public void validatesignup(String Testtype, String expected) {
		
		String actual_url=driver.getCurrentUrl();
		String exp_url=expected;
		
		if(Testtype.equalsIgnoreCase("Validinput")) {
			if(actual_url.equalsIgnoreCase(exp_url)) {
				WebElement Logout=wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
				Logout.click();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
		else if(Testtype.equalsIgnoreCase("Invalidinput")) {
			
			if (actual_url.equalsIgnoreCase(exp_url)) {
		
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
			
		}
			}
			
		}
	
	
	
	

