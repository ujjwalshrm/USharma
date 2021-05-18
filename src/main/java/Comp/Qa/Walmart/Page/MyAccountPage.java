package Comp.Qa.Walmart.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Comp.Qa.Walmart.Utils.Constants;
import Comp.Qa.Walmart.Utils.ElementUtil;

public class MyAccountPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
//	1.By locators OR;
	@FindBy(xpath="//div[@data-automation='quick-links']/a") WebElement Quicklinks;
	
//	@FindBy(xpath="//h2")int header;
	By header= By.xpath("//h2");
	//
	//

	@FindBy(xpath="//h1[@class='tablet-hide']")
	WebElement title;
	
	@FindBy(linkText="Personal Settings")
	WebElement personalsettingslink;
	
	@FindBy(linkText="Addresses")
	WebElement addresseslink;
	
	@FindBy(linkText="Credit Cards")
	WebElement creditcardslink;
	
	@FindBy(linkText="Sign Out")
	WebElement signoutlink;
	
	
//	2. Constructor of page class
	public MyAccountPage (WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
//		create object inside the constructor so that we can pass the driver and initialize the object here
		elementUtil= new ElementUtil(this.driver); 
		}
	
	
//	3. Actions
	public String getaccountsPageTitle() throws InterruptedException {
		Thread.sleep(10000);
		return elementUtil.waitForPageTitlePresent(Constants.ACCOUNT_PAGE_TITLE, 10);
	}

	//problem with pagefactory method
	public int getheadersCount() {
		return driver.findElements(header).size();
	
	}
	
	/*
	 * 
	 */
	
	public MyAccountPage()
	{
	PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle()
	{
	String MyAccountTitle=	title.getText();
	return MyAccountTitle;
	}
	
	public void clickOnPersonalSettingsLink()
	{
		personalsettingslink.click();
	}
	
	public void clickOnAddressesLink()
	{
		addresseslink.click();
	}
	
	public LoginPage clickOnSignOutLink()
	{
		signoutlink.click();
		return new LoginPage(driver);
	}
	public void clickOnCreditCardsLink()
	{
		creditcardslink.click();
		
	}
}
