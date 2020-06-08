package pageUtilities;

import org.openqa.selenium.support.ui.WebDriverWait;


	public class _wait {
		
		static WebDriverWait wait = new WebDriverWait(_base.driver, 180);
		
//		public static void visibleXpath(String elmt, int time) {
////			WebDriverWait wait = new WebDriverWait(_base.driver, time);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elmt)));
//		}
	
//		public static void visibleCss(String elmt, int time) {
////			WebDriverWait wait = new WebDriverWait(_base.driver, time);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elmt)));
//		}
	
//		public static void inVisibleCss(String elmt, int time) {
////			WebDriverWait wait = new WebDriverWait(_base.driver, time);
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(elmt)));
//		}
	
//		public static void clickable(WebElement elmt, int time) {
////			WebDriverWait wait = new WebDriverWait(_base.driver, time);
//			wait.until(ExpectedConditions.elementToBeClickable(elmt));
//		}
		
//		public static void waitForElementInVisibleByLocator(By by) {
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
//		}
		
//		public static void waitForElementVisibleByLocator(By by) {
//			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//		}
}
