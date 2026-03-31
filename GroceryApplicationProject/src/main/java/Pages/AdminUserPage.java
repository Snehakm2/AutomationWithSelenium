package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {
	public WebDriver driver;
	
	public AdminUserPage(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// for adding New user
	@FindBy(xpath = "//a[@href='javascript:void(0)' and @onclick='click_button(1)']")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement newUserField;
	@FindBy(xpath = "//input[@id='password']")
	WebElement newPasswordField;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement newUserTypeDropDown;
	@FindBy(xpath = "//button[@name='Create' and @class='btn btn-block-sm btn-danger']")
	WebElement newUserSaveButton;
	
	// for searching user
	@FindBy(xpath = "//a[@href='javascript:void(0)' and @onclick='click_button(2)']")
	WebElement searchButton;
	@FindBy(name = "un")
	WebElement searchUserField;
	@FindBy(name = "ut")
	WebElement searchUserTypeDropDown;
	@FindBy(xpath = "//button[@name='Search' and @class='btn btn-block-sm btn-danger']")
	WebElement searchUserBtn;
	
	// for reset option
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='btn btn-rounded btn-warning']")
	WebElement resetButton;
	
	
	public AdminUserPage clickOnNewButton() {
		newButton.click();
		return this;
	}

	public AdminUserPage enterNewUserNameOnUserNameField(String newUserName) {
		newUserField.sendKeys(newUserName);
		return this;
	}

	public AdminUserPage enterNewPasswordOnPasswordField(String newPassword) {
		newPasswordField.sendKeys(newPassword);
		return this;
	}

	public AdminUserPage clickOnNewUserTypeDropDown() { 
		newUserTypeDropDown.click();
		return this;
	}

	public AdminUserPage selectUserTypeFromUserTypeDropDown() {
		Select select = new Select(newUserTypeDropDown);
		select.selectByIndex(2);
		newUserSaveButton.click();
		return this;
	}
	
	public AdminUserPage clickOnSearchButton() {
		searchButton.click();
		return this;
	}

	public AdminUserPage searchUsingUserName(String newUserName) {
		searchUserField.sendKeys(newUserName);
		return this;
	}

	public AdminUserPage clickOnSearchUserTypeDropDown() {
		searchUserTypeDropDown.click();
		return this;
	}

	public AdminUserPage selectFromSearchUserTypeDropDown() {
		Select select = new Select(searchUserTypeDropDown);
		select.selectByIndex(2);
		searchUserBtn.click();
		return this;
	}
	
	public AdminUserPage resetAction() 
	{
		resetButton.click();
		return this;
	}
	
	public boolean isNewAdminUsersPageDisplayed() 
	{
		return newUserSaveButton.isEnabled();
	}

	public boolean isSearchAdminUsersPageDisplayed() 
	{
		return searchUserBtn.isEnabled();
	}
	
}
