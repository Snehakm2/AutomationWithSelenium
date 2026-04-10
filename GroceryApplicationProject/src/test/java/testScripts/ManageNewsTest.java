package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationCore.testNGBase;
import Pages.LoginPage;
import Pages.ManageNewsPage;
import Pages.HomePage;
import Utilities.ExcelUtility;
import constants.Constant;

public class ManageNewsTest extends testNGBase
{
	ManageNewsPage manageNewsPage;
	HomePage home;
	
	@Test(priority = 1, description = "Validating Whether User Is Able To Add A New News")
	public void VerifyWhetherUserIsAbleToAddANewNews() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName).enterPasswordFeild(password);
		home = login.clickLoginButton();

		//homePage home = new homePage(driver);
		manageNewsPage = home.clickOnManageNewsTile();

		String newNewsText = ExcelUtility.readStringData(0, 0, "ManageNewsPage");

		//ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
		manageNewsPage.clickOnNewNewsButton().enterNewNewsOnManageNewsField(newNewsText).clickOnSaveButton();
		
		boolean newManageNewsSaveButton  = manageNewsPage.isManageNewsNewPageDisplayed();
		Assert.assertFalse(newManageNewsSaveButton, Constant.AddNewManageNewsError);
	}

	@Test(priority = 2, description = "Validating Whether User Is Able To Search A News")
	public void VerifyWhetherUserIsAbleToSearchANews() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName).enterPasswordFeild(password);
		home = login.clickLoginButton();

		//homePage home = new homePage(driver);
		manageNewsPage = home.clickOnManageNewsTile();

		String searchNewsText = ExcelUtility.readStringData(0, 0, "ManageNewsPage");

		//ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
		manageNewsPage.clickOnSearchButton();
		manageNewsPage.searchForANews(searchNewsText);
		manageNewsPage.clickOnSearchSubmitButton();
		
		boolean searchManageNewsSubmitButton = manageNewsPage.isSearchManageNewsPageDisplayed();
		Assert.assertTrue(searchManageNewsSubmitButton, Constant.SearchManageNewsError);
	}

	@Test(priority = 3, description = "Validating Whether User Is Able To Reset The Data")
	public void VerifyWhetherUserIsAbleToResetTheData() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName).enterPasswordFeild(password);
		home = login.clickLoginButton();

		//homePage home = new homePage(driver); 
		manageNewsPage = home.clickOnManageNewsTile();

		//ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
		manageNewsPage.resetAction();
		
		boolean searchManageNewsSubmitButton = manageNewsPage.isSearchManageNewsPageDisplayed();
		boolean resetManageNewsTable = manageNewsPage.isResetManageNewsPageDisplayed();
		Assert.assertEquals(!searchManageNewsSubmitButton, resetManageNewsTable, Constant.ResetManageNewsError);
	}

}
