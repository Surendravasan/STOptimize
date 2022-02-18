 package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageUtilities._base;
import pageUtilities._utils;


public class _testClass extends _base {
	
	@Test
	public void test1() {
		_base.driver.get("https://sabarimalaonline.org/#/login");
		
		_base.driver.findElement(By.id("email")).sendKeys("9994642235");
		_base.driver.findElement(By.id("password")).sendKeys("Sindhu@89");
		_base.driver.findElement(By.id("regi_continue")).click();
		
		_utils.waitForElementInVisibleByLocator(By.id("loader"));
		
		_utils.waitForElementVisibleByLocator(By.cssSelector("button.btn.btn-clear-pop "));
		
		_utils.waitForElementInVisibleByLocator(By.id("loader"));
		
		_base.driver.findElement(By.xpath("//button[text()=' Ok ']")).click();
		
		_base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				

		
		int i=0;
		do {
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			_base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			_utils.waitForElementInVisibleByLocator(By.id("loader"));
			
			_utils.waitForElementVisibleByLocator(By.xpath("//div[@class='col-sm-12 heading_tag_dar']/span[contains(text(),' 180 minutes')]"));
			
			
//			int k = 0;
//			do {
				_utils.waitForElementVisibleByLocator(By.cssSelector("button.mat-icon-button"));
				_utils.clickJs(_base.driver.findElement(By.cssSelector("button.mat-icon-button")));
				
//				int nov[] = {23};
//				for(int date: nov) {
//					String className = _base.driver.findElement(By.xpath("//tbody//td[(@role='gridcell') and (contains(@aria-label, '"+date+" 2020'))]")).getAttribute("class");
//					if(className.contains("example-custom-date-class")) {
//						k=1;
//						break;
//					} else {
//						_utils.waitForElementVisibleByLocator(By.cssSelector("div.date-msg"));
//						_utils.clickJs(_base.driver.findElement(By.cssSelector("div.date-msg")));
//						Actions action = new Actions(_base.driver);
//						action.moveToElement(_base.driver.findElement(By.cssSelector("div.date-msg"))).click().perform();
//					}
//				}
//			} while (k==0);
			
//			_utils.clickJs(_base.driver.findElement(By.cssSelector("button[aria-label='Next month']")));
			
			//DECEMBER
			
//			int a[] = {24,25};
//			int a[] = {29};
//			for(int date: a) {
//				String className = _base.driver.findElement(By.xpath("//tbody//td[(@role='gridcell') and (contains(@aria-label, '"+date+" 2020'))]")).getAttribute("class");
//				
//				if(!className.contains("disabled")) {
//					System.out.println(date);
//					_utils.clickJs(_base.driver.findElement(By.xpath("//tbody//td[(@role='gridcell') and (contains(@aria-label, '"+date+" 2020'))]")));
//					
//					_utils.waitForElementInVisibleByLocator(By.id("loader"));
//					
//					int size = _base.driver.findElements(By.xpath("//div[@id='myName_0']")).size();
//					
//					if(size!=0) {
//						book(44);
//					} else {
//						System.out.println("No availability");
//						
//						_utils.clickJs(_base.driver.findElement(By.cssSelector("button.mat-icon-button")));
//						
//						break;
//					}
//				}
//			}
			
			
			//JANUARY
			
//			_utils.clickJs(_base.driver.findElement(By.cssSelector("button[aria-label='Next month']")));
			
			int b[] = {14,15,16};
//			int b[] = {3,15,16,1,2,4,5,6,7,8,9,10,11,12,13,14,17,18,19};
			for(int date: b) {
				String className = _base.driver.findElement(By.xpath("//tbody//td[(@role='gridcell') and (contains(@aria-label, '"+date+" 2021'))]")).getAttribute("class");
				
				if(!className.contains("disabled")) {
					System.out.println(date);
					_utils.clickJs(_base.driver.findElement(By.xpath("//tbody//td[(@role='gridcell') and (contains(@aria-label, '"+date+" 2021'))]")));
					
					int size = _base.driver.findElements(By.xpath("//div[@id='myName_0']")).size();
					
					if(size!=0) {
						book(42);
					} else {
						System.out.println("No availability");
						break;
					}
				}
			}
			
			_base.driver.navigate().refresh();
			
		} while (i==0);
		
		_utils.clickJs(_base.driver.findElement(By.cssSelector("button[aria-label='Next month']")));
		
	}
	
	
	void book(int pilgrim) {
			
			_utils.clickJs(_base.driver.findElement(By.xpath("//button[text()=' Select Pilgrim ']")));
			
			_utils.waitForElementVisibleByLocator(By.xpath("(//label[@class='mat-checkbox-layout'])["+pilgrim+"]/div/input"));
			
			_utils.clickJs(_base.driver.findElement(By.xpath("(//label[@class='mat-checkbox-layout'])["+pilgrim+"]/div")));
			
			_utils.clickJs(_base.driver.findElement(By.xpath("//button[text()=' Submit ']")));
			System.out.println("Pilgrim Selected");
			
			_utils.clickJs(_base.driver.findElement(By.xpath("//div[@id='myName_0']")));
			
//			_utils.clickJs(_base.driver.findElement(By.xpath("//button[text()=' OK ']")));
			
			_utils.waitForElementVisibleByLocator(By.xpath("//button[text()=' Add to Wishlist ']"));
					
			_utils.clickJs(_base.driver.findElement(By.xpath("//button[text()=' Add to Wishlist ']")));
			System.out.println("Add to Wishlist");
			_utils.waitForElementVisibleByLocator(By.xpath("//button[text()=' Proceed ']"));
			
			_utils.clickJs(_base.driver.findElement(By.xpath("//button[text()=' Proceed ']")));
			System.out.println("Added Wishlist");
			_utils.waitForElementVisibleByLocator(By.xpath("//button[text()=' Proceed ']"));
			_utils.clickJs(_base.driver.findElement(By.xpath("//button[text()=' Proceed ']")));
			
			_utils.waitForElementVisibleByLocator(By.xpath("//button[text()=' Proceed ']"));
			_utils.clickJs(_base.driver.findElement(By.xpath("//button[text()=' Proceed ']")));
			_base.driver.findElement(By.xpath("//button[text()=' Proceed ']")).click();
 			System.out.println("Booked");
	}
}
	
	
 

