package pageMethods;

import objRepository._signInPage;
import pageUtilities._actions;
import pageUtilities._base;
import pageUtilities._propMgr;
import pageUtilities._wait;

public class _signIn extends _signInPage {
	
	public _signIn() {
		super();
	}
	
	public void login() {
		_base.driver.navigate().to(_propMgr.getUrl()+"/signin.html");
		_wait.clickable($username, 20);
		_actions.sendKeys($username, _propMgr.getUsername());
		_actions.sendKeys($password, _propMgr.getPassword());
		_actions.click($loginBtn);
	}

}
