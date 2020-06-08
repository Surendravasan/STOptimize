 package tests;

import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import pageUtilities._base;

	public class _testClass1 extends _base {
		
		ExtentTest test;
		
		@Test
		public void man() {
			test = _base.report.createTest("Dashboard");
			String storename = "East Side Storage";
			String address = "305 East 61St Street, New York, NY 10065";
			test.log(Status.INFO, MarkupHelper.createLabel((storename+" "+"<br>"+" "+address), ExtentColor.BLUE));
		}
		
//		@BeforeClass
//	    public void beforeMethod() {
//			_propMgr.getInstance(); 
//			_signIn signIn = new _signIn();
//			signIn.login();
//			
//	        long id = Thread.currentThread().getId();
//	        System.out.println("Before test-method. Thread id is: " + id);
//	    }
//	 
//	    @Test
//	    public void testMethodsOne() {
//	        long id = Thread.currentThread().getId();
//	        System.out.println("Simple test-method One. Thread id is: " + id);
//	    }
//	 
//	    @Test
//	    public void testMethodsTwo() {
//	        long id = Thread.currentThread().getId();
//	        System.out.println("Simple test-method Two. Thread id is: " + id);
//	    }
//	 
//	    @AfterClass
//	    public void afterMethod() {
//	    	_base.driver.quit();
//	    	
//	        long id = Thread.currentThread().getId();
//	        System.out.println("After test-method. Thread id is: " + id);
//	        
//	    }
		
		
}












