package pageMethods;  

import java.util.TreeSet;
import objRepository._dashboardPage;
import pageUtilities._browser;
import pageUtilities._dbConn;
import pageUtilities._queries;
import pageUtilities._wait;

public class _dashboard extends _dashboardPage {
	
	public _dashboard() {
		super();
	}
	
	public void getAllValues() {
		
		_wait.inVisibleCss(loading, 60);
		_wait.clickable($preDefBox, 60);
		System.out.println("Verifying Dashboard Values Started");

		for(int i=1; i<=$preDefBoxCount.size(); i++) {
			TreeSet<Integer> rawdbValues = new TreeSet<Integer>();
			String unitName = $unitName(_browser.driver, i).getText();
			System.out.println(unitName);
			
			if(!unitName.equalsIgnoreCase("10x25")) {
				String uiStOff = stringHandling($unitStoresOffered(_browser.driver, unitName).getText());
				if(!unitName.contains("RV"))
					rawdbValues = _dbConn.getValue(_queries.dashStoresOffered(unitName));
				else
					rawdbValues = _dbConn.getValue(_queries.dashStoresOfferedRV());
				String dbStOff = dbResult(rawdbValues);
				if(!uiStOff.equals(dbStOff)) {
					System.out.println("Stores Offered: Site:"+uiStOff+" DB:"+dbStOff+" VALUE MISMATCH");
				} else {System.out.println("Stores Offered: Site:"+uiStOff+" DB:"+dbStOff);}
				
 				String uiAvgPrice = stringHandling($unitAvgPrice(_browser.driver, unitName).getText());
				if(!unitName.contains("RV"))
					rawdbValues = _dbConn.getValue(_queries.dashAvgPrice(unitName));
				else
					rawdbValues = _dbConn.getValue(_queries.dashAvgPriceRV());
				String dbAvgPrice = dbResult(rawdbValues);
				if(!uiAvgPrice.equals(dbAvgPrice)) {
					System.out.println("Avg Price: Site:"+uiAvgPrice+" DB:"+dbAvgPrice+" VALUE MISMATCH");
				}else {System.out.println("Avg Price: Site:"+uiAvgPrice+" DB:"+dbAvgPrice);}
				
				String uiYourPrice = stringHandling($unitYourPrice(_browser.driver, unitName).getText());
				if(!unitName.contains("RV"))
					rawdbValues = _dbConn.getValue(_queries.dashYourPrice(unitName));
				else
					rawdbValues = _dbConn.getValue(_queries.dashYourPriceRV());
				String dbYourPrice = dbResult(rawdbValues);
				if(!uiYourPrice.equals(dbYourPrice)) {
					System.out.println("Your Price: Site:"+uiYourPrice+" DB:"+dbYourPrice+" VALUE MISMATCH");
				}else {System.out.println("Your Price: Site:"+uiYourPrice+" DB:"+dbYourPrice);}
				System.out.println("----------");
			}
		}
	}
	
	public String dbResult(TreeSet<Integer> dbValues) {
		
		TreeSet<Integer> set = new TreeSet<Integer>(dbValues); 
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
