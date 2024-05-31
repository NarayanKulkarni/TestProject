package DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTest {
	
	private WebDriver driver;
	
	
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	
	public void Login(String username1, String password1) throws InterruptedException {
		driver.get("https://demo.guru99.com/V1/index.php");
		driver.findElement(By.name("uid")).sendKeys(username1);
		driver.findElement(By.name("password")).sendKeys(password1);
		driver.findElement(By.name("btnLogin")).click();
		
		//String title = driver.getTitle();
		System.out.println(driver.getTitle());
		//System.out.println(UserNmae_Field);
		//System.out.println(Password_filed);
		Thread.sleep(5000);
		
	
	}

	
	public Object[][] LoginData() {
		Object [][] data = new Object[2][2];
		data[0][0] = "mngr558962";
		data[0][1] = "rUpuqeh";
		
		data[1][0] = "Admin";
		data[1][1] = "secret_sauce";
		
		return data;
		
	}
	
	//@AfterTest
	//public void logout() {
	//	driver.close();
	//}
	
}
