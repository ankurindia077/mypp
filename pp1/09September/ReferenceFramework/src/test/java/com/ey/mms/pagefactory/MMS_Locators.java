/**
 * @Copyright Copyright (C) 2016 General Electric Company. All rights reserved.
 */
package com.ey.mms.pagefactory;

/**
* <h1>Locators Class</h1>
* MMS Locators Class containing Path Locators values across multiple pages of Application.
* @author  Ankur Chaudhry
* @version 1.1
* @since   2016-07-17
*/

public class MMS_Locators { 
	// Locators for Login Page
	public static final String USERNAME_INPUTFIELD_LOCATOR="css_input[name='Username']";
	public static final String PASSWORD_INPUTFIELD_LOCATOR="css_input[name='PlaintextPassword']";
	public static final String SUBMIT_BUTTON_LOCATOR="xpath_//input[@type='submit']";
	
	// Locators for Home Page
	public static final String CONFIGURATION_DROPDOWNMENU_LOCATOR = "xpath_//li[@id='Nav_Configuration']/a[1]";
	public static final String FLEETS_SUBMENU_LOCATOR = "xpath_//li[@id='Nav_Configuration']/ul[@class='dropdown-menu']/li/a";
	public static final String FLEETLIST_FLEETSUBMENU_LOCATOR = "xpath_//li[@id='Nav_Configuration']/ul[@class='dropdown-menu']/li[a[contains(text(),'Fleets')]]/ul/li/a";

	// Locators for Fleet List Page
	public static final String FLEET_BUTTON_LOCATOR = "xpath_//button[contains(text(),'Filter')]";
	public static final String FLEET_CARINITIAL_INPUTBOX_LOCATOR = "css_input[id='Car_Initial']";
	public static final String FLEET_FILTER_SAVE_BUTTON_LOCATOR = "css_button[id='Save']";
	public static final String FLEET_FILTER_RESULTS_LIST_LOCATOR = "xpath_//table[@id='DataTables_Table_0']/tbody/tr/td";
	public static final String FLEET_FILTER_RESULTS_CARINTIAL_LIST_LOCATOR = "xpath_//table[@id='DataTables_Table_0']/tbody/tr/td[2]";

}
