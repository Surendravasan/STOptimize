package pageMethods;  

import objRepository._coverageTypePopup;
import pageUtilities._actions;
import pageUtilities._browser;
import pageUtilities._randGen;
import pageUtilities._testData;
import pageUtilities._wait;

public class _coverageType extends _coverageTypePopup {
	
	public _coverageType() {
		super();
	}
	
	public void radius(int radius) {
		_wait.inVisibleCss(loading, 60);
		
		if(radius!=0) {
			if(radius!=10) {
				_actions.click($radius(_browser.driver, radius));
				_wait.inVisibleCss(loading, 20);
			}
			_actions.click($saveCoverage);
			
		}
			else {
				radius();
			}
		
	}
	
	public void radius() {
		_wait.inVisibleCss(loading, 20);
		int i = _randGen.getRandNumber($sliderPoints.size());
		if (i!=10) {
			_actions.click($selectMiles(_browser.driver, i));
			_wait.inVisibleCss(loading, 20);
		}
		_testData.setRadius(i);
		_actions.click($saveCoverage);
	}
	
}
