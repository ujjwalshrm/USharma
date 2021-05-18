package Comp.Qa.Walmart.Page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Comp.Qa.Walmart.Factory.DriverFactory;


public class RecommendationPage extends DriverFactory{

	
	@FindBy(xpath="//h1[contains(text(),'Recommendations for')]")
	WebElement title;
	
	public  RecommendationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHeader()
	{
		String actual=title.getText();
		return actual;
	
	}
}

