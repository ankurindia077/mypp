package com.serenity.demo.steps.serenity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;

import com.serenity.demo.pages.ExpressYardLoginPageObject;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Step;


public class ExpressYardLoginUserSteps {

	
	@ManagedPages
	ExpressYardLoginPageObject expressyardLoginPageObject;
	
	@Step
	public void opensExpressYardPage() {
		expressyardLoginPageObject.openURL();
		
	}
	
	@Step
	public void enterCompanyNameUserNamePassword(String cName, String uName, String pName) {
		
		//System.out.println("yipeeeeeeee"+d.getTitle());
		expressyardLoginPageObject.enterLoginDetails(cName,uName,pName);
	}
	
	
	@Step
	public void userLoginSuccessfull(String sExpectedResult) {
		assertThat(expressyardLoginPageObject.getCompanyText(), is(equalToIgnoringCase(sExpectedResult)));	
	}
	

	@Step
	public void userClickGoButton() throws InterruptedException {
		expressyardLoginPageObject.clickGoButton();	
	}
	
	@Step
	public void searchOptionSelected() {
		expressyardLoginPageObject.clickMyYardLink();
	}
	
	
	@Step
	public void enterCarInitial(){
		expressyardLoginPageObject.enters_Car_Initial();
	}
	
	@Step
	public void clickSearchButton(){
		expressyardLoginPageObject.click_Search_Button();
	}
	
	@Step
	public void verifyCarDetails(String sExpectedResult){
		assertThat(expressyardLoginPageObject.successfully_Find_Details(), is(equalToIgnoringCase(sExpectedResult)));	
	}
	
	
}