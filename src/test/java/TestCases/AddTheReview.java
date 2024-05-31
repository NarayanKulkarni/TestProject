package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import DriverConfigs.driverSelection;

public class AddTheReview extends driverSelection {

	private WebDriver driver;

	@BeforeTest
	public void Browser() {
		driver = InitializerTheDriver();
		 String url = getUrl("url"); 
		 System.out.println(url);
		 driver.get(url);
	}
	 @Test 
	 public void AddReview() { 
		 driver.findElement(By.xpath("//input[@id='Quality 1_4']")).click();
		 driver.findElement(By.id("review_field")).sendKeys("Test The review filel by ubuntu");
		 driver.findElement(By.id("summary_field")).sendKeys("Test The summery filel by ubuntu");
		 driver.findElement(By.id("nickname_field")).sendKeys("Intel-NVIDIA");
		 driver.findElement(By.xpath("//button[@class='button'][@title='Submit Review']")).click();
	  }
	 

	@AfterTest 
	public void close() { 
		if(driver!=null) { 
			driver.close();
			}
		}
}
