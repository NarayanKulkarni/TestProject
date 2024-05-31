package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

import DriverConfigs.driverSelection;

public class Approve_Review extends driverSelection {
	
	private WebDriver driver;
	
	@BeforeTest
	public void Browser() {
		driver= InitializerTheDriver();
		String url=getUrl("ApprovedURL");
		System.out.println(url);
		driver.get(url);
	}
	
	@Test
	public void ApproveReview() {
		driver.findElement(By.id("username")).sendKeys("user01");
		driver.findElement(By.id("login")).sendKeys("guru99com");
		driver.findElement(By.className("form-button")).click();
		
	}
	

	@AfterTest
	public void close() {
		if(driver!=null) {
			driver.close();
		}
	}
	
}
