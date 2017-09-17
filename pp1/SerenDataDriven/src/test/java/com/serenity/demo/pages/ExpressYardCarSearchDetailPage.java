package com.serenity.demo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import net.thucydides.core.guice.Injectors;
import net.thucydides.core.webdriver.WebdriverManager;

public class ExpressYardCarSearchDetailPage {


	WebDriver d= Injectors.getInjector().getInstance(WebdriverManager.class).getWebdriver();
    
    private static final String LOCATOR_CARLINK="//a[text()='NS 200883']";
    private static final String LOCATOR_IFRAME="//iframe[@name='imain']";
    
    @FindBy(how=How.XPATH, using=LOCATOR_CARLINK)
    private WebElement CarLink;
    
    @FindBy(how=How.XPATH, using=LOCATOR_IFRAME)
    private WebElement Iframe;
    
    public String getCarText(){
    	String s= CarLink.getText();
    	return s;
    }
    
}
