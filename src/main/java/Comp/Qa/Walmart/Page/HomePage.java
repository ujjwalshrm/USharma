package Comp.Qa.Walmart.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Comp.Qa.Walmart.Utils.ElementUtil;
import Comp.Qa.Walmart.Utils.JavaScriptUtil;

public class HomePage {
	
//  To avoid Captcha I am associating all page from this page "https://www.walmart.ca/en" in config.property	

	private WebDriver driver;
	private ElementUtil elementUtil;
	private JavaScriptUtil javaScriptUtil;

//	1. By locator
	@FindBy (xpath="//div[@data-automation= 'quick-links']//li") WebElement quicklinks;
	@FindBy (xpath="//input[@aria-label='What are you looking for?']") WebElement searchText;
	@FindBy (xpath="//button[@aria-label='Search']") WebElement searchButton;
	
	@FindBy (xpath="//div[@data-automation='product']") List<WebElement> returnItemOnPage;
	By returnItems = By.xpath("(//p[contains (@data-automation, 'name' ) ]) [position()=5]");
	
//	2. Constructor of page class
	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver,this);
		elementUtil = new ElementUtil(this.driver);
		
		this.driver=driver;
		javaScriptUtil= new JavaScriptUtil(this.driver);
	}
	
//	3.1 Action Title
	public String getPagetitle() {
		return driver.getTitle();
	}
	
//	3.2 Action count
	public int doCountItemAppear() throws InterruptedException {
		searchText.sendKeys("shoe");
		searchButton.click();
		javaScriptUtil.scrollPageDown();	
		Thread.sleep(8000);

		
//	With By locator method along two options
//		List <WebElement>list= driver.findElements( By.xpath("//div[@data-automation='product']"));
//		List <WebElement> list= elementUtil.getElements(returnItems);
//		int a = list.size();
//		return a;
		
//	With Findby method
	return returnItemOnPage.size();
	
		}
//	3.3 selecting product
	public void selectProductFromResult(String productName) {
		List <WebElement> list =elementUtil.getElements(returnItems);
		System.out.println("Total number of items displayed"+ list.size());
		
		for(WebElement e: list) {
		if(e.getText().equals(productName)) {
			e.click();
			break;
		}
		
	}
	}	
}
