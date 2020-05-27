package pageMethods	;  

import com.aventstack.extentreports.Status;

import objRepository._confirmMarketPopup;
import pageUtilities._actions;
import pageUtilities._base;
import pageUtilities._excelReader;
import pageUtilities._testData;
import pageUtilities._wait;

public class _confirmMarket extends _confirmMarketPopup {
	
	public _confirmMarket() {
		super();
		_base.logger = _base.report.createTest("Store Details");
	}
	
	public void confirmMarket() {
		
		/*	Step 4: Confirm Market  */  
		_excelReader.updateStoreId(_testData.storeId);
		
		_wait.visibleXpath(marketDashboard, 30);
		String userStoreId = $getUserStoreId.getAttribute("href");
		_testData.setUserStoreId(Integer.valueOf((userStoreId.substring(userStoreId.lastIndexOf("/")+1))));
		_actions.click($goToMyMarkets);
		
//		System.out.println("Market Confirm Success");
//		System.out.println("-------------------------");
//		_base.logger.log(Status.INFO, "Store Details:");
		_base.logger.log(Status.INFO, _testData.storeName);	
		_base.logger.log(Status.INFO, _testData.address+", "+_testData.city+", "+_testData.state+" "+_testData.zipcode);
		_base.logger.log(Status.INFO, "Coverage: "+_testData.radius+" mile radius");
		_base.logger.log(Status.INFO, "UserStoreID: "+_testData.userStoreId);
//		System.out.println("-------------------------");
	}
	
}
