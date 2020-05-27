package pageMethods;  

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import objRepository._addAddressPopup;
import pageUtilities._actions;
import pageUtilities._base;
import pageUtilities._dateTime;
import pageUtilities._dbConn;
import pageUtilities._excelReader;
import pageUtilities._randGen;
import pageUtilities._testData;
import pageUtilities._wait;

public class _addAddress extends _addAddressPopup {
	
	private int popupDisplay;
	private String storeName;
	private String state;
	
	public _addAddress() {
		super();
	}
	
	HashMap<String, String> map = null;
	
	public void addAddress(String source) {
		
		/*	Step 1: Add Address  */
		_wait.inVisibleCss(loading, 60);
		_wait.clickable($marketName, 10);
		
		do {
			getStoreDetails(source);
			
			storeName = map.get("storename")+" ("+_dateTime.getDateTime()+")";
			_actions.sendKeys($marketName, storeName);
			_actions.sendKeys($addressLine1, map.get("address"));
			_actions.sendKeys($city, map.get("city"));
			
			if((_testData.regId)!=3) {
				state = map.get("state");
				List<WebElement> options = _base.driver.findElements(By.xpath("//select[@name='state']/option"));

				for (WebElement option : options) {
					String value = option.getAttribute("value");
				    if (value.toLowerCase().startsWith(state.toLowerCase())) {
				        option.click();
				        break;
				    }
				}
			}
		
			_actions.sendKeys($zipCode, map.get("zipcode"));
			_actions.click($saveAddress);
		
			_wait.inVisibleCss(loading, 30);
			popupDisplay = $addrNotFound.size(); 
			if(popupDisplay==1) 
				_actions.click($addrNotFoundX);
			} while(popupDisplay==1);
		
		_testData.setStoreId(Integer.valueOf(map.get("storeid")));
		_testData.setStoreName(storeName);
//		System.out.println("-------------------------");
//		System.out.println("Add address Success");
		
	}

	private void getStoreDetails(String source) {
		switch(source.charAt(0)) {
		case 'D':
			getStoreDb();
			break;
		case 'E':
			getStoreEx();
			break;
		}
	}
	
	private void getStoreDb() {
		String storeList = "select storeid from stores with (nolock) where storemodflag !=3 and regionid = "+_testData.regId;
		ArrayList<Integer> ls = _dbConn.getRowValues(storeList);
		String storeInfo = "select storeid, storename, address, city, state, zipcode from stores with (nolock) where storeid = " +ls.get(_randGen.getRandNumber(ls.size()));
		map = _dbConn.getColumnValues(storeInfo);
	}
	
	private void getStoreEx() {
		map = _excelReader.exStore;
	}
	
}
