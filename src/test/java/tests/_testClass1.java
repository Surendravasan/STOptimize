 package tests;

import com.aventstack.extentreports.Status;
import org.testng.annotations.*;
import pageUtilities._base;

	public class _testClass1 extends _base {
		
		@Test
		public void man() {
			_base.logger = _base.report.createTest("Sample Test");
			
			_base.logger.log(Status.PASS, "Testing");
		}
		
}












