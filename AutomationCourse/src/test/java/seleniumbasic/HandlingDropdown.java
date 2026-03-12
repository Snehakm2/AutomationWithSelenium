package seleniumbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdown extends Base 
{
	public void verifyDropdown() 
	{
		driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		WebElement dropDown1 = driver.findElement(By.id("dropdowm-menu-1"));
		Select select = new Select(dropDown1);
		//select.selectByIndex(1);
		//select.selectByValue("sql");
		select.selectByVisibleText("Python");
	}
	public void verifyCheckBox() 
	{
		driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		WebElement checkbox = driver.findElement(By.xpath("//input[@value='option-1']"));
		checkbox.click();
		System.out.println(checkbox.isSelected()); 
	}
	public void verifyRadioButton() 
	{
		driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		WebElement radioButton = driver.findElement(By.xpath("//input[@value='green']"));
		radioButton.click();
		
	}

	public static void main(String[] args) 
	{
		HandlingDropdown drop = new HandlingDropdown();
		drop.browserLaunch();
		//drop.verifyDropdown();
		drop.verifyCheckBox();
		//drop.verifyRadioButton();

	}

}
