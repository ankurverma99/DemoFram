package Org.qsp.Genric;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConst {
	public WebDriver driver = null;

	@BeforeMethod
	public void OpenBrowser() {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(chrome_key, chrome_value);
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty(firefox_key, firefox_value);
			driver = new FirefoxDriver();
		} else {
			Reporter.log("Browser is not valid ", true);
		}
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser(ITestResult testResult) throws Exception {
		String name = testResult.getName();
		int status = testResult.getStatus();
		if (status == 1)
			Reporter.log("Testcase " + name + " is pass ", true);
		else {
			ScreenShot.takeScreenS(driver, imgFolder, name);
			Reporter.log("Testcase " + name + " is fail ", true);
		}
		driver.close();
	}

}
