package pageMethods;  

import java.math.BigDecimal;

import org.jsoup.Jsoup;
import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import objRepository._currentPricingAnalysisPage;
import pageUtilities._base;
import pageUtilities._databaseUtils;
import pageUtilities._queries;
import pageUtilities._testData;
import pageUtilities._utils;
import tests._smokeTestsExcel;

public class _currentPricingAnalysis extends _currentPricingAnalysisPage {
	
	
	public String unitName;
	ExtentTest test = _smokeTestsExcel.test;
	ExtentTest node;
	
	
	public _currentPricingAnalysis(String unitName) {
		super();
		_utils.waitForElementInVisibleByLocator(loader);
		node = test.createNode("Current Pricing Analysis");
		this.unitName = $unitName.getText();
	}
	
	
	public void OverviewHeader() {
		
		_utils.waitForElementInVisibleByLocator(loader);
//		unitName = $unitName.getText();
		node = node.createNode("Overview Header");
		
		
		/* Current Lowest Price */
		
		String uiCurLowestPrice = stringHandling($curLowestPrice.getText());
		String dbCurLowestPrice = null;
		if(!unitName.contains("RV")){
			dbCurLowestPrice = _databaseUtils.getStringValue(_queries.curLowestPrice(unitName));
		} else {
			dbCurLowestPrice = _databaseUtils.getStringValue(_queries.curLowestPriceRV());
		}
		compareUiDbValues("Current Lowest Price", uiCurLowestPrice, dbCurLowestPrice);
		
		
		/* Current Average Price */
		
		String uiCurAvgPrice = stringHandling($curAveragePrice.getText());
		String dbCurAvgPrice = null;
		if(!unitName.contains("RV")){
			dbCurAvgPrice = _databaseUtils.getStringValue(_queries.curAvgPrice(unitName));
		} else {
			dbCurAvgPrice = _databaseUtils.getStringValue(_queries.curAvgPriceRV());
		}
		compareUiDbValues("Current Average Price", uiCurAvgPrice, dbCurAvgPrice);
		
		
		/* Current Highest Price */
		
		String uiCurHighestPrice = stringHandling($curHighestPrice.getText());
		String dbCurHighestPrice = null;
		if(!unitName.contains("RV")){
			dbCurHighestPrice = _databaseUtils.getStringValue(_queries.curHighPrice(unitName));
		} else {
			dbCurHighestPrice = _databaseUtils.getStringValue(_queries.curHighPriceRV());
		}
		compareUiDbValues("Current Highest Price", uiCurHighestPrice, dbCurHighestPrice);
		
	}
	
	
	public void AllMarketView() {
		
		_utils.waitForElementInVisibleByLocator(loader);
		
		node = node.createNode("All MarketView");
		
		_utils.waitForElementInVisibleByLocator($tableData);
		int rowCount = $rowCount.size();
		int colCount = $colCount.size();
		
		for(int i=1; i<=rowCount; i++) {
			String storeName = $storeName(_base.driver, i).getText();
			String address = $storeAddress(_base.driver, i).getText();
			node.log(Status.INFO, MarkupHelper.createLabel((storeName+"<br>"+address), ExtentColor.BLUE));
//			node.log(Status.INFO, MarkupHelper.createLabel(address, ExtentColor.BLUE));
			String header = null;
			int storeId;
			if(!address.isEmpty()){
				storeId = (_testData.regId!=3) ? _databaseUtils.getIntValue(_queries.storeIdFromAddressNonUK(address)) : _databaseUtils.getIntValue(_queries.storeIdFromAddressUK(address)); 
			} else {
				storeId = _testData.storeId;
				
			}
			for(int j=2; j<=colCount-1; j++) {
				String uiValue = null;
				String dbValue = null;
				if(j!=6) {
					uiValue = stringHandling($storeData(_base.driver, i, j).getText());
				}
				switch(j) {
				case 2:
//					dbValue = _dbConn.getStringValue(_queries.currentPremium(storeId, unitName)); //to add for RV
					if(!unitName.contains("RV")){
						dbValue = _databaseUtils.getStringValue(_queries.currentPremium(storeId, unitName));
					}
					else {
						dbValue = _databaseUtils.getStringValue(_queries.currentPremiumRV(storeId));
					}
					header = "Current Premium";
					break;
						
				case 3:
					
					dbValue = (!unitName.contains("RV")) ? _databaseUtils.getStringValue(_queries.currentValue(storeId, unitName)) : _databaseUtils.getStringValue(_queries.currentValueRV(storeId));
//					dbValue = _dbConn.getStringValue(_queries.currentValue(storeId, unitName)); //to add for RV
					header = "Current Value";
					break;
						
				case 4:
					dbValue = (!unitName.contains("RV")) ? _databaseUtils.getStringValue(_queries.highestPremium(storeId, unitName)) : _databaseUtils.getStringValue(_queries.highestPremiumRV(storeId));
//					dbValue = _dbConn.getStringValue(_queries.highestPremium(storeId, unitName)); //to add for RV
					header = "Highest Premium";
					break;
						
				case 5:
					dbValue = (!unitName.contains("RV")) ? _databaseUtils.getStringValue(_queries.lowestValue(storeId, unitName)) : _databaseUtils.getStringValue(_queries.lowestValueRV(storeId));
//					dbValue = _dbConn.getStringValue(_queries.lowestValue(storeId, unitName)); //to add for RV
					header = "Lowest Value";
					break;
						
				case 6:
					int morelink = _base.driver.findElements(By.xpath("//table[contains(@class,'market-table')]/tbody/tr[9]/td[6]/div/span/span[1]//a[text()='more']")).size();
					if(morelink==1){
						_base.driver.findElement(By.xpath("//table[contains(@class,'market-table')]/tbody/tr[9]/td[6]/div/span/span[1]//a[text()='more']")).click();
					}
					uiValue = Jsoup.parse($storeDataPromo(_base.driver, i, j).getText().replace("No specials", "N/A")).text();
					dbValue = (!unitName.contains("RV")) ? _databaseUtils.getStringValue(_queries.promotions(storeId, unitName)) : _databaseUtils.getStringValue(_queries.promotionsRV(storeId));
//					dbValue = _dbConn.getStringValue(_queries.promotions(storeId, unitName)); //to add for RV
					header = "Promotions";
					break;
						
				case 7:
					dbValue = (!unitName.contains("RV")) ? _databaseUtils.getStringValue(_queries.walkinPremium(storeId, unitName)) : _databaseUtils.getStringValue(_queries.walkinPremiumRV(storeId));
//					dbValue = _dbConn.getStringValue(_queries.walkinPremium(storeId, unitName)); //to add for RV
					header = "Current Walk-in Premium";
					break;
						
				case 8:
					dbValue = (!unitName.contains("RV")) ? _databaseUtils.getStringValue(_queries.walkinValue(storeId, unitName)) : _databaseUtils.getStringValue(_queries.walkinValueRV(storeId));
//					dbValue = _dbConn.getStringValue(_queries.walkinValue(storeId, unitName)); //to add for RV
					header = "Current Walk-in Value";
					break;
				}
				compareUiDbValues(header, uiValue, dbValue);
			}
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
		String dbValue = (rawDbValue==null || rawDbValue.equalsIgnoreCase("0.0") || rawDbValue.isEmpty()) ? "N/A" : ((rawDbValue.endsWith(".0")) ? rawDbValue.replace(".0", "") : rawDbValue.substring(0));
		if(uiText.equals(dbValue)) {
			node.log(Status.PASS, header+" - Site:"+uiText+" DB:"+dbValue);
		} else {
			node.log(Status.FAIL, header+" - Site:"+uiText+" DB:"+dbValue);
		}
	}
	
	public void backToDashboard() {
		_utils.submit($breadcrumbDashboard(_base.driver, _testData.userStoreId));
	}
	
}
