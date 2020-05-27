package pageMethods;  

import java.util.concurrent.TimeUnit;

import objRepository._myMarketPage;
import pageUtilities._actions;
import pageUtilities._base;
import pageUtilities._dateTime;
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
		
		_wait.clickable($addMarket, 60);
		_actions.click($addMarket);
		
	}
	
	public void gotoDashboard(int userStore) {
		_base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		_wait.inVisibleCss(loading, 60);
		_wait.visibleCss($marketsTable, 60);
		_actions.click($dashboardLink(_base.driver, userStore));
		_wait.inVisibleCss(loading, 60);
	}
	
}
