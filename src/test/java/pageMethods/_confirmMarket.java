package pageMethods	;  

import objRepository._confirmMarketPopup;
import pageUtilities._actions;
import pageUtilities._excelReader;
import pageUtilities._testData;
import pageUtilities._wait;

public class _confirmMarket extends _confirmMarketPopup {
	
	public _confirmMarket() {
		super();
	}
	
	public void confirmMarket() {
		
		/*	Step 4: Confirm Market  */  
		_excelReader.updateStoreId(_testData.storeId);
		
		_wait.visibleXpath(marketDashboard, 30);
		String userStoreId = $getUserStoreId.getAttribute("href");
		_testData.setUserStoreId(Integer.valueOf((userStoreId.substring(userStoreId.lastIndexOf("/")+1))));
		_actions.click($goToMyMarkets);
		
		System.out.println("Market Confirm Success");
		System.out.println("-------------------------");
		System.out.println("Store Details:");
		System.out.println(_testData.storeName);	
		System.out.println(_testData.address+", "+_testData.city+", "+_testData.state+", "+_testData.zipcode);
		System.out.println("Coverage: "+_testData.radius+" mile radius");
		System.out.println("UserStoreID: "+_testData.userStoreId);
		System.out.println("-------------------------");
	}
	
}
