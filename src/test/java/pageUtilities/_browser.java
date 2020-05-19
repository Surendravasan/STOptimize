package pageUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class _browser {
	
	public static WebDriver driver;
	
	
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Surey\\Automation\\ChromeDriver\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
	}
	
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
			

}
