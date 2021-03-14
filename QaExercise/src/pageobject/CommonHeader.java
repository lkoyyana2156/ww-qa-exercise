package pageobject;

import org.openqa.selenium.By;

public class CommonHeader extends BasePage {
	
	private By _attendDropDown = By.xpath("//*[contains(@class,'NavigationSlice_containerRight')]//button[@da-label='Attend']");
	private By _unlimitedWorkshops = By.xpath("//div[@id='overlay-provider']//a[@da-label='Unlimited Workshops']");
	
	public void clickAttend() {
		driver.findElement(_attendDropDown).click();
	}
	
	public void clickUnlimitedWorkShops() {
		driver.findElement(_unlimitedWorkshops).click();
	}

}
