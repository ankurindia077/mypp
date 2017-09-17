package com.serenity.demo.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

//import org.jbehave.core.annotations.*;
import com.serenity.demo.steps.serenity.GoogleSearchUserSteps;
//import org.jbehave.core.model.ExamplesTable;
import com.serenity.demo.util.EY_Constants;
import com.serenity.demo.util.EY_TestBase;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.requirements.model.Example;


public class GoogleSearchStorySteps {

	@Steps
	GoogleSearchUserSteps googleSearchUserSteps;
	private String searchText = null;
	private String searchResult = null;
	public Map<String, Price> priceList;
	private List<Integer> numbers;
	 private int sum;
	
	@Given("user is on home Google Search Page '(.*)'")
	public void givenUserIsOnGoogleSearchPage(Integer iterationNumber) throws Exception {
	
		System.out.println("Iteration Number "+ iterationNumber);
		EY_TestBase.init();
		String capXLS = EY_TestBase.projectProperties.getProperty("xlsFileLocationCapabilitySet")+EY_Constants.Xls_CapabilitySet+".xlsx";
		String capNameXLS = EY_TestBase.projectProperties.getProperty("xlsFileLocationGoogleSearch")+EY_Constants.Xls_CapabilityName1+".xlsx";
		
		 boolean testRunMode = EY_TestBase.validateRunmodeCFS(EY_Constants.Col_Value_CapabilitySet_Capabilities_CapabilityName_1, EY_Constants.Col_Value_GoogleSearch_FeatureScenarioMap_FeatureId1, EY_Constants.Col_Value_GoogleSearch_FeatureScenarioMap_FeatureId1_ScenarioName1, iterationNumber, capXLS, capNameXLS);

		 if (!testRunMode){
			 throw new Exception("Skipping the test ");
		 }
		 else{
			 Hashtable<String,String> table1 = EY_TestBase.getDataHashTable(EY_Constants.Col_Value_GoogleSearch_FeatureScenarioMap_FeatureId1, EY_Constants.Col_Value_GoogleSearch_FeatureScenarioMap_FeatureId1_ScenarioName1,iterationNumber,capNameXLS);

		 searchText = table1.get("SearchText");
		 searchResult = table1.get("SearchResult");
		 }
		 
		System.out.println("####################################################");
		System.out.println("Search Text is   " + iterationNumber + searchText);
		System.out.println("Search result is " + iterationNumber + searchResult);
		System.out.println("####################################################");
		
	//	googleSearchUserSteps.opensGooglePage();
	}

	@When("the user enters SearchText")
	public void whenUserEntersSearchText(){
		this.searchText = searchText;
		System.out.println("####################################################");
		System.out.println("Search Text is  inside 2nd statement " + searchText);
		System.out.println("####################################################");

		//googleSearchUserSteps.searchWithText(searchText);
	}

	
	@Then("the result should contains SearchResult")
	public void the_result_successfull(){
		this.searchResult = searchResult;
		
		System.out.println("####################################################");
		System.out.println("Search Result is  inside 3rd statement " + searchResult);
		System.out.println("####################################################");

		String result = "a3";
		assertThat(result, is(equalToIgnoringCase(searchResult)));
		//assertThat("abc", is(equalToIgnoringCase("abcd")));
	}
	
	@Given("user is on '(.*)' Google Search Page")
	public void givenUserIsOnGoogleSearchPage(String abc){
		googleSearchUserSteps.opensGooglePage();
	}

	@When("the user enters search text1")
	public void whenUserEntersSearchText1(){
		googleSearchUserSteps.searchWithText("Serenity BDD");
	}

	@Then("the result successfull1")
	public void the_result_successfull1(){
		assertThat("abc", is(equalToIgnoringCase("abcd")));
	}
	
	 @Then("^Relogin option should be available$") 
	   public void checkRelogin() { 
	      System.out.println("Usage of but with then");
	   }
	
	 
		@Given("user is on home Google Search Page doc strings")
		public void docstrings(String doccomments) throws Exception {
			System.out.println("Doc Comments are" + doccomments);
		}
		
		@Before("@sanity")
		public void beforeScenario() {
			System.out.println("Inside before");
		}
		
		
		@After("@sanity")
		public void afterScenario() {
			System.out.println("Inside after");
		}

		
}
