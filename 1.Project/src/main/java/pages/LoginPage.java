package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.Projectspecificmethods;

public class LoginPage extends Projectspecificmethods{
	
	WebDriver driver;
	

	
	
	By email=By.xpath("//input[@id='email']");
	By password=By.xpath("//input[@id='password']");
	By submit=By.xpath("//button[@id='submit']");
	By logout=By.xpath("//button[@id='logout']");
	By error=By.xpath("//span[@id='error']");
		
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}

	public void Enterusername(String un) {
		driver.findElement(email).sendKeys(un);
	}
	
	public void Enterpassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	public void loginbutton() {
		driver.findElement(submit).click();
	}
	
	public void logoutbutton() {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
    	
		driver.findElement(logout).click();
	}
	
	
	
	public void validatelogin(String Testtype, String Expected) {
	
		String actual_url=driver.getCurrentUrl();
		String exc_mes= Expected;
		
		logger.info("valid input is started");
		if (Testtype.equalsIgnoreCase("Validinput")) {
			
			if(actual_url.equalsIgnoreCase(exc_mes)) {
				
				WebElement Logout=wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
				Logout.click();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
		else if(Testtype.equalsIgnoreCase("Invalidinput")) {
			
			if (actual_url.equalsIgnoreCase(exc_mes)) {
		
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
			
		}
		
	}
	
}
		
	
			
		

