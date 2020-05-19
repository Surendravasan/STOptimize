package pageUtilities;

import java.util.HashMap;

public class _queries {
	
	public static String dashStoresOffered(String unitName) {
		String query = "select count(distinct storeid) from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where userstoreid = "+_testData.userStoreId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes where id = "+getUnitID(unitName)+")) and IsCurrentPrice=1 and onlineprice between 2 and 999";
		return query;
	}
	
	public static String dashStoresOfferedRV() {
		String query = "select count(distinct storeid) from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where userstoreid = "+_testData.userStoreId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id=18 or (id=17 and RV=1))) and IsCurrentPrice=1 and onlineprice between 2 and 999";
		return query;
	}
	
	public static String dashAvgPrice(String unitName) {
		String query = "select ROUND((AVG(onlineprice)),0) as avgprice from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where userstoreid = "+_testData.userStoreId+")) and spaceid in (Select SpaceID from Space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+")) and IsCurrentPrice=1 and onlineprice between 2 and 999";
		return query;
	}
	
	public static String dashAvgPriceRV() {
		String query = "select ROUND((AVG(onlineprice)),0) as avgprice from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where userstoreid = "+_testData.userStoreId+")) and spaceid in (Select SpaceID from Space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id=18 or (id=17 and RV=1))) and IsCurrentPrice=1 and onlineprice between 2 and 999";
		return query;
	}
	
	public static String dashYourPrice(String unitName) {
		String query = "select ROUND(onlineprice,0) as YourPrice from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+_testData.storeId+")) and spaceid in (Select SpaceID from Space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+")) and iscurrentprice=1 and onlineprice between 2 and 999";
		return query;
	}
	
	public static String dashYourPriceRV() {
		String query = "select ROUND(onlineprice,0) as YourPrice from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+_testData.storeId+")) and spaceid in (Select SpaceID from Space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id=18 or (id=17 and RV=1))) and iscurrentprice=1 and onlineprice between 2 and 999";
		return query;
	}
	
	
	public static int getUnitID(String unitName) {
		HashMap<String, Integer> map1;
		String query = null;
		
		switch(_testData.regId) {
		case 1:
			if(!unitName.contains("m²")){
				query = "select UnitType, ID from DefaultUnitSizes where countryid like '1,2' and id between 2 and 17";
			} else { 
 				query = "select UnitType, ID from DefaultUnitSizes where countryid like '3,4,5'";
			}
			break;
		case 2:
			query = "select UnitType, ID from DefaultUnitSizes where RegionId = 2 and id between 29 and 38";
			break;
		case 3:
			query = "select UnitType, ID from DefaultUnitSizes where RegionId = 3 and id between 39 and 48";
			break;
		case 4:
			query = "select UnitType, ID from DefaultUnitSizes where RegionId = 4 and id between 59 and 68";
			break;
		}
		map1 = _dbConn.getRowColumn(query);
		
		return map1.get(unitName);
	}	
	

}
