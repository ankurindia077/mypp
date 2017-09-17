/**
 * @Copyright Copyright (C) 2016 General Electric Company. All rights reserved.
 * @author  Ankur Chaudhry
 * @version 1.0
 * @since   2016-07-05
 */

package com.serenity.demo.util;

public class EY_Constants {
	
	//xlsNames - Capability Set
	public static String Xls_CapabilitySet = "CapabilitySet";   /* Constant, Need not to change. */
	
	//sheetNames - Capability Set
	public static String Sheet_CapabilitySet_Capabilities = "Capabilities";	/* Constant, Need not to change. */
		
	//colNames - Capability Set
	public static String Col_CapabilitySet_Capabilities_CapabilityName="Capability Name"; /* Constant, Need not to change. */
	
	//colName Values - Capability Set
	public static String Col_Value_CapabilitySet_Capabilities_CapabilityName_1="GoogleSearch"; /* Change as per Capability Name. */
	public static String Col_Value_CapabilitySet_Capabilities_CapabilityName_2="ExpressYardCRB"; /* Change as per Capability Name. */

	// colNames - Generic
	public static String Col_RunMode="Run Mode"; /* Constant, Need not to change. */
	

	//xlsNames - Capability Name
	public static String Xls_CapabilityName1 = "GoogleSearch"; /* Change as per Capability Name. */
	public static String Xls_CapabilityName2 = "ExpressYardCRB"; /* Change as per Capability Name. */
	// Add more if more than 1 capability
	
	//sheetNames - Capability Name
	public static String Sheet_FeatureScenarioMap = "FeatScenMap"; /* Deviation -  Constant, Need not to change. */
	public static String Sheet_GoogleSearch_FeatureId1 = "101"; /* Change as per Capability Name and Feature Id Set. */
	// Add more if more than 1 capability
	
	//colNames - Capability Name 
	public static String Col_FeatureScenarioMap_FeatureId ="Feature Id"; /* Deviation - Constant, Need not to change. */
	public static String Col_FeatureScenarioMap_ScenarioId ="Child"; /* Deviation - Constant, Need not to change. */
	public static String Col_GoogleSearch_101_ScenarioId1_SearchText="SearchText"; /* Deviation - Change as per Capability Name, Feature Id, Scenario Id Set. */
	public static String Col_GoogleSearch_101_ScenarioId1_SearchResult="SearchResult"; /* Deviation - Change as per Capability Name, Feature Id, Scenario Id Set. */

	
	//colName Values - Capability Name
	public static String Col_Value_GoogleSearch_FeatureScenarioMap_FeatureId1="101"; /* Change as per Capability Name, Feature Id. */
	public static String Col_Value_GoogleSearch_FeatureScenarioMap_FeatureId1_ScenarioName1="Google should display appropriate search results page when I enter a Search Term"; /* Deviation - Change as per Capability Name, Feature Id and Scenario Id Set. */

	public static String Col_Value_ExpressYardCRB_FeatureScenarioMap_FeatureId1="101"; /* Change as per Capability Name, Feature Id. */
	public static String Col_Value_ExpressYardCRB_FeatureScenarioMap_FeatureId1_ScenarioName1="Verify Successful ExpressYard Application Login with valid user"; /* Deviation - Change as per Capability Name, Feature Id and Scenario Id Set. */

	public static String Col_Value_ExpressYardCRB_FeatureScenarioMap_FeatureId2="102"; /* Change as per Capability Name, Feature Id. */
	public static String Col_Value_ExpressYardCRB_FeatureScenarioMap_FeatureId2_ScenarioName2="Verify Car Search Details for Particular Car"; /* Deviation - Change as per Capability Name, Feature Id and Scenario Id Set. */

	
	//ColDataSet Names - Capability Name
	
	//	public static String Col_CapabilityName_FeatureId_DataId="Data Id"; /* Constant, Need not to change. */
//	public static String Col_CapabilityName_FeatureId_Col1="Col1"; /* Change as per Data Set mapped with Capability Name, Feature Id,Scenario Id and Data Id Set. */
//	public static String Col_CapabilityName_FeatureId_Col2="Col2"; /* Change as per Data Set mapped with Capability Name, Feature Id,Scenario Id and Data Id Set. */
//	public static String Col_CapabilityName_FeatureId_Col3="Col3"; /* Change as per Data Set mapped with Capability Name, Feature Id,Scenario Id and Data Id Set. */
	
	// suiteNames
	public static String FIRST_SUITE="SuiteA";
	public static String SECOND_SUITE="SuiteB";
	public static String ROOT_SUITE="My Project";
		
	//sheets
	public static String SUITE_SHEET="Suite";
	public static String TESTCASES_SHEET="TestCases";
	public static String DATA_SHEET="Data";

	//Col names
	public static String SUITENAME_COL="SuiteName";
	public static String RUNMODE_COL="Runmode";
	public static String TESTCASES_COL="TestCases";
		
	// runModes
//	public static String RUNMODE_YES="Y";
	public static String RUNMODE_NO="N";

		

}
