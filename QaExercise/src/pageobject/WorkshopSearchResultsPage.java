package pageobject;

import org.openqa.selenium.By;

public class WorkshopSearchResultsPage extends BasePage {
	
	private By getLocationTitleBy(int index)
	{
		return By.xpath("//*[@id='search-results']/div["+index+"]//a[contains(@class,'linkUnderline')]");
	}
	
	private By getLocationDistanceBy(int index)
	{
		return By.xpath("//*[@id='search-results']/div["+index+"]//span");
	}
	
	/*
	 * Get location title from the search results
	 * @param index Index of the search results
	 * @return location title as a string
	 */
	public String getLocationTitle(int index) 
	{
		return driver.findElement(getLocationTitleBy(index)).getText();
	}
	
	/*
	 * Get location Distance
	 * @param index Index of the search results
	 * @return distance as a string
	 */
	public String getLocationDistance(int index) 
	{
		return driver.findElement(getLocationDistanceBy(index)).getText();
	}
	
	/*
	 * Click search result link
	 * @param index Index of the search results
	 */
	public void clickSearchResult(int index)
	{
		driver.findElement(getLocationTitleBy(index)).click();
	}

}
