package pageUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


enum conditions {
	VisibleXpath("visibilityOfElementLocated"),InVisibleXpath("invisibilityOfElementLocated");
	
private final String shortCode;
	
	conditions(String code) {
		this.shortCode = code;
	}
	
	public String getDirectionCode() {
		return this.shortCode;
	}
	
}

public class _wait {

	public static void visibleXpath(String elmt, int time) {
		WebDriverWait wait = new WebDriverWait(_browser.driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elmt)));
	}
	
	public static void visibleCss(String elmt, int time) {
		WebDriverWait wait = new WebDriverWait(_browser.driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elmt)));
	}
	
	public static void inVisibleCss(String elmt, int time) {
		WebDriverWait wait = new WebDriverWait(_browser.driver, time);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(elmt)));
	}
	
	public static void clickable(WebElement elmt, int time) {
		WebDriverWait wait = new WebDriverWait(_browser.driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(elmt));
	}
	

}
