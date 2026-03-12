package seleniumbasic;

public class BrowserAndNavigationCommands extends Base {
	
	public void verifyBrowserCommands() 
	{
		String title =driver.getTitle();
		System.out.println(title);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String source = driver.getPageSource();
		System.out.println(source);
		String handleId = driver.getWindowHandle();
		System.out.println(handleId);
	}
	public void verifyNavigationCommands() 
	{
		driver.navigate().to("https://www.amazon.in/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}

	public static void main(String[] args) {
	BrowserAndNavigationCommands browser = new BrowserAndNavigationCommands();
	browser.browserLaunch();
	//browser.verifyBrowserCommands();
	browser.verifyNavigationCommands();


	}

}
