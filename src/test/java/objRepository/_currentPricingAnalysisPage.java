package objRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUtilities._base;

public class _currentPricingAnalysisPage {
	
	public _currentPricingAnalysisPage() {
		PageFactory.initElements(_base.driver, this);
	}
	
	protected String loading = "div.loading";
	
	/* Overview Header */
	
	@FindBy(xpath="//div[contains(@class,'overview-header')]//h2")
	protected WebElement $unitName;
	
	@FindBy(xpath="//div[contains(@class,'view-top-right')]//h4[contains(text(),'Lowest')]/..//h5")
	protected WebElement $curLowestPrice;
	
	@FindBy(xpath="//div[contains(@class,'view-top-right')]//h4[contains(text(),'Lowest')]/..//p")
	protected WebElement $curLowestStore;
	
	@FindBy(xpath="//div[contains(@class,'view-top-right')]//h4[contains(text(),'Average')]/..//h5")
	protected WebElement $curAveragePrice;
	
	@FindBy(xpath="//div[contains(@class,'view-top-right')]//h4[contains(text(),'Highest')]/..//h5")
	protected WebElement $curHighestPrice;
	
	@FindBy(xpath="//div[contains(@class,'view-top-right')]//h4[contains(text(),'Highest')]/..//p")
	protected WebElement $curHighestStore;
	
	
	protected WebElement $unitStoresOffered(WebDriver driver, int nth) {
		return driver.findElement(By.xpath("(//div[@class='drag-view'])["+nth+"]/p"));
	}
	
	
	
}
