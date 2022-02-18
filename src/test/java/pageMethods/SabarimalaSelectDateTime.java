package pageMethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;

import pageUtilities._base;
import pageUtilities._utils;

public class SabarimalaSelectDateTime {

	SabarimalaPilgrimBook pilgrimBook = new SabarimalaPilgrimBook();
	Date d = new Date();

	public int selectDateTime(String bookDate, String time, String pilgrimid) {
		int isPilgrimBooked = 0;
		// System.out.println(bookDate);
		// System.out.println(time);
		// System.out.println(pilgrimid);

		String monthValue = _base.driver
				.findElement(By.cssSelector("div.mat-calendar-header>div>button[class*='period']>span")).getText();
		String year = (monthValue.contains(" JAN ")) ? "2022" : "2021";
		String className = _base.driver
				.findElement(By.xpath(
						"//tbody//td[(@role='gridcell') and (contains(@aria-label, '" + bookDate + " " + year + "'))]"))
				.getAttribute("class");

		if (!className.contains("disabled")) {
			System.out.println(bookDate);
			_utils.clickJs(_base.driver.findElement(By.xpath(
					"//tbody//td[(@role='gridcell') and (contains(@aria-label, '" + bookDate + " " + year + "'))]")));

			int pilgrimId = Integer.parseInt(pilgrimid);
			System.out.println(pilgrimId);

			if (time.equalsIgnoreCase("0")) {
				int size = _base.driver.findElements(By.xpath("//div[@id='myName_0']")).size();
				System.out.println("Time Available?: " + size);

				if (size != 0) {
					String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
					System.out.println(timeStamp);

					String isAvailable = _base.driver
							.findElement(By.xpath("//div[@id='myName_0']/following-sibling::div")).getText();
					System.out.println(isAvailable);

					String timeStamp1 = new SimpleDateFormat("yyyyMMdd_HHmmss")
							.format(Calendar.getInstance().getTime());
					System.out.println(timeStamp1);

					if (!isAvailable.endsWith("1")) {

						String timeStamp2 = new SimpleDateFormat("yyyyMMdd_HHmmss")
								.format(Calendar.getInstance().getTime());
						System.out.println(timeStamp2);

						_utils.clickJs(_base.driver.findElement(By.xpath("//div[@id='myName_0']")));

						String timeStamp3 = new SimpleDateFormat("yyyyMMdd_HHmmss")
								.format(Calendar.getInstance().getTime());
						System.out.println(timeStamp3);

						int booked = pilgrimBook.pilgrimBook(pilgrimId);
						if (booked == 1) {
							isPilgrimBooked = 1;
						}
					}
				}

			} else {
				// int size = _base.driver.findElements(By.xpath("//div[text()='
				// +time+ ']")).size();
				// System.out.println("Time Available?: " + size);

				Set<String> list = new HashSet<String>();
				int count = _base.driver.findElements(By.xpath("//div[contains(@id,'myName')]")).size();
				for (int i = 0; i < count; i++) {
					String timings = _base.driver.findElement(By.xpath("//div[contains(@id,'myName_" + i + "')]"))
							.getText();
					list.add(timings);
				}
				System.out.println(list);
				Boolean avail = list.contains(time);
				System.out.println(avail);

				if (avail.equals(true)) {
					_utils.clickJs(_base.driver.findElement(
							By.xpath("//div[contains(@id,'myName_') and starts-with(text(),' " + time + "')]")));
					int booked = pilgrimBook.pilgrimBook(pilgrimId);
					if (booked == 1) {
						isPilgrimBooked = 1;
					}
				}
			}
		}
		return isPilgrimBooked;
	}
}
