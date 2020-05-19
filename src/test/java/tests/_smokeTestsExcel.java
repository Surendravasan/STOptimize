package tests;

import org.testng.annotations.*;

import pageMethods._addAddress;
import pageMethods._confirmMarket;
import pageMethods._coverageType;
import pageMethods._dashboard;
import pageMethods._myMarket;
import pageMethods._reviewCoverage;
import pageMethods._signIn;
import pageUtilities._browser;
import pageUtilities._dbConn;
import pageUtilities._excelReader;
import pageUtilities._propMgr;
import pageUtilities._testData;

public class _smokeTestsExcel extends _browser {
	
	@BeforeTest
	public void login()  {
		_propMgr.getInstance();
		_dbConn.getInstance();
		_excelReader.openExcel();
		_excelReader.getStore();
		
		_signIn signIn = new _signIn();
		signIn.login();
	}  
	
	@Test(priority=1)
	public void addMarket() {
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
	
	@Test(priority=2, dependsOnMethods={"addMarket"})
	public void verifyDashboard() {
		_myMarket gotoDash = new _myMarket();
		gotoDash.gotoDashboard(_testData.userStoreId);
		
		_dashboard dash = new _dashboard();
		dash.getAllValues();
	}
	
	@AfterTest
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



