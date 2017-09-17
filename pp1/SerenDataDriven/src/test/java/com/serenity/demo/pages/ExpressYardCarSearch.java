package com.serenity.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import net.thucydides.core.guice.Injectors;
import net.thucydides.core.webdriver.WebdriverManager;

public class ExpressYardCarSearch {

	WebDriver d= Injectors.getInjector().getInstance(WebdriverManager.class).getWebdriver();
    
    private static final String LOCATOR_CARINITIALTEXTFIELD="//input[@name='sInitials']";
    private static final String LOCATOR_CARNUMBERTEXTFIELD="//input[@name='sNumber']";
    private static final String LOCATOR_SEARCHBUTTON="//input[@class='input-button']";
    private static final String LOCATOR_IFRAME="//iframe[@name='imain']";
    private static final String LOCATOR_CARCHECKIN_STARTDATE_TEXTFIELD="//input[@name='sInStartDate']";
    private static final String LOCATOR_CARCHECKIN_ENDDATE_TEXTFIELD="//input[@name='sInEndDate']";
    
    @FindBy(how=How.XPATH, using=LOCATOR_CARINITIALTEXTFIELD)
    private WebElement CarInitialTextField;
    
    @FindBy(how=How.XPATH, using=LOCATOR_CARNUMBERTEXTFIELD)
    private WebElement CarNumberTextField;
    
    @FindBy(how=How.XPATH, using=LOCATOR_SEARCHBUTTON)
    private WebElement SearchButton;
    
    @FindBy(how=How.XPATH, using=LOCATOR_IFRAME)
    private WebElement Iframe;
    
    @FindBy(how=How.XPATH, using=LOCATOR_CARCHECKIN_STARTDATE_TEXTFIELD)
    private WebElement CarCheckIn_StartDate_TextField;
    
    @FindBy(how=How.XPATH, using=LOCATOR_CARCHECKIN_ENDDATE_TEXTFIELD)
    private WebElement CarCheckIn_EndDate_TextField;
    
    public void enterCarInitialTextField(String textToBeEntered){
        System.out.println("[ExpressYard_Carsearch_CarDetails : enterCarInitialTextField] Entering '" + textToBeEntered + "' in CarInitialTextField");
        CarInitialTextField.clear();
        CarInitialTextField.sendKeys(textToBeEntered);    
    }
    
    public void enterCarNumberTextField(String textField){
        System.out.println("[ExpressYard_Carsearch_CarDetails : enterCarInitialTextField] Entering '" + textField + "' in CarNumberTextField");
        CarNumberTextField.clear();
        CarNumberTextField.sendKeys(textField);
    }
    
    public void clickSearchButton(){
        System.out.println("[ExpressYard_Carsearch_CarDetails : clickSearchButton] Clicking 'SearchButton' button");
        SearchButton.click();
    }
    
    public void SwitchIframe(){  	    
    	System.out.println("[ExpressYard_Carsearch_CarDetails : Iframe]  'Switch' Iframe");
        d.switchTo().frame("imain");
	 
    }
    
    public void enterCarCheckIn_StartDate_TextField(String textToBeEntered){
        System.out.println("[ExpressYard_Carsearch_CarDetails : CarCheckIn_StartDate_TextField] Entering '" + textToBeEntered + "' in CarCheckIn_StartDate_TextField");
        CarCheckIn_StartDate_TextField.clear();
        CarCheckIn_StartDate_TextField.sendKeys(textToBeEntered);    
    }
    
    public void enterCarCheckIn_EndDate_TextField(String textToBeEntered){
        System.out.println("[ExpressYard_Carsearch_CarDetails : CarCheckIn_EndDate_TextField] Entering '" + textToBeEntered + "' in CarCheckIn_EndDate_TextField");
        CarCheckIn_EndDate_TextField.clear();
        CarCheckIn_EndDate_TextField.sendKeys(textToBeEntered);    
    }
    
}
