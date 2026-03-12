package seleniumbasic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlinhAlerts extends Base
{
	public void verifySimpleAlert() 
	{
		driver.navigate().to("https://demoqa.com/alerts");
		WebElement simpleAlert = driver.findElement(By.id("alertButton"));
		simpleAlert.click();
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	public void verifyConfirmAlert() 
	{
		driver.navigate().to("https://demoqa.com/alerts");
		WebElement confirmAlert = driver.findElement(By.id("confirmButton"));
		confirmAlert.click();
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}
	public void verifyPromptAlert() 
	{
		driver.navigate().to("https://demoqa.com/alerts");
		WebElement proptAlert = driver.findElement(By.id("promtButton"));
		proptAlert.click();
		Alert al = driver.switchTo().alert();
		al.sendKeys("sneha");
		al.accept();
	}

	public static void main(String[] args) {
		HandlinhAlerts alerts = new HandlinhAlerts();
		alerts.browserLaunch();
		//alerts.verifySimpleAlert();
		//alerts.verifyConfirmAlert();
		alerts.verifyPromptAlert();
		

	}

}
