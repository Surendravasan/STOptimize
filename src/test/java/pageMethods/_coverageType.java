package pageMethods;  

import objRepository._coverageTypePopup;
import pageUtilities._base;
import pageUtilities._testData;
import pageUtilities._utils;

public class _coverageType extends _coverageTypePopup {
	
	public _coverageType() {
		super();
	}
	
	public void radius(int radius) {
		_utils.waitForElementInVisibleByLocator(loader);
		
		
		if(radius!=0) {
			if(radius!=10) {
				_utils.submit($radius(_base.driver, radius));
				_utils.waitForElementInVisibleByLocator(loader);
			}
			_utils.submit($saveCoverage);
			
		}
			else {
				radius();
			}
		
	}
	
	public void radius() {
		_utils.waitForElementInVisibleByLocator(loader);
		int i = _utils.getRandNumber($sliderPoints.size());
		if (i!=10) {
			_utils.submit($selectMiles(_base.driver, i));
			_utils.waitForElementInVisibleByLocator(loader);
		}
		_testData.setRadius(i);
		_utils.submit($saveCoverage);
	}
	
}
