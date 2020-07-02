package pageUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class _excelUtils {
	
	
	static String filePath = "test-input/storesList.xls";
	public static HashMap<String, String> exStore;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static Workbook wb;
	public static Sheet sh;
	public static Row row;
	public static Cell cell;
	static int random;

	public static void openExcel() { 
		
		try {
			fis = new FileInputStream(filePath);
			wb = WorkbookFactory.create(fis);
			
		} catch (Exception e) {
			System.out.println("Couldn't able to read Excel file"+e);
		}
	}
	
	public static void getStore() {
//		Boolean boo;
//		do {
//			sh = wb.getSheet("input");
//			int randomRow = _utils.getRandNumber(sh.getLastRowNum());
//			System.out.println(randomRow);
//			exStore = new HashMap<String, String>();
//			DataFormatter format = new DataFormatter();
//			for(int i=0; i<=sh.getRow(0).getLastCellNum()-1; i++) {
//				String header_cell = sh.getRow(0).getCell(i).getStringCellValue();
//				String value_cell = format.formatCellValue(sh.getRow(randomRow).getCell(i));
//				exStore.put(header_cell, value_cell);
//			}
//			String rad = exStore.get("radius");
//			String storeid = exStore.get("storeid");
//			if(rad.isEmpty()) 
//				exStore.replace("radius", "0");
//			if(storeid.isEmpty())
//				exStore.replace("storeid", "0");
//			boo = verifyExisting(exStore.get("storeid"));
//		} while(boo==true);
		
		sh = wb.getSheet("input");
		String isProcessed = "";
		DataFormatter format = new DataFormatter();
		exStore = new HashMap<String, String>();
		do {
//			Random rand = new Random();
//			random = rand.nextInt(6)+1;
			random = _utils.getRandNumber(sh.getLastRowNum());
			System.out.println(random);
			isProcessed = format.formatCellValue(sh.getRow(random).getCell(sh.getRow(0).getLastCellNum()-1));
			System.out.println(isProcessed);
		} while(isProcessed.isEmpty()!=true);
		
		for(int i=0; i<=sh.getRow(0).getLastCellNum()-2; i++) {
			String header_cell = sh.getRow(0).getCell(i).getStringCellValue();
			String value_cell = format.formatCellValue(sh.getRow(random).getCell(i));
			exStore.put(header_cell, value_cell);
		}
		String rad = exStore.get("radius");
		if(rad.isEmpty()) 
			exStore.replace("radius", "0");
		System.out.println(exStore);
	
		_testData.setStoreDetails(exStore);
	}

	public static void setStoreProcessed() {
		try {
			sh = wb.getSheet("input");
			row = sh.getRow(random);
			cell = row.createCell(sh.getRow(0).getLastCellNum()-1);
			cell.setCellValue("Yes");
			fos = new FileOutputStream(filePath);
			wb.write(fos);
			fos.flush();
		} catch (Exception e) {
        e.printStackTrace();
		}
	}
	
	
	public static void closeExcel() { 
		
		try {
			wb.close();
			fos.close();
		} catch (Exception e) {
			System.out.println("No workbook instance open "+e);
		}
	}
	
	/* Not Used*/
	/* Verify selected store id present in already processed sheet */
	
//	public static Boolean verifyExisting(String storeId) {
//		sh = wb.getSheet("processed");
//		DataFormatter format = new DataFormatter();
//		int rowCount = sh.getLastRowNum();
//		ArrayList<String> ls = new ArrayList<String>();
//		for (int i=1; i<=rowCount; i++) {
//			String cellValue = format.formatCellValue(_excelUtils.sh.getRow(i).getCell(0));
//			ls.add(i-1, cellValue);
//		}
//		Boolean boo = ls.contains(storeId);
//		return boo;
//	}
	
	
	/* Not Used*/
	/* Update added store in the sheet "processed" */
	
//	public static void updateStoreId(int storeId) {
//		try {
//			sh = wb.getSheet("processed");
//			row = sh.createRow(sh.getLastRowNum()+1);
//			cell = row.createCell(0);
//			cell.setCellValue(storeId);
//			fos = new FileOutputStream(filePath);
//			wb.write(fos);
//			fos.flush();
//		} catch (Exception e) {
//        e.printStackTrace();
//		}
	
}
