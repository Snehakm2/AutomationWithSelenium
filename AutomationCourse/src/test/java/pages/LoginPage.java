package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
public WebDriver driver;

public LoginPage(WebDriver driver) 
{
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(id="user-name") WebElement userNameField;
@FindBy(id="password") WebElement passwordField;
@FindBy(id="login-button") WebElement submitButton;

public void enterUsernameFeild()
{
	userNameField.sendKeys("standard_user");
}
public void enterPasswordFeild()
{
	passwordField.sendKeys("secret_sauce");
}
public void clickLoginButton()
{
	submitButton.click();
}

}
