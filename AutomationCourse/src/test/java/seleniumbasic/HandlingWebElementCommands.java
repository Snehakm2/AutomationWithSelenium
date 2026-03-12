package seleniumbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingWebElementCommands  extends Base{
	public void verifyWebElement() 
	{
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		
		WebElement messagebox = driver.findElement(By.id("single-input-field"));
		messagebox.sendKeys("test message");
		
		WebElement showButton = driver.findElement(By.id("button-one"));
		System.out.println(showButton.isDisplayed());
		System.out.println(showButton.isEnabled());
		showButton.click();
		
		
		WebElement yourmessage = driver.findElement(By.id("message-one"));
		System.out.println(yourmessage.getText());
		
		messagebox.clear();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlingWebElementCommands commands = new HandlingWebElementCommands();
		commands.browserLaunch();
		commands.verifyWebElement();
	}

}
