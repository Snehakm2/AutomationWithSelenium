package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import AutomationCore.testNGBase;
import Pages.LoginPage;
import Pages.ManageNewsPage;
import Pages.homePage;
import Utilities.ExcelUtility;

public class ManageNewsTest extends testNGBase
{
	@Test(priority = 1, description = "Validating Whether User Is Able To Add A New News")
	public void VerifyWhetherUserIsAbleToAddANewNews() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName);
		login.enterPasswordFeild(password);
		login.clickLoginButton();

		homePage home = new homePage(driver);
		home.clickOnManageNewsTile();

		String newNewsText = ExcelUtility.readStringData(0, 0, "ManageNewsPage");

		ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
		manageNewsPage.clickOnNewNewsButton();
		manageNewsPage.enterNewNewsOnManageNewsField(newNewsText);
		manageNewsPage.clickOnSaveButton();
	}

	@Test(priority = 2, description = "Validating Whether User Is Able To Search A News")
	public void VerifyWhetherUserIsAbleToSearchANews() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName);
		login.enterPasswordFeild(password);
		login.clickLoginButton();

		homePage home = new homePage(driver);
		home.clickOnManageNewsTile();

		String searchNewsText = ExcelUtility.readStringData(0, 0, "ManageNewsPage");

		ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
		manageNewsPage.clickOnSearchButton();
		manageNewsPage.searchForANews(searchNewsText);
		manageNewsPage.clickOnSearchSubmitButton();
	}

	@Test(priority = 3, description = "Validating Whether User Is Able To Reset The Data")
	public void VerifyWhetherUserIsAbleToResetTheData() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName);
		login.enterPasswordFeild(password);
		login.clickLoginButton();

		homePage home = new homePage(driver);
		home.clickOnManageNewsTile();

		ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
		manageNewsPage.resetAction();
	}

}
