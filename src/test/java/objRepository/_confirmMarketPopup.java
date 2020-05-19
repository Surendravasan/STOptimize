package objRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUtilities._browser;

public class _confirmMarketPopup {
	
	public _confirmMarketPopup() {
		PageFactory.initElements(_browser.driver, this);
	}
	
	protected String loading = "div.loading";
	protected String marketDashboard = "//a[contains(text(),'Market Dashboard')]";
	
	@FindBy(xpath="//a[contains(text(),'Market Dashboard')]")
	public WebElement $getUserStoreId;
	
	@FindBy(xpath="//span[contains(text(),'Go to My Markets')]")
	public WebElement $goToMyMarkets;
	
	

}
