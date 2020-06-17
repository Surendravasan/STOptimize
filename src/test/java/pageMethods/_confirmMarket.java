package pageMethods	;  

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import objRepository._confirmMarketPopup;
import pageUtilities._excelUtils;
import pageUtilities._propMgr;
import pageUtilities._testData;
import pageUtilities._utils;
import tests._smokeTestsExcel;

public class _confirmMarket extends _confirmMarketPopup {
	
	ExtentTest test = _smokeTestsExcel.test;;
	
	public _confirmMarket() {
		super();
//		test = _base.report.createTest("Store Details");
	}
	
	public void confirmMarket() {
		
		/*	Step 4: Confirm Market  */  
		_excelUtils.updateStoreId(_testData.storeId);
		
		_utils.waitForElementVisibleByLocator($marketDashboard);
		String userStoreId = $getUserStoreId.getAttribute("href");
		_testData.setUserStoreId(Integer.valueOf((userStoreId.substring(userStoreId.lastIndexOf("/")+1))));
		_utils.submit($goToMyMarkets);
		
//		System.out.println("Market Confirm Success");
//		System.out.println("-------------------------");
//		_base.logger.log(Status.INFO, "Store Details:");
		if(_propMgr.getNewUser().equalsIgnoreCase("yes")) {
			test.log(Status.INFO, _signUp.loginEmail);
		} else {
			test.log(Status.INFO, _propMgr.getUsername());
		}
		test.log(Status.INFO, _testData.storeName);	
		test.log(Status.INFO, _testData.address+", "+_testData.city+", "+_testData.state+" "+_testData.zipcode);
		test.log(Status.INFO, "Coverage: "+_testData.radius+" mile radius");
		test.log(Status.INFO, "UserStoreID: "+_testData.userStoreId);
//		System.out.println("-------------------------");
	}
	
}
