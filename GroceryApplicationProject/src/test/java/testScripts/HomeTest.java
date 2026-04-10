package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationCore.testNGBase;
import Pages.LoginPage;
import Pages.HomePage;
import Utilities.ExcelUtility;
import constants.Constant;

public class HomeTest extends testNGBase {
	HomePage home;
	@Test(description = "Validate user is able to successfully Logout")
	public void verifyUserIsAbletoSuccessfullyLogout() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage"); 

		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName).enterPasswordFeild(password);
		home = login.clickLoginButton();

		// For Logout
		//homePage home = new homePage(driver);
		home.clickonAdminProfileIcon();
		login = home.clickonLogoutoption();
		
		String actualText = login.getPageText();
		String expectedText = "7rmart supermarket";
		Assert.assertEquals(actualText, expectedText, Constant.LogoutError);


	}

}
