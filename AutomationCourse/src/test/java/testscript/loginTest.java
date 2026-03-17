package testscript;

import java.io.IOException;
import org.testng.annotations.Test;
import Utilities.ExcelUtility;
import Pages.LoginPage;
import seleniumbasic.TestNGBase;

public class loginTest extends TestNGBase
{ 
	@Test
	public void verifyUserLoginwithValidCredentials() throws IOException
	{
		//WebElement userNameField = driver.findElement(By.id("user-name"));
		//userNameField.sendKeys("standard_user");
		//WebElement passwordField = driver.findElement(By.id("password"));
		//passwordField.sendKeys("secret_sauce");
		//WebElement submitButton = driver.findElement(By.id("login-button"));
		//submitButton.click();
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
	    LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName);
		login.enterPasswordFeild(password);
		login.clickLoginButton();
		
	}
	
	@Test
	public void verifyUserLoginwithValidUsernameInvalidPassword() throws IOException
	{
		String userName = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
	    LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName);
		login.enterPasswordFeild(password);
		login.clickLoginButton();
		
	}
	
	@Test
	public void verifyUserLoginwithInvalidUsernameValidPassword() throws IOException
	{
		String userName = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
	    LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName);
		login.enterPasswordFeild(password);
		login.clickLoginButton();
		
	}
	
	@Test
	public void verifyUserLoginwithInvalidCredentials() throws IOException
	{
		String userName = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
	    LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild(userName);
		login.enterPasswordFeild(password);
		login.clickLoginButton();
		
	}
}
