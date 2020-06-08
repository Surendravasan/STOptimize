package objRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUtilities._base;

public class _reviewCoveragePopup {
	
	public _reviewCoveragePopup() {
		PageFactory.initElements(_base.driver, this);
	}
	
	protected By loader = By.cssSelector("div.loading");
	
	@FindBy(xpath="//table/ancestor::div[contains(@class,'tab-bx')]//span[contains(text(),'Save')]")
	protected WebElement $saveRevCoverage;
	

}
