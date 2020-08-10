package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checking_Pending_Leaves_Objects {

	@FindBy(xpath="//*[@id='task-list-group-panel-menu_holder']//following::tr[1]")
	public static WebElement pendingleave;
}
