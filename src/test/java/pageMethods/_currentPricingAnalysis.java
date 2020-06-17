package pageMethods;  

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
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
		test.log(Status.INFO, MarkupHelper.createLabel("Current Pricing Analysis", ExtentColor.BLACK));
		this.unitName = $unitName.getText();
	}
	
	
	public void OverviewHeader() {
		
		_utils.waitForElementInVisibleByLocator(loader);
		node = test.createNode("Overview Header");
		
		
		/* Current Lowest Price */
		
		String uiCurLowestPrice = repSymbolText($curLowestPrice.getText());
		String dbCurLowestPrice = _databaseUtils.getStringValue(_queries.curLowestPrice(unitName));
		compareUiDbValues("Current Lowest Price", uiCurLowestPrice, dbCurLowestPrice, node);
		
		
		/* Current Average Price */
		
		String uiCurAvgPrice = repSymbolText($curAveragePrice.getText());
		String dbCurAvgPrice = _databaseUtils.getStringValue(_queries.curAvgPrice(unitName));
		compareUiDbValues("Current Average Price", uiCurAvgPrice, dbCurAvgPrice, node);
		
		
		/* Current Highest Price */
		
		String uiCurHighestPrice = repSymbolText($curHighestPrice.getText());
		String dbCurHighestPrice = _databaseUtils.getStringValue(_queries.curHighPrice(unitName));
		compareUiDbValues("Current Highest Price", uiCurHighestPrice, dbCurHighestPrice, node);
		
	}
	
	/* All Market View Verification */
	public void AllMarketView() {
		
		node = test.createNode("All MarketView");
		
		try {
			_utils.waitForElementInVisibleByLocator(loader);
			_utils.waitForElementInVisibleByLocator($tableData);
			
			int rowCount = $rowCount.size();
			int colCount = $colCount.size();
			
			/* Verify number of rows */
			if(rowCount>3){
				rowCount = 3;
			}
			
			for(int i=1; i<=rowCount; i++) {
				String storeName = $storeName(_base.driver, i).getText();
				String address = $storeAddress(_base.driver, i).getText();
				node.log(Status.INFO, MarkupHelper.createLabel((storeName+"<br>"+address), ExtentColor.BLUE));
				String header = null;
				int storeId;
				
				if(!address.isEmpty()){
					storeId = _databaseUtils.getIntValue(_queries.storeIdFromAddress(address));
				} else {
					storeId = _testData.storeId;
					
				}
				for(int j=2; j<=colCount-1; j++) {
					String uiValue = null;
					String dbValue = null;
					if(j!=6) {
						uiValue = repSymbolText($storeData(_base.driver, i, j).getText());
					}
					switch(j) {
					case 2:
						dbValue = _databaseUtils.getStringValue(_queries.currentPremium(storeId, unitName));
						header = "Current Premium";
						break;
							
					case 3:
						dbValue = _databaseUtils.getStringValue(_queries.currentValue(storeId, unitName));
						header = "Current Value";
						break;
							
					case 4:
						dbValue = _databaseUtils.getStringValue(_queries.highestPremium(storeId, unitName));
						header = "Highest Premium";
						break;
							
					case 5:
						dbValue = _databaseUtils.getStringValue(_queries.lowestValue(storeId, unitName));
						header = "Lowest Value";
						break;
							
					case 6:
						int morelink = _base.driver.findElements(By.xpath("//table[contains(@class,'market-table')]/tbody/tr["+i+"]/td["+j+"]/div/span/span[1]//a[text()='more']")).size();
						if(morelink==1){
							_base.driver.findElement(By.xpath("//table[contains(@class,'market-table')]/tbody/tr["+i+"]/td["+j+"]/div/span/span[1]//a[text()='more']")).click();
						}
						uiValue = Jsoup.parse($storeDataPromo(_base.driver, i, j).getText().replace("No specials", "N/A")).text();
						dbValue = _databaseUtils.getStringValue(_queries.promotions(storeId, unitName));
						header = "Promotions";
						break;
							
					case 7:
						dbValue = _databaseUtils.getStringValue(_queries.walkinPremium(storeId, unitName));
						header = "Current Walk-in Premium";
						break;
							
					case 8:
						dbValue = _databaseUtils.getStringValue(_queries.walkinValue(storeId, unitName));
						header = "Current Walk-in Value";
						break;
					}
					compareUiDbValues(header, uiValue, dbValue, node);
				}
			}
		} catch(Exception e) {
			node.log(Status.FAIL, "Exception: "+e);
			node.fail(e);
		}
		
	} 
	
	/* Clear symbols and other texts from given String  */
	public String repSymbolText(String uiText) {
		return uiText.replace("Offered by ", "").replace(" stores", "").replace(" store", "").replace("A$", "")
				.replace("NZ$", "").replace("$", "").replace("£", "").replace("€", "")
				.replace("*", "");
	}
	
	/* Compare given values and log under the given header and node(Extent Report) */
	private void compareUiDbValues(String header, String uiText, String rawDbValue, ExtentTest node) {
		if((!uiText.equals("N/A") && !header.contains("Promotions"))) {
			BigDecimal number = new BigDecimal(uiText);  
			uiText = number.stripTrailingZeros().toPlainString();
		}
		String dbValue = (rawDbValue.equals("null") || rawDbValue.equalsIgnoreCase("0.0") || rawDbValue.isEmpty()) ? "N/A" : ((rawDbValue.endsWith(".0")) ? rawDbValue.replace(".0", "") : rawDbValue.substring(0));
		if(uiText.replaceAll("( )+", " ").equals(dbValue.replaceAll("( )+", " "))) {
			node.log(Status.PASS, header+" - Site:"+uiText+" DB:"+dbValue);
		} else {
			node.log(Status.FAIL, header+" - Site:"+uiText+" DB:"+dbValue);
		}
	}
	
	/* Navigate to dashboard of the user store id under test */
	public void backToDashboard() {
		_utils.submit($breadcrumbDashboard(_base.driver, _testData.userStoreId));
	}
	
	/* Current Advertised Rates & Market Low/Average/High verification */
	public void currentAdvertisedRates() {
		node = test.createNode("Current Advertised Rates");
		
		try {
			_utils.waitForElementInVisibleByLocator(loader);
			
			
			int colCount = _base.driver.findElements(By.cssSelector("div[class*='online-price'] thead th")).size();
			int rowCount = _base.driver.findElements(By.xpath("//div[contains(@class,'online-price')]//tbody/tr[not(contains(@class,'graph'))][not(contains(@class,'background'))]")).size();

			for(int j=2; j<=colCount; j++) {
				_base.driver.findElement(By.cssSelector("div[class*='online-price'] thead th:nth-child("+j+")"));
				
				/* Actions class to get address from tool tip */
				Actions act = new Actions(_base.driver);
				act.moveToElement(_base.driver.findElement(By.cssSelector("div[class*='online-price'] thead th:nth-child("+j+")"))).click().build().perform();
				
				String tooltip = ""; 
				do {
					tooltip = _base.driver.findElement(By.cssSelector("div[class*='online-price'] thead th:nth-child("+j+")")).getAttribute("aria-describedby");
				} while(tooltip==null);
				
				int count;
				do {
					count = _base.driver.findElements(By.cssSelector("div#"+tooltip+" div div")).size();
				} while(count!=1);
				
				/* Get store id by matching address */
				String uiStoreNameAddress = _base.driver.findElement(By.cssSelector("div#"+tooltip+" div div")).getText();
				HashMap<String, String> map = new HashMap<>();
				map = _databaseUtils.getMapString(_queries.unitTypeStores(unitName));
				node.log(Status.INFO, MarkupHelper.createLabel(uiStoreNameAddress, ExtentColor.BLUE));
				int storeid = 0;
				
				for(String i : map.keySet()) {
					if(uiStoreNameAddress.endsWith(i)){
						storeid = Integer.valueOf(map.get(i));
					}
				}
				
				String b[] =  returnResult(_databaseUtils.getStringSet(_queries.currAdvRates(storeid, unitName)));
				
				for(int i=0; i<rowCount; i++) {
					int x = i+1;
					String uiText = repSymbolText(_base.driver.findElement(By.xpath("//div[contains(@class,'online-price')]//tbody/tr[not(contains(@class,'graph'))][not(contains(@class,'background'))]["+x+"]/td["+j+"]")).getText());
					if(uiText.equalsIgnoreCase(b[i])){
						node.log(Status.PASS, "Site:"+uiText+" DB:"+b[i]);
					} else {
						node.log(Status.FAIL, "Site:"+uiText+" DB:"+b[i]);
					}
				}
			}
			
			/* Verifies Market Low/Average/High table in right side of Current Advertised Rates */
			
			int rowCnt = _base.driver.findElements(By.xpath("//div[contains(@class,'online-price')]//tbody//span[text()='Premium' or text()='Value']")).size();
			for (int i=1; i<=rowCnt; i++) {
				
				/* ExtentReport */
				if(i==1) {
					node.log(Status.INFO, MarkupHelper.createLabel("Premium", ExtentColor.BLACK));
				} else {
					node.log(Status.INFO, MarkupHelper.createLabel("Value", ExtentColor.BLACK));
				}
				
				List<Float> tree = new LinkedList<>();
				for(int j=1; j<=colCount-1; j++) {
					String text = repSymbolText(_base.driver.findElement(By.xpath("(//div[contains(@class,'online-price')]//tbody//span[text()='Premium' or text()='Value'])["+i+"]/../../td[not(contains(@class,'tablebtn'))]["+j+"]")).getText());
					System.out.println(text);
					if(!text.startsWith("N/A")) {
						tree.add(Float.valueOf(text));
					}
					Collections.sort(tree);
				}
					System.out.println(tree);
					Float v=0f;
					for(Float u : tree) {
						v = v + u; 
					}
					v = v/tree.size();
					System.out.println(v);
					
					int k = _base.driver.findElements(By.xpath("//table[@class='mss market-right-table table']/tbody/tr[1]/td")).size();
					for(int s=1; s<=k; s++) {
						DecimalFormat df = new DecimalFormat("0.00");
						int m=i;
						if(i==2){
							m=i+3;
						}
						String marketText = repSymbolText(_base.driver.findElement(By.xpath("//table[@class='mss market-right-table table']/tbody/tr["+m+"]/td["+s+"]")).getText());
						System.out.println(marketText);
						

						if(s==1) {
							compareUiDbValues("Market Low", marketText, repSymbolText(String.valueOf(tree.get(0))), node);
						} else if(s==2) {
							BigDecimal number = new BigDecimal(String.valueOf(df.format(v)));  
							String avgValue = number.stripTrailingZeros().toPlainString();
							compareUiDbValues("Market Average", marketText, avgValue, node);
						} else if(s==3) {
							compareUiDbValues("Market High", marketText, repSymbolText(String.valueOf(tree.get(tree.size()-1))), node);
						}
					}
			}
		} catch (Exception e) {
			node.log(Status.FAIL, "Exception: "+e);
			node.fail(e);
		}
		
		
		
		
  	}
	
	/*  */
	public String[] returnResult(TreeSet<Float> ad) {
		SortedSet<Float> abc = new TreeSet<>(ad);
		String[] a = new String[4];
		if(!abc.isEmpty()) {
			a[0] = String.valueOf(abc.size());
			String premium = String.valueOf(abc.last()); 
			a[1] = (premium.equals("null") || premium.equalsIgnoreCase("0.0") || premium.isEmpty()) ? "N/A" : ((premium.endsWith(".0")) ? premium.replace(".0", "") : premium.substring(0));
			String value = String.valueOf(abc.first()); 
			a[3] = (value.equals("null") || value.equalsIgnoreCase("0.0") || value.isEmpty()) ? "N/A" : ((value.endsWith(".0")) ? value.replace(".0", "") : value.substring(0));
			  
			if(abc.size()>1){
				a[2] = a[3]+"-"+a[1];
			} else if(abc.size()==1) {
				a[2] = a[3];
			}
		} else {
			a[0] = "0";
			a[1] = "N/A";
			a[2] = "N/A";
			a[3] = "N/A";
		}
		return a;
	}
	
}
