package objRepository;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUtilities._browser;

public class _addAddressPopup {
	
	public _addAddressPopup() {
		PageFactory.initElements(_browser.driver, this);
	}
	
	protected String loading = "div.loading";
	protected String state = "//select[@name='state']/option";
	
	@FindBy(name="marketName")
	public WebElement $marketName;
	
	@FindBy(name="addressLine1")
	public WebElement $addressLine1;
	
	@FindBy(name="city")
	public WebElement $city;
	
	@FindBy(xpath="//select[@name='state']/option")
	public List<WebElement> $state;
	
	@FindBy(name="zipcode")
	public WebElement $zipCode;
	
	@FindBy(css="button[type='submit']")
	public WebElement $saveAddress;
	
	@FindBy(xpath="//h2[text()='Address not found']")
	public List<WebElement> $addrNotFound;
	
	@FindBy(xpath="//h2[text()='Address not found']/../../button")
	public WebElement $addrNotFoundX;
	

}
