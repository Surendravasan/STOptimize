package objRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUtilities._base;

public class _myMarketPage {
	
	public _myMarketPage() {
		PageFactory.initElements(_base.driver, this);
	}
	
	protected By loader = By.cssSelector("div.loading");
	protected String dashboard = "td[class*='market-name'] a[href*='";
	protected String $marketsTable = "div[class*='table']";
	protected By $tableData = By.cssSelector("table tbody tr");
	protected By $addMarketLabel = By.cssSelector("button[class*='add']");

	@FindBy(css="button[class*='add']")
	protected WebElement $addMarketBtn;
	
	@FindBy(css="div.drag-view h5 span")
	protected WebElement $unitName;
	
	protected WebElement $dashboardLink(WebDriver driver, int userStoreId) {
		return driver.findElement(By.cssSelector("td[class*='market-name'] a[href$='"+userStoreId+"']"));
	}
}
