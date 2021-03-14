package pageobject;

import org.openqa.selenium.By;

public class StudioModule extends BasePage {
	
	private By _locationTextbox = By.id("location-search");
	private By _enterButton = By.id("location-search-cta");
	
	/*
	 * Enter location text
	 * @param location string value
	 */
	public void enterLocation(String location)
	{
		driver.findElement(_locationTextbox).sendKeys(location);
	}
	
	/*
	 * Click enter
	 */
	public void clickEnter()
	{
		driver.findElement(_enterButton).click();
	}
}
