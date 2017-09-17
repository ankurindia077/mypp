/**
 * @Copyright Copyright (C) 2016 General Electric Company. All rights reserved.
 * @author  Ankur Chaudhry
 * @version 1.0
 * @since   2016-07-05
 */

package com.serenity.demo.util;

import java.util.Hashtable;

public class EY_DataUtility {
	
	/**
	**********************************************************************
	* @Function Name : isCapabilityRunnable
	* @Description : Check whether Capability Runnable or not
	* @Param : capabilityName , excelFilePathLocation for CapabilitySet
	* @Return : boolean
	* @Date : 2016-07-05
	* @Author : Ankur Chaudhry
	***********************************************************************
	*/
	public static boolean isCapabilityRunnable(String capabilityName, EY_DataReader xls){
		int rows = xls.getRowCount(EY_Constants.Sheet_CapabilitySet_Capabilities);
			for(int rNum=2;rNum<=rows;rNum++){
				String data = xls.getCellData(EY_Constants.Sheet_CapabilitySet_Capabilities, EY_Constants.Col_CapabilitySet_Capabilities_CapabilityName, rNum);
				if(data.equals(capabilityName)){
					String runmodeCapability = xls.getCellData(EY_Constants.Sheet_CapabilitySet_Capabilities, EY_Constants.Col_RunMode, rNum);
					if(runmodeCapability.equals("Y")||runmodeCapability.equals("Yes")||runmodeCapability.equals("y")||runmodeCapability.equals("yes"))
						return true;
					else
						return false;
				}
			}
		return false;
	}
	
	/**
	***********************************************************************************
	* @Function Name : isFeatureRunnable
	* @Description : Check whether Feature Runnable or not for particular Capability
	* @Param : featureId, excelFilePathLocation 
	* @Return : boolean
	* @Date : 2016-07-05
	* @Author : Ankur Chaudhry
	***********************************************************************************
	*/
	public static boolean isFeatureRunnable(String featureId, EY_DataReader xls){
		int rows = xls.getRowCount(EY_Constants.Sheet_FeatureScenarioMap);
		for(int rNum=2;rNum<=rows;rNum++){
			String featureIdXls = xls.getCellData(EY_Constants.Sheet_FeatureScenarioMap, EY_Constants.Col_FeatureScenarioMap_FeatureId, rNum);
			String featureIdXls1 = featureIdXls.split("\\.")[0];
			if(featureIdXls1.equals(featureId)){
			String runmodeFeature = xls.getCellData(EY_Constants.Sheet_FeatureScenarioMap, EY_Constants.Col_RunMode, rNum);
			if(runmodeFeature.equals("Y")||runmodeFeature.equals("Yes")||runmodeFeature.equals("y")||runmodeFeature.equals("yes"))
				return true;
			else
				return false;
		    }
		}
		return false;
	}
	
	/**
	**********************************************************************************************
	* @Function Name : isScenarioRunnable
	* @Description : Check whether Scenario Runnable or not for particular Capability & Feature
	* @Param : scenarioName, excelFilePathLocation 
	* @Return : boolean
	* @Date : 2016-07-05
	* @Author : Ankur Chaudhry
	**********************************************************************************************
	*/
	public static boolean isScenarioRunnable(String scenarioName, EY_DataReader xls){
		int rows = xls.getRowCount(EY_Constants.Sheet_FeatureScenarioMap);
		for(int rNum=2;rNum<=rows;rNum++){
			String scenarioIdXls = xls.getCellData(EY_Constants.Sheet_FeatureScenarioMap, EY_Constants.Col_FeatureScenarioMap_ScenarioId, rNum);
			String scenarioIdXls1 = scenarioIdXls.split("\\.")[0];			
			if(scenarioIdXls1.equals(scenarioName)){
			String runmodeScenario = xls.getCellData(EY_Constants.Sheet_FeatureScenarioMap, EY_Constants.Col_RunMode, rNum);
			if(runmodeScenario.equals("Y")||runmodeScenario.equals("Yes")||runmodeScenario.equals("y")||runmodeScenario.equals("yes"))
				return true;
			else
				return false;
		    }
		}
		return false;
	}
	
	/**
	*************************************************************************************************
	* @Function Name : getTestData
	* @Description : Creates Hash table in key, value pair. Key as ColName, and Value as Test Data
	* @Param : sheetName, scenarioName, excelFilePathLocation 
	* @Return : Hash table in Object Array
	* @Date : 2016-07-05
	* @Author : Ankur Chaudhry
	*************************************************************************************************
	*/
	public static Object[][]  getTestData(String sheetName,String scenarioName, EY_DataReader xls){
		int rows = xls.getRowCount(sheetName);
		System.out.println("Total rows - "+ rows);
		
		// row number for testCase
		int testCaseRowNum=1;
		for(testCaseRowNum=1;testCaseRowNum<=rows;testCaseRowNum++){
			String scenarioIdXls = xls.getCellData(sheetName, 0, testCaseRowNum);
			String scenarioIdXls1 = scenarioIdXls.split("\\.")[0];
			if(scenarioIdXls1.equalsIgnoreCase(scenarioName))
				break;
		}
		System.out.println("Test Starts from row Number - "+ testCaseRowNum);
		int dataStartRowNum=testCaseRowNum+2;
		int colStartRowNum=testCaseRowNum+1;
		
		// rows of data
		int testRows=1;
		while(!xls.getCellData(sheetName, 0, dataStartRowNum+testRows).equals("")){
			testRows++;
		}
		System.out.println("Total rows of data are - "+testRows);
		
		// columns of data
		int testCols=0;
		while(!xls.getCellData(sheetName,testCols,colStartRowNum).equals("")){
			testCols++;
		}
		Object[][] data = new Object[testRows][1];
		int r=0;
		for(int rNum=dataStartRowNum;rNum<(dataStartRowNum+testRows);rNum++){
			Hashtable<String,String> table = new Hashtable<String,String>();
			for(int cNum=0;cNum<testCols;cNum++){
				table.put(xls.getCellData(sheetName, cNum, colStartRowNum), xls.getCellData(sheetName, cNum, rNum));
			}
			data[r][0]=table;
			r++;
		}
		return data;

	}
	
	/**
	****************************************************************************************************
	* @Function Name : isDataSetRunnable
	* @Description : Check whether DataSet Runnable or not for particular Capability,Feature & DataSet
	* @Param : featureId, scenarioName, dataRowNum, excelFilePathLocation 
	* @Return : boolean
	* @Date : 2016-07-05
	* @Author : Ankur Chaudhry
	****************************************************************************************************
	*/
	public static boolean isDataSetRunnable(String featureId, String scenarioName, Integer dataRowNum, EY_DataReader xls){
		Object[][] data = getTestData(featureId, scenarioName, xls);
		Hashtable<String,String> table = new Hashtable<String,String>();
		table= (Hashtable<String, String>) data[dataRowNum-1][0];
		String runmodeDataSet = table.get(EY_Constants.Col_RunMode);
		if(runmodeDataSet.equals("Y")||runmodeDataSet.equals("Yes")||runmodeDataSet.equals("y")||runmodeDataSet.equals("yes"))
			return true;
		else
			return false;
		}
}
