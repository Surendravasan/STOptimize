package objRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUtilities._base;

public class _dashboardPage {
	
	public _dashboardPage() {
		PageFactory.initElements(_base.driver, this);
	}
	
	protected By loader = By.cssSelector("div.loading");
	protected static By $unitDetails = By.cssSelector("div.market-Card");
	
	@FindBy(css="div.drag-view")
	protected WebElement $preDefBox;
		
	@FindBy(css="div.drag-view")
	protected List<WebElement> $preDefBoxCount;
	
	protected static WebElement $unitName(WebDriver driver, int nth) {
//	    String unitName = "(//div[@class='drag-view']//h5/span)['defUnit']";
//	    return driver.findElement(By.xpath(unitName.replace("defUnit", id)));
		return driver.findElement(By.xpath("(//div[@class='drag-view']//h5/span)["+nth+"]"));
	}
	
	protected WebElement $unitName(WebDriver driver, String unit) {
		return driver.findElement(By.xpath("//span[text()='"+unit+"']"));
	}
	
	protected WebElement $unitStoresOffered(WebDriver driver, int nth) {
		return driver.findElement(By.xpath("(//div[@class='drag-view'])["+nth+"]/p"));
	}
	
	protected WebElement $unitStoresOffered(WebDriver driver, String unit) {
		return driver.findElement(By.xpath("//span[text()='"+unit+"']//ancestor::div[@class='drag-view']/p"));
	}
	
	protected WebElement $unitAvgPrice(WebDriver driver, int nth) {
		return driver.findElement(By.xpath("(//div[@class='drag-view'])["+nth+"]//span[contains(@class,'price-show')]"));
	}
	
	protected WebElement $unitAvgPrice(WebDriver driver, String unit) {
		return driver.findElement(By.xpath("//span[text()='"+unit+"']//ancestor::div[@class='drag-view']//span[contains(@class,'price-show')]"));
	}
	
	protected WebElement $unitPriceTrend(WebDriver driver, int nth) {
		return driver.findElement(By.xpath("(//div[@class='drag-view'])["+nth+"]//span[@class='na-count']/span[1]"));
	}
	
	protected WebElement $unitPriceTrend(WebDriver driver, String unit) {
		return driver.findElement(By.xpath("//span[text()='"+unit+"']//ancestor::div[@class='drag-view']//span[@class='na-count']/span[1]"));
	}
	
	protected WebElement $unitYourPrice(WebDriver driver, int nth) {
		return driver.findElement(By.xpath("(//div[@class='drag-view'])["+nth+"]//div[@class='your-price']/div[@class='prices']"));
	}
	
	protected WebElement $unitYourPrice(WebDriver driver, String unit) {
		return driver.findElement(By.xpath("//span[text()='"+unit+"']//ancestor::div[@class='drag-view']//div[@class='prices']"));
	}
	
	protected WebElement $unitViewDetails(WebDriver driver, int nth) {
		return driver.findElement(By.xpath("(//div[@class='drag-view'])["+nth+"]//div[@class='view-Details']//a"));
	}
	
	protected WebElement $unitViewDetails(WebDriver driver, String unit) {
		return driver.findElement(By.xpath("//span[text()='"+unit+"']//ancestor::div[@class='drag-view']//div[@class='view-Details']//a"));
	}
	
	
	
	
	
	
	
	
	
	
}
