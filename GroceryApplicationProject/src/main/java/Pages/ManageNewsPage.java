package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage 
{
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// for adding news
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add' and @onclick='click_button(1)']")
	WebElement newButtonNews;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newNewsField;
	@FindBy(xpath = "//button[@name='create' and @class='btn btn-danger']")
	WebElement newNewsSaveButton;

	// for searching  news
	@FindBy(xpath = "//a[@href='javascript:void(0)' and @onclick='click_button(2)']")
	WebElement searchButton;
	@FindBy(xpath = "//input[@name='un']")
	WebElement searchNewsField;
	@FindBy(xpath = "//button[@name='Search' and @class='btn btn-danger btn-fix']")
	WebElement searchNewsSubmitButton;
	
	// For Reset Option
		@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='btn btn-rounded btn-warning']")
		WebElement resetButton;
		
		// Assertion
		@FindBy(xpath = "//h4[text()='Manage News']") WebElement newsListHeader;
		
		

		public void clickOnNewNewsButton() {
			newButtonNews.click();
		}

		public void enterNewNewsOnManageNewsField(String newNewsText)
		{
			newNewsField.sendKeys(newNewsText);
		}

		public void clickOnSaveButton() 
		{
			newNewsSaveButton.click();
		}

		public void clickOnSearchButton() 
		{
			searchButton.click();
		}

		public void searchForANews(String searchNewsText) 
		{
			searchNewsField.sendKeys(searchNewsText);
		}

		public void clickOnSearchSubmitButton() 
		{
			searchNewsSubmitButton.click();
		}

		public void resetAction() 
		{
			resetButton.click();
		}
		
		// Assertion
		public boolean isManageNewsNewPageDisplayed() 
		{
			return newNewsSaveButton.isDisplayed();
		}

		public boolean isSearchManageNewsPageDisplayed() 
		{
			return searchNewsSubmitButton.isDisplayed();
		}
		
		public boolean isResetManageNewsPageDisplayed() 
		{
			return newsListHeader.isDisplayed();
		}

}
