package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import AutomationCore.testNGBase;
import Pages.LoginPage;
import Utilities.ExcelUtility;
import constants.Constant;

public class loginTest extends testNGBase {

	@Test(priority = 1, description = "Validating user login with Valid credentials", groups = {"smoke"})
	public void verifyUserLoginwithValidCredentials() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName);
		login.enterPasswordFeild(password);
		login.clickLoginButton();
		
		boolean dashboardDisplayed = login.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplayed, Constant.validCredError);
	}

	@Test(priority = 2, description = "Validating user login Valid Username and Invalid Password credentials")
	public void verifyUserLoginwithValidUsernameInvalidPassword() throws IOException {
		String userName = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName);
		login.enterPasswordFeild(password);
		login.clickLoginButton();
		
		String actualText = login.getPageText();
		String expectedText = "7rmart supermarket";
		Assert.assertEquals(actualText, expectedText, Constant.InvalidLoginPasswordError);

	}

	@Test(priority = 3, description = "Validating user login with Invalid Username Valid Password credentials")
	public void verifyUserLoginwithInvalidUsernameValidPassword() throws IOException {
		String userName = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName);
		login.enterPasswordFeild(password);
		login.clickLoginButton(); 
		
		boolean loginPageDisplayed = login.isLoginPageDisplayed();
		Assert.assertTrue(loginPageDisplayed, Constant.InvalidLoginUsernameError);

	} 

	@Test(priority = 4, description = "Validating user login with Invalid credentials", groups = {"smoke"})
	public void verifyUserLoginwithInvalidCredentials() throws IOException {
		String userName = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName);
		login.enterPasswordFeild(password);
		login.clickLoginButton();
		
		boolean loginPageDisplayed = login.isLoginPageDisplayed();
		Assert.assertFalse(!loginPageDisplayed, Constant.InvalidLoginCredError);

	}

}
