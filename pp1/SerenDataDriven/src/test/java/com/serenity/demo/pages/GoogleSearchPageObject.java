package com.serenity.demo.pages;

import java.util.Hashtable;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade; 

public class GoogleSearchPageObject extends PageObject {

	@FindBy(id="lst-ib")
	public WebElementFacade txtboxGoogleSearch;

	@FindBy(css="h3.r>a")
	public WebElementFacade lnkGoogleSearchResults_FirstRecord;

	@FindBy(name="btnG")
	public WebElementFacade btnSearch;

	@FindBy(xpath="//input[@name='sCompanyLogin']")
	public WebElementFacade CompanyTextField;
	
	@FindBy(xpath="//*[@id='username']")
	public WebElementFacade username;
	
	@FindBy(xpath="//*[@id='password']")
	public WebElementFacade password;
	
	@FindBy(xpath="//*[@id='submitFrm']")
	public WebElementFacade submitFrm;
	
	public void openURL(){
		String url1 ="https://ssologin.ssogen2.corporate.ge.com/SSOLogin/rsologin.do?site=corporate&TYPE=33554433&REALMOID=06-000435e4-93a8-15d7-94df-026c036c902d&GUID=&SMAUTHREASON=0&METHOD=GET&SMAGENTNAME=vIQKA0U5Y0mrHu9pZceUw0rlOSPC6ksKZ2os56VbDiVWyMbDBSopu5oCt1edOFcB&TARGET=-SM-HTTPS%3a%2f%2ffssauth.ge.com%2fPfIdpIntegSmAuth%2fPFCProxyInTheCloudRedirect.jsp%3ffedHost%3dhttps%3a%2f%2ffssfedpitc.ge.com%2ffss%26resumePath%3d-%2Fidp-%2FIKLaK-%2FresumeSAML20-%2Fidp-%2FSSO.ping"; 
		openAt(url1);  
		username.sendKeys("502584801");
		password.sendKeys("Delhi@17091982d");
		submitFrm.click();
		waitABit(10000);
		String url = "https://www.google.co.in";
		openAt(url);	
	}

	public void typeSearchText(String sSearchTerm){
		waitABit(10000);
		txtboxGoogleSearch.type(sSearchTerm);
	}

	public  String getFirstRecordFromSearchResults(){
		waitABit(3000);
		return lnkGoogleSearchResults_FirstRecord.getText();
	}

	public void pressEnterToSearch(){
		btnSearch.click();
	}
	
}
	
