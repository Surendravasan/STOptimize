package pageMethods;  

import objRepository._reviewCoveragePopup;
import pageUtilities._utils;

public class _reviewCoverage extends _reviewCoveragePopup {
	
	public _reviewCoverage() {
		super();
	}
	
	public void revCoverage() {
		/*	Step 3: Review Coverage  */
		_utils.waitForElementInVisibleByLocator(loader);
		_utils.waitForElementClickable($saveRevCoverage);
		_utils.submit($saveRevCoverage);
		_utils.waitForElementInVisibleByLocator(loader);
	}
}
