/**
 * @Copyright Copyright (C) 2016 General Electric Company. All rights reserved.
 */

package com.ey.mms.util;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import net.thucydides.core.guice.Injectors;
import net.thucydides.core.webdriver.WebdriverManager;

/**
* <h1>Framework Getters Setters Library</h1>
* Contains functions for settings and getting framework variables
* to be maintained at global level like Web Driver Instance
* @author  Ankur Chaudhry
* @version 1.1
* @since   2016-07-17
*/
public class EY_GettersSetters {
   private static WebDriver driver;
   private static Logger APP_LOGS = null;
   private static Logger setLogger(){
		if (APP_LOGS==null)
			APP_LOGS = LogManager.getLogger(EY_GettersSetters.class.getName());
		return APP_LOGS;	
	}

   /**
    ***********************************************************************
	* Get Web Driver Instance as generated by the Framework
	* @return WebDriver
	***********************************************************************
	*/	  
	public static WebDriver getDriver() {
		try{
	    	if(driver==null){
	    		setDriver();
	    		driver.manage().window().maximize();
	    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	}
	        return driver;
		}
		catch (Exception e) {
			setLogger().error("[EY_GettersSetters: getDriver] Exception thrown -- " + EY_FW_Utility.getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
			return null;
		}
	}

	/**
	**********************************************************************
	Set Driver Instance as generated by the Framework
	***********************************************************************
	*/	
	private static void setDriver() {
		try{
	    	EY_GettersSetters.driver= Injectors.getInjector().getInstance(WebdriverManager.class).getWebdriver();
		}
		catch (Exception e) {
			setLogger().error("[EY_GettersSetters: setDriver] Exception thrown -- " + EY_FW_Utility.getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
		}
	}

}