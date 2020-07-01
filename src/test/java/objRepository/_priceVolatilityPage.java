package objRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUtilities._base;

public class _priceVolatilityPage {
	
	public _priceVolatilityPage() {
		PageFactory.initElements(_base.driver, this);
	}
	
	protected By loader = By.cssSelector("div.loading");
	
	/* Overview Header */
	protected By topHeader = By.cssSelector("div.overview-header.row div[class*='price-top']");
	
	@FindBy(css="div[class*='overview-header'] div[class*='value']")
	protected List<WebElement> $headerCount;
	
	
	protected WebElement $overviewHeaderValue(WebDriver driver, int nth) {
		return driver.findElement(By.xpath("(//div[contains(@class,'overview-header')]//div[contains(@class,'value')])["+nth+"]"));
	}
	
	protected WebElement $overviewHeaderLabel(WebDriver driver, int nth) {
		return driver.findElement(By.xpath("(//div[contains(@class,'overview-header')]//div[contains(@class,'label')][not(contains(@class,'btm'))])["+nth+"]"));
	}
	
	
	protected WebElement $priceVolatility(WebDriver driver, int userStoreid) {
		return driver.findElement(By.xpath("//span[text()='Price Volatility']/ancestor::a[contains(@href,'"+userStoreid+"')]"));
	}
	
	
	
	/* Market Volatility */
	
	protected By currMrktVolGrid = By.cssSelector("div.market-volatility");
	
	@FindBy(css="div.market-volatility thead th")
	protected List<WebElement> $noOfUnits;
	
	@FindBy(css="div.market-volatility tbody td")
	protected List<WebElement> $noOfRows;
	
	protected WebElement $getUnitName(WebDriver driver, int nth) {
		return driver.findElement(By.cssSelector("div.market-volatility thead th:nth-child("+nth+")"));
	}
	
	protected WebElement $getUnitValue(WebDriver driver, int nth) {
		return driver.findElement(By.cssSelector("div.market-volatility tbody td:nth-child("+nth+")"));
	}
	
	
	/* Market Volatility by Store & price*/
	protected By currMrktVolStrPriGrid = By.cssSelector("div[class*='view-market-volatility']");
	
	@FindBy(css="div[class*='view-market-volatility'] tbody tr")
	protected List<WebElement> $noOfStores;
	
	@FindBy(css="div[class*='view-market-volatility'] tbody>tr:nth-child(1) td")
	protected List<WebElement> $noOfColumns;
	
	protected WebElement $getAddress(WebDriver driver, int nth) {
		return driver.findElement(By.cssSelector("div[class*='view-market-volatility'] tbody>tr:nth-child("+nth+")>td>div"));
	}
	
	protected WebElement $getAllPreValPrice(WebDriver driver, int row, int col) {
		return driver.findElement(By.cssSelector("div[class*='view-market-volatility'] tbody>tr:nth-child("+row+") td:nth-child("+col+")"));
	}
	
	
	
	
	
	
	
	

	
}
