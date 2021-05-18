package Comp.Qa.Walmart.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Comp.Qa.Walmart.Base.BaseTest;
import Comp.Qa.Walmart.Utils.Constants;

public class LoginPageTest extends BaseTest{

//	This Test pages will be used For calling and asserting
	
	@Test
	(priority=1)
	public void loginPageTitleTest() {
		String title= loginPage.getLoginPageTitle();
		System.out.println(title);				//Cx should not have any driver in program
		Assert.assertEquals(title, "Walmart Canada" ); //from constant class	
	}	
	
	@Test
	(priority=2)
	public void doLoginTest() throws InterruptedException {
//		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
//		to verify we refer the above line with account page
		myAccountPage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(myAccountPage.getaccountsPageTitle(), Constants.ACCOUNT_PAGE_TITLE);
	}
	
	
}
