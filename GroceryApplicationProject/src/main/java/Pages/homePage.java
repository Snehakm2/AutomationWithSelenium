package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	public WebDriver driver;

	public homePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminiconField;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logoutField;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	WebElement adminUserTile;

	public void clickonAdminProfileIcon() {
		adminiconField.click();
	}

	public void clickonLogoutoption() {
		logoutField.click();
	}

	// Clicking on MoreInfo in AdminUserTile

	public void clickOnAdminUserTile() {
		adminUserTile.click();
	}

}
