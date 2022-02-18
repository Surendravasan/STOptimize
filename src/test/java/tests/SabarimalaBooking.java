package tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageMethods.SabarimalaMonthSelection;
import pageMethods.SabarimalaSelectDateTime;
import pageUtilities._base;
import pageUtilities._utils;

public class SabarimalaBooking extends _base {

	static String filePath = "test-input/sabarimala.xls";
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static Workbook wb;
	public static Sheet sh;
	public static Row row;
	public static Cell cell;

	SabarimalaSelectDateTime dateTime = new SabarimalaSelectDateTime();
	SabarimalaMonthSelection navigateMonth = new SabarimalaMonthSelection();

	@BeforeTest
	public void InitializeBrowser() {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Surey\\Automation\\ChromeDriver\\chromedriver.exe");
		// _base.driver = new ChromeDriver();
		// _base.driver.manage().window().maximize();
		System.out.println("Hai");

		try {
			fis = new FileInputStream(filePath);
			wb = WorkbookFactory.create(fis);

		} catch (Exception e) {
			System.out.println("Couldn't able to read Excel file" + e);
		}

	}

	@Test(priority = 1)
	public void Login() {

		_base.driver.get("https://sabarimalaonline.org/#/login");

		_base.driver.findElement(By.id("email")).sendKeys("9994642235");
		_base.driver.findElement(By.id("password")).sendKeys("Sindhu@89");
		_base.driver.findElement(By.id("regi_continue")).click();

		_utils.waitForElementInVisibleByLocator(By.id("loader"));
		_utils.waitForElementVisibleByLocator(By.cssSelector("button.btn.btn-clear-pop "));
		_utils.waitForElementInVisibleByLocator(By.id("loader"));

		_base.driver.findElement(By.xpath("//button[text()=' Ok ']")).click();
		_base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// wait till entire page gets loaded
		refresh();
		// _base.driver.manage().timeouts().implicitlyWait(10,
		// TimeUnit.SECONDS);
		// _utils.waitForElementInVisibleByLocator(By.id("loader"));
		// _utils.waitForElementVisibleByLocator(
		// By.xpath("//div[@class='col-sm-12
		// heading_tag_dar']/span[contains(text(),' 180 minutes')]"));

	}

	// refresh till page completely loads
	void refresh() {
		int pageLoaded = 0;
		do {
			_base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			_utils.waitForElementInVisibleByLocator(By.id("loader"));
			pageLoaded = _base.driver
					.findElements(
							By.xpath("//div[@class='col-sm-12 heading_tag_dar']/span[contains(text(),' 180 minutes')]"))
					.size();
			if (pageLoaded == 0) {
				_base.driver.navigate().refresh();
			}
		} while (pageLoaded == 0);
	}

	@Test(priority = 2)
	public void bookTicket() {

		// read sheet
		sh = wb.getSheet("input");

		int pendingRequest = 0;
		do {
			for (int i = 1; i <= sh.getLastRowNum(); i++) {

				// open calendar
				_utils.waitForElementVisibleByLocator(By.cssSelector("button.mat-icon-button"));
				_utils.clickJs(driver.findElement(By.cssSelector("button.mat-icon-button")));

				cell = sh.getRow(i).getCell(4);
				// System.out.println(cell);
				String isBooked = (cell == null || cell.getCellType() == CellType.BLANK) ? "no" : "yes";
				System.out.println("PilgrimNo: " + sh.getRow(i).getCell(3) + " booked? - " + isBooked);
				// pendingRequest = (isBooked.equalsIgnoreCase("no")) ? 1 : 0;

				if (isBooked.equalsIgnoreCase("no")) {
					String month = sh.getRow(i).getCell(0).toString();
					// System.out.println(month);
					int pilgrimBooked;

					switch (month) {
					case "nov":
						navigateMonth.gotoMonth(month);
						pilgrimBooked = dateTime.selectDateTime(sh.getRow(i).getCell(1).toString(),
								sh.getRow(i).getCell(2).toString(), sh.getRow(i).getCell(3).toString());
						if (pilgrimBooked == 1) {
							setPilgrimBooked(i);
						}
						break;

					case "dec":
						navigateMonth.gotoMonth(month);
						pilgrimBooked = dateTime.selectDateTime(sh.getRow(i).getCell(1).toString(),
								sh.getRow(i).getCell(2).toString(), sh.getRow(i).getCell(3).toString());
						if (pilgrimBooked == 1) {
							setPilgrimBooked(i);
						}
						break;

					case "jan":
						navigateMonth.gotoMonth(month);
						pilgrimBooked = dateTime.selectDateTime(sh.getRow(i).getCell(1).toString(),
								sh.getRow(i).getCell(2).toString(), sh.getRow(i).getCell(3).toString());
						if (pilgrimBooked == 1) {
							setPilgrimBooked(i);
						}
						break;
					}
				}
			}

			// refresh the page
			_base.driver.navigate().refresh();

			// wait till entire page gets loaded
			refresh();
			// _base.driver.manage().timeouts().implicitlyWait(10,
			// TimeUnit.SECONDS);
			// _utils.waitForElementInVisibleByLocator(By.id("loader"));
			// _utils.waitForElementVisibleByLocator(
			// By.xpath("//div[@class='col-sm-12
			// heading_tag_dar']/span[contains(text(),' 180 minutes')]"));

			System.out.println("-------------------------");

		} while (pendingRequest == 0);

	}

	void setPilgrimBooked(int rowId) {
		try {
			sh = wb.getSheet("input");
			row = sh.getRow(rowId);
			cell = row.createCell(sh.getRow(rowId).getLastCellNum());
			cell.setCellValue("Yes");
			fos = new FileOutputStream(filePath);
			wb.write(fos);
			fos.flush();
			System.out.println("Excel Updated");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterTest
	public void Logout() {
		driver.quit();
	}

}
