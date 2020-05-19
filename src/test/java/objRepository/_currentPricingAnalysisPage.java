package objRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUtilities._browser;

public class _currentPricingAnalysisPage {
	
	public _currentPricingAnalysisPage() {
		PageFactory.initElements(_browser.driver, this);
	}
	
	protected String loading = "div.loading";
	
	@FindBy(xpath="//div[contains(@class,'view-top-right')]//h4[contains(text(),'Lowest')]/..//p")
	public WebElement $currLowStore;
	
	@FindBy(xpath="//div[contains(@class,'view-top-right')]//h4[contains(text(),'Highest')]/..//p")
	public WebElement $currHighStore;
	
	@FindBy(xpath="//div[contains(@class,'view-top-right')]//h4[contains(text(),'Lowest')]/..//h5")
	public WebElement $currLowPrice;
	
	@FindBy(xpath="//div[contains(@class,'view-top-right')]//h4[contains(text(),'Average')]/..//h5")
	public WebElement $currAvgPrice;
	
	@FindBy(xpath="//div[contains(@class,'view-top-right')]//h4[contains(text(),'Lowest')]/..//h5")
	public WebElement $currHighPrice;
	
	
	public WebElement $unitStoresOffered(WebDriver driver, int nth) {
		return driver.findElement(By.xpath("(//div[@class='drag-view'])["+nth+"]/p"));
	}
	
	
	
}
