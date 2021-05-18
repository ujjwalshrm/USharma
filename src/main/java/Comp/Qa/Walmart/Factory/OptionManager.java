package Comp.Qa.Walmart.Factory;

import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {
//	  private static final Logger LOGGER  = Logger.getLogger(String.valueOf(OptionManager.class));
		
		private Properties prop;
		private ChromeOptions co;
//		private FirefoxOptions fo;
		
		public OptionManager(Properties prop) { //1 this value when we give or call. it goes to private prop
			this.prop = prop;
		}
		
		public ChromeOptions getChromeOptions() {
//			LOGGER.info("getting Chrome Options");
			co = new ChromeOptions();
			if(Boolean.parseBoolean(prop.getProperty("headless").trim())) co.addArguments("--headless");
			if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) co.addArguments("--incognito");
			return co;
		}
		
//		public FirefoxOptions getFirefoxOptions() {
//			LOGGER.info("getting Firefox Options");
//			fo = new FirefoxOptions();
//			if(Boolean.parseBoolean(prop.getProperty("headless").trim())) fo.addArguments("--headless");
//			if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) fo.addArguments("--incognito");
//			return fo;
//		}
		
		
}
