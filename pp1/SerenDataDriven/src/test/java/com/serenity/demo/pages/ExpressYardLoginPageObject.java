package com.serenity.demo.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.webdriver.WebdriverManager;

public class ExpressYardLoginPageObject extends PageObject {

	@Managed(driver="iexplorer")
	WebDriver d;
	 
	@FindBy(xpath="//input[@name='sCompanyLogin']")
	public WebElementFacade CompanyTextField;
	
	@FindBy(xpath="//input[@name='sUsername']")
	public WebElementFacade UsernameTextField;
	    
	@FindBy(xpath="//input[@name='sPassword']")
	public WebElementFacade PasswordField; 
	    
	@FindBy(xpath="id(\"loginButton\")")
	public WebElementFacade LoginButton;
	
	@FindBy(xpath="id(\"bPersist\")")
	public WebElementFacade StayLoggedInCheckbox;
		
    @FindBy(xpath="//form[@name='loginForm']/div[1]/input[1]")
    public WebElementFacade GoButton;
    
   /* @FindBy(xpath="//div[@id='O1002']/div")
    public WebElementFacade MyYardLink;
    
    @FindBy(xpath="//div[@id='O5']/div")
    public WebElementFacade SearchLink; */
    
    @FindBy(xpath="//form[@name='loginForm']/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]")
	public WebElementFacade CompanyText;
    
    ExpressYardLogin expressYardLoginPage;
	ExpressYardMain expressYardMainPage;
	ExpressYardCarSearch expressYardCarSearch;
	ExpressYardCarSearchDetailPage	expressYardCarSearchDetailPage;

	public void openURL(){
		String url = "http://3.204.170.44/ns/login";
		openAt(url);
		d= Injectors.getInjector().getInstance(WebdriverManager.class).getWebdriver();
	   expressYardLoginPage = PageFactory.initElements(d, ExpressYardLogin.class);
	   expressYardMainPage = PageFactory.initElements(d, ExpressYardMain.class);
	   expressYardCarSearch = PageFactory.initElements(d, ExpressYardCarSearch.class);
	   expressYardCarSearchDetailPage = PageFactory.initElements(d, ExpressYardCarSearchDetailPage.class);
	}
	
	public void enterLoginDetails(String cName, String uName, String pName){
	
	//	CompanyTextField.sendKeys("ns");
	// expressYardLoginPage.enterCompanyTextField("ns");
		expressYardLoginPage.enterCompanyTextField(cName);
		
	//	UsernameTextField.sendKeys("v7a7b");
	//	expressYardLoginPage.enterUsernameTextField("v7a7b");
		expressYardLoginPage.enterUsernameTextField(uName);
		
	//	expressYardLoginPage.enterPasswordField("admin");
		expressYardLoginPage.enterPasswordField(pName);

		StayLoggedInCheckbox.click();

		LoginButton.click();
		waitABit(10000);
	
	}

	public String getCompanyText(){
		 String parsedText = CompanyText.getText().replaceAll("(?:\n|\r)", "").trim();
		 return parsedText;	
	}
	
	public void clickGoButton() throws InterruptedException
	{
		GoButton.click();
		waitABit(10000);
		Thread.sleep(10000);
	}
	
	  public void clickMyYardLink() {
		  expressYardMainPage.clickMyYardLink();
		  
		  waitABit(5000);
		  
		  try{
		  expressYardMainPage.clickSearchLink();
		  }
		  catch(Exception e){
			  
		  }
		  waitABit(5000);
		  
      }
	
	  public void enters_Car_Initial () {
			expressYardCarSearch.SwitchIframe();
			expressYardCarSearch.enterCarInitialTextField("NS");
			expressYardCarSearch.enterCarNumberTextField("200883");
		}
	
	  public void click_Search_Button () {
			
			expressYardCarSearch.clickSearchButton();
		}
	  
	  public String successfully_Find_Details () {
			String actualCarResult  = expressYardCarSearchDetailPage.getCarText();
			return actualCarResult;
	  }
	
}
	
