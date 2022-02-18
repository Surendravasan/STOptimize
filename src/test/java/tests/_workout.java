 package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class _workout {
	
	WebDriver driver;
	
	
	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {
//	public void setup() {
		
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
		
//		System.setProperty("webdriver.ie.driver", "C:\\Surey\\Automation\\IEDriver\\IEDriverServer.exe");
//		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void test1() {
		driver.get("https://sabarimalaonline.org/#/login");
		
		driver.findElement(By.id("email")).sendKeys("9994642235");
		driver.findElement(By.id("password")).sendKeys("Sindhu@89");
		driver.findElement(By.id("regi_continue")).click();
		
		
		waitForElementInVisibleByLocator(By.id("loader"));
		
		waitForElementVisibleByLocator(By.cssSelector("button.btn.btn-clear-pop "));
		
		waitForElementInVisibleByLocator(By.id("loader"));
		
		driver.findElement(By.xpath("//button[text()=' Ok ']")).click();
		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				

		
		int i=0;
		do {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			waitForElementInVisibleByLocator(By.id("loader"));
			
			waitForElementVisibleByLocator(By.xpath("//div[@class='col-sm-12 heading_tag_dar']/span[contains(text(),' 180 minutes')]"));
			
			
//			int k = 0;
//			do {
				waitForElementVisibleByLocator(By.cssSelector("button.mat-icon-button"));
				clickJs(driver.findElement(By.cssSelector("button.mat-icon-button")));
				
//				int nov[] = {23};
//				for(int date: nov) {
//					String className = driver.findElement(By.xpath("//tbody//td[(@role='gridcell') and (contains(@aria-label, '"+date+" 2020'))]")).getAttribute("class");
//					if(className.contains("example-custom-date-class")) {
//						k=1;
//						break;
//					} else {
//						waitForElementVisibleByLocator(By.cssSelector("div.date-msg"));
//						clickJs(driver.findElement(By.cssSelector("div.date-msg")));
//						Actions action = new Actions(driver);
//						action.moveToElement(driver.findElement(By.cssSelector("div.date-msg"))).click().perform();
//					}
//				}
//			} while (k==0);
			
			clickJs(driver.findElement(By.cssSelector("button[aria-label='Next month']")));
			
			
//			int a[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
			int a[] = {27,28,29,30};
			for(int date: a) {
				String className = driver.findElement(By.xpath("//tbody//td[(@role='gridcell') and (contains(@aria-label, '"+date+" 2020'))]")).getAttribute("class");
				if(!className.contains("disabled")) {
					clickJs(driver.findElement(By.xpath("//tbody//td[(@role='gridcell') and (contains(@aria-label, '"+date+" 2020'))]")));
					
					waitForElementInVisibleByLocator(By.id("loader"));
					
					int size = driver.findElements(By.xpath("//div[@id='myName_0']")).size();
					
					if(size!=0) {
						book(8);
					} else {
						System.out.println("No availability");
						
						clickJs(driver.findElement(By.cssSelector("button.mat-icon-button")));
						
						break;
					}
				}
			}
			
			
			clickJs(driver.findElement(By.cssSelector("button[aria-label='Next month']")));
			
			int b[] = {14,15,16};
//			int b[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
			for(int date: b) {
				String className = driver.findElement(By.xpath("//tbody//td[(@role='gridcell') and (contains(@aria-label, '"+date+" 2021'))]")).getAttribute("class");
				if(!className.contains("disabled")) {
					clickJs(driver.findElement(By.xpath("//tbody//td[(@role='gridcell') and (contains(@aria-label, '"+date+" 2021'))]")));
					
					int size = driver.findElements(By.xpath("//div[@id='myName_0']")).size();
					
					if(size!=0) {
//						if(date==15) {
							book(12);
//						} else {
//							book(7);
//						}
					} else {
						System.out.println("No availability");
						break;
					}
				}
			}
			
			driver.navigate().refresh();
			
		} while (i==0);
		
		clickJs(driver.findElement(By.cssSelector("button[aria-label='Next month']")));
		
	}
	
	
		void book(int pilgrim) {
			
			clickJs(driver.findElement(By.xpath("//button[text()=' Select Pilgrim ']")));
			
			waitForElementVisibleByLocator(By.xpath("(//label[@class='mat-checkbox-layout'])["+pilgrim+"]/div/input"));
			
			clickJs(driver.findElement(By.xpath("(//label[@class='mat-checkbox-layout'])["+pilgrim+"]/div")));
			
			clickJs(driver.findElement(By.xpath("//button[text()=' Submit ']")));
			System.out.println("Pilgrim Selected");
			
			clickJs(driver.findElement(By.xpath("//div[@id='myName_0']")));
			
			clickJs(driver.findElement(By.xpath("//button[text()=' OK ']")));
			
			waitForElementVisibleByLocator(By.xpath("//button[text()=' Add to Wishlist ']"));
					
			clickJs(driver.findElement(By.xpath("//button[text()=' Add to Wishlist ']")));
			System.out.println("Add to Wishlist");
			waitForElementVisibleByLocator(By.xpath("//button[text()=' Proceed ']"));
			
			clickJs(driver.findElement(By.xpath("//button[text()=' Proceed ']")));
			System.out.println("Added Wishlist");
			waitForElementVisibleByLocator(By.xpath("//button[text()=' Proceed ']"));
			clickJs(driver.findElement(By.xpath("//button[text()=' Proceed ']")));
			
			waitForElementVisibleByLocator(By.xpath("//button[text()=' Proceed ']"));
			clickJs(driver.findElement(By.xpath("//button[text()=' Proceed ']")));
			System.out.println("Booked");
	}
		
		
		public void clickJs(WebElement ele) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
		}
	
		public void waitForElementInVisibleByLocator(By by) {
			WebDriverWait wait = new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		}
		
		public void waitForElementVisibleByLocator(By by) {
			WebDriverWait wait = new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
	
	
		@AfterTest
		public void tearDown() {
			driver.close();
		}
}
