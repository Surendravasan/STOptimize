 package tests;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import pageMethods._currentPricingAnalysis;
import pageMethods._myMarket;
import pageMethods._signIn;
import pageUtilities._base;
import pageUtilities._dbConn;
import pageUtilities._excelReader;
import pageUtilities._propMgr;
import pageUtilities._wait;


public class _workout extends _base {
	
	
	@BeforeTest
	public void login()  {
		_propMgr.getInstance();
		_dbConn.getInstance();
		
		_signIn signIn = new _signIn();
		signIn.login();
	}   
	
	@Test
	public void dashboard() {
		
		_myMarket obj1 = new _myMarket();
		obj1.gotoDashboard(146019);
		
//		_wait.inVisibleCss("div.loading", 60);
//		
//		WebDriverWait wait = new WebDriverWait(_base.driver, 60);
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class*='add']")));
//		
//		
//		_myMarket my = new _myMarket();
//		my.gotoDashboard(_testData.userStoreId);
		
		_base.driver.findElement(By.xpath("//span[text()='5x5 Reg']//ancestor::div[@class='drag-view']//div[@class='view-Details']//a")).click();
		_wait.inVisibleCss("div.loading", 60);
		
		_currentPricingAnalysis cp = new _currentPricingAnalysis();
		cp.OverviewHeader();
		
		cp.AllMarketView();
		
		
	}
	
//	@AfterTest
	public void closeInstance() {
		if(_dbConn.st!=null){
			try{
				_dbConn.st.close();
			} catch (Exception e) {}
		}
		
		if(_dbConn.con!=null){
			try{
				_dbConn.con.close();
			} catch (Exception e) {}
		}
		
		if(_excelReader.fis!=null){
			try{
				_excelReader.fis.close();
			} catch (Exception e) {}
		}
		
		if(_excelReader.fos!=null){
			try{
				_excelReader.fos.close();
			} catch (Exception e) {}
		}
		
		if(_excelReader.wb!=null){
			try{
				_excelReader.wb.close();
			} catch (Exception e) {}
		}
		
	}
	
}
	
	
	

 