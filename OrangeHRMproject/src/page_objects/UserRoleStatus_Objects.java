package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRoleStatus_Objects {
	@FindBy(xpath="//*[text()='Admin']")

	public static WebElement AdminLink;

	@FindBy(xpath="//*[text()='User Management']")

	public static WebElement UserManagementLink;

	@FindBy(xpath="//*[text()='Users']")

	public static WebElement UsersLink;

	@FindBy(id="searchSystemUser_userType")
	public static WebElement UserRole;

	@FindBy(id="searchSystemUser_status")
	public static  WebElement status;

	@FindBy(id="searchBtn")
	public static WebElement search;
	
	@FindBy(xpath="//tr/td[3]")
	public static WebElement UserRole_result;

	@FindBy(xpath="//tr/td[5]")
	public static  WebElement status_result;
}
