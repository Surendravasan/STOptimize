package pageUtilities;

import java.util.HashMap;

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

}
