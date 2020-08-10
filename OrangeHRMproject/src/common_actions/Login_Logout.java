package common_actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import page_objects.Login_Logout_Objects;

public class Login_Logout {

	public static Properties properties=null;
	public static WebDriver driver;
	public static Logger logger=Logger.getLogger(Login_Logout.class);

	public Properties LoadPropertyFile() throws IOException {
		PropertyConfigurator.configure("logger.properties");
		FileInputStream fileInputStream= new FileInputStream("configuration.properties");
		properties=new Properties();
		properties.load(fileInputStream);
		return properties;
	}
	@BeforeSuite
	public void LuanchBrowser() throws IOException {
		logger.info("load property file");
		LoadPropertyFile();
		String location=properties.getProperty("location");
		String url=properties.getProperty("URL");
		System.setProperty("webdriver.chrome.driver", location);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		logger.info("Opening the chrome");
		driver.navigate().to(url);
		logger.info("Orange HRM Login Page");
	}
	
	@BeforeTest
	public void LogIn() {

		PageFactory.initElements(driver, Login_Logout_Objects.class);
		Login_Logout_Objects.UserName.sendKeys(properties.getProperty("USERNAME"));
		Login_Logout_Objects.PassWord.sendKeys(properties.getProperty("PASSWORD"));
		Login_Logout_Objects.Login_Button.click();
		logger.info("User Logged in");
	}
	@AfterTest
	public void LogOut() throws InterruptedException {
		PageFactory.initElements(driver, Login_Logout_Objects.class);
		WebDriverWait wait= new WebDriverWait(driver,10);
		WebElement welcome_button= wait.until(ExpectedConditions.elementToBeClickable((By.id("welcome"))));
		welcome_button.click();
		WebDriverWait wait2= new WebDriverWait(driver,10);
		WebElement logout= wait2.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[text()='Logout']"))));
		logout.click();
		logger.info("User Logged out");

	}

	@AfterSuite
	public void Close_Browser() {
		driver.quit();
	}
	

}
