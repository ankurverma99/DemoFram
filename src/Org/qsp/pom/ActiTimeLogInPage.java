package Org.qsp.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTimeLogInPage {

	@FindBy(id = "username")
	private WebElement UserName;

	@FindBy(name = "pwd")
	private WebElement Password;

	@FindBy(id = "loginButton")
	private WebElement loginButton;

	@FindBy(linkText = "Forgot your password?")
	private WebElement forgetpassword;

	@FindBy(xpath = "//a[contains(.,'actiTIME Inc.')]")
	private WebElement actiTimrINC;

	public ActiTimeLogInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void sendUserName(String username) {
		UserName.sendKeys(username);

	}

	public void sendpassword(String password) {
		Password.sendKeys(password);

	}

	public void clickLogIn() {
		loginButton.click();
	}

	public void clickForgetPass() {
		forgetpassword.click();
	}
}
