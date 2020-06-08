package objRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUtilities._base;

public class _addAddressPopup {
	
	public _addAddressPopup() {
		PageFactory.initElements(_base.driver, this);
	}
	
	protected By loader = By.cssSelector("div.loading");
	protected String state = "//select[@name='state']/option";
	
	@FindBy(name="marketName")
	protected WebElement $marketName;
	
	@FindBy(name="addressLine1")
	protected WebElement $addressLine1;
	
	@FindBy(name="city")
	protected WebElement $city;
	
	@FindBy(xpath="//select[@name='state']/option")
	protected List<WebElement> $state;
	
	@FindBy(name="zipcode")
	protected WebElement $zipCode;
	
	@FindBy(css="button[type='submit']")
	protected WebElement $saveAddress;
	
	@FindBy(xpath="//h2[text()='Address not found']")
	protected List<WebElement> $addrNotFound;
	
	@FindBy(xpath="//h2[text()='Address not found']/../../button")
	protected WebElement $addrNotFoundX;
	

}
