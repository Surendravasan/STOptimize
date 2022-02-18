package pageMethods;

import org.openqa.selenium.By;

import pageUtilities._base;
import pageUtilities._utils;

public class SabarimalaMonthSelection {

	public void gotoMonth(String month) {
		String monthValue = _base.driver
				.findElement(By.cssSelector("div.mat-calendar-header>div>button[class*='period']>span")).getText();

		if (month.equalsIgnoreCase("nov")) {
			if (monthValue.contains("OCT")) {
				_utils.clickJs(_base.driver.findElement(By.cssSelector("button.mat-calendar-next-button")));
			} else if (monthValue.contains("DEC")) {
				_utils.clickJs(_base.driver.findElement(By.cssSelector("button.mat-calendar-previous-button")));
			} else if (monthValue.contains("JAN")) {
				_utils.clickJs(_base.driver.findElement(By.cssSelector("button.mat-calendar-previous-button")));
				_utils.clickJs(_base.driver.findElement(By.cssSelector("button.mat-calendar-previous-button")));
			}
		} else if (month.equalsIgnoreCase("dec")) {
			if (monthValue.contains("OCT")) {
				_utils.clickJs(_base.driver.findElement(By.cssSelector("button.mat-calendar-next-button")));
				_utils.clickJs(_base.driver.findElement(By.cssSelector("button.mat-calendar-next-button")));
			} else if (monthValue.contains("NOV")) {
				_utils.clickJs(_base.driver.findElement(By.cssSelector("button.mat-calendar-next-button")));
			} else if (monthValue.contains("JAN")) {
				_utils.clickJs(_base.driver.findElement(By.cssSelector("button.mat-calendar-previous-button")));
			}
		} else if (month.equalsIgnoreCase("jan")) {
			if (monthValue.contains("OCT")) {
				_utils.clickJs(_base.driver.findElement(By.cssSelector("button.mat-calendar-next-button")));
				_utils.clickJs(_base.driver.findElement(By.cssSelector("button.mat-calendar-next-button")));
				_utils.clickJs(_base.driver.findElement(By.cssSelector("button.mat-calendar-next-button")));
			} else if (monthValue.contains("NOV")) {
				_utils.clickJs(_base.driver.findElement(By.cssSelector("button.mat-calendar-next-button")));
				_utils.clickJs(_base.driver.findElement(By.cssSelector("button.mat-calendar-next-button")));
			} else if (monthValue.contains("DEC")) {
				_utils.clickJs(_base.driver.findElement(By.cssSelector("button.mat-calendar-next-button")));
			}
		}

		// System.out.println("Changed Calendar to the specific Month");
	}
}
