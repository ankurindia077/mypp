/**
 * @Copyright Copyright (C) 2016 General Electric Company. All rights reserved.
 * @author  Ankur Chaudhry
 * @version 1.0
 * @since   2016-07-05
 */

package com.serenity.demo.util;

import java.util.Hashtable;

public class Dummy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EY_TestBase.init();
		
		boolean capabilityRunmode=EY_DataUtility.isCapabilityRunnable(EY_Constants.Col_Value_CapabilitySet_Capabilities_CapabilityName_1, new EY_DataReader(EY_TestBase.projectProperties.getProperty("xlsFileLocationCapabilitySet")+EY_Constants.Xls_CapabilitySet+".xlsx"));
		System.out.println("Capability Runmode is " + capabilityRunmode );
		
		boolean featureRunmode=EY_DataUtility.isFeatureRunnable(EY_Constants.Col_Value_GoogleSearch_FeatureScenarioMap_FeatureId1, new EY_DataReader(EY_TestBase.projectProperties.getProperty("xlsFileLocationGoogleSearch")+EY_Constants.Xls_CapabilityName1+".xlsx"));
		System.out.println("Feature Runmode is for Capability1 " + featureRunmode );

		boolean sceanrioRunmode=EY_DataUtility.isScenarioRunnable(EY_Constants.Col_Value_GoogleSearch_FeatureScenarioMap_FeatureId1_ScenarioName1, new EY_DataReader(EY_TestBase.projectProperties.getProperty("xlsFileLocationGoogleSearch")+EY_Constants.Xls_CapabilityName1+".xlsx"));
		System.out.println("Scenario Runmode is for Capability1 & Feature 101 " + sceanrioRunmode );

		Object[][] data = EY_DataUtility.getTestData(EY_Constants.Sheet_GoogleSearch_FeatureId1, EY_Constants.Col_Value_GoogleSearch_FeatureScenarioMap_FeatureId1_ScenarioName1,  new EY_DataReader(EY_TestBase.projectProperties.getProperty("xlsFileLocationGoogleSearch")+EY_Constants.Xls_CapabilityName1+".xlsx"));
		
		Hashtable<String,String> table = new Hashtable<String,String>();
		
		table= (Hashtable<String, String>) data[0][0];
		
		System.out.println("Data table value@@@@" + table.get("SearchText"));

		boolean dataRunmode=EY_DataUtility.isDataSetRunnable(EY_Constants.Col_Value_GoogleSearch_FeatureScenarioMap_FeatureId1,EY_Constants.Col_Value_GoogleSearch_FeatureScenarioMap_FeatureId1_ScenarioName1,1, new EY_DataReader(EY_TestBase.projectProperties.getProperty("xlsFileLocationGoogleSearch")+EY_Constants.Xls_CapabilityName1+".xlsx"));

		System.out.println("Data Set Run Mode@@@@ " + dataRunmode );
		
		String capXLS = EY_TestBase.projectProperties.getProperty("xlsFileLocationCapabilitySet")+EY_Constants.Xls_CapabilitySet+".xlsx";
		String capNameXLS = EY_TestBase.projectProperties.getProperty("xlsFileLocationGoogleSearch")+EY_Constants.Xls_CapabilityName1+".xlsx";
		
		boolean validateRunMode = EY_TestBase.validateRunmodeCFS(EY_Constants.Col_Value_CapabilitySet_Capabilities_CapabilityName_1, EY_Constants.Col_Value_GoogleSearch_FeatureScenarioMap_FeatureId1, EY_Constants.Col_Value_GoogleSearch_FeatureScenarioMap_FeatureId1_ScenarioName1, 3, capXLS, capNameXLS);
	
		 
		 Hashtable<String,String> table1 = EY_TestBase.getDataHashTable(EY_Constants.Col_Value_GoogleSearch_FeatureScenarioMap_FeatureId1, EY_Constants.Col_Value_GoogleSearch_FeatureScenarioMap_FeatureId1_ScenarioName1, 3,capNameXLS);
		System.out.println("Data table value 1@@@@@" + table1.get("SearchText"));
		System.out.println("Data table value 2@@@@@" + table1.get("SearchResult"));
		
	}

}
