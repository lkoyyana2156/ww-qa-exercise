package pageobject;

import org.openqa.selenium.By;

public class FindAWorkshopPage extends BasePage {
	
	private By _studioButton = By.xpath("//*[@id='search-container']//span[text()='Studio']");
	
	public StudioModule StudioModule = new StudioModule();
	
	/*
	 * Click Studio link
	 */
	public void clickStudio() 
	{
		driver.findElement(_studioButton).click();
	}
}
