package Org.qsp.TestData;

import org.testng.annotations.Test;

import Org.qsp.Genric.BaseTest;
import Org.qsp.Genric.Xl;
import Org.qsp.pom.ActiTimeLogInPage;
import Org.qsp.pom.HomePage;

public class ValidLogIn extends BaseTest {
	@Test
	public void TcValidLogin() throws Exception {
		String username = Xl.readCell(XL_data + Xl_File, sheetName, 1, 0);
		String password = Xl.readCell(XL_data + Xl_File, sheetName, 1, 1);

		ActiTimeLogInPage atl = new ActiTimeLogInPage(driver);
		atl.sendUserName(username);
		atl.sendpassword(password);
		atl.clickLogIn();
		HomePage hp = new HomePage(driver);
		hp.verifyHomePageIsDisplayed(driver);

	}

}
