package test_cases;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import common_actions.Login_Logout;
import page_objects.UserRoleStatus_Objects;

public class UserRoleStatus extends Login_Logout{
@Test
	public void checkuserrole() throws InterruptedException  {
		
		PageFactory.initElements(driver, UserRoleStatus_Objects.class);
		
		  Actions actions= new Actions(driver);
		  actions.moveToElement(UserRoleStatus_Objects.AdminLink);
		  actions.moveToElement(UserRoleStatus_Objects.UserManagementLink);
		  actions.moveToElement(UserRoleStatus_Objects.UsersLink); 
		  actions.build().perform();
		  UserRoleStatus_Objects.UsersLink.click();
		  
		  
		  Select selectrole=new Select(UserRoleStatus_Objects.UserRole);
		  selectrole.selectByIndex(1);
		  
		  Select selectstatus=new Select(UserRoleStatus_Objects.status);
		  selectstatus.selectByIndex(1); UserRoleStatus_Objects.search.click();
		  
		  String User=UserRoleStatus_Objects.UserRole_result.getText(); 
		  String Status=UserRoleStatus_Objects.status_result.getText(); 
		  Assert.assertEquals(User, "Admin");
		  Assert.assertEquals(Status, "Enabled");
}
}
