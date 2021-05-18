package Comp.Qa.Walmart.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountHomePage {
	
	@FindBy(xpath="//span[contains(text(),'My account')]")
	WebElement myaccount;
	
	
	@FindBy(linkText="My recommendations")
	WebElement recommendationlink;
	
	@FindBy(xpath="//a[contains(text(),'My lists')]")
	WebElement mylistlink;
	
	
	@FindBy(xpath="//a[contains(text(),'My registries')]")
	WebElement myregisterieslink;
	
	//@FindBy(xpath="//div[contains(@class,'flyout-menu-content')]//a[@id='header-my-account']")

	@FindBy(xpath="//span[contains(text(),'My account')]")
	WebElement myaccountlink;
	
	@FindBy(xpath="//li[@id='header-deals']//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//body/div/div/div/div/div/div/div/div/div/div/div/div[5]/a[1]//*[local-name()='svg']")
    WebElement cartlogo;	
	
	@FindBy(linkText="Sign out")
	WebElement signoutlink;
	
	public void HomePageAfterLogin()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMyRecommendationlink()
	{
		
		action.moveToElement(myaccount).build().perform();
		recommendationlink.click();
		
	}
	
	public void clickOnMyListLink()
	{
		
		action.moveToElement(myaccount).build().perform();
		mylistlink.click();
		
	}
	
	public void clickOnMyRegisteriesLink()
	{
		action.moveToElement(myaccount).build().perform();
		myregisterieslink.click();
		
	}
	

	public LoginPage clickOnSignOutLink()
	{
		action.moveToElement(myaccount).build().perform();
		signoutlink.click();
		 return new LoginPage(null);
	}
	
	}
	
	public void clickOnCartLogo()
	{
		cartlogo.click();
	}

	public static void sortBy(String string) {
		
	}


	public static String getItemsOnFirstPage() {
		return null;
	}
}
