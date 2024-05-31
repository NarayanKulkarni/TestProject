package DriverConfigs;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//The driver instance variable is set to the WebDriver instance passed to the constructor.
	//The wait instance variable is initialized to a new WebDriverWait object, which will wait up to 15 seconds for a condition to be met when interacting with the WebDriver
	public CommonFunctions(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	// This is helper method to wait the element  // "@parameter-ele - WebElement" //@returns - boolean value
	public boolean waitForElement(WebElement ele) {
		return wait.until(ExpectedConditions.elementToBeClickable(ele)) != null ? true :false;
	}
	
 
	
	//Takes the screens shot
	public void takeScreenshot() {
		File scrnFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrnFile, new File(currentDir + "/screenshots" + formatTimeSDF() + ".png"));
		} catch (IOException e) {
			System.out.println("Exception in takeScreenshot method: " + e.getMessage());
		}
	}
		
		//take the screenshot with file name & time stamp
	public void takeScreenshot(String testName) {
		File scrnFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrnFile,
					new File(currentDir + "/screenshots/" + testName + "_" + formatTimeSDF() + ".png"));
		} catch (IOException e) {
			System.out.println("Exception in takeScreenshot method: " + e.getMessage());
		}
	}

	
	//Date & Time formate
	public static String formatTimeSDF() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
		
		
	}


