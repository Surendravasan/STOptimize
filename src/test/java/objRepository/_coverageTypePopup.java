package objRepository;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUtilities._browser;

public class _coverageTypePopup {
	
	public _coverageTypePopup() {
		PageFactory.initElements(_browser.driver, this);
	}
	
	protected String loading = "div.loading";
	
	@FindBy(css="button[class*='add']")
	public WebElement $addMarket;
	
	/*	Step 2: Choose Coverage Type  */
//	@FindBy(css="button[type=submit]")
	@FindBy(xpath="//div[contains(text(),'coverage')]/ancestor::form//span[contains(text(),'Save')]")
	public WebElement $saveCoverage;
	
	@FindBy(xpath="//span[contains(@class,'slider')]")
	public WebElement $slider;
	
	@FindBy(xpath="//span[contains(@class,'slider')]/span[contains(@class,'markActive')]")
	public List<WebElement> $sliderPoints;
		
	public WebElement $radius(WebDriver driver, int nth) {
		return driver.findElement(By.xpath("//span[contains(@class,'slider')]/span[contains(@class,'markLabel')][text()="+nth+"]"));
	}
	
	public WebElement $selectMiles(WebDriver driver, int nth) {
		return driver.findElement(By.xpath("//span[contains(@class,'slider')]/span[contains(@class,'markLabel')][text()="+nth+"]"));
	}

}
