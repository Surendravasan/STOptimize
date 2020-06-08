 package tests;

import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentTest;
import pageMethods._signIn;
import pageUtilities._base;
import pageUtilities._databaseUtils;
import pageUtilities._excelUtils;
import pageUtilities._propMgr;

public class _workout extends _base {
	public static ExtentTest test;
	
	@BeforeTest
	public void login()  {
		_propMgr.getInstance(); 
		_databaseUtils.getInstance();
		_excelUtils.openExcel();
		_excelUtils.getStore();
		
		_signIn signIn = new _signIn();
		signIn.login();
	}
	
	
	 @Test
	    public void testMethodsOne() {
	        long id = Thread.currentThread().getId();
	        System.out.println("Simple test-method One. Thread id is: " + id);
	    }
	 
	    @Test
	    public void testMethodsTwo() {
	        long id = Thread.currentThread().getId();
	        System.out.println("Simple test-method Two. Thread id is: " + id);
	    }
	 
	    @AfterMethod
	    public void afterMethod() {
	        long id = Thread.currentThread().getId();
	        System.out.println("After test-method. Thread id is: " + id);
	    }
	
	@AfterTest
	public void closeInstance() {
		if(_databaseUtils.st!=null){
			try{
				_databaseUtils.st.close();
			} catch (Exception e) {}
		}
		
		if(_databaseUtils.con!=null){
			try{
				_databaseUtils.con.close();
			} catch (Exception e) {}
		}
		
		if(_excelUtils.fis!=null){
			try{
				_excelUtils.fis.close();
			} catch (Exception e) {}
		}
		
		if(_excelUtils.fos!=null){
			try{
				_excelUtils.fos.close();
			} catch (Exception e) {}
		}
		
		if(_excelUtils.wb!=null){
			try{
				_excelUtils.wb.close();
			} catch (Exception e) {}
		}
		_base.driver.quit();
	}
}
