package com.serenity.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import net.serenitybdd.core.pages.WebElementFacade;


public class ExpressYardLogin
{

    
    private static final String LOCATOR_COMPANYTEXTFIELD="//input[@name='sCompanyLogin']";
    
    private static final String LOCATOR_USERNAMETEXTFIELD="//input[@name='sUsername']";
    
    private static final String LOCATOR_PASSWORDFIELD="//input[@name='sPassword']";
    
    private static final String LOCATOR_LOGINBUTTON="id(\"loginButton\")";
    
    private static final String LOCATOR_STAYLOGGEDINCHECKBOX="id(\"bPersist\")";
         
    @FindBy(how=How.XPATH, using=LOCATOR_COMPANYTEXTFIELD)
   private WebElement CompanyTextField;
    

	//@FindBy(xpath="//input[@name='sCompanyLogin']")
//	public WebElementFacade CompanyTextField;
	
    @FindBy(how=How.XPATH, using=LOCATOR_USERNAMETEXTFIELD)
    private WebElement UsernameTextField;
    
	//@FindBy(xpath="//*[@id='sUsername']")
	//public WebElementFacade UsernameTextField;
	
	
    @FindBy(how=How.XPATH, using=LOCATOR_PASSWORDFIELD)
    private WebElement PasswordField;
    
    @FindBy(how=How.XPATH, using=LOCATOR_LOGINBUTTON)
    private WebElement LoginButton;
    
    @FindBy(how=How.XPATH, using=LOCATOR_STAYLOGGEDINCHECKBOX)
    private WebElement StayLoggedInCheckbox;
    
    
    public void enterCompanyTextField(String textToBeEntered){
        System.out.println("[ExpressYardLogin : enterCompanyTextField] Entering '" + textToBeEntered + "' in CompanyTextField");
        CompanyTextField.clear();
        CompanyTextField.sendKeys(textToBeEntered);
    }
    
     
    public void enterUsernameTextField(String textToBeEntered){
        System.out.println("[ExpressYardLogin : enterUsernameTextField] Entering '" + textToBeEntered + "' in UsernameTextField");
        UsernameTextField.clear();
        UsernameTextField.sendKeys(textToBeEntered);
    }
    

    public void enterPasswordField(String p_strPasswordString){
		System.out.println("[SigninPage : enterPassword] Entering the password for ");
        PasswordField.clear();
        PasswordField.sendKeys(p_strPasswordString);
    }
        
    public void clickLoginButton(){
        System.out.println("[ExpressYardLogin : clickLoginButton] Clicking 'LoginButton' button");
        LoginButton.click();
    }
    
    public void enterStayLoggedInCheckbox(String checkBoxState){
        System.out.println("[ExpressYardLogin : selectStayLoggedInCheckbox] Setting StayLoggedInCheckbox Checkbox to " + checkBoxState.toString());
            Boolean isChecked = StayLoggedInCheckbox.isSelected();
            switch (checkBoxState) {
            case "TRUE":
                if (!isChecked) {
                    StayLoggedInCheckbox.click();
                }
                break;
            case "FALSE":
                if (isChecked) {
                    StayLoggedInCheckbox.click();
                }
                break;
        }
    }
    
}
