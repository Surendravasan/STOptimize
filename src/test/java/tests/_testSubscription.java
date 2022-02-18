package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _testSubscription {
	
WebDriver driver;
	
	
	@BeforeTest
	public void open_browser() {
		
		String browserName = "chrome";
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Surey\\Automation\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", "C:\\Surey\\Automation\\OperaDriver\\operadriver.exe");
			driver = new OperaDriver();
		} else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Surey\\Automation\\IEDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Surey\\Automation\\EdgeDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
		} 
		
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void test1() {
		driver.get("https://www.youtube.com/");
		
//		driver.findElement(By.cssSelector("#buttons #button[aria-label='Sign in']")).click();
//		driver.findElement(By.id("identifierId")).sendKeys("suray.it@gmail.com");
//		driver.findElement(By.cssSelector("#identifierId button")).click();
//		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("mnsbnrmnv974222");
		
	}
}