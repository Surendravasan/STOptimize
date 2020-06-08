package pageMethods;  

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import objRepository._addAddressPopup;
import pageUtilities._base;
import pageUtilities._databaseUtils;
import pageUtilities._excelUtils;
import pageUtilities._testData;
import pageUtilities._utils;

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
		_utils.waitForElementInVisibleByLocator(loader);
		_utils.waitForElementClickable($marketName);
		
		do {
			getStoreDetails(source);
			
			storeName = map.get("storename")+" ("+_utils.getDateTime()+")";
			_utils.fillData($marketName, storeName);
			_utils.fillData($addressLine1, map.get("address"));
			_utils.fillData($city, map.get("city"));
			
			if((_testData.regId)!=3) {
				state = map.get("state");
				List<WebElement> stateList = _base.driver.findElements(By.xpath("//select[@name='state']/option"));

				for (WebElement stateLists : stateList) {
					String listValue = stateLists.getAttribute("value");
				    if (listValue.toLowerCase().startsWith(state.toLowerCase())) {
				    	stateLists.click();
				        break;
				    }
				}
			}
		
			_utils.fillData($zipCode, map.get("zipcode"));
			_utils.submit($saveAddress);
		
			_utils.waitForElementInVisibleByLocator(loader);
			popupDisplay = $addrNotFound.size(); 
			if(popupDisplay==1) 
				_utils.submit($addrNotFoundX);
			} while(popupDisplay==1);
		
		_testData.setStoreId(Integer.valueOf(map.get("storeid")));
		_testData.setStoreName(storeName);
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
		ArrayList<Integer> ls = _databaseUtils.getRowValues(storeList);
		String storeInfo = "select storeid, storename, address, city, state, zipcode from stores with (nolock) where storeid = " +ls.get(_utils.getRandNumber(ls.size()));
		map = _databaseUtils.getColumnValues(storeInfo);
	}
	
	private void getStoreEx() {
		map = _excelUtils.exStore;
	}
	
}
