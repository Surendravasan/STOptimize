package pageMethods;  

import objRepository._reviewCoveragePopup;
import pageUtilities._actions;
import pageUtilities._wait;

public class _reviewCoverage extends _reviewCoveragePopup {
	
	public _reviewCoverage() {
		super();
	}
	
	public void revCoverage() {
		
		System.out.println("Coverage Type Success");
		
		/*	Step 3: Review Coverage  */
		_wait.inVisibleCss(loading, 60);
		_wait.clickable($saveRevCoverage, 10);
		_actions.click($saveRevCoverage);
		System.out.println("Review Coverage Success");
	}
}
