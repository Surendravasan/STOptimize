package objRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUtilities._base;

public class _reviewCoveragePopup {
	
	public _reviewCoveragePopup() {
		PageFactory.initElements(_base.driver, this);
	}
	
	protected String loading = "div.loading";
	
//	@FindBy(xpath="//span[contains(text(),'Save')]")
	@FindBy(xpath="//table/ancestor::div[contains(@class,'tab-bx')]//span[contains(text(),'Save')]")
	public WebElement $saveRevCoverage;
	

}
