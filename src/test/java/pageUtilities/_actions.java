package pageUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class _actions {
	
		public static void sendKeys(WebElement ele, String text) {
		ele.sendKeys(text);
	}
	
		public static void click(WebElement ele) {
		ele.click();
	}
		
		public static void clickJs(WebElement ele) {
			JavascriptExecutor executor = (JavascriptExecutor)_browser.driver;
			executor.executeScript("arguments[0].click();", ele);
		}

		public static void dropDownByValue(WebElement ele, String text) {
		Select dropDown = new Select(ele);
		dropDown.selectByValue(text);
	}
		
		public static void clickAction(WebElement ele) {
			Actions action = new Actions(_browser.driver);
			action.moveToElement(ele).click().perform();
		}
}
