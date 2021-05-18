package Comp.Qa.Walmart.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Comp.Qa.Walmart.Base.BaseTest;

public class HomePageTest extends BaseTest {

	@Test(priority=1)
	public void homePageTitleTest() {
	String title= homePage.getPagetitle();
	Assert.assertEquals(title, "Online Shopping Canada: Everyday Low Prices at Walmart.ca!");
	}
	
	
	@Test(priority=2)
	public void doCountItemAppearTest () throws InterruptedException {
		int a = homePage.doCountItemAppear();
		Assert.assertEquals(a, 64);
	}
	
	@Test(enabled = false)
	public void selectProductFromResultTest() throws InterruptedException {
		homePage.doCountItemAppear();
		homePage.selectProductFromResult("George Women's Lemon Sneakers");
	}
}
