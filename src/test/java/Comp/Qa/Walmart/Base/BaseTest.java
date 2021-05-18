package Comp.Qa.Walmart.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Comp.Qa.Walmart.Factory.DriverFactory;

import Comp.Qa.Walmart.Page.HomePage;
import Comp.Qa.Walmart.Page.LoginPage;
import Comp.Qa.Walmart.Page.MyAccountPage;
import Comp.Qa.Walmart.Page.SignUpPage;

public class BaseTest {
	
	
//		create reference and import because its coming from different package
		DriverFactory df; 
		public	Properties prop;
		WebDriver driver;
		
		public SignUpPage  signUpPage; //signup page
		public LoginPage loginPage; // public to access from
		public HomePage homePage;// Guest user
		public MyAccountPage myAccountPage;
		
		@BeforeTest 
		public void setup() {
			df=new DriverFactory();
		
//		create object of  first because first we have to see which browser is written(chrome).		
		prop = df.init_prop();	
		
//		get name of browser and pass it to init_driver
//		String browserName = prop.getProperty("browser"); 
//		driver= df.init_Driver(browserName);
		driver= df.init_Driver(prop);
			
		driver.get(prop.getProperty("url"));	
		
//1.	In case when we need to start for create Account page
//		accountPage = new CreateAccountPage(driver); 
		
//2.	This driver will call the constant and constant than pass it to LoginPage class driver			
		loginPage = new LoginPage(driver); 

//3. 	In case when we need to start from Home page
//		homePage = new HomePage(driver); 
		}

		@AfterTest
		public void tearDown() {
		driver.close();
		}
		
	}
