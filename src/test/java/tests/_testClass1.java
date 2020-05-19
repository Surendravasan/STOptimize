package tests;

import java.util.HashMap;
import org.testng.annotations.Test;
import pageUtilities._dbConn;


enum Mobile {
	APPLE ("Apple is okay"), SAMSUNG ("Samsung is okay"), HTC ("Htc is okay"), MI ("Mi is okay");
	
	private final String shortCode;
	
	Mobile(String code) {
		this.shortCode = code;
	}
	
	public String getDirectionCode() {
		return this.shortCode;
	}
}

public class _testClass1 {
	
	@Test
	public static void man() {
		_dbConn.getInstance();
		
		HashMap<String, Integer> map1;
		String query = null;
		String unitName = "5m²";
		switch(1) {
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
		
		System.out.println(map1.get(unitName));
		
		
		
	}
	
	
		
}












