package test_cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import common_actions.Login_Logout;
import page_objects.Checking_Pending_Leaves_Objects;



public class Pending_Leav_Check extends Login_Logout{
	public String value;
	
	@Test
	public void leavecheck() throws InterruptedException {

		PageFactory.initElements(driver, Checking_Pending_Leaves_Objects.class);
		Thread.sleep(3000);
		value=Checking_Pending_Leaves_Objects.pendingleave.getText();
		System.out.println(value);

	}
}

