package com.serenity.demo.steps;



import java.util.Hashtable;

import com.serenity.demo.steps.serenity.ExpressYardLoginUserSteps;
import com.serenity.demo.util.EY_Constants;
import com.serenity.demo.util.EY_TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class ExpressYardLoginStorySteps {
	

	@Steps
	ExpressYardLoginUserSteps expressyardLoginUserSteps;
	public String companyName = null;
	public String userName = null;
	public String passWord = null;
	
	@Given("Application is launched in a InternetExplorer browser '(.*)'")
	public void givenUserIsOnExpressYardLoginPage(Integer iterationNumber) throws Exception{
		System.out.println("Iteration Number "+ iterationNumber);
		EY_TestBase.init();
		String capXLS = EY_TestBase.projectProperties.getProperty("xlsFileLocationCapabilitySet")+EY_Constants.Xls_CapabilitySet+".xlsx";
		String capNameXLS = EY_TestBase.projectProperties.getProperty("xlsFileLocationExpressYardCRB")+EY_Constants.Xls_CapabilityName2+".xlsx";
		
		 boolean testRunMode = EY_TestBase.validateRunmodeCFS(EY_Constants.Col_Value_CapabilitySet_Capabilities_CapabilityName_2, EY_Constants.Col_Value_ExpressYardCRB_FeatureScenarioMap_FeatureId1, EY_Constants.Col_Value_ExpressYardCRB_FeatureScenarioMap_FeatureId1_ScenarioName1, iterationNumber, capXLS, capNameXLS);


		 if (!testRunMode){
			 throw new Exception("Skipping the test ");
		 }
		 else{
		 Hashtable<String,String> table1 = EY_TestBase.getDataHashTable(EY_Constants.Col_Value_ExpressYardCRB_FeatureScenarioMap_FeatureId1, EY_Constants.Col_Value_ExpressYardCRB_FeatureScenarioMap_FeatureId1_ScenarioName1,iterationNumber,capNameXLS);
		 companyName = table1.get("CompanyName");
		 userName = table1.get("UserName");
		 passWord = table1.get("Password");
		 
		 System.out.println("Company Name  "+ companyName);
		 System.out.println("User Name  "+ userName);
		 System.out.println("Password  "+passWord);
		 expressyardLoginUserSteps.opensExpressYardPage();
		 }
		
	}
	

	@When("User Enter Valid Company Name, User Name and Password")
	public void whenUserEntersCompanyNameUserNamePassword(){
		 System.out.println("Company Name @@@ "+ companyName);
		 System.out.println("User Name  @@@"+ userName);
		 System.out.println("Password  @@@"+passWord);
		expressyardLoginUserSteps.enterCompanyNameUserNamePassword(companyName,userName,passWord);
	}
	
	
	@Then("User Login Successfully")
	public void thenUserAbleSuccessfulLogin(){
		expressyardLoginUserSteps.userLoginSuccessfull("NS");
	}

	
	@When("User Clicks Go Button")
	public void whenUserClicksGoButton() throws InterruptedException{
		expressyardLoginUserSteps.userClickGoButton();
	}
	
	@When("User Selects Search Option from My Yard Menu")
	public void userSelectsSearchOption(){
		expressyardLoginUserSteps.searchOptionSelected();
	}
	
	@When("User enters Car Initial and Car Number in Text Box")
	public void userEntersCarInitial(){
		expressyardLoginUserSteps.enterCarInitial();
	}
	
	@When("User Click Search Button")
	public void userClickSearchButton(){
		expressyardLoginUserSteps.clickSearchButton();
	}
	
	@Then("User Successfully Find Details of Search Car")
	public void userFindDetails(){
		expressyardLoginUserSteps.verifyCarDetails("NS 200883-1");
	}
	
	
	
	
}
