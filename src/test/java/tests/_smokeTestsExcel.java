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
import pageMethods._signUp;
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
		_excelUtils.getStore();
		
		if(_propMgr.getNewUser().equalsIgnoreCase("yes") && _propMgr.getUrl().contains("staging")) {
			_signUp signup = new _signUp();
			signup.singleMarket();
		} else {
			 _signIn signIn = new _signIn();
			signIn.login();
		}
	}  
	
	@Test(priority=1)
	public void addMarket() {
		
		test = _base.report.createTest("Login & Market Details");
		
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
	
	@Test(priority=3, dataProvider="unitName", dataProviderClass=_testData.class)
	public void verifyDetails(String unitName) {
		
		_dashboard dash = new _dashboard();
		dash.unitViewDetails(unitName);

		test = _base.report.createTest(unitName);
		System.out.println("View Details Started for unit: "+unitName);
		_currentPricingAnalysis cp = new _currentPricingAnalysis(unitName);
		cp.OverviewHeader();
		cp.AllMarketView();
		cp.currentAdvertisedRates();
		cp.backToDashboard();
		System.out.println("View Details Completed for unit: "+unitName);
		
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



