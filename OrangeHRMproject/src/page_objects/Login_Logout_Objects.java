package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Logout_Objects {
	
@FindBy(name="txtUsername")
public static WebElement UserName;

@FindBy(name="txtPassword")
public static WebElement PassWord;

@FindBy(name="Submit")
public static WebElement Login_Button;

@FindBy(id="welcome")
public static WebElement Welcome_Admin;

@FindBy(xpath="//*[text()='Logout']")
public static WebElement Logout_Button;
}
