package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.LoginPage;
import seleniumbasic.TestNGBase;

public class loginTest extends TestNGBase
{
	@Test
	public void verifyUserLoginwithValidCredentials()
	{
		//WebElement userNameField = driver.findElement(By.id("user-name"));
		//userNameField.sendKeys("standard_user");
		//WebElement passwordField = driver.findElement(By.id("password"));
		//passwordField.sendKeys("secret_sauce");
		//WebElement submitButton = driver.findElement(By.id("login-button"));
		//submitButton.click();
		LoginPage login = new LoginPage(driver);
		login.enterUsernameFeild();
		login.enterPasswordFeild();
		login.clickLoginButton();
		
	}
	
	@Test
	public void verifyUserLoginwithValidUsernameInvalidPassword()
	{
		WebElement userNameField = driver.findElement(By.id("user-name"));
		userNameField.sendKeys("standard_user");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("standard_user1");
		WebElement submitButton = driver.findElement(By.id("login-button"));
		submitButton.click();
		
	}
	
	@Test
	public void verifyUserLoginwithInvalidUsernameValidPassword()
	{
		WebElement userNameField = driver.findElement(By.id("user-name"));
		userNameField.sendKeys("Sneha");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("secret_sauce");
		WebElement submitButton = driver.findElement(By.id("login-button"));
		submitButton.click();
		
	}
	
	@Test
	public void verifyUserLoginwithInvalidCredentials()
	{
		WebElement userNameField = driver.findElement(By.id("user-name"));
		userNameField.sendKeys("sneha");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("standard_user1");
		WebElement submitButton = driver.findElement(By.id("login-button"));
		submitButton.click();
		
	}
}
