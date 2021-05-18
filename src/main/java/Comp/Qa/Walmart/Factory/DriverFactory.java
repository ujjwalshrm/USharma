package Comp.Qa.Walmart.Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

//	Reference at class level so anyone can use it.
	WebDriver driver;
	Properties prop;
	public static String highlight;
	OptionManager optionManager;
	
//	Thread local Driver
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
	
	/**
	 * This method use to initialize the web Driver on basis of given browser name
	 * but we want to use other method as well from property file so we select prop 
	 * @param prop
	 * @return
	 */
	
//	public WebDriver init_Driver(String browserName)
	public WebDriver init_Driver(Properties prop) {
	
		String Browser= prop.getProperty("browser");
		highlight = prop.getProperty("highlight");
		
		optionManager = new OptionManager(prop);
				
		if (Browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver(optionManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionManager.getChromeOptions()));	
		}
		
//		Simple use no option method, no thread local
		else if (Browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else {
			System.out.println("pass the right browser");
		}
		
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		return driver();
		
//		With Thread Local Method
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
//		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	/**
	 * Method used to Initialize the properties from config file
	 * @return Properties prop
	 */
	 
//	These are the environment properties just like we declare java_HOME environment home variable 
	public Properties init_prop() {
		 prop =new Properties();
		 
//	For any file interaction we need to create FileIntputStream class	
		 try {
			FileInputStream ip= new FileInputStream("./src/test/resources/config/configuration.properties");
			prop.load(ip);
		 	 }
		 			catch (FileNotFoundException e) {
		 					e.printStackTrace();
		 			} catch (IOException e) 		{
		 		  			e.printStackTrace();
		 			}
		
		 return prop;
	}

	/**
	 *Take screenshot
	 * Ashot for full screenshot
	 */
	public String getScreenshot() {
	File srcFile=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
	
	String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
	File destination = new File(path);
	
	try {
		FileUtils.copyFile(srcFile, destination);
	} catch (IOException e) {
//		LOGGER.error("some exception is coming while creating the screenshot");
		e.printStackTrace();
	}
	return path;
}
	
}
