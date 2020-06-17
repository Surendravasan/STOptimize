package pageUtilities;

import java.util.Date;
import java.util.HashMap;

public class _queries {
	
	
	public static int getUnitID(String unitName) {
		HashMap<String, String> map1;
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
		map1 = _databaseUtils.getMapString(query);
		
		return Integer.valueOf(map1.get(unitName));
	}
	
	
	static Date maxDatePrice = _databaseUtils.getDate("select DatePrice from MaxDatePrice");
	
	
	
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
		String query;
		if(!unitName.contains("RV")) {
			query = "select ROUND(min(onlineprice),2) as MINPRICE from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where UserStoreId = "+_testData.userStoreId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+")) and iscurrentPrice = 1 and onlineprice between 2 and 999 order by 1";
		} else {
			query = "select ROUND(min(onlineprice),2) as MINPRICE from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where UserStoreId = "+_testData.userStoreId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id=18 or (id=17 and RV=1))) and iscurrentPrice = 1 and onlineprice between 2 and 999 order by 1";
		}
		return query;
	}
	
	public static String curAvgPrice(String unitName) {
		String query;
		if(!unitName.contains("RV")) {
			query = "select ROUND(AVG(onlineprice),2) as avgprice from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where userstoreid = "+_testData.userStoreId+")) and spaceid in (Select SpaceID from Space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+")) and IsCurrentPrice=1 and onlineprice between 2 and 999";
		} else {
			query = "select ROUND(AVG(onlineprice),2) as avgprice from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where userstoreid = "+_testData.userStoreId+")) and spaceid in (Select SpaceID from Space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id=18 or (id=17 and RV=1))) and IsCurrentPrice=1 and onlineprice between 2 and 999";
		}
		return query;
	}
	
	public static String curHighPrice(String unitName) {
		String query;
		if(!unitName.contains("RV")) {
			query = "select ROUND(MAX(onlineprice),2) as maxprice from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where userstoreid = "+_testData.userStoreId+")) and spaceid in (Select SpaceID from Space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+")) and IsCurrentPrice=1 and onlineprice between 2 and 999";
		} else {
			query = "select ROUND(MAX(onlineprice),2) as maxprice from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where userstoreid = "+_testData.userStoreId+")) and spaceid in (Select SpaceID from Space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id=18 or (id=17 and RV=1))) and IsCurrentPrice=1 and onlineprice between 2 and 999";
		}
		return query;
	}
	
	/* Queries - Current Pricing Analysis (All Market View) */
	
	public static String storeIdFromAddress(String fullAddress) {
		String queryNonUK = "select StoreID from stores where storemodflag != 3 and (address+', '+city+', '+state+' '+ZipCode) = '"+fullAddress+"'";
		String queryUK = "select StoreID from stores where storemodflag != 3 and (address+', '+city+' '+ZipCode) = '"+fullAddress+"'";
		return (_testData.regId!=3) ? queryNonUK : queryUK;
	}
	
	public static String currentPremium(int storeId, String unitName) {
		String query;
		if(!unitName.contains("RV")) {
			query = "select top 1 ROUND(currentPremium,2) from (select distinct spaceid, onlineprice as currentPremium from SpacePrice with (nolock) where iscurrentprice=1 and storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+"))) as temp order by currentPremium desc";
		} else {
			query = "select top 1 ROUND(currentPremium,2) from (select distinct spaceid, onlineprice as currentPremium from SpacePrice with (nolock) where iscurrentprice=1 and storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id=18 or (id=17 and RV=1))) and iscurrentPrice = 1 and onlineprice between 2 and 999) as temp order by currentPremium desc";
		}
		return query;
	}
	
	public static String currentValue(int storeId, String unitName) {
		String query;
		if(!unitName.contains("RV")) {
			query = "select top 1 ROUND(currentValue,2) from (select distinct spaceid, onlineprice as currentValue from SpacePrice with (nolock) where iscurrentprice=1 and storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+"))) as temp order by currentValue";
		} else {
			query = "select top 1 ROUND(currentValue,2) from (select distinct spaceid, onlineprice as currentValue from SpacePrice with (nolock) where iscurrentprice=1 and storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id=18 or (id=17 and RV=1))) and iscurrentPrice = 1 and onlineprice between 2 and 999) as temp order by currentValue";
		}
		return query;
	}
	
	public static String highestPremium(int storeId, String unitName) {
		String query;
		if(!unitName.contains("RV")) {
			query = "select top 1 ROUND(highestPremium,2) from (select distinct SpaceID, onlineprice as highestPremium from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and dateprice >= (SELECT DATEADD(DAY, -5, '"+maxDatePrice+"')) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+"))) as temp order by highestPremium desc";
		} else {
			query = "select top 1 ROUND(highestPremium,2) from (select distinct SpaceID, onlineprice as highestPremium from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and dateprice >= (SELECT DATEADD(DAY, -5, '2019-09-25')) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id=18 or (id=17 and RV=1))) and iscurrentPrice = 1 and onlineprice between 2 and 999) as temp order by highestPremium desc";
		}
		return query;
	}
	
	public static String lowestValue(int storeId, String unitName) {
		String query;
		if(!unitName.contains("RV")) {
			query = "select top 1 ROUND(lowestValue,2) from (select distinct SpaceID, onlineprice as lowestValue from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and dateprice >= (SELECT DATEADD(DAY, -5, '"+maxDatePrice+"')) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+"))) as temp order by lowestValue";
		} else {
			query = "select top 1 ROUND(lowestValue,2) from (select distinct SpaceID, onlineprice as lowestValue from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and dateprice >= (SELECT DATEADD(DAY, -5, '2019-09-25')) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id=18 or (id=17 and RV=1))) and iscurrentPrice = 1 and onlineprice between 2 and 999) as temp order by lowestValue";
		}
		return query;
	}
	
	public static String promotions(int storeId, String unitName) {
		String query;
		if(!unitName.contains("RV")) {
			query = "select distinct promo as promotions from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and dateprice >= (SELECT DATEADD(DAY, -5, '"+maxDatePrice+"')) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+"))";
		} else {
			query = "select distinct promo as promotions from SpacePrice with (nolock) where storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and dateprice >= (SELECT DATEADD(DAY, -5, '"+maxDatePrice+"')) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id=18 or (id=17 and RV=1))) and iscurrentPrice = 1 and onlineprice between 2 and 999";
		}
		return query;
	}
	
	public static String walkinPremium(int storeId, String unitName) {
		String query;
		if(!unitName.contains("RV")) {
			query = "select top 1 ROUND(walkinPremium,2) from (select distinct spaceid, regularprice as walkinPremium from SpacePrice with (nolock) where iscurrentprice=1 and storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+"))) as temp order by walkinPremium desc";
		} else {
			query = "select top 1 ROUND(walkinPremium,2) from (select distinct spaceid, regularprice as walkinPremium from SpacePrice with (nolock) where iscurrentprice=1 and storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id=18 or (id=17 and RV=1))) and iscurrentPrice = 1 and onlineprice between 2 and 999) as temp order by walkinPremium desc";
		}
		return query;
	}
	
	
	public static String walkinValue(int storeId, String unitName) {
		String query;
		if(!unitName.contains("RV")) {
			query = "select top 1 ROUND(walkinValue,2) from (select distinct spaceid, regularprice as walkinValue from SpacePrice with (nolock) where iscurrentprice=1 and storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+"))) as temp order by walkinValue";
		} else {
			query = "select top 1 ROUND(walkinValue,2) from (select distinct spaceid, regularprice as walkinValue from SpacePrice with (nolock) where iscurrentprice=1 and storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id=18 or (id=17 and RV=1))) and iscurrentPrice = 1 and onlineprice between 2 and 999) as temp order by walkinValue";
		}
		return query;
	}
	
	
	/* Queries - Current Pricing Analysis (Current Advertised Rates) */
	
	public static String unitTypeStores(String unitName) {
		String query = "";
		if(_testData.regId!=3) {
			if(!unitName.contains("RV")) {
				query = "select distinct (st.Address+', '+st.City+', '+st.State+' '+st.ZipCode) as address, sp.StoreID from SpacePrice sp with (nolock) join stores st with (nolock) on sp.StoreID = st.StoreID join userstorecompset us with (nolock) on st.StoreID = us.StoreId join space se with (nolock) on sp.SpaceID = se.SpaceID where us.UserStoreId = "+_testData.userStoreId+" and se.DefaultUnitId = "+getUnitID(unitName)+" and sp.IsCurrentPrice = 1 and sp.onlineprice between 2 and 999";
			} else {
				query = "select distinct (st.Address+', '+st.City+', '+st.State+' '+st.ZipCode) as address, sp.StoreID from SpacePrice sp with (nolock) join stores st with (nolock) on sp.StoreID = st.StoreID join userstorecompset us with (nolock) on st.StoreID = us.StoreId join space se with (nolock) on sp.SpaceID = se.SpaceID join DefaultUnitSizes du (nolock) on se.defaultunitid = du.id where us.UserStoreId = "+_testData.userStoreId+" and (du.id=18 or (du.id=17 and RV=1))  and sp.IsCurrentPrice = 1 and sp.onlineprice between 2 and 999";
			}
		} else {
			if(!unitName.contains("RV")) {
				query = "select distinct (st.Address+', '+st.City+' '+st.ZipCode) as address, sp.StoreID from SpacePrice sp with (nolock) join stores st with (nolock) on sp.StoreID = st.StoreID join userstorecompset us with (nolock) on st.StoreID = us.StoreId join space se with (nolock) on sp.SpaceID = se.SpaceID where us.UserStoreId = "+_testData.userStoreId+" and se.DefaultUnitId = "+getUnitID(unitName)+" and sp.IsCurrentPrice = 1 and sp.onlineprice between 2 and 999";
			} else {
				query = "select distinct (st.Address+', '+st.City+' '+st.ZipCode) as address, sp.StoreID from SpacePrice sp with (nolock) join stores st with (nolock) on sp.StoreID = st.StoreID join userstorecompset us with (nolock) on st.StoreID = us.StoreId join space se with (nolock) on sp.SpaceID = se.SpaceID join DefaultUnitSizes du (nolock) on se.defaultunitid = du.id where us.UserStoreId = "+_testData.userStoreId+" and (du.id=18 or (du.id=17 and RV=1))  and sp.IsCurrentPrice = 1 and sp.onlineprice between 2 and 999";
			}
		}
		return query; 
	}
	
	
	public static String currAdvRates(int storeId, String unitName) {
		String query;
		if(!unitName.contains("RV")) {
			query = "select distinct onlineprice, spaceid from SpacePrice with (nolock) where iscurrentprice=1 and storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id = "+getUnitID(unitName)+")) and onlineprice between 2 and 999 order by 1";
		} else {
			query = "select distinct onlineprice, spaceid from SpacePrice with (nolock) where iscurrentprice=1 and storeid in (select StoreID from stores with (nolock) where storeid in (select storeid from userstorecompset with (nolock) where storeid = "+storeId+")) and spaceid in (select spaceid from space with (nolock) where defaultunitid in (select id from DefaultUnitSizes with (nolock) where id=18 or (id=17 and RV=1))) and onlineprice between 2 and 999 order by 1";
		}
		return query;
	}

}
