package objRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUtilities._browser;

public class _signInPage {
	
	public _signInPage() {
		PageFactory.initElements(_browser.driver, this);
	}
	
	protected String loading = "div.loading";
	
	@FindBy(id="usernme")
	public WebElement $username;
	
	@FindBy(id="pass")
	public WebElement $password;
	
	@FindBy(id="btn")
	public WebElement $loginBtn;


}
