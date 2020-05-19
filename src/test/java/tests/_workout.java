package tests;

import org.testng.annotations.*;

import pageMethods._dashboard;
import pageMethods._signIn;
import pageUtilities._browser;
import pageUtilities._dbConn;
import pageUtilities._propMgr;
import pageUtilities._testData;

public class _workout extends _browser {
	
		@Test
		@Parameters({"region"})
		public void login(@Optional("US") String region)  {
			_testData.setRegion(region);
			_propMgr.getInstance();
			_dbConn.getInstance();
			
			_signIn signIn = new _signIn();
			signIn.login();
			
			
//			_myMarket addMarket = new _myMarket();
//			addMarket.gotoDashboard();
			
			_dashboard dashboardValues = new _dashboard();
			dashboardValues.getAllValues();
			
		}
		
		@AfterTest
		public void tearDown() {
			
			System.out.println("Test AfterTest");
			try {
			_dbConn.con.close();
			} catch (Exception e) {
				System.out.println("Database Connection Close: "+e);
			}
		}
}
	
	
	

 