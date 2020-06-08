package objRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUtilities._base;

public class _confirmMarketPopup {
	
	public _confirmMarketPopup() {
		PageFactory.initElements(_base.driver, this);
	}
	
	protected By loader = By.cssSelector("div.loading");
	protected String marketDashboard1 = "//a[contains(text(),'Market Dashboard')]";
	protected By $marketDashboard = By.xpath("//a[contains(text(),'Market Dashboard')]");
	
	@FindBy(xpath="//a[contains(text(),'Market Dashboard')]")
	protected WebElement $getUserStoreId;
	
	@FindBy(xpath="//span[contains(text(),'Go to My Markets')]")
	protected WebElement $goToMyMarkets;
	
	

}
