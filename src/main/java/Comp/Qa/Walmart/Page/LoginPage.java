package Comp.Qa.Walmart.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Comp.Qa.Walmart.Utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
//	1. By locator In every page class remember we need to maintain by locators/Object repository OR
	
//	@FindBy(id="username") WebElement Username;
	private By Username = (By.id("username"));
	
//	@FindBy(id="password") WebElement Password;
	private By Password = (By.id("password"));
	
	@FindBy(xpath="//label[@for = 'rememberme']//div[text()= 'Keep me']") WebElement KeepSignIn;
	@FindBy(xpath="//button[contains (text(), 'Sign in')]") WebElement SignIn;
	
	private By createAccountLink= By.xpath("//a[contains (text(), 'Create account')]");
	
//	2. Constructor of page class
//	public LoginPage (WebDriver driver) {
//		this.driver=driver;
//		}
	
//	Initialize the element of OR using page Factory
	public LoginPage(WebDriver driver) { //purpose of driver in bracket is 
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtil = new ElementUtil(this.driver);
	}
	
//	3. Page action/ methods /Libraries
	public String getLoginPageTitle() {
		return driver.getTitle();
	}		

//	3. Initialize the login
	public MyAccountPage doLogin (String un, String pwd) {
//		Username.sendKeys(un);
		elementUtil.doSendKeys(Username, un);
//		Password.sendKeys(pwd);
		elementUtil.doSendKeys(Password, pwd);
		KeepSignIn.click();
		SignIn.click();
		
//		link to nextpage
		return new MyAccountPage(driver);		
	}
	
	public SignUpPage navigateToSignUpPage() {
		System.out.println("Navigate to register page");
		elementUtil.doClick(createAccountLink);
		return new SignUpPage(driver);
	}

}
