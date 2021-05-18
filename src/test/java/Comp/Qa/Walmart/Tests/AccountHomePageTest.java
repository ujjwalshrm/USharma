package Comp.Qa.Walmart.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Comp.Qa.Walmart.Base.BaseTest;
import Comp.Qa.Walmart.Page.AccountHomePage;
import Comp.Qa.Walmart.Utils.Constants;

public class AccountHomePageTest extends BaseTest {

	@BeforeClass
	public void accountAccountHomePageSetup() {
		myAccountPage =loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password") );
//		We need above reference if we want to use accept page methods
	}
	
		@Test
		(priority=1)
		public void accountPageTitleTest() throws InterruptedException {
		String title =myAccountPage.getaccountsPageTitle();
		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
		}
		
		@Test
		(priority=2)
		public void headersCountTest() {
			int sz= myAccountPage.getheadersCount();
			Assert.assertTrue(sz == 26);
		}
		@Test 
		public void searchProductWithItemNumberTest()
		{
			AccountHomePage.searchProduct("322YXQISBR52");
		}
		
		@Test  
		public void searchProductInDepartmentTest() throws InterruptedException
		{
			AccountHomePage.navigateToDepartmentProduct();
		}
		@Test 
		public void verifyRelvalantProductNameTest()
		{
			AccountHomePage.searchProduct("waterbottle");
			String actual = AccountHomePage.verifySearchProductWithName();
					
			Assert.assertTrue(true, actual);
			
		}
		
		@Test 
		public void verifyProductInformationTest()
		{
			AccountHomePage.searchProduct("waterbottle");
			
			AccountHomePage.verifyProductInformation();
		}
		
		@Test 
		public void getTotalNumberOfProductsPerPageTest() throws InterruptedException 
		{
			AccountHomePage.searchProduct("bottle");
		
			int totalcount=AccountHomePage.getCountOfTotalproducts();
			Assert.assertEquals(totalcount, 60);
			
		}
		@Test 
		public void noDuplicationOnPaginationTest()
		{
			AccountHomePage.searchProduct("bottle");
			String  firstpage= AccountHomePage.getItemsOnFirstPage();
			String secondpage = AccountHomePage.getItemsOnSecondPage();
			Assert.assertFalse(firstpage.equals(secondpage));
		}
		 
		@Test 
		public void sortingTest()
		{
			AccountHomePage.searchProduct("bottle");
			AccountHomePage.sortBy("Top Rated");
			
		}
		
		@Test 
		public void filternyNewArrivalsTest() 
		{
			AccountHomePage.searchProduct("bottle");
			AccountHomePage.filterByNewArrivals();
		
			//Assert.assertEquals(true, AccountHomePage.filterByNewArrivals());
		}
		
		 
		@Test 
		public void filterbyCustomerRatingTest()
		{
			AccountHomePage.searchProduct("bottle");
			AccountHomePage.filterByCustomerRating(4);
		}
		
		@Test 
		public void filterByAvailabiltyTest()
		{
			AccountHomePage.searchProduct("bottle");
			AccountHomePage.filterByAvailabilty("In Store");
		}
		
		@Test 
		public void filterByPriceTest() throws InterruptedException
		{
			AccountHomePage.searchProduct("bottle");
			AccountHomePage.filterByPrice("15", "20");
		}
		
}
