package Comp.Qa.Walmart.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Comp.Qa.Walmart.Base.BaseTest;
import Comp.Qa.Walmart.Page.HomePage;
import Comp.Qa.Walmart.Page.LoginPage;
import Comp.Qa.Walmart.Page.RecommendationPage;
import Comp.Qa.Walmart.Page.SignUpPage;

public class RecommendationPageTest extends BaseTest {


		HomePage homepage;
		LoginPage loginPage;
		RecommendationPage recommendationpage;
		MyAccountPage myAccountPage;
		
		public RecommendationPageTest()
		{
			super();
		}

		@BeforeTest()
		public void setUp() throws InterruptedException
		{
			initialization();
			homepage= new HomePage();
			loginPage = new LoginPage();
			MyAccountPage = new HomePageAfterLogin();
			recommendationpage= new RecommendationPage();



			homepage.clickOnSignIn();
			//Thread.sleep(6000);
			loginPage.enterEmail("brucewayne@mailinator.com");
			loginPage.enterPassword("Batman@123");
			loginPage.SignIn();
		}

		private void initialization() {
			// TODO Auto-generated method stub
			
		}

		@Test(priority=1)
		public void clickOnRecommendationLink() {
			MyAccountPage.clickOnMyRecommendationlink();
			String actual=	recommendationpage.verifyHeader();

			String Expected="Recommendations for";

			Assert.assertEquals(actual, Expected);


		}




}
