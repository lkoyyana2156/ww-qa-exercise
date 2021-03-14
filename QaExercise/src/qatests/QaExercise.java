package qatests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import enums.DayEnums;
import pageobject.BasePage;
import pageobject.CommonHeader;
import pageobject.FindAWorkshopPage;
import pageobject.StudioDetailsPage;
import pageobject.WorkshopSearchResultsPage;

public class QaExercise extends BasePage{
	
	public CommonHeader CommonHeader = new CommonHeader();
	public FindAWorkshopPage FindAWorkshopPage = new FindAWorkshopPage();
	public StudioDetailsPage StudioDetailsPage = new StudioDetailsPage();
	public WorkshopSearchResultsPage WorkshopSearchResultsPage = new WorkshopSearchResultsPage();

	@Test
	public void validateQaExercise() throws Exception
	{
		String websiteUrl = "https://www.weightwatchers.com/us/";
		String homePageTitle = "WW (Weight Watchers): Weight Loss & Wellness Help | WW USA";
		String workshopPageTitle = "Find WW Studios & Meetings Near You | WW USA";
		String locationZipCode = "10011";
		int rowIndex = 1;
				
		driver.get(websiteUrl);
		
		try
		{
			assertEquals(driver.getTitle(),homePageTitle);
		}
		catch(Error e)
		{
			System.out.println("********* Home Page Title Assertion******");
			System.out.println(e);
		}
		
		CommonHeader.clickAttend();
		CommonHeader.clickUnlimitedWorkShops();
		FindAWorkshopPage.clickStudio();
		
		try
		{
			assertEquals(driver.getTitle(),workshopPageTitle);
		}
		catch(Error e)
		{
			System.out.println("********* Workshop Page Title Assertion******");
			System.out.println(e);
		}
		
		FindAWorkshopPage.StudioModule.enterLocation(locationZipCode);
		FindAWorkshopPage.StudioModule.clickEnter();
		
		String firstResultTitle = WorkshopSearchResultsPage.getLocationTitle(rowIndex);
		
		System.out.println("********* First Result Title And Distance******");
		System.out.println("Title: "+firstResultTitle);
		System.out.println("Distance: " + WorkshopSearchResultsPage.getLocationDistance(rowIndex));
		
		WorkshopSearchResultsPage.clickSearchResult(rowIndex);
		
		try
		{
			assertEquals(StudioDetailsPage.getLocationTitle(),firstResultTitle);
		}
		catch(Error e)
		{
			System.out.println("********* Search Result Title Assertion******");
			System.out.println(e);
		}
		StudioDetailsPage.expandBusinessHours();
		
		System.out.println("*********Today's Business Hours******");
		System.out.println(StudioDetailsPage.getTodaysHoursOfOperation());
		
		System.out.println("*********Studio Schedule******");
		try
		{
			HashMap<String, Integer> schedule =	StudioDetailsPage.getStudioSchedule(DayEnums.Tuesday);
			for(String s: schedule.keySet())
			{
				System.out.println(s+ " "+schedule.get(s));
			}
		}
		catch(Error e)
		{
			System.out.println(e.getMessage());
		}	
		
		System.out.println("*********Virtual Schedule******");
		
		try
		{
			HashMap<String, Integer> schedule =	StudioDetailsPage.getVirtualSchedule(DayEnums.Tuesday);
			for(String s: schedule.keySet())
			{
				System.out.println(s+ " "+schedule.get(s));
			}
		}
		catch(Error e)
		{
			System.out.println(e.getMessage());
		}	
		
		System.out.println("*********Combined Schedule******");
		try
		{
			HashMap<String, Integer> schedule =	StudioDetailsPage.getCombinedSchedule(DayEnums.Thursday);
			for(String s: schedule.keySet())
			{
				System.out.println(s+ " "+schedule.get(s));
			}
		}
		catch(Error e)
		{
			System.out.println(e.getMessage());
		}	
	}
}
