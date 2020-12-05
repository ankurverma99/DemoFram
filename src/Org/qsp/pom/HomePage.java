package Org.qsp.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class HomePage {
	public void verifyHomePageIsDisplayed(WebDriver driver) {
		WebDriverWait ww = new WebDriverWait(driver, 10);
		try {
			ww.until(ExpectedConditions.titleContains("Enter"));
			Reporter.log("Home pages is displayed", true);
		} catch (Exception e) {
			Reporter.log("Home page is not displayed", true);
			Assert.fail();
		}
	}

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
