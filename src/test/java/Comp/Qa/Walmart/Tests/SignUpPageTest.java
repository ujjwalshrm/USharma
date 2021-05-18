package Comp.Qa.Walmart.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Comp.Qa.Walmart.Base.BaseTest;
import Comp.Qa.Walmart.Page.SignUpPage;
import Comp.Qa.Walmart.Utils.ExcelUtil;

public class SignUpPageTest extends BaseTest{
	
	private static final String ACCOUNT_SUCCESS_MESSG = null;

	@BeforeClass
	public void signUpPageSetup() {
		signUpPage =loginPage.navigateToSignUpPage();
	}
	
	
//	Hard core input values method
	@Test(enabled=false)
	public void accountRegistrationTest() {
	signUpPage.accountRegistration("Shanu", 
									"Sharma",
									"9990009999",
									"tom111@gmail.com",
									"P@ssword1!");	
		Assert.assertEquals(ACCOUNT_SUCCESS_MESSG, "banner-welcome");
	}
	
	@DataProvider
	public Object[][] getRegistrationData() {
	Object data[][]	=ExcelUtil.getTestData("register");
	return data;
	}
	
	@Test(dataProvider="getRegistrationData") 
	public void accountRegistrationTest(String Firstname, String LastName, String PhoneNumber, String 
			Emailaddress,String Password) {
		Assert.assertTrue(signUpPage.accountRegistration(Firstname, LastName, PhoneNumber, Emailaddress, Password));
	}
	
}
