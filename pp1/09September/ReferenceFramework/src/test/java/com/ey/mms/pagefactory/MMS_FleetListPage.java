/**
 * @Copyright Copyright (C) 2016 General Electric Company. All rights reserved.
 */
package com.ey.mms.pagefactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ey.mms.util.EY_FW_Utility;

import net.serenitybdd.core.pages.PageObject;

/**
* <h1>Fleet List Page Class</h1>
* MMS FleetListPage Class containing Page Functions for Fleet List.
* @author  Ankur Chaudhry
* @version 1.1
* @since   2016-07-17
*/

public class MMS_FleetListPage extends PageObject {

	private Logger APP_LOGS = null;
	
	private Logger setLogger(){
		if (APP_LOGS==null)
			APP_LOGS = LogManager.getLogger(MMS_FleetListPage.class.getName());
		return APP_LOGS;	
	}
	
	public void clickFleetFilterButton() {
		try{
		setLogger().info("[MMS_FleetListPage : clickFleetFilterButton] Clicking Fleek filter button");
		EY_FW_Utility.doWait(5000);
		EY_FW_Utility.getAnyElementByAnyLocator(MMS_Locators.FLEET_BUTTON_LOCATOR).click();
		}
		catch(Exception e){
			setLogger().error("[MMS_FleetListPage : clickFleetFilterButton] Exception thrown -- " + EY_FW_Utility.getStackTrace(e));	
	    	Assert.assertTrue(false, e.getMessage()); 
	    }
	}

	public void enterFleetCarInital() {
		try{
		setLogger().info("[MMS_FleetListPage : enterFleetCarInital] Entering fleet car initial as AOKR");
		EY_FW_Utility.getAnyElementByAnyLocator(MMS_Locators.FLEET_CARINITIAL_INPUTBOX_LOCATOR).sendKeys("AOKR");
		}
		catch(Exception e){
		setLogger().error("[MMS_FleetListPage : enterFleetCarInital] Exception thrown -- " + EY_FW_Utility.getStackTrace(e));	
    	Assert.assertTrue(false, e.getMessage()); 
		}
	}

	public void clickFleetFilterSaveButton() {
		try{
		setLogger().info("[MMS_FleetListPage : clickFleetFilterSaveButton] Clicking Fleet Filter Save Button");
		EY_FW_Utility.doWait(5000);
		EY_FW_Utility.getAnyElementByAnyLocator(MMS_Locators.FLEET_FILTER_SAVE_BUTTON_LOCATOR).click();
		}
		catch(Exception e){
			setLogger().error("[MMS_FleetListPage : clickFleetFilterSaveButton] Exception thrown -- " + EY_FW_Utility.getStackTrace(e));	
	    	Assert.assertTrue(false, e.getMessage()); 
	    }
	}
	
	public void verifyFleetListPageTitle() {
		try{
		setLogger().info("[MMS_FleetListPage : verifyFleetListPageTitle] Verifying Fleet List Page Title as " + MMS_ExpectedResult.FLEETLIST_PAGE_TITLE);
		MatcherAssert.assertThat(EY_FW_Utility.getCurrentPageTitle(), equalTo(MMS_ExpectedResult.FLEETLIST_PAGE_TITLE));
		}
		catch(Exception e){
			setLogger().error("[MMS_FleetListPage : verifyFleetListPageTitle] Exception thrown -- " + EY_FW_Utility.getStackTrace(e));	
	    	Assert.assertTrue(false, e.getMessage()); 
	    }
		catch(AssertionError e){
			setLogger().error("[MMS_FleetListPage : verifyFleetListPageTitle] Assert Failure -- " + EY_FW_Utility.getStackTrace(e));
	    	Assert.assertTrue(false, e.getMessage()); 
	    }
	}
	
	public void verifyListOfResults() {
		try{
		setLogger().info("[MMS_FleetListPage : verifyListOfResults] Verifying List of results displayed");
		List<WebElement> emptyOrNot = EY_FW_Utility.getAllElementsByAnyLocator(MMS_Locators.FLEET_FILTER_RESULTS_LIST_LOCATOR);
		MatcherAssert.assertThat(emptyOrNot, not(hasSize(1)));
		EY_FW_Utility.doWait(5000);
		List<WebElement> carInitialsTestDataColumnList = EY_FW_Utility
				.getAllElementsByAnyLocator(MMS_Locators.FLEET_FILTER_RESULTS_CARINTIAL_LIST_LOCATOR);
		List<String> carInitialsTestDataValuesList = new ArrayList<String>();
		
		for (WebElement eachCarIntialColumn : carInitialsTestDataColumnList) {
			carInitialsTestDataValuesList.add(eachCarIntialColumn.getText());
		}
		MatcherAssert.assertThat(carInitialsTestDataValuesList , hasItem(MMS_ExpectedResult.FLEETLIST_FLEET_SEARCH_RESULT));
		}
		catch(Exception e){
			setLogger().error("[MMS_FleetListPage : verifyListOfResults] Exception thrown -- " + EY_FW_Utility.getStackTrace(e));	
	    	Assert.assertTrue(false, e.getMessage()); 
	    }
		catch(AssertionError e){
			setLogger().error("[MMS_FleetListPage : verifyListOfResults] Assert Failure -- " + EY_FW_Utility.getStackTrace(e));
	    	Assert.assertTrue(false, e.getMessage()); 
	    }
		}
	
	
	
}
