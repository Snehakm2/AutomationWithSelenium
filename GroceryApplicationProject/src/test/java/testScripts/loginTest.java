package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import AutomationCore.testNGBase;
import Pages.LoginPage;
import Pages.homePage;
import Utilities.ExcelUtility;
import constants.Constant;

public class loginTest extends testNGBase {
homePage home;
	@Test(priority = 1, description = "Validating user login with Valid credentials", groups = {"smoke"})
	public void verifyUserLoginwithValidCredentials() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName).enterPasswordFeild(password);
		home = login.clickLoginButton();
		
		boolean dashboardDisplayed = login.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplayed, Constant.validCredError);
	}

	@Test(priority = 2, description = "Validating user login Valid Username and Invalid Password credentials")
	public void verifyUserLoginwithValidUsernameInvalidPassword() throws IOException {
		String userName = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName).enterPasswordFeild(password).clickLoginButton();
		
		String actualText = login.getPageText();
		String expectedText = "7rmart supermarket";
		Assert.assertEquals(actualText, expectedText, Constant.InvalidLoginPasswordError);

	}

	@Test(priority = 3, description = "Validating user login with Invalid Username Valid Password credentials")
	public void verifyUserLoginwithInvalidUsernameValidPassword() throws IOException {
		String userName = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName).enterPasswordFeild(password).clickLoginButton(); 
		
		boolean loginPageDisplayed = login.isLoginPageDisplayed();
		Assert.assertTrue(loginPageDisplayed, Constant.InvalidLoginUsernameError);

	} 

	@Test(priority = 4, description = "Validating user login with Invalid credentials", groups = {"smoke"} ,dataProvider = "loginProvider")
	public void verifyUserLoginwithInvalidCredentials(String userName,String password) throws IOException {
		//String userName = ExcelUtility.readStringData(3, 0, "LoginPage");
		//String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName).enterPasswordFeild(password).clickLoginButton();
		
		boolean loginPageDisplayed = login.isLoginPageDisplayed();
		Assert.assertFalse(!loginPageDisplayed, Constant.InvalidLoginCredError);

	} 
	 @DataProvider(name = "loginProvider") 
	 	public Object[][] getDataFromDataProvider() throws IOException { 
	  
	 		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" }, 
	 				// new Object[] {ExcelUtility.getStringData(3, 
	 				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")} 
	 		}; 
	 	}

}
