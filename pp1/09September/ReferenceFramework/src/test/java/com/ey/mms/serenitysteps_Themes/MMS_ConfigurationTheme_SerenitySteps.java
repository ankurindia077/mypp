/**
 * @Copyright Copyright (C) 2016 General Electric Company. All rights reserved.
 */

package com.ey.mms.serenitysteps_Themes;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ey.mms.pagefactory.MMS_FleetListPage;
import com.ey.mms.pagefactory.MMS_HomePage;
import com.ey.mms.pagefactory.MMS_LoginPage;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Step;

/**
* <h1>Serenity Steps Class</h1>
* MMS Serenity Steps Class for Configuration Theme.
* @author  Ankur Chaudhry
* @version 1.1
* @since   2016-07-17
*/

public class MMS_ConfigurationTheme_SerenitySteps {
	private Logger APP_LOGS = null;
	
	private Logger setLogger(){
		if (APP_LOGS==null)
			APP_LOGS = LogManager.getLogger(MMS_ConfigurationTheme_SerenitySteps.class.getName());
		return APP_LOGS;	
	}
	
	@ManagedPages
	MMS_LoginPage mmsloginpage;
	
	@ManagedPages
	MMS_HomePage mmshomepage;
	
	@ManagedPages
	MMS_FleetListPage mmsfleetlistpage;
	
	@Step
	public void opensMMSLoginPage() {
		setLogger().info("[MMS_ConfigurationTheme_SerenitySteps : opensMMSLoginPage] Opening MMS Login Page");
		mmsloginpage.openURL();		
	}
	
	@Step
	public void enterUserId(String userid) {
		setLogger().info("[MMS_ConfigurationTheme_SerenitySteps : enterUserId] Entering User Id");
		mmsloginpage.enterUserId(userid);
	}

	@Step
	public void enterPassword(String password) {
		setLogger().info("[MMS_ConfigurationTheme_SerenitySteps : enterPassword] Entering Password");
		mmsloginpage.enterPassword(password);		
	}
	
	@Step
	public void clickLoginButton() {
		setLogger().info("[MMS_ConfigurationTheme_SerenitySteps : clickLoginButton] Clicking Login Button");
		mmsloginpage.clickLoginButton();		
	}
	
	@Step
	public void verifyHomePage() {
		setLogger().info("[MMS_ConfigurationTheme_SerenitySteps : verifyHomePage] Verify Home Page Title");
		mmshomepage.verifyHomePageTitle();
	}
	
	@Step
	public void clickConfigurationLink()
	{
		setLogger().info("[MMS_ConfigurationTheme_SerenitySteps : clickConfigurationLink] Clicking Configuration Link");
		mmshomepage.clickConfiguration();
	}
	
	@Step
	public void moveToFleetsSubmenuItem()
	{
		setLogger().info("[MMS_ConfigurationTheme_SerenitySteps : moveToFleetsSubmenuItem] Clicking Fleets Sub Menu");
		mmshomepage.selectFleetsSubMenu();
	}
	
	@Step
	public void clickFleets_FleetListSubmenu()
	{
		setLogger().info("[MMS_ConfigurationTheme_SerenitySteps : clickFleets_FleetListSubmenu] Clicking Fleets List Sub Sub Menu");
		mmshomepage.selectFleet_FleetListSubmenu();
	}
	
	@Step
	public void verifyFleetListPageName()
	{
		setLogger().info("[MMS_ConfigurationTheme_SerenitySteps : verifyFleetListPageName] Verifying Fleet List Page Title");
		mmsfleetlistpage.verifyFleetListPageTitle();
	}
	
	@Step
	public void clickFleetFilterButton()
	{
		setLogger().info("[MMS_ConfigurationTheme_SerenitySteps : clickFleetFilterButton] Clicking Fleet Filter Button");
		mmsfleetlistpage.clickFleetFilterButton();
	}

	@Step
	public void enterFleetCarIntial()
	{
		setLogger().info("[MMS_ConfigurationTheme_SerenitySteps : enterFleetCarIntial] Entering Fleet Car Initial");
		mmsfleetlistpage.enterFleetCarInital();
	}
	
	@Step
	public void clickFilterSaveButton()
	{
		setLogger().info("[MMS_ConfigurationTheme_SerenitySteps : clickFilterSaveButton] Clicking Filter Save Button");
		mmsfleetlistpage.clickFleetFilterSaveButton();
	}
	
	@Step
	public void verifyFilterResults()
	{
		setLogger().info("[MMS_ConfigurationTheme_SerenitySteps : verifyFilterResults] Verifying Filter Results");
		mmsfleetlistpage.verifyListOfResults();
		
	}

}
