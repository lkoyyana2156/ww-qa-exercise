package pageobject;

import org.openqa.selenium.By;

public class WorkshopSearchResultsPage extends BasePage {
	
	private By _locationTitle = By.xpath("//*[@id='search-results']/div[1]//a[contains(@class,'linkUnderline')]");
	private By _locationDistance = By.xpath("//*[@id='search-results']/div[1]//span");
	
	public String getLocationTitle() {
		return driver.findElement(_locationTitle).getText();
	}
	
	public String getLocationDistance() {
		return driver.findElement(_locationDistance).getText();
	}
	
	public void clickSearchResult() {
		driver.findElement(_locationTitle).click();
	}

}
