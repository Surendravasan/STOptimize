package tests;

import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import pageMethods._addAddress;
import pageMethods._confirmMarket;
import pageMethods._coverageType;
import pageMethods._currentPricingAnalysis;
import pageMethods._dashboard;
import pageMethods._myMarket;
import pageMethods._reviewCoverage;
import pageMethods._signIn;
import pageUtilities._base;
import pageUtilities._databaseUtils;
import pageUtilities._excelUtils;
import pageUtilities._propMgr;
import pageUtilities._testData;
import pageUtilities._utils;

public class _smokeTestsExcel extends _base {
	
	public static ExtentTest test;
	
	@BeforeTest
	public void login()  {
		_propMgr.getInstance(); 
		_databaseUtils.getInstance();
		_excelUtils.openExcel();
		_excelUtils.getStore();
		
		_signIn signIn = new _signIn();
		signIn.login();
	}  
	
	@Test(priority=1)
	public void addMarket() {
		
		test = _base.report.createTest("Add Market");
		_myMarket addMarket = new _myMarket();
		addMarket.addMarket();
		
		_addAddress address = new _addAddress(); 
		address.addAddress("Excel");
		
		_coverageType chooseCoverage = new _coverageType(); 
		chooseCoverage.radius(_testData.radius);
		
		_reviewCoverage reviewCoverage = new _reviewCoverage();
		reviewCoverage.revCoverage();
		 
		_confirmMarket cofirmMarket = new _confirmMarket();
		cofirmMarket.confirmMarket();
	}
	
	@Test(priority=2)
	public void verifyDashboard() {
		
		test = _base.report.createTest("Dashboard");
		
		_myMarket gotoDash = new _myMarket();
		gotoDash.gotoDashboard(_testData.userStoreId);
		
		_dashboard dash = new _dashboard();
		dash.getAllValues();
	}
	
	@Test(priority=3, dataProvider="unitName", dependsOnMethods={"verifyDashboard"})
	public void verifyDetails(String unitName) {
		
		_dashboard dash = new _dashboard();
		dash.unitViewDetails(unitName);
		
		test = _base.report.createTest(unitName);
		_currentPricingAnalysis cp = new _currentPricingAnalysis(unitName);
		cp.OverviewHeader();
		cp.AllMarketView(); 
		cp.backToDashboard();
		
	}
	
	@DataProvider(name="unitName")
	public Object[][] unitName() {
		Object unitNames[][] = null;
		switch(_testData.regId) {
		case 1:
			if(!_dashboard.getUnitName.contains("m²"))
			{
//				unitNames = new Object[][] {{"5x10 CC"}};
				unitNames = new Object[][] {
					{"5x5 Reg"}, {"5x5 CC"}, {"5x10 Reg"}, {"5x10 CC"}, 
					{"10x10 Reg"}, {"10x10 CC"}, {"10x15"}, {"10x20"}, 
					{"10x30"}, {"Car Parking"}, {"RV Parking"}};
			} else {
				unitNames = new Object[][] {
					{"1m²"}, {"2m²"}, {"3m²"}, {"4m²"},	{"5m²"}, 
					{"6m²"}, {"7m²"}, {"8m²"}, {"9m²"}, {"10m²"}};
			}
			break;
			
		case 2:
			unitNames = new Object[][] {
				{"3mx3m"}, {"1.5mx1.5m"}, {"3mx6m"}, {"1.5mx3m"}, 
				{"1mx1m"}, {"3mx4.5m"}, {"1.5mx2m"}, {"2mx3m"}, 
				{"3mx4m"}, {"3mx5m"}};
				break;
				
		case 3:
			unitNames = new Object[][] {
				{"20 sq.ft"}, {"25 sq.ft"}, {"35 sq.ft"}, {"40 sq.ft"}, 
				{"50 sq.ft"}, {"80 sq.ft"}, {"100 sq.ft"}, {"150 sq.ft"}, 
				{"160 sq.ft"}, {"200 sq.ft"}};
				break;
				
		case 4:
			unitNames = new Object[][] {
				{"1mx1m"}, {"2mx1m"}, {"2mx1.5m"}, {"2mx2m"}, 
				{"3mx1.5m"}, {"3mx2m"}, {"3mx3m"}, {"4mx3m"}, 
				{"5mx3m"}, {"6mx3m"}};
				break;
				
		}
		return unitNames;
	}
	
	
	@AfterMethod
	public void createLog(ITestResult result) throws IOException {
		
		if(result.getStatus() == ITestResult.SUCCESS){
//        	test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        } 
		else if(result.getStatus() == ITestResult.FAILURE) {
			String screenShotpath = _utils.screenCapture(_base.driver);
        	test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
        	test.fail(result.getThrowable());
        	test.log(Status.FAIL, "Screen Shot below: "+test.addScreenCaptureFromPath(screenShotpath));
        } 
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
		_base.report.flush();
	}
	
	
	
	@AfterTest
	public void closeInstance() {
		if(_databaseUtils.st!=null){
			try{
				_databaseUtils.st.close();
			} catch (Exception e) {}
		}
		
		if(_databaseUtils.con!=null){
			try{
				_databaseUtils.con.close();
			} catch (Exception e) {}
		}
		
		if(_excelUtils.fis!=null){
			try{
				_excelUtils.fis.close();
			} catch (Exception e) {}
		}
		
		if(_excelUtils.fos!=null){
			try{
				_excelUtils.fos.close();
			} catch (Exception e) {}
		}
		
		if(_excelUtils.wb!=null){
			try{
				_excelUtils.wb.close();
			} catch (Exception e) {}
		}
		_base.driver.quit();
	}
}



