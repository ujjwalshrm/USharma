package Comp.Qa.Walmart.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	private WebDriver driver;

	public JavaScriptUtil(WebDriver driver) {
		this.driver= driver;
	}
	
//	1.  Title
	public String getTitleByJS() {
//		To run javascript Executor, we have to convert DRIVER in EXECUTOR and store that in JavaScriptExecutor reference variable 
		JavascriptExecutor js = ((JavascriptExecutor) driver);
//		Below line just used to execute the script
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

//	2. InnerText
	public String getPageInnerText() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
//	3. To refresh the page
	public void refreshBrowserByJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}
	
//	4. draw the border (give webElement)--Used when we raise the bug or track the element
	public void drawBorder(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
//	5. flash the selected element basically keep changing the color looks like it is changing 
	public void flash(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 25; i++) {
			changeColor("rgb(0,200,0)", element);// 1
			changeColor(bgcolor, element);// 2
		}
	}

	private void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}


//	6. Generate alert
	public void generateAlert(String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");
	}
	
//	7. User Agent - give information for user and browser
	public String getBrowserInfo() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String uAgent = js.executeScript("return navigator.userAgent;").toString();
		return uAgent;
	}

//	8. Helps in pop up where element is not interactable
	public void clickElementByJS(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}
	
//	9.
	public void scrollPageDown() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void scrollPageUp() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}

//	10. Scroll to till specific element
	public void scrollIntoView(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	
	public void sendKeysUsingJSWithId(String id, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}

	public void sendKeysUsingJSWithName(String name, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementByName('" + name + "').value='" + value + "'");
	}

	public void checkPageIsReady() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Initially below given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
			return;
		}
		// This loop will rotate for 25 times to check If page Is ready after every 1 second.
		// You can replace your value with 25 If you wants to Increase or decrease wait time.
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}
}
