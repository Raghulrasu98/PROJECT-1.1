package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Projectspecificmethods;


public class ContactPage extends Projectspecificmethods{
	
	WebDriver driver;
	
	By addcontact= By.xpath("//button[@id='add-contact']");
	By firstname=By.xpath("//input[@id='firstName']");
	By lastname=By.xpath("//input[@id='lastName']");
	By birthdate= By.xpath("//input[@id='birthdate']");
	By email=By.xpath("//input[@id='email']");
	By phone=By.xpath("//input[@id='phone']");
	By street1=By.xpath("//input[@id='street1']");
	By street2=By.xpath("//input[@id='street2']");
	By city=By.xpath("//input[@id='city']");
	By state=By.xpath("//input[@id='stateProvince']");
	By postcode=By.xpath("//input[@id='postalCode']");
	By country=By.xpath("//input[@id='country']");
	By submitbutton=By.xpath("//button[@id='submit']");
	By Firstcontact=By.xpath("//tr[1]//td[2]");
	By Editcontact=By.xpath("//button[@id='edit-contact']");
	By cancelbutton=By.xpath("//button[@id='cancel']");
	By phonenumber = By.xpath("//span[@id='phone']");
	By error = By.xpath("//span[@id='error']");
	By delete=By.xpath("//button[@id='delete']");
	By contactName = By.xpath("//table[@class='contactTable']/tr[1]/td[2]");
	By toastMessage = By.xpath("//div[contains(@class,'toast-message')]");
	By address = By.xpath("//table[@class='contactTable']/tr/td[6]");


	
	
	public ContactPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void addfirstname(String fr) {
		driver.findElement(firstname).sendKeys(fr);
	}
	
	public void addcontactform() {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(addcontact));
    	
    	driver.findElement(addcontact).click();
		
	}

	public void addingcontact(String fn ,String ln ,String ph,String ct) {
		
		driver.findElement(addcontact).click();
		driver.findElement(firstname).sendKeys(fn);
		driver.findElement(lastname).sendKeys(ln);
		driver.findElement(phone).sendKeys(ph);
		driver.findElement(city).sendKeys(ct);
				
	}
	
	public String getPhoneNumber() {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(phonenumber));
    	
	    return driver.findElement(phonenumber).getText();
	    }
	
	    public void phonenumber() {
	    	
	    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(phonenumber));
	    	
	    	driver.findElement(phonenumber).isDisplayed();
	    }
	 

	    public void phnnum(String pn) {
	    	
	    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(phone));
	    	
	    	driver.findElement(phone).sendKeys(pn);
	    	
	    }
	    
	    public void deletebutton() {
	    	
	    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(delete));
	    	
	    	driver.findElement(delete).click();
	    }
	
       public void firstcontact() {
    	   
    	   
	   driver.findElement(Firstcontact).click();
	   
	   
       }
       
       
       public String getContactName() {
    	   
    	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	       wait.until(ExpectedConditions.visibilityOfElementLocated(contactName));
    	   
   	    return driver.findElement(contactName).getText();
     
       }
       
       public boolean isContactPresent(String contactName) {
    	    try {
    	        driver.findElement(By.xpath("//td[text()='" + contactName + "']"));
    	        return true;
    	    } catch (Exception e) {
    	        return false;
    	    }
    	}
     
       public void editcontact() {
    	
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(Editcontact));
    	
  	   driver.findElement(Editcontact).click();;
	   
   }
     public void birthDate(String bd) {
	
	    driver.findElement(birthdate).sendKeys(bd);
	
      }
     public void Email(String mail) {
 	
	    driver.findElement(email).sendKeys(mail);
	
      }
    
      public void Street1(String s1) {
		
		driver.findElement(street1).sendKeys(s1);
		
	}
      
      public String addressdetails() {
    	  
    	  return driver.findElement(address).getText();
    	  
    	  
      }
      public void Street2(String s2) {
	
	  driver.findElement(street2).sendKeys(s2);
	
      }
      
      public void clearlastname() {
    	  
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastname));
    	  
    	  driver.findElement(lastname).clear();
    	  
      }
       
      public void State(String st) {
		
		driver.findElement(state).sendKeys(st);
		
	}
      
      public void Postcode(String pc) {
  		
  		driver.findElement(postcode).sendKeys(pc);
  		
  	}
      
      public void Country(String co) {
  		
  		driver.findElement(country).sendKeys(co);
  		
  	}
      
      public void Submit() {
    	  driver.findElement(submitbutton).click();
      }
      
      public boolean errormessage() {
    	  
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    wait.until(ExpectedConditions.visibilityOfElementLocated(error));
    	  return driver.findElement(error).isDisplayed();
    	  
      }
    
      public void cancel() {
    	  driver.findElement(cancelbutton).click();
      }
      
      public void contactUrl() {
    	  driver.get("https://thinking-tester-contact-list.herokuapp.com/contactList");
      }
      
      public boolean areFieldsAlignedProperly() {

    	    int firstNameX = driver.findElement(firstname).getLocation().getX();
    	    int lastNameX = driver.findElement(lastname).getLocation().getX();
    	    int emailX = driver.findElement(email).getLocation().getX();
    	    int phoneX = driver.findElement(phone).getLocation().getX();
    	    int submitX = driver.findElement(submitbutton).getLocation().getX();

    	    return firstNameX == lastNameX &&
    	           lastNameX == emailX &&
    	           emailX == phoneX &&
    	           phoneX == submitX;
    	}

      public boolean areFieldsDisplayed() {

    	    return driver.findElement(firstname).isDisplayed()
    	        && driver.findElement(lastname).isDisplayed()
    	        && driver.findElement(email).isDisplayed()
    	        && driver.findElement(phone).isDisplayed()
    	        && driver.findElement(submitbutton).isDisplayed();
    	}
      
      public String getToastMessage() {

    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	    wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage));
			
    	    return driver.findElement(toastMessage).getText();
			
    	   	}
     
      public int getFirstNameLength() {
    	    return driver.findElement(firstname)
    	                 .getAttribute("value")
    	                 .length();
    	}
      

}
