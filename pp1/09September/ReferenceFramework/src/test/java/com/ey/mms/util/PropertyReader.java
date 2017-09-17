/**
 * @Copyright Copyright (C) 2016 General Electric Company. All rights reserved.
 */

package com.ey.mms.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

/**
* <h1>Framework Property Reader</h1>
* Contains functions for reading values from keys mentioned in framework properties file.
* @author  Ankur Chaudhry
* @version 1.1
* @since   2016-07-17
*/

public class PropertyReader {
	Properties properties = new Properties();
	InputStream inputStream = null;
	private Logger APP_LOGS = null;
	
	private Logger setLogger(){
		if (APP_LOGS==null)
			APP_LOGS = LogManager.getLogger(PropertyReader.class.getName());
		return APP_LOGS;	
	}

	/**
	**********************************************************************
	* PropertyReader (Default Constructor) Calls the loadProperties method
	***********************************************************************
	*/
	public PropertyReader() {
		loadProperties();
	}

	/**
	**********************************************************************
	* PropertyReader (Overload Constructor) Calls the loadProperties method
	* @param propetiesFilePath This is path of properties file in String format
	***********************************************************************
	*/
	public PropertyReader(String propetiesFilePath) {
		loadProperties(propetiesFilePath);
	}
	
	/**
	**********************************************************************
	Initialize and load the config.properties file
	***********************************************************************
	*/
	private void loadProperties() {
		try {
			inputStream = new FileInputStream("./src/test/resources/ConfigFiles/config.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			setLogger().error("[PropertyReader : loadProperties] Exception thrown -- " + EY_FW_Utility.getStackTrace(e));
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	/**
	**********************************************************************
	* Initialize and load the config.properties file
	* @param propetiesFilePath This is path of properties file in String format
	***********************************************************************
	*/
	private void loadProperties(String propetiesFilePath) {
		try {
			inputStream = new FileInputStream(propetiesFilePath);
			properties.load(inputStream);
		} catch (IOException e) {
			setLogger().error("[PropertyReader : loadProperties] Exception thrown -- " + EY_FW_Utility.getStackTrace(e));
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	/**
	**************************************************************************************
	* Return value for the key mentioned in config.properties file
	* @param key This is name of Key in String format.
	* @return KeyValue	This is Key value is String format.
	***************************************************************************************
	*/
	public String readProperty(String key) {
		return properties.getProperty(key);
	}
}
