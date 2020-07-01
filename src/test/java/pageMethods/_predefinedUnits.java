package pageMethods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import pageUtilities._testData;

public class _predefinedUnits {
	
	private String spaceType = "";
	private String unitSize = "";
	private int exactMatch = 0;
	private int climateControl = -1;
	
	static Method preDefInstanceMethod = null;
	static Object ob = "";
	
	static String country() {
		String country = "";
		if(_testData.regId==1) {
			if(_testData.countryId==1 || _testData.countryId==2) {
				country = "us";
			} else if(_testData.countryId==3 || _testData.countryId==4 || _testData.countryId==5) {
				country = "eu";
			}
		} else if(_testData.regId==2) {
			country = "au";
		} else if(_testData.regId==3) {
			country = "uk";
		} else if(_testData.regId==4) {
			country = "nz";
		}
		return country;
	}
	
	public static Object invokeMethod(String unitName) {
		try {
			preDefInstanceMethod = _predefinedUnits.class.getMethod(country()+unitName.replace(" ", "").replace("²", "").replace(".", ""));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		_predefinedUnits operationsInstance = new _predefinedUnits();
	    try {
			 ob = preDefInstanceMethod.invoke(operationsInstance);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	    return ob;
	    
	}
	
	
	
	
	public void setSpaceType(String spaceType) {
		this.spaceType = spaceType;
	}
	
	public String getSpaceType() {
		return spaceType;
	}
	
	public void setUnitSize(String unitSize) {
		this.unitSize = unitSize;
	}
	
	public String getUnitSize() {
		return unitSize;
	}
	
	public void setExactMatch(int exactMatch) {
		this.exactMatch = exactMatch;
	}
	
	public int getExactMatch() {
		return exactMatch;
	}
	
	public void setClimateControl(int climateControl) {
		this.climateControl = climateControl;
	}
	
	public int getClimateControl() {
		return climateControl;
	}
	
	
	/* Predefined Values - US/Canada */
	
	public static Object us5x5Reg() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("5x5");
		obj.setExactMatch(1);
		obj.setClimateControl(0);
		return obj;
	}
	
	public static Object us5x5CC() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("5x5");
		obj.setExactMatch(1);
		obj.setClimateControl(1);
		return obj;
	}
	
	public static Object us5x10Reg() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("5x10");
		obj.setExactMatch(1);
		obj.setClimateControl(0);
		return obj;
	}
	
	public static Object us5x10CC() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("5x10");
		obj.setExactMatch(1);
		obj.setClimateControl(1);
		return obj;
	}
	
	public static Object us10x10Reg() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("10x10");
		obj.setExactMatch(1);
		obj.setClimateControl(0);
		return obj;
	}
	
	public static Object us10x10CC() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("10x10");
		obj.setExactMatch(1);
		obj.setClimateControl(1);
		return obj;
	}
	
	public static Object us10x15() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("10x15");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object us10x20() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("10x20");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object us10x25() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("10x25");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object us10x30() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("10x30");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object usCarParking() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("Car");
		return obj;
	}
	
	public static Object usRVParking() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("RV");
		return obj;
	}
	
	
	/* Predefined Values - Europe*/
	
	public static Object eu1m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("1m²");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object eu2m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("2m²");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object eu3m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("3m²");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object eu4m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("4m²");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object eu5m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("5m²");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object eu6m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("6m²");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object eu7m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("7m²");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object eu8m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("8m²");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object eu9m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("9m²");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object eu10m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("10m²");
		obj.setExactMatch(1);
		return obj;
	}
	
	/* Predefined Values - Australia*/
	
	public static Object au3mx3m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("3mx3m");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object au15mx15m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("1.5mx1.5m");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object au3mx6m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("3mx6m");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object au15mx3m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("1.5mx3m");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object au1mx1m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("1mx1m");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object au3mx45m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("3mx4.5m");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object au15mx2m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("1.5mx2m");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object au2mx3m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("2mx3m");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object au3mx4m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("3mx4m");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object au3mx5m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("3mx5m");
		obj.setExactMatch(1);
		return obj;
	}
	
	
	/* Predefined Values - United Kingdom*/

	public static Object uk20sqft() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("20 sq.ft");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object uk25sqft() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("25 sq.ft");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object uk35sqft() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("35 sq.ft");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object uk40sqft() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("40 sq.ft");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object uk50sqft() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("50 sq.ft");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object uk80sqft() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("80 sq.ft");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object uk100sqft() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("100 sq.ft");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object uk150sqft() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("150 sq.ft");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object uk160sqft() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("160 sq.ft");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object uk200sqft() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("200 sq.ft");
		obj.setExactMatch(1);
		return obj;
	}
	
	/* Predefined Values - New Zealand*/
	
	public static Object nz1mx1m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("1mx1m");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object nz2mx1m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("2mx1m");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object nz2mx15m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("2mx1.5m");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object nz2mx2m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("2mx2m");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object nz3mx15m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("3mx1.5m");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object nz3mx2m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("3mx2m");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object nz3mx3m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("3mx3m");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object nz4mx3m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("4mx3m");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object nz5mx3m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("5mx3m");
		obj.setExactMatch(1);
		return obj;
	}
	
	public static Object nz6mx3m() {
		_predefinedUnits obj = new _predefinedUnits();
		obj.setUnitSize("6mx3m");
		obj.setExactMatch(1);
		return obj;
	}
	
}
