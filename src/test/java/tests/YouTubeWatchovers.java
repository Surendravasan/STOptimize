package tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YouTubeWatchovers {

	// WebDriver driver;
	ChromeDriver driver;
	static String filePath = "test-input/sabarimala.xls";
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static Workbook wb;
	public static Sheet sh;
	public static Row row;
	public static Cell cell;
	int x = 0;

	@BeforeTest
	public void InitiateBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Surey\\Automation\\ChromeDriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("start-maximized");
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);

		// driver = new ChromeDriver();
		// driver.manage().window().maximize();

		// try {
		// fis = new FileInputStream(filePath);
		// wb = WorkbookFactory.create(fis);
		//
		// } catch (Exception e) {
		// System.out.println("Couldn't able to read Excel file" + e);
		// }
	}

	@Test
	public void startWatchovers() throws InterruptedException {

		int i = 25;
		do {
			x = x + 1;
			driver.get("https://www.youtube.com/watch?v=zlCq6vHLEwo");
			Thread.sleep(3000);
			int a = driver.findElements(By.xpath("//button[@class='ytp-play-button ytp-button'][@title='Play (k)']"))
					.size();
			if (a == 1) {
				driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button'][@title='Play (k)']"))
						.click();
			}
			Thread.sleep(35000);

			driver.get("https://www.youtube.com/watch?v=bZaLfrzIPaA");
			Thread.sleep(3000);
			int b = driver.findElements(By.xpath("//button[@class='ytp-play-button ytp-button'][@title='Play (k)']"))
					.size();
			if (b == 1) {
				driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button'][@title='Play (k)']"))
						.click();
			}
			Thread.sleep(65000);
			i = i - 1;
			System.out.println(x);
		} while (i > 0);
		System.out.println(x);
	}

	@AfterTest
	public void Logout() {
		driver.quit();
	}

}
