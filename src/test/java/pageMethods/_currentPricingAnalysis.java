package pageMethods;  

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.TreeSet;
import org.openqa.selenium.By;
import objRepository._currentPricingAnalysisPage;
import pageUtilities._base;
import pageUtilities._dbConn;
import pageUtilities._queries;
import pageUtilities._testData;
import pageUtilities._wait;
import tests._testClass1;

public class _currentPricingAnalysis extends _currentPricingAnalysisPage {
	
	public _currentPricingAnalysis() {
		super();
	}
	
	String unitName;
	
	public void OverviewHeader() {
		
		_wait.inVisibleCss(loading, 60);
		
		unitName = $unitName.getText();
		
		
		/* Current Lowest Price */
		
		String uiCurLowestPrice = stringHandling($curLowestPrice.getText());
		String dbCurLowestPrice = null;
		if(!unitName.contains("RV")){
			dbCurLowestPrice = _dbConn.getStringValue(_queries.curLowestPrice(unitName));
		} else {
			dbCurLowestPrice = _dbConn.getStringValue(_queries.curLowestPriceRV());
		}
		compareUiDbValues("Current Lowest Price", uiCurLowestPrice, dbCurLowestPrice);
		
		
		/* Current Average Price */
		
		String uiCurAvgPrice = stringHandling($curAveragePrice.getText());
		String dbCurAvgPrice = null;
		if(!unitName.contains("RV")){
			dbCurAvgPrice = _dbConn.getStringValue(_queries.curAvgPrice(unitName));
		} else {
			dbCurAvgPrice = _dbConn.getStringValue(_queries.curAvgPriceRV());
		}
		compareUiDbValues("Current Average Price", uiCurAvgPrice, dbCurAvgPrice);
		
		
		/* Current Highest Price */
		
		String uiCurHighestPrice = stringHandling($curHighestPrice.getText());
		String dbCurHighestPrice = null;
		if(!unitName.contains("RV")){
			dbCurHighestPrice = _dbConn.getStringValue(_queries.curHighPrice(unitName));
		} else {
			dbCurHighestPrice = _dbConn.getStringValue(_queries.curHighPriceRV());
		}
		compareUiDbValues("Current Highest Price", uiCurHighestPrice, dbCurHighestPrice);
		
	}
	
	
	public void AllMarketView() {
		
//		table[class*='market-table'] - is visible
		
//		//span[text()='2027 83rd St, North Bergen, NJ 07047']/ancestor::tr/td[2]
		int rowCount = _base.driver.findElements(By.xpath("//table[contains(@class,'market-table')]/tbody/tr")).size();
		int colCount = _base.driver.findElements(By.xpath("//table[contains(@class,'market-table')]/tbody/tr[1]/td")).size();
		
		for(int i=1; i<=rowCount; i++) {
			String storeName = _base.driver.findElement(By.xpath("//table[contains(@class,'market-table')]/tbody/tr["+i+"]/td[1]/span[1]")).getText();
			String address = _base.driver.findElement(By.xpath("//table[contains(@class,'market-table')]/tbody/tr["+i+"]/td[1]/span[2]")).getText();
			System.out.println(storeName);
			System.out.println(address);
			String header = null;
			int storeId;
			if(!address.isEmpty()){
				storeId = _dbConn.getIntValue(_queries.storeIdFromAddress(address));
			} else {
				storeId = _testData.storeId;
				
			}
			
			System.out.println(storeId);
			System.out.println("--------------------------------------------");
			
				for(int j=2; j<=colCount-1; j++) {
					String uiValue = null;
					String dbValue = null;
					if(j!=6) {
						uiValue = stringHandling(_base.driver.findElement(By.xpath("//table[contains(@class,'market-table')]/tbody/tr["+i+"]/td["+j+"]")).getText());
					}
					
					switch(j) {
					
					case 2:
						dbValue = _dbConn.getStringValue(_queries.currentPremium(storeId, unitName)); //to add for RV
						header = "Current Premium";
						break;
						
					case 3:
						dbValue = _dbConn.getStringValue(_queries.currentValue(storeId, unitName)); //to add for RV
						header = "Current Value";
						break;
						
					case 4:
						dbValue = _dbConn.getStringValue(_queries.highestPremium(storeId, unitName)); //to add for RV
						header = "Highest Premium";
						break;
						
					case 5:
						dbValue = _dbConn.getStringValue(_queries.lowestValue(storeId, unitName)); //to add for RV
						header = "Lowest Value";
						break;
						
					case 6:
						uiValue = _base.driver.findElement(By.xpath("//table[contains(@class,'market-table')]/tbody/tr["+i+"]/td["+j+"]")).getText();
						dbValue = _dbConn.getStringValue(_queries.promotions(storeId, unitName)); //to add for RV
						header = "Promotions";
						break;
						
					case 7:
						dbValue = _dbConn.getStringValue(_queries.walkinPremium(storeId, unitName)); //to add for RV
						header = "Current Walk-in Premium";
						break;
						
					case 8:
						dbValue = _dbConn.getStringValue(_queries.walkinValue(storeId, unitName)); //to add for RV
						header = "Current Walk-in Value";
						break;
				}
					compareUiDbValues(header, uiValue, dbValue);
				}
				System.out.println("--------------------------------------------");
		}
	} 
	
	/* This method is to separate UI text and additional information like currency and other text */
	
	public String stringHandling(String uiText) {
		return uiText.replace("Offered by ", "").replace(" stores", "").replace(" store", "").replace("A$", "")
				.replace("NZ$", "").replace("$", "").replace("£", "").replace("€", "");
	}
	
	
	
	/* Common method to compare UI & DB values*/
	/* As need to check floating values, condition is checked to get UI values.
	 * If UI value is not N/A then get text as Floating value & if N/A assign floating value  */
	
	private void compareUiDbValues(String header, String uiText, String rawDbValue) {
		
		if((!uiText.equals("N/A") && !header.contains("Promotions"))) {
			BigDecimal number = new BigDecimal(uiText);  
			uiText = number.stripTrailingZeros().toPlainString();
		}
		
		String dbValue = (rawDbValue==null || uiText==("0")) ? "N/A" : ((rawDbValue.endsWith(".0")) ? rawDbValue.replace(".0", "") : rawDbValue.substring(0));
		if(uiText.equals(dbValue)) {
			System.out.println(header+" - Site:"+uiText+" DB:"+dbValue);
		} else {
			System.out.println(header+" - Site:"+uiText+" DB:"+dbValue+" VALUE MISMATCH");
		}
	}
	
	
	
}
