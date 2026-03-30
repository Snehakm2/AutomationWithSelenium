package constants;

public class Constant 
{
	public static final String TestDataFile = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
	public static final String ConfigFile = System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
	
	// Assertion Error Message
	// Login
	public static final String validCredError = "User unable to login with valid credentials";
	public static final String InvalidLoginPasswordError = "User was able to login using Invalid Password";
	public static final String InvalidLoginUsernameError = "User was able to login using Invalid Username";
	public static final String InvalidLoginCredError = "Logged in with invalid creds";
	
	// Home
	public static final String LogoutError = "User was unable to log out from the application";
	
	// AdminUsers
	public static final String AddNewAdminUserError = "User was unable to add a New User";
	public static final String SearchAdminUserError = "User was unable to Search for a User";
	public static final String ResetAdminUserError = "User was unable to reset the Admin User Page";
	
	// Manage News
	public static final String AddNewManageNewsError = "User was unable to add a New News";
	public static final String SearchManageNewsError = "User was unable to Search for a News";
	public static final String ResetManageNewsError = "User was unable to reset the Manage News Page";
}
