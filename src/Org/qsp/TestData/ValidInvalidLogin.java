package Org.qsp.TestData;

import org.testng.annotations.Test;

import Org.qsp.Genric.BaseTest;
import Org.qsp.pom.ActiTimeLogInPage;
import Org.qsp.pom.HomePage;

public class ValidInvalidLogin extends BaseTest {

	@Test(dataProvider = "readExcel", dataProviderClass = Org.qsp.Genric.Xl.class)
	public void Tc1(String user, String pass) throws Exception {
		ActiTimeLogInPage atl = new ActiTimeLogInPage(driver);
		atl.sendUserName(user);
		atl.sendpassword(pass);
		atl.clickLogIn();
		HomePage hp = new HomePage(driver);
		hp.verifyHomePageIsDisplayed(driver);
	}

}
