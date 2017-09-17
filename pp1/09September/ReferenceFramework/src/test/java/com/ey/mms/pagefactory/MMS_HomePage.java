/**
 * @Copyright Copyright (C) 2016 General Electric Company. All rights reserved.
 */
package com.ey.mms.pagefactory;

import static org.hamcrest.CoreMatchers.equalTo;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.ey.mms.util.EY_FW_Utility;
import com.ey.mms.util.EY_GettersSetters;

import net.serenitybdd.core.pages.PageObject;

/**
* <h1>Home Page Class</h1>
* MMS HomePage Class containing Page Functions for Home.
* @author  Ankur Chaudhry
* @version 1.1
* @since   2016-07-17
*/

public class MMS_HomePage extends PageObject {
	private Logger APP_LOGS = null;
	private Logger setLogger(){
		if (APP_LOGS==null)
			APP_LOGS = LogManager.getLogger(MMS_HomePage.class.getName());
		return APP_LOGS;	
	}
	
	public void clickConfiguration() {
		try{
		setLogger().info("[MMS_HomePage : clickConfiguration] Clicking Configuration " );
		EY_FW_Utility.doWait(5000);
		EY_FW_Utility.getAnyElementByAnyLocator(MMS_Locators.CONFIGURATION_DROPDOWNMENU_LOCATOR).click();
		}
		catch(Exception e){
			setLogger().error("[MMS_HomePage : clickConfiguration] Exception thrown -- " + EY_FW_Utility.getStackTrace(e));
	    	Assert.assertTrue(false, e.getMessage()); 
	    }
	}

	public void selectFleetsSubMenu() {
		try{
		setLogger().info("[MMS_HomePage : selectFleetsSubMenu] Selecting Fleets Sub Menu " );
		EY_FW_Utility.doWait(5000);
		List<WebElement> allConfigItems = EY_FW_Utility.getAllElementsByAnyLocator(MMS_Locators.FLEETS_SUBMENU_LOCATOR);
		for (WebElement we : allConfigItems) {
			if (we.getText().equals("Fleets")) {
				Actions a = new Actions(EY_GettersSetters.getDriver());
				a.moveToElement(we).perform();
				break;
			}
		}
		}
		catch(Exception e){
			setLogger().error("[MMS_HomePage : selectFleetsSubMenu] Exception thrown -- " + EY_FW_Utility.getStackTrace(e));
	    	Assert.assertTrue(false, e.getMessage()); 
	    }
	}

	public void selectFleet_FleetListSubmenu() {
		try{
		setLogger().info("[MMS_HomePage : selectFleet_FleetListSubmenu] Selecting Fleets List Sub Menu item Fleet List " );
		EY_FW_Utility.doWait(5000);
		List<WebElement> allConfigItems = EY_FW_Utility.getAllElementsByAnyLocator(MMS_Locators.FLEETLIST_FLEETSUBMENU_LOCATOR);
		for (WebElement we : allConfigItems) {
			if (we.getText().equals("Fleet List")) {
				Actions a = new Actions(EY_GettersSetters.getDriver());
				a.moveToElement(we).perform();
				a.click(we).perform();
				break;
			}
		}
		}
		catch(Exception e){
			setLogger().error("[MMS_HomePage : selectFleet_FleetListSubmenu] Exception thrown -- " + EY_FW_Utility.getStackTrace(e));
	    	Assert.assertTrue(false, e.getMessage()); 
	    }
	}

	public void verifyHomePageTitle() {
		try{
		setLogger().info("[MMS_HomePage : verifyHomePageTitle] Verifying Home Page title as "+ MMS_ExpectedResult.HOME_PAGE_TITLE);
		MatcherAssert.assertThat(EY_FW_Utility.getCurrentPageTitle(), equalTo(MMS_ExpectedResult.HOME_PAGE_TITLE));
		}
		catch(Exception e){
			setLogger().error("[MMS_HomePage : verifyHomePageTitle] Exception thrown -- " + EY_FW_Utility.getStackTrace(e));	
	    	Assert.assertTrue(false, e.getMessage()); 
	    }
		catch(AssertionError e){
			setLogger().error("[MMS_HomePage : verifyHomePageTitle] Assert Failure -- " + EY_FW_Utility.getStackTrace(e));
	    	Assert.assertTrue(false, e.getMessage()); 
	    }
	}

}
