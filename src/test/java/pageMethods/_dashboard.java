package pageMethods;  

import java.util.TreeSet;

import com.aventstack.extentreports.Status;

import objRepository._dashboardPage;
import pageUtilities._base;
import pageUtilities._dbConn;
import pageUtilities._queries;
import pageUtilities._wait;
import tests._testClass1;

public class _dashboard extends _dashboardPage {
	
	public _dashboard() {
		super();
		_base.logger = _base.report.createTest("Dashboard");
	}
	
	public void getAllValues() {
		
		_wait.inVisibleCss(loading, 60);
		_wait.clickable($preDefBox, 60);
		_base.logger.log(Status.INFO, "Verifying Dashboard Values Started");

		for(int i=1; i<=$preDefBoxCount.size(); i++) {
			TreeSet<Integer> rawdbValues = new TreeSet<>();
			String unitName = $unitName(_base.driver, i).getText();
			_base.logger.log(Status.INFO, unitName);
			
			/* Stores Offered */
			
			if(!unitName.equalsIgnoreCase("10x25")) {
				String uiStOff = stringHandling($unitStoresOffered(_base.driver, unitName).getText());
				if(!unitName.contains("RV"))
					rawdbValues = _dbConn.getValue(_queries.dashStoresOffered(unitName));
				else
					rawdbValues = _dbConn.getValue(_queries.dashStoresOfferedRV());
				String dbStOff = dbResult(rawdbValues);
				if(!uiStOff.equals(dbStOff)) {
					_base.logger.log(Status.FAIL, "Stores Offered: Site:"+uiStOff+" DB:"+dbStOff+" VALUE MISMATCH");
				} else {_base.logger.log(Status.PASS, "Stores Offered: Site:"+uiStOff+" DB:"+dbStOff);}
				
				
				/* Average Price */
				
 				String uiAvgPrice = stringHandling($unitAvgPrice(_base.driver, unitName).getText());
				if(!unitName.contains("RV"))
					rawdbValues = _dbConn.getValue(_queries.dashAvgPrice(unitName));
				else
					rawdbValues = _dbConn.getValue(_queries.dashAvgPriceRV());
				String dbAvgPrice = dbResult(rawdbValues);
				if(!uiAvgPrice.equals(dbAvgPrice)) {
					_base.logger.log(Status.FAIL, "Avg Price: Site:"+uiAvgPrice+" DB:"+dbAvgPrice+" VALUE MISMATCH");
				}else {_base.logger.log(Status.PASS, "Avg Price: Site:"+uiAvgPrice+" DB:"+dbAvgPrice);}
				
				
				/* Your Price */
				
				String uiYourPrice = stringHandling($unitYourPrice(_base.driver, unitName).getText());
				if(!unitName.contains("RV"))
					rawdbValues = _dbConn.getValue(_queries.dashYourPrice(unitName));
				else
					rawdbValues = _dbConn.getValue(_queries.dashYourPriceRV());
				String dbYourPrice = dbResult(rawdbValues);
				if(!uiYourPrice.equals(dbYourPrice)) {
					_base.logger.log(Status.FAIL, "Your Price: Site:"+uiYourPrice+" DB:"+dbYourPrice+" VALUE MISMATCH");
				}else {_base.logger.log(Status.PASS, "Your Price: Site:"+uiYourPrice+" DB:"+dbYourPrice);}
				_base.logger.log(Status.INFO, "---------------------------");
			}
		}
	}
	
	public String dbResult(TreeSet<Integer> dbValues) {
		
		TreeSet<Integer> set = new TreeSet<>(dbValues); 
		String value = null;
		int count = set.size();
		if(count==0) {
			value = "N/A";
		} else if(count==1) {
			value = String.valueOf(set.first());
		} else if(count>1){
			value = set.first()+" - "+set.last();
		} 
		
		if(count==1 && Integer.valueOf(value)==0) {
			value = "N/A";
		}
		
		return value;
	}
	
	
	public String stringHandling(String uiText) {
		return uiText.replace("Offered by ", "").replace(" stores", "").replace(" store", "").replace("A$", "")
				.replace("NZ$", "").replace("$", "").replace("£", "").replace("€", "");
	}
	
	
	
}
