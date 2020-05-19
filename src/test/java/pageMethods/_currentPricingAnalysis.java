package pageMethods;  

import objRepository._currentPricingAnalysisPage;
import pageUtilities._wait;

public class _currentPricingAnalysis extends _currentPricingAnalysisPage {
	
	public _currentPricingAnalysis() {
		super();
	}
	
	public void getAllValues() {
		
		_wait.inVisibleCss(loading, 30);
		
	}
	
}
