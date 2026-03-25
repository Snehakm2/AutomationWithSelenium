package seleniumbasic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
public WebDriver driver;
public void browserLaunch()
{
	driver =new ChromeDriver();
	driver.get("https://selenium.qabible.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
}
public void closeandquit()
{
	//driver.close();
	driver.quit();
}
	public static void main(String[] args) {
		Base base =new Base();
		base.browserLaunch();
		base.closeandquit();
	}

}
