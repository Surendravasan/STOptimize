package pageUtilities;

import java.util.Date;
import java.util.HashMap;

public class _queries {
	
	
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
	
	
	static Date maxDatePrice = _dbConn.getDate("select DatePrice from MaxDatePrice");
	
	
	
	/* Queries - DashBoard */
	
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
	
	
	/* Queries - Current Pricing Analysis */
	
	public static String curLowestPrice(String unitName) {
		String query = "select min(onlineprice) as MINPRICE from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where UserStoreId = "+_testData.userStoreId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+")) and iscurrentPrice = 1 and onlineprice between 2 and 999 order by 1";
		return query;
	}
	
	public static String curLowestPriceRV() {
		String query = "select min(onlineprice) as MINPRICE from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where UserStoreId = "+_testData.userStoreId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id=18 or (id=17 and RV=1))) and iscurrentPrice = 1 and onlineprice between 2 and 999 order by 1";
		return query;
	}
	
	public static String curAvgPrice(String unitName) {
		String query = "select ROUND((AVG(onlineprice)),2) as avgprice from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where userstoreid = "+_testData.userStoreId+")) and spaceid in (Select SpaceID from Space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+")) and IsCurrentPrice=1 and onlineprice between 2 and 999";
		return query;
	}
	
	public static String curAvgPriceRV() {
		String query = "select ROUND((AVG(onlineprice)),2) as avgprice from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where userstoreid = "+_testData.userStoreId+")) and spaceid in (Select SpaceID from Space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id=18 or (id=17 and RV=1))) and IsCurrentPrice=1 and onlineprice between 2 and 999";
		return query;
	}
	
	public static String curHighPrice(String unitName) {
		String query = "select MAX(onlineprice) as maxprice from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where userstoreid = "+_testData.userStoreId+")) and spaceid in (Select SpaceID from Space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+")) and IsCurrentPrice=1 and onlineprice between 2 and 999";
		return query;
	}
	
	public static String curHighPriceRV() {
		String query = "select MAX(onlineprice) as maxprice from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where userstoreid = "+_testData.userStoreId+")) and spaceid in (Select SpaceID from Space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id=18 or (id=17 and RV=1))) and IsCurrentPrice=1 and onlineprice between 2 and 999";
		return query;
	}
	
	
	/* Queries - Current Pricing Analysis (All Market View) */
	
	public static String storeIdFromAddress(String fullAddress) {
		String query = "select StoreID from stores where storemodflag != 3 and (address+', '+city+', '+state+' '+ZipCode) = '"+fullAddress+"'";
		return query;
	}
	
	public static String currentPremium(int storeId, String unitName) {
		String query = "select top 1 currentPremium from (select distinct spaceid, onlineprice as currentPremium from SpacePrice with (nolock) where iscurrentprice=1 and storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+"))) as temp order by currentPremium desc";
		return query;
	}
	
	public static String currentValue(int storeId, String unitName) {
		String query = "select top 1 currentValue from (select distinct spaceid, onlineprice as currentValue from SpacePrice with (nolock) where iscurrentprice=1 and storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+"))) as temp order by currentValue";
		return query;
	}
	
	//max date
	public static String highestPremium(int storeId, String unitName) {
		String query = "select top 1 highestPremium from (select distinct SpaceID, onlineprice as highestPremium from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and dateprice >= (SELECT DATEADD(DAY, -5, '"+maxDatePrice+"')) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+"))) as temp order by highestPremium desc";
		return query;
	}
	
	//max date
	public static String lowestValue(int storeId, String unitName) {
		String query = "select top 1 lowestValue from (select distinct SpaceID, onlineprice as lowestValue from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and dateprice >= (SELECT DATEADD(DAY, -5, '"+maxDatePrice+"')) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+"))) as temp order by lowestValue";
		return query;
	}
	
	//max date
	public static String promotions(int storeId, String unitName) {
		String query = "select distinct promo as promotions from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and dateprice >= (SELECT DATEADD(DAY, -5, '"+maxDatePrice+"')) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+"))";
		return query;
	}
	
	public static String walkinPremium(int storeId, String unitName) {
		String query = "select top 1 walkinPremium from (select distinct spaceid, regularprice as walkinPremium from SpacePrice with (nolock) where iscurrentprice=1 and storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+"))) as temp order by walkinPremium desc";
		return query;
	}
	
	public static String walkinValue(int storeId, String unitName) {
		String query = "select top 1 walkinValue from (select distinct spaceid, regularprice as walkinValue from SpacePrice with (nolock) where iscurrentprice=1 and storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+"))) as temp order by walkinValue";
		return query;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
}
