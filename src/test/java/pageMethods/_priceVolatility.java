package pageMethods;

import java.util.HashMap;
import java.util.TreeSet;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import objRepository._priceVolatilityPage;
import pageUtilities._base;
import pageUtilities._databaseUtils;
import pageUtilities._queries;
import pageUtilities._testData;
import pageUtilities._utils;
import tests._smokeTestsExcel;

public class _priceVolatility extends _priceVolatilityPage {
	
	ExtentTest test = _base.test;
	ExtentTest node;
	
	public _priceVolatility() {
		super();
		_utils.clickAction($priceVolatility(_base.driver, _testData.userStoreId));
		_utils.waitForElementInVisibleByLocator(loader);
		
	}
	
	public void overviewHeader() {
		node = test.createNode("Overview Header");
		
		_utils.waitForElementVisibleByLocator(topHeader);
		int count = $headerCount.size();
		for(int i=1; i<=count; i++) {
			String uiValue = $overviewHeaderValue(_base.driver, i).getText();
			String uiLabel = $overviewHeaderLabel(_base.driver, i).getText();
			
			String dbValue = "";
			String header = "";
			switch(uiLabel) {
			case "Market":
				dbValue = _databaseUtils.getStringValue(_queries.pvMarket());
				header = "Market";
				break;
			case "Your Store":
				dbValue = _databaseUtils.getStringValue(_queries.pvYourStore());
				header = "Your Store";
				break;
			case "REIT's":
				dbValue = _databaseUtils.getStringValue(_queries.pvREIT());
				header = "REIT's";
				break;
			case "Multi-Ops":
				dbValue = _databaseUtils.getStringValue(_queries.pvMultiOps());
				header = "Multi-Ops";
				break;
			case "Single-Ops":
				dbValue = _databaseUtils.getStringValue(_queries.pvSingleOps());
				header = "Single-Ops";
				break;
			}
			compareUiDbValues(header, uiValue, dbValue, node);
		}
	}
	
	public void currentMarketVolatility() {
		_utils.waitForElementVisibleByLocator(currMrktVolGrid);
		node = test.createNode("Current Market Volatility");
		int noOfRows = $noOfRows.size();
		String header = "";
		if(noOfRows>1) {
			HashMap<String, String> hm = new HashMap<>(_databaseUtils.getMapString(_queries.pvCurrMarketVol()));
			int noOfUnits = $noOfUnits.size();
			for(int i=1; i<=noOfUnits; i++) {
				String unitName = $getUnitName(_base.driver, i).getText();
				header = unitName;
//				System.out.println(unitName);
				String dbValue = hm.get(unitName);
				System.out.println(dbValue);
				if(dbValue==null)
					dbValue = "N/A";
				String unitValue = $getUnitValue(_base.driver, i).getText();
				System.out.println(unitValue);
				compareUiDbValues(header, unitValue, dbValue, node);
			}
		} else {
			node.log(Status.PASS, "No Data Found");
//			System.out.println("No Data Found");
		}
		
	}
	
	
	public void marketVolPriceStore() {
		
		_utils.waitForElementVisibleByLocator(currMrktVolStrPriGrid);
		
		node = test.createNode("Market Volatility Price & Store");

		int noOfStores = $noOfStores.size();
		HashMap<String, String> hm = new HashMap<>(); 
		for(int i=1; i<=noOfStores; i++) {
			String address = $getAddress(_base.driver, i).getText();
			node.log(Status.INFO, MarkupHelper.createLabel(address, ExtentColor.BLUE));
//			System.out.println(address);
			hm = _databaseUtils.getColumnValues(_queries.pvMarketVolPriceStore(address));
			
			System.out.println(hm);
			System.out.println(hm.isEmpty());
			
			
				int noOfColumns = $noOfColumns.size(); 
				String header = "";
				for(int j=2; j<noOfColumns; j++) {
					String uiText = $getAllPreValPrice(_base.driver, i, j).getText();
					String dbValue = "";
					
					if(!hm.isEmpty()) {
						switch(j) {
						case 2:
							dbValue = hm.get("AllPriceVolatility");
							header = "AllPrice";
							break;
						case 3:
							dbValue = hm.get("PremiumPriceVolatility");
							header = "PremiumPrice";
							break;
						case 4:
							dbValue = hm.get("ValuePriceVolatility");
							header = "ValuePrice";
							break;
						}
					} else {
						dbValue = "N/A";
					}
					compareUiDbValues(header, uiText, dbValue, node);
				}
		}
	}
	
	
	
	
	public void compareUiDbValues(String Header, String rawUi, String rawDb, ExtentTest node) {
		String uiValue = rawUi.replace("%", "");
//		String dbValue = (rawDb.equals("null")) ? "N/A" : (rawDb.equals("0.0")) ? "0" : rawDb.substring(0);
		String dbValue = (rawDb.equals("null")) ? "N/A" : (rawDb.endsWith(".0")) ? rawDb.replace(".0", "") : rawDb.substring(0);
		
		if(uiValue.equals(dbValue)) {
			node.log(Status.PASS, Header+" - UI: "+uiValue+", DB: "+dbValue);
			System.out.println("PASS ---- UI"+uiValue+", DB"+dbValue);
		} else {
			node.log(Status.FAIL, Header+" - UI: "+uiValue+", DB: "+dbValue);
			System.out.println("FAIL ---- UI"+uiValue+", DB"+dbValue);
		}
	}
	
	
}
