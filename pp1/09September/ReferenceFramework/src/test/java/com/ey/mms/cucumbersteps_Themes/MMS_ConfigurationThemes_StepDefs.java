/**
 * @Copyright Copyright (C) 2016 General Electric Company. All rights reserved.
 */

package com.ey.mms.cucumbersteps_Themes;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ey.mms.serenitysteps_Themes.MMS_ConfigurationTheme_SerenitySteps;
import com.ey.mms.util.PropertyReader;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


/**
* <h1>Cucumber Steps Class</h1>
* MMS Given,When,Then Statements Class for Configuration Theme
* @author  Ankur Chaudhry
* @version 1.1
* @since   2016-07-17
*/

public class MMS_ConfigurationThemes_StepDefs {
	private Logger APP_LOGS = null;
	
	private Logger setLogger(){
		if (APP_LOGS==null)
			APP_LOGS = LogManager.getLogger(MMS_ConfigurationThemes_StepDefs.class.getName());
		return APP_LOGS;	
	}
	
	@Steps
	MMS_ConfigurationTheme_SerenitySteps mmsconfigtheme;

	@Given("User is logged in as '(.*)' and '(.*)' as password.")
	public void user_is_logged_in_as_and_as_password(String username, String password) {
		setLogger().info("@Given(\"User is logged in as '(.*)' and '(.*)' as password.\")");
		mmsconfigtheme.opensMMSLoginPage();
		mmsconfigtheme.enterUserId(username);
		mmsconfigtheme.enterPassword(password);
	}

	@When("User Clicks on MMS Login Button.")
	public void user_Clicks_on_MMS_Login_Button() {
		setLogger().info("@When(\"User Clicks on MMS Login Button.\")");
		mmsconfigtheme.clickLoginButton();
	}

	@Then("User navigates to mms home page.")
	public void user_navigates_to_mms_home_page() {
		setLogger().info("@Then(\"User navigates to mms home page.\")");
		mmsconfigtheme.verifyHomePage();
	}

	@Given("User navigate through configuration.")
	public void user_navigate_through_configuration() {
		setLogger().info("@Given(\"User navigate through configuration.\")");
		mmsconfigtheme.clickConfigurationLink();
	}

	@When("User selects fleets and clicks fleets list.")
	public void user_selects_fleets_and_clicks_fleets_list() {
		setLogger().info("@When(\"User selects fleets and clicks fleets list.\")");
		mmsconfigtheme.moveToFleetsSubmenuItem();
		mmsconfigtheme.clickFleets_FleetListSubmenu();
	}

	@Then("User navigates to fleets list page.")
	public void user_navigates_to_fleets_list_page() {
		setLogger().info("@Then(\"User navigates to fleets list page.\")");
		mmsconfigtheme.verifyFleetListPageName();	
	}

	@Given("User clicks on filter button.")
	public void user_clicks_on_filter_button() throws Throwable {
		setLogger().info("@Given(\"User clicks on filter button.\")");
		mmsconfigtheme.clickFleetFilterButton();
	}

	@When("User enters car initial and click on save.")
	public void user_enters_car_initial_and_click_on_save() {
		setLogger().info("@When(\"User enters car initial and click on save.\")");
		mmsconfigtheme.enterFleetCarIntial();
		mmsconfigtheme.clickFilterSaveButton();
	}

	@Then("^filter should apply and verify results\\.$")
	public void filter_should_apply_and_verify_results() {
		setLogger().info("@Then(\"^filter should apply and verify results\\.$\")");
		mmsconfigtheme.verifyFilterResults();
	}

	@Before("@MMSLOGIN")
	public void beforeScenario() {
		System.out.println("Inside before");
		String path1=System.getProperty("user.dir")+"\\target\\logs\\";
		String path2 = new PropertyReader().readProperty("logfile1"); 
		System.setProperty("logfile.name",path1+path2+".html"); 
	}

}
