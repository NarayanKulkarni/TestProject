package DriverConfigs;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.manager.SeleniumManager;

public class driverSelection {
		private WebDriver driver;
		Properties props = new Properties();
		

		// resource paths (properties file path)
		private final String propsFilepath = "/resources/config.properties";
		
		//initializerDriver according to the properties file 
		public WebDriver InitializerTheDriver() {
			loadProperty();
			switch(getBrowser()) {
			case "chrome":
				SeleniumManager.getInstance();
				driver = new ChromeDriver();
				break;
			case "firefox":
				SeleniumManager.getInstance();
				driver = new FirefoxDriver();
				break;
			case "edge":
				SeleniumManager.getInstance();
				driver = new EdgeDriver();
				break;
				default:
					}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			return driver;
		}

		// Check the Properties file is present of not & it return the place of .properties file
		public void loadProperty() {
			try {
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);  //Return the File place in the system /resources/config.properties means to get the place of .properties file
				props.load(fis);
			} catch (IOException e) {
				System.out.println("Exception in loadProperty method: " + e.getMessage());
			}
		}


		// Get the URL from the properties file
		public String getUrl(String url) {
			return props.getProperty(url);
		}

		// Get the Browser value from the properties file
		public String getBrowser() {
			return props.getProperty("browser");
		}
	
}
