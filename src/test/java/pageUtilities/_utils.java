package pageUtilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _utils {
	
	private static String letters = "abcdefghijklmnopqrstuvwxyz";
	private static char[] alphaNumericString = (letters + letters.toUpperCase() + "0123456789").toCharArray();
	static WebDriverWait wait = new WebDriverWait(_base.driver, 180);
	
	public static void fillData(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	
	public static void submit(WebElement element) {
		int cnt=0;
		do {
			if(element.isDisplayed()==true && element.isEnabled()==true && element!=null) {
				waitForElementClickable(element);
				element.click();
				cnt++;
			}
		} while(cnt==0);
	}
	
	
	public static void clickJs(WebElement ele) {
		JavascriptExecutor executor = (JavascriptExecutor)_base.driver;
		executor.executeScript("arguments[0].click();", ele);
	}
	
	
	public static void dropDownByValue(WebElement ele, String text) {
		Select dropDown = new Select(ele);
		dropDown.selectByValue(text);
	}
	
	
	public static void clickAction(WebElement ele) {
		Actions action = new Actions(_base.driver);
		action.moveToElement(ele).click().perform();
	}
	
	
	public static String getDateTime() {
		Date thisDate = new Date();
		SimpleDateFormat dateForm = new SimpleDateFormat("ddMM'T'HHmmss");
		return dateForm.format(thisDate);
	}
	
	
	public static String getRandString(int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(alphaNumericString[new Random().nextInt(alphaNumericString.length)]);
		}
		return sb.toString();
	}

	
	public static int getRandNumber(int length) {

		Random rand = new Random();
		return rand.nextInt(length)+1;
	}
	
	


	public static void waitForElementClickable(WebElement elmt) {
		wait.until(ExpectedConditions.elementToBeClickable(elmt));
	}
	
	public static void waitForElementInVisibleByLocator(By by) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public static void waitForElementVisibleByLocator(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	
	public static String screenCapture(WebDriver driver)  {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\target\\"+_utils.getDateTime()+".png";
		File destination = new File(dest);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dest;
	}
	

}
