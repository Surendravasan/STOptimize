package objRepository;

import java.util.List;

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
	
	protected By loader = By.cssSelector("div.loading");
	
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
	
	
	protected WebElement $breadcrumbDashboard(WebDriver driver, int userStoreId) {
		return driver.findElement(By.cssSelector("li[class*='Breadcrumbs'] a[href*='"+userStoreId+"']"));
	}
	
	
	
	/* All Markets View */
	
//	@FindBy(xpath="//table[contains(@class,'market-table')]/tbody/tr/td[contains(text(),'no competitors available')]")
//	protected WebElement $tableData1;
	
	protected By $tableData = By.xpath("//table[contains(@class,'market-table')]/tbody/tr/td[contains(text(),'no competitors available')]");
	
	@FindBy(xpath="//table[contains(@class,'market-table')]/tbody/tr")
	protected List<WebElement> $rowCount;
	
	@FindBy(xpath="//table[contains(@class,'market-table')]/tbody/tr[1]/td")
	protected List<WebElement> $colCount;
	
	protected WebElement $storeName(WebDriver driver, int rowNo) {
		return driver.findElement(By.xpath("//table[contains(@class,'market-table')]/tbody/tr["+rowNo+"]/td[1]/span[1]"));
	}
	
	protected WebElement $storeAddress(WebDriver driver, int rowNo) {
		return driver.findElement(By.xpath("//table[contains(@class,'market-table')]/tbody/tr["+rowNo+"]/td[1]/span[2]"));
	}
	
	protected WebElement $storeData(WebDriver driver, int rowNo, int colNo) {
		return driver.findElement(By.xpath("//table[contains(@class,'market-table')]/tbody/tr["+rowNo+"]/td["+colNo+"]"));
	}
	
	protected WebElement $storeDataPromo(WebDriver driver, int rowNo, int colNo) {
		return driver.findElement(By.xpath("//table[contains(@class,'market-table')]/tbody/tr["+rowNo+"]/td["+colNo+"]/div/span/span[1]"));
	}
	
	
	
	
	
	
}
