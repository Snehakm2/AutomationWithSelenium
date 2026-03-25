package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import AutomationCore.testNGBase;
import Pages.AdminUserPage;
import Pages.LoginPage;
import Pages.homePage;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;

public class AdminUserTest extends testNGBase {
	@Test(priority = 1, description = "Validating Whether User Is Able To Add A New User")
	public void VerifyWhetherUserIsAbleToAddANewUser() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName);
		login.enterPasswordFeild(password);
		login.clickLoginButton();

		homePage home = new homePage(driver);
		home.clickOnAdminUserTile();

		FakerUtility faker = new FakerUtility();
		String newUserName = faker.createRandomUserName();
		String newPassword = faker.createRandomPassword();	
		//String newUserName = ExcelUtility.readStringData(0, 0, "AdminUsersPage");
		//String newPassword = ExcelUtility.readStringData(0, 1, "AdminUsersPage");

		AdminUserPage admin = new AdminUserPage(driver);
		admin.clickOnNewButton();
		admin.enterNewUserNameOnUserNameField(newUserName);
		admin.enterNewPasswordOnPasswordField(newPassword);
		admin.clickOnNewUserTypeDropDown();
		admin.selectUserTypeFromUserTypeDropDown();

	}

	@Test(priority = 2, description = "Validating Whether User Is Able To Search User")
	public void VerifyWhetherUserIsAbleToSearchUser() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName);
		login.enterPasswordFeild(password);
		login.clickLoginButton();

		homePage home = new homePage(driver);
		home.clickOnAdminUserTile();

		String newUserName = ExcelUtility.readStringData(0, 0, "AdminUsersPage");

		AdminUserPage admin = new AdminUserPage(driver);
		admin.clickOnSearchButton();
		admin.searchUsingUserName(newUserName);
		admin.clickOnSearchUserTypeDropDown();
		admin.selectFromSearchUserTypeDropDown();
	}

	@Test(priority = 3, description = "Validating Whether User Is Able To Rest Users List")
	public void VerifyWhetherUserIsAbleToRestUsersList() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName);
		login.enterPasswordFeild(password);
		login.clickLoginButton();

		homePage home = new homePage(driver);
		home.clickOnAdminUserTile();

		AdminUserPage admin = new AdminUserPage(driver);
		admin.resetAction();
	}

}
