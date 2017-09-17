/**
 * @Copyright Copyright (C) 2016 General Electric Company. All rights reserved.
 */

package com.ey.mms.pagefactory;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ey.mms.util.EY_FW_Utility;
import com.ey.mms.util.PropertyReader;

import net.serenitybdd.core.pages.PageObject;

/**
* <h1>Login Page Class</h1>
* MMS LoginPage Class containing Page Functions for Login.
* @author  Ankur Chaudhry
* @version 1.1
* @since   2016-07-17
*/

public class MMS_LoginPage extends PageObject{

	private Logger APP_LOGS = null;
	
	private Logger setLogger(){
		if (APP_LOGS==null)
			APP_LOGS = LogManager.getLogger(MMS_LoginPage.class.getName());
		return APP_LOGS;	
	}
	
	
	public void openURL(){
		try{
		String url = new PropertyReader().readProperty("appurl");
		setLogger().info("[MMS_LoginPage : openURL] Opening WebURL:  " + url );
		openAt(url);
		}
		catch(Exception e){
			setLogger().error("[MMS_LoginPage : openURL] Exception thrown -- " + EY_FW_Utility.getStackTrace(e));	
	    	Assert.assertTrue(false, e.getMessage()); 
	    }
	}

	public void enterUserId(String userid) {
		try{
		setLogger().info("[MMS_LoginPage : enterUserId] Entering '" + userid + "' in UserField");
		WebElement userNameTextField = EY_FW_Utility.getAnyElementByAnyLocator(MMS_Locators.USERNAME_INPUTFIELD_LOCATOR);
		userNameTextField.clear();
		userNameTextField.sendKeys(userid);
		}
		catch(Exception e){
			setLogger().error("[MMS_LoginPage : enterUserId] Exception thrown -- " + EY_FW_Utility.getStackTrace(e));	
	    	Assert.assertTrue(false, e.getMessage()); 
	    }
	
	}

	public void enterPassword(String pwd) {
		try{
		setLogger().info("[MMS_LoginPage : enterPassword] Entering '" + pwd + "' in PasswordField");
		WebElement passwordTextField = EY_FW_Utility.getAnyElementByAnyLocator(MMS_Locators.PASSWORD_INPUTFIELD_LOCATOR);
		passwordTextField.clear();
		passwordTextField.sendKeys(pwd);
		}
		catch(Exception e){
			setLogger().error("[MMS_LoginPage : enterPassword] Exception thrown -- " + EY_FW_Utility.getStackTrace(e));	
	    	Assert.assertTrue(false, e.getMessage()); 
	    }
	}

	public void clickLoginButton() {
		try{
		setLogger().info("[MMS_LoginPage : clickLoginButton] Clicking Login Button");
		EY_FW_Utility.getAnyElementByAnyLocator(MMS_Locators.SUBMIT_BUTTON_LOCATOR).click();
		}
		catch(Exception e){
			setLogger().error("[MMS_LoginPage : clickLoginButton] Exception thrown -- " + EY_FW_Utility.getStackTrace(e));	
	    	Assert.assertTrue(false, e.getMessage()); 
	    }
	}
	
	public String getHomePageTitle()
	{
		setLogger().info("[MMS_LoginPage : getHomePageTitle] Returning Home Page Title");
		return EY_FW_Utility.getCurrentPageTitle();
	}

}
