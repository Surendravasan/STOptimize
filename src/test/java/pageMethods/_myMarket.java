package pageMethods;  

import objRepository._myMarketPage;
import pageUtilities._base;
import pageUtilities._utils;

public class _myMarket extends _myMarketPage {
	
	public _myMarket() {
		super();
		_utils.waitForElementInVisibleByLocator(loader);
		_utils.waitForElementVisibleByLocator($addMarketLabel);
		_utils.waitForElementVisibleByLocator($tableData);
		_utils.waitForElementInVisibleByLocator(loader);
	}
	
	public void addMarket() {
		_utils.submit($addMarketBtn);
	}
	
	public void gotoDashboard(int userStore) {
		_utils.submit($dashboardLink(_base.driver, userStore));
		_utils.waitForElementInVisibleByLocator(loader);
	}
	
}
