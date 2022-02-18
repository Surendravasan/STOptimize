package pageMethods;

import org.openqa.selenium.By;

import pageUtilities._base;
import pageUtilities._utils;

public class SabarimalaPilgrimBook {

	public int pilgrimBook(int pilgrim) {

		int isBooked = 0;

		_utils.clickJs(_base.driver.findElement(By.xpath("//button[text()=' Select Pilgrim ']")));

		_utils.clickJs(_base.driver.findElement(By.cssSelector("div.mat-select-value")));

		_utils.clickJs(
				_base.driver.findElement(By.cssSelector("div[class^='mat-select-panel'] mat-option:nth-child(4)")));

		_utils.waitForElementVisibleByLocator(
				By.xpath("//mat-cell[contains(@class,'cdk-column-index') and contains(text(),' " + pilgrim
						+ " ')]/..//label/div"));

		_utils.clickJs(_base.driver
				.findElement(By.xpath("//mat-cell[contains(@class,'cdk-column-index') and contains(text(),' " + pilgrim
						+ " ')]/..//label/div")));

		// hardcoded to select more than one pilgrim
		_utils.clickJs(_base.driver.findElement(
				By.xpath("//mat-cell[contains(@class,'cdk-column-index') and contains(text(),' 48 ')]/..//label/div")));

		_utils.clickJs(_base.driver.findElement(By.xpath("//button[text()=' Submit ']")));
		System.out.println("Pilgrim Selected");

		_utils.waitForElementVisibleByLocator(By.xpath("//button[text()=' Add to Wishlist ']"));
		_utils.clickJs(_base.driver.findElement(By.xpath("//button[text()=' Add to Wishlist ']")));
		System.out.println("Added to Wishlist");

		_utils.waitForElementVisibleByLocator(By.cssSelector("app-wishlist div.row>div.button>button:nth-child(2)"));
		_utils.clickJs(_base.driver.findElement(By.cssSelector("app-wishlist div.row>div.button>button:nth-child(2)")));
		System.out.println("Reached Payment Gateway");

		_utils.waitForElementVisibleByLocator(
				By.cssSelector("form[name='paymentForm'] div.row>div>button#regi_continue"));
		_utils.clickJs(
				_base.driver.findElement(By.cssSelector("form[name='paymentForm'] div.row>div>button#regi_continue")));
		System.out.println("Booked");

		int bookedPopup = 0, unavailableText = 0;
		do {
			bookedPopup = _base.driver.findElements(By.cssSelector("button.btn.btn-addto-pop")).size();

			unavailableText = _base.driver
					.findElements(By.xpath("//div[contains(text(),'Sorry, this service is not available')]")).size();
		} while (bookedPopup == 0 && unavailableText == 0);

		if (bookedPopup == 1) {
			// _utils.waitForElementVisibleByLocator(By.cssSelector("button.btn.btn-addto-pop"));
			// _utils.clickJs(_base.driver.findElement(By.cssSelector("button.btn.btn-addto-pop")));
			//
			// _utils.waitForElementVisibleByLocator(By.cssSelector("span[routerlink='/darshan'].nav-link-clr"));
			// _utils.clickJs(_base.driver.findElement(By.cssSelector("span[routerlink='/darshan'].nav-link-clr")));

			_base.driver.navigate().to("https://sabarimalaonline.org/#/darshan");
			isBooked = 1;
		}

		if (unavailableText == 1) {
			// _utils.waitForElementVisibleByLocator(By.cssSelector("span[routerlink='/darshan'].nav-link-clr"));
			// _utils.clickJs(_base.driver.findElement(By.cssSelector("span[routerlink='/darshan'].nav-link-clr")));
			_base.driver.navigate().to("https://sabarimalaonline.org/#/darshan");

			// clear wishlist
			_utils.waitForElementVisibleByLocator(By.cssSelector("div.item div.row button#regi_continue"));
			_utils.clickJs(_base.driver.findElement(By.cssSelector("div.item div.row button#regi_continue")));

			_utils.waitForElementVisibleByLocator(By.cssSelector("div.feedback_form button.btn.btn-addto-pop"));
			_utils.clickJs(_base.driver.findElement(By.cssSelector("div.feedback_form button.btn.btn-addto-pop")));
			System.out.println("Wishlist Cleared");

		}

		return isBooked;
	}

}
