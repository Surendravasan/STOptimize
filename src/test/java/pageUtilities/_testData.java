package pageUtilities;

import java.util.HashMap;

import org.testng.annotations.DataProvider;

import pageMethods._dashboard;

public class _testData {
	
	public static int regId;
	public static int storeId;
	public static String storeName;
	public static String address;
	public static String city;
	public static String state;
	public static String zipcode;
	public static int userStoreId;
	public static String baseUrl;
	public static int radius = 0;
	
	static HashMap<String, String> map;
	
	public static void setRegion(String region) {
		
		if(region.equalsIgnoreCase("US"))
			regId = 1;
		else if (region.equalsIgnoreCase("AU"))
			regId = 2;
		else if (region.equalsIgnoreCase("UK"))
			regId = 3;
		else if (region.equalsIgnoreCase("NZ"))
			regId = 4;
		else 
			regId = 1;
	}
	
	public static void setStoreId(int sId) {
		storeId = sId;
	}
	
	public static void setStoreName(String sName) {
		storeName = sName;
	}
	
	public static void setUserStoreId(int usId) {
		userStoreId = usId;
	}
	
	public static void setRadius(int rad) {
		radius = rad;
	}
	
	
	public static void setStoreDetails(HashMap<String, String> hm) {
		HashMap<String, String> ab = hm;
		storeId = Integer.valueOf(ab.get("storeid"));
		address = ab.get("address");
		city = ab.get("city");
		state = ab.get("state");
		zipcode = ab.get("zipcode");
		radius = Integer.valueOf(ab.get("radius"));
		ab.put("regid", "");
		regId = _databaseUtils.getIntValue("select regionid from stores where storeid = "+storeId+" and storemodflag!=3");
	}
	
	
	
	@DataProvider(name="unitName")
	public static Object[][] unitName() {
		Object unitNames[][] = null;
		switch(_testData.regId) {
		case 1:
			if(!_dashboard.getUnitName.contains("m²"))
			{
//				unitNames = new Object[][] {{"5x5 Reg"}};
				unitNames = new Object[][] {
					{"5x5 Reg"}, {"5x5 CC"}, {"5x10 Reg"}, {"5x10 CC"}, 
					{"10x10 Reg"}, {"10x10 CC"}, {"10x15"}, {"10x20"}, 
					{"10x30"}, {"Car Parking"}, {"RV Parking"}};
			} else {
//				unitNames = new Object[][] {{"1mx1m"}};
				unitNames = new Object[][] {
					{"1m²"}, {"2m²"}, {"3m²"}, {"4m²"},	{"5m²"}, 
					{"6m²"}, {"7m²"}, {"8m²"}, {"9m²"}, {"10m²"}};
			}
			break;
			
		case 2:
//			unitNames = new Object[][] {{"3mx4m"}, {"3mx5m"}};
			unitNames = new Object[][] {
				{"3mx3m"}, {"1.5mx1.5m"}, {"3mx6m"}, {"1.5mx3m"}, 
				{"1mx1m"}, {"3mx4.5m"}, {"1.5mx2m"}, {"2mx3m"}, 
				{"3mx4m"}, {"3mx5m"}};
				break;
				
		case 3:
//			unitNames = new Object[][] {{"25 sq.ft"}, {"35 sq.ft"}};
			unitNames = new Object[][] {
				{"20 sq.ft"}, {"25 sq.ft"}, {"35 sq.ft"}, {"40 sq.ft"}, 
				{"50 sq.ft"}, {"80 sq.ft"}, {"100 sq.ft"}, {"150 sq.ft"}, 
				{"160 sq.ft"}, {"200 sq.ft"}};
				break;
				
		case 4:
//			unitNames = new Object[][] {{"1mx1m"}};
			unitNames = new Object[][] {
				{"1mx1m"}, {"2mx1m"}, {"2mx1.5m"}, {"2mx2m"}, 
				{"3mx1.5m"}, {"3mx2m"}, {"3mx3m"}, {"4mx3m"}, 
				{"5mx3m"}, {"6mx3m"}};
				break;
				
		}
		return unitNames;
	}

}
