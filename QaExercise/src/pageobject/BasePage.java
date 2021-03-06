package pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BasePage{
	
	private final int TIME_OUT = 15;
	public static WebDriver driver;   //Defining driver object
	
	/*
	 * Initializing webdriver
	 * Maximizing the window after launch
	 * setting driver implicit wait
	 */
	@BeforeSuite  
	private void driverInitialization() 
	{
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"\\supportingbinaries\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	/*
	 * Closing browser 
	 * Quitting driver instance
	 */
	@AfterSuite
	private void driverDispose()
	{
		
		driver.close();
		driver.quit();
	}
}
