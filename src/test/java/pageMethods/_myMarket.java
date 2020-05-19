package pageMethods;  

import objRepository._myMarketPage;
import pageUtilities._actions;
import pageUtilities._browser;
import pageUtilities._wait;

public class _myMarket extends _myMarketPage {
	
	public _myMarket() {
		super();
	}
	
	public void addMarket() {
		_wait.inVisibleCss(loading, 60);
		
		try{
		Thread.sleep(10);
		} catch(Exception e){
			
		}
		
		_wait.clickable($addMarket, 30);
		_actions.click($addMarket);
		
	}
	
	public void gotoDashboard(int userStore) {
		_wait.inVisibleCss(loading, 30);
		_wait.clickable($addMarket, 20);
		_actions.click($dashboardLink(_browser.driver, userStore));
		_wait.inVisibleCss(loading, 30);
	}
	
}
