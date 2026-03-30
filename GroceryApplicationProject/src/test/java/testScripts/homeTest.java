package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationCore.testNGBase;
import Pages.LoginPage;
import Pages.homePage;
import Utilities.ExcelUtility;
import constants.Constant;

public class homeTest extends testNGBase {
	@Test(description = "Validate user is able to successfully Logout")
	public void verifyUserIsAbletoSuccessfullyLogout() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage"); 

		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName);
		login.enterPasswordFeild(password);
		login.clickLoginButton();

		// For Logout
		homePage home = new homePage(driver);
		home.clickonAdminProfileIcon();
		home.clickonLogoutoption();
		
		String actualText = login.getPageText();
		String expectedText = "7rmart supermarket";
		Assert.assertEquals(actualText, expectedText, Constant.LogoutError);


	}

}
