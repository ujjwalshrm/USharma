package Comp.Qa.Walmart.Page;

import javax.lang.model.element.Element;
import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Comp.Qa.Walmart.Utils.ElementUtil;
import net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveTypeAwareAssigner;

public class SignUpPage {

private static final By ACCOUNT_SUCCESS_MESSG = null;
//	1.by locator In every page class remember we need to maintain by locators/Object repository OR
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By Firstname = By.id("firstName");
	private By LastName = By.id("lastName");
	private By Phonenumber	= By.id("phoneNumber");
	private By Emailaddress = By.id("email");		
	private By Password = By.id("password");
				
	private By Flyer=(By.xpath("//label[contains (text(), 'Email me about weekly flyers, rollback & clearance items')]"));
	private By TermsandCondition= (By.xpath("//label[contains (text(), 'By selecting \"Create account\", you are confirming that you have read and agree to Walmart Canada’s ')]"));
	
	private By Button = (By.xpath("//button [contains (text(), 'Create account')]"));
	private By VerifySignUpPageText= By.xpath("//h1[contains (text(), 'Create an account')]");
	private By VerifyWelcomePage= By.xpath("//h1[@data-automation]");
	
//	2. Constructor of page class
	public SignUpPage (WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
	}
		
//	3. Action
	public boolean accountRegistration(String Firstname, String LastName, String PhoneNumber, String 
			Emailaddress,String Password) {
		elementUtil.doSendKeys(this.Firstname, Firstname);
		elementUtil.doSendKeys(this.LastName, LastName);
		elementUtil.doSendKeys(this.Phonenumber, PhoneNumber);
		elementUtil.doSendKeys(this.Emailaddress, Emailaddress);
		elementUtil.doSendKeys(this.Password, Password);
		elementUtil.doClick(TermsandCondition);
		elementUtil.doClick(Button);
		elementUtil.doGetText(ACCOUNT_SUCCESS_MESSG);
		return true;
		
	}
	
}
