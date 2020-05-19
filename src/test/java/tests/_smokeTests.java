package tests;

import org.testng.annotations.*;

import pageMethods._addAddress;
import pageMethods._confirmMarket;
import pageMethods._coverageType;
import pageMethods._myMarket;
import pageMethods._reviewCoverage;
import pageMethods._signIn;
import pageUtilities._browser;
import pageUtilities._propMgr;
import pageUtilities._testData;

public class _smokeTests extends _browser {
	
	@BeforeTest
	@Parameters({"region"})
	public void login(@Optional("US") String region)  {
		_propMgr.getInstance();
		
		_signIn signIn = new _signIn();
		signIn.login();
	}
	
	@Test(priority=1)
	public void addMarket() {
		_myMarket addMarket = new _myMarket();
		addMarket.addMarket();
		
		_addAddress address = new _addAddress(); 
		address.addAddress("Database");
		
		_coverageType chooseCoverage = new _coverageType(); 
		chooseCoverage.radius();
		
		_reviewCoverage reviewCoverage = new _reviewCoverage();
		reviewCoverage.revCoverage();
		
		_confirmMarket cofirmMarket = new _confirmMarket();
		cofirmMarket.confirmMarket();
		
		System.out.println(_testData.storeName);
//		System.out.println(_testData.address);
		System.out.println(_testData.userStoreId);
	}
}
