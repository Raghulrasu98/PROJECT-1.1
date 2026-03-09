package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.Utilityclass;

public class Projectspecificmethods extends Utilityclass {
	
	@BeforeSuite
	public void reportintialization() {
		
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/src/test/resources/testoutput/herokureport.html");
		
		sparkReporter.config().setDocumentTitle("automation report");
		sparkReporter.config().setReportName("functional testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
	
	}
	
	@BeforeClass
	public void testdescription() {
		
		test=extent.createTest(testname, testdescription);
		test.assignCategory(testcategory);
		test.assignAuthor(testauthour);
		
		}
	
	@Parameters({"url","browser"})
	@BeforeMethod
	public void browserlaunch(String url,String browser) {
		
		browsersetup(browser);
		geturl(url);
		
	}
	
	
	@DataProvider(name="xllogindetails")
	public Object[][] readlogin() throws IOException {
		String filepath = System.getProperty("user.dir") + "/src/test/resources/Data/Logindata.xlsx";
		
		int row=Utilityclass.getRowCount(filepath, "logindetails");
		
		Object[][] data=new Object[row][2];
		for(int i=1; i<=row;i++) {
					
			data[i-1][0]=Utilityclass.getcelldata(filepath, "logindetails", i, 0);
			data[i-1][1]=Utilityclass.getcelldata(filepath, "logindetails", i, 1);
			
		}
		return data;
		
	}
	
	
	@DataProvider(name="xllogin")
	public Object[][] readlogindata() throws IOException {
		String filepath = System.getProperty("user.dir") + "/src/test/resources/Data/Logindata.xlsx";
		
		int row=Utilityclass.getRowCount(filepath, "Login");
		
		Object[][] data=new Object[row][4];
		for(int i=1; i<=row;i++) {
					
			data[i-1][0]=Utilityclass.getcelldata(filepath, "Login", i, 0);
			data[i-1][1]=Utilityclass.getcelldata(filepath, "Login", i, 1);
			data[i-1][2]=Utilityclass.getcelldata(filepath, "Login", i, 2);
			data[i-1][3]=Utilityclass.getcelldata(filepath, "Login", i, 3);
		}
		return data;
		
	}
	
	@DataProvider(name="xlsignup")
	public Object[][] readsignupdata() throws IOException {
		String filepath = System.getProperty("user.dir") + "/src/test/resources/Data/Logindata.xlsx";
		
		int row=Utilityclass.getRowCount(filepath, "signup");
		
		Object[][] data=new Object[row][4];
		for(int i=1; i<=row;i++) {
					
			data[i-1][0]=Utilityclass.getcelldata(filepath, "signup", i, 0);
			data[i-1][1]=Utilityclass.getcelldata(filepath, "signup", i, 1);
			data[i-1][2]=Utilityclass.getcelldata(filepath, "signup", i, 2);
			data[i-1][3]=Utilityclass.getcelldata(filepath, "signup", i, 3);
			
			
		}
		return data;
		
	}
	
	@DataProvider(name="xladdcontact")
	public Object[][] readcontactdata() throws IOException {
		String filepath = System.getProperty("user.dir") + "/src/test/resources/Data/Logindata.xlsx";
		
		int row=Utilityclass.getRowCount(filepath, "contactdetails");
		
		Object[][] data=new Object[row][8];
		for(int i=1; i<=row;i++) {
					
			data[i-1][0]=Utilityclass.getcelldata(filepath, "contactdetails", i, 0);
			data[i-1][1]=Utilityclass.getcelldata(filepath, "contactdetails", i, 1);
			data[i-1][2]=Utilityclass.getcelldata(filepath, "contactdetails", i, 2);
			data[i-1][3]=Utilityclass.getcelldata(filepath, "contactdetails", i, 3);
			data[i-1][4]=Utilityclass.getcelldata(filepath, "contactdetails", i, 4);
			data[i-1][5]=Utilityclass.getcelldata(filepath, "contactdetails", i, 5);
			data[i-1][6]=Utilityclass.getcelldata(filepath, "contactdetails", i, 6);
			data[i-1][7]=Utilityclass.getcelldata(filepath, "contactdetails", i, 7);
			
			
		}
		return data;
		
	}
	
	@AfterMethod
	public void closebrowser() throws InterruptedException {
		
		driver.quit();
		
	}

		
	@AfterSuite
	public void closereport() {
		extent.flush();
	}
	

}
