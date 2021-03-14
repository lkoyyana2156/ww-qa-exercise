package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.*;

import enums.DayEnums;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class StudioDetailsPage extends BasePage{
	
	private By _businessHoursLink = By.xpath("//*[contains(@class,'hours')]/div[contains(@class,'title')]");
	private By _locationTitle = By.xpath("//h1[contains(@class,'locationName')]");
	
	private By getStudioScheduleBy(int index) {
		return By.xpath("((//div[contains(@class,'scheduleContainerMobile')])[1]//div[contains(@class,'day')])["+index+"]/div/span");
	}
	private By getVirtualScheduleBy(int index) {
		return By.xpath("((//div[contains(@class,'scheduleContainerMobile')])[2]//div[contains(@class,'day')])["+index+"]/div/span");
	}
	private By getTimeBy(int index) {
		return By.xpath("(//div[contains(@class,'times')])["+index+"]");
	}
	
	private static List<WebElement> elements;
	
	public void expandBusinessHours() {
		driver.findElement(_businessHoursLink).click();
	}
	
	public String getTodaysHoursOfOperation() {
		Calendar calendar = Calendar.getInstance();
        int dayIndex = calendar.get(Calendar.DAY_OF_WEEK);
        return driver.findElement(getTimeBy(dayIndex)).getText();
	}
	
	public HashMap<String,Integer> getStudioSchedule(DayEnums day) throws Exception{
		switch(day){
				case Sunday:
					elements = driver.findElements(getStudioScheduleBy(1));
					break;
				case Monday:
					elements = driver.findElements(getStudioScheduleBy(2));
					break;
				case Tuesday:
					elements = driver.findElements(getStudioScheduleBy(3));
					break;
				case Wednesday:
					elements = driver.findElements(getStudioScheduleBy(4));
					break;
				case Thursday:
					elements = driver.findElements(getStudioScheduleBy(5));
					break;
				case Friday:
					elements = driver.findElements(getStudioScheduleBy(6));
					break;
				case Saturday:
					elements = driver.findElements(getStudioScheduleBy(7));
					break;
				default:
					throw new Exception("No valid DayEnum found");	
		}
		if(elements.size()>0) {
			
			HashMap<String, Integer> schedule = new HashMap<String, Integer>();
			for(int i = 1; i<elements.size(); i=i+2) {
				schedule.put(elements.get(i).getText(), schedule.getOrDefault(elements.get(i).getText(), 0)+1);
			}
			
			return schedule;
		}
		
		else {
			throw new Error("No Schedule Found");
		}
		
	}
	
	public HashMap<String,Integer> getVirtualSchedule(DayEnums day) throws Exception{
			switch(day){
				case Sunday:
					elements = driver.findElements(getVirtualScheduleBy(1));
					break;
				case Monday:
					elements = driver.findElements(getVirtualScheduleBy(2));
					break;
				case Tuesday:
					elements = driver.findElements(getVirtualScheduleBy(3));
					break;
				case Wednesday:
					elements = driver.findElements(getVirtualScheduleBy(4));
					break;
				case Thursday:
					elements = driver.findElements(getVirtualScheduleBy(5));
					break;
				case Friday:
					elements = driver.findElements(getVirtualScheduleBy(6));
					break;
				case Saturday:
					elements = driver.findElements(getVirtualScheduleBy(7));
					break;
				default:
					throw new Exception("No valid DayEnum found");	
			}
			
			if(elements.size()>0) {
				
				HashMap<String, Integer> schedule = new HashMap<String, Integer>();
				for(int i = 1; i<elements.size(); i=i+2) {
					schedule.put(elements.get(i).getText(), schedule.getOrDefault(elements.get(i).getText(), 0)+1);
				}
				
				return schedule;
			}
			
			else {
				throw new Error("No Schedule Found");
			}
	}
	public HashMap<String,Integer> getCombinedSchedule(DayEnums day) throws Exception{
		
		HashMap<String, Integer> studioMap = getStudioSchedule(day);
		HashMap<String, Integer> virtualMap = getVirtualSchedule(day);
		for(String s: studioMap.keySet()) {
			if(virtualMap.containsKey(s)) {
				virtualMap.put(s,virtualMap.get(s)+studioMap.get(s));
			}
			else {
				virtualMap.put(s,studioMap.get(s));
			}
		}
		
		return virtualMap;
	}
	
	public String getLocationTitle() {
		return driver.findElement(_locationTitle).getText();
	}
	

}
