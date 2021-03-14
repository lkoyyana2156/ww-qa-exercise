package pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BasePage {
	
	public static WebDriver driver;
	
	@BeforeSuite
	private void driverInitialization() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"\\supportingbinaries\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
	@AfterSuite
	private void driverDispose() {
		
		driver.close();
		driver.quit();
		}
	

}
