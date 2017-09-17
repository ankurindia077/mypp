/**
 * @Copyright Copyright (C) 2016 General Electric Company. All rights reserved.
 * @author  Ankur Chaudhry
 * @version 1.0
 * @since   2016-07-05
 */

package com.serenity.demo.util;

import java.io.FileInputStream;
import java.util.Hashtable;
import java.util.Properties;

//import org.testng.SkipException;



public class EY_TestBase {
	
	public static Properties projectProperties;
	
	/**
	**********************************************************************
	* @Function Name : init
	* @Description : Function to load properties file
	* @Param : null
	* @Return : null
	* @Date : 2016-07-05
	* @Author : Ankur Chaudhry
	***********************************************************************
	*/	
	public static void init(){
		if(projectProperties == null){
			System.out.println("System porperty"+System.getProperty("user.dir"));
			
			String path=System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties";
			projectProperties = new Properties();
			try {
				FileInputStream fs = new FileInputStream(path);
				projectProperties.load(fs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	**********************************************************************
	* @Function Name : validateRunmodeCFS
	* @Description : Function to Validate Run Modes for particular Capability, Feature, Scenario, DataSet
	* @Param : capabilityName, featureId, scenarioName, dataRowNum, capabilityXls, capabilityNameXls
	* @Return : Hashtable with Key,Value pair for data set if Run Mode set as Yes for all
	* @Date : 2016-07-07
	* @Author : Ankur Chaudhry
	***********************************************************************
	*/	
	
	public static boolean validateRunmodeCFS(String capabilityName, String featureId, String scenarioName, int dataRowNum, String capabilityXls, String capabilityNameXls){
		init();
		
		boolean capabilityRunmode=EY_DataUtility.isCapabilityRunnable(capabilityName, new EY_DataReader(capabilityXls));
		boolean featureRunmode=EY_DataUtility.isFeatureRunnable(featureId, new EY_DataReader(capabilityNameXls));
		boolean sceanrioRunmode=EY_DataUtility.isScenarioRunnable(scenarioName, new EY_DataReader(capabilityNameXls));
		boolean dataRunmode=EY_DataUtility.isDataSetRunnable(featureId,scenarioName,dataRowNum, new EY_DataReader(capabilityNameXls));

		System.out.println("capabilityRunmode "+capabilityRunmode);
		System.out.println("featureRunmode "+featureRunmode);
		System.out.println("sceanrioRunmode "+sceanrioRunmode);
		System.out.println("dataRunmode "+dataRunmode);
		
		if(!(capabilityRunmode && featureRunmode && sceanrioRunmode && dataRunmode)){
			System.out.println("Skipping");
			return false;
		}
		
		else
			return true;
	
			
/*
		boolean suiteRunmode=Utility.isSuiteRunnable(suiteName, new Xls_Reader(prop.getProperty("xlsFileLocation")+"Suite.xlsx"));
		boolean testRunmode=Utility.isTestCaseRunnable(testName, new Xls_Reader(prop.getProperty("xlsFileLocation")+suiteName+".xlsx"));
		boolean dataSetRunmode=false;
		if(dataRunmode.equals(Constants.RUNMODE_YES))
			dataSetRunmode=true;
		
		if(!(suiteRunmode && testRunmode && dataSetRunmode)){
			APPLICATION_LOG.debug("Skipping the test "+testName+" inside the suite "+ suiteName);
			throw new SkipException("Skipping the test "+testName+" inside the suite "+ suiteName);
		}
		*/
	}

	
	/**
	**********************************************************************
	* @Function Name : getDataHashTable
	* @Description : Function to extract data in HashTable if runmode set as True
	* @Param : featureId, scenarioName, dataRowNum, capabilityNameXls
	* @Return : Hashtable with Key,Value pair for data set if Run Mode set as Yes for all
	* @Date : 2016-07-07
	* @Author : Ankur Chaudhry
	***********************************************************************
	*/
	public static Hashtable<String,String> getDataHashTable(String featureId, String scenarioName, int dataRowNum, String capabilityNameXls){
		Hashtable<String,String> table = null;
		table = new Hashtable<String,String>();
		Object[][] data = EY_DataUtility.getTestData(featureId, scenarioName, new EY_DataReader(capabilityNameXls));
		table= (Hashtable<String, String>) data[dataRowNum-1][0];
		return table;
	}
	

}
