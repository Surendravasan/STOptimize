package tests;

import java.sql.ResultSet;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.ITestResult;
import org.testng.annotations.*;

import pageUtilities._base;
import pageUtilities._dateTime;
import pageUtilities._dbConn;

	public class _testClass1 extends _base {
		
		@Test
		public void man() {
			_base.logger = _base.report.createTest("Sample Test");
			
			_base.logger.log(Status.PASS, "Testing");
		}
		
}












