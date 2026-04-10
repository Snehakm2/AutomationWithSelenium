package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.waitUtility;

public class LoginPage {
	public WebDriver driver;
	waitUtility wait = new waitUtility();

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="username") WebElement userNameField;
	@FindBy(name="password") WebElement passwordField;
	@FindBy(xpath="//button[text()='Sign In']") WebElement submitButton;
	@FindBy(xpath = "//p[text() = 'Dashboard']") WebElement dashboard;
	@FindBy(xpath = "//b[text()='7rmart supermarket']") WebElement pageText;

	public LoginPage enterUsernameFeild(String userName)
	{
		userNameField.sendKeys(userName);
		return this;
	}
	public LoginPage enterPasswordFeild(String password)
	{
		passwordField.sendKeys(password);
		return this;
	}
	public HomePage clickLoginButton()
	{
		wait.waitUntilElementToBeClickable(driver, submitButton);
		submitButton.click();
		return new HomePage(driver);
	}
;
	//Assertion
	public boolean isDashboardDisplayed() 
	{
		return dashboard.isDisplayed();
	}
	public boolean isLoginPageDisplayed() 
	{
		return pageText.isDisplayed();
	}
	
	public String getPageText() 
	{ 
		return pageText.getText();
	}
}
