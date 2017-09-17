package com.serenity.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import net.thucydides.core.guice.Injectors;
import net.thucydides.core.webdriver.WebdriverManager;

public class ExpressYardMain {
	
	WebDriver d= Injectors.getInjector().getInstance(WebdriverManager.class).getWebdriver();
	Actions action = new Actions(d);
	
	// Main Page Locators   
    private static final String LOCATOR_MYYARDLINK="//div[@id='O1002']/div";
    private static final String LOCATOR_SEARCHLINK="//div[@id='O5']/div";
    private static final String LOCATOR_NSSEARCHLINK="//div[@id='O6']/div";
    
    @FindBy(how=How.XPATH, using=LOCATOR_MYYARDLINK)
    private WebElement MyYardLink;
    
    @FindBy(how=How.XPATH, using=LOCATOR_SEARCHLINK)
    private WebElement SearchLink;
    
    @FindBy(how=How.XPATH, using=LOCATOR_NSSEARCHLINK)
    private WebElement NSSearchLink;
    
    public void clickMyYardLink(){
    		mouseHoverJScript(MyYardLink);
    		MyYardLink.click();    		
        }
       
   public void clickSearchLink() throws InterruptedException{
   	 	System.out.println("[ExpressYard_Carsearch_CarDetails : SearchLink] Clicking 'Search' link");
   	 		
		WebElement elem = d.findElement(By.xpath("//div[@id='O5']/div"));
		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		((JavascriptExecutor) d).executeScript(js, elem);
	
		Thread.sleep(10000);
		mouseHoverJScript(SearchLink);
		Thread.sleep(3000);
			
		Actions builder = new Actions(d);
		builder.moveToElement(MyYardLink).perform();
		SearchLink.click();
		
		Thread.sleep(10000);	
   }
    
   public void clickNSSearchLink() throws InterruptedException{
  	 	System.out.println("[ExpressYard_Carsearch_CarDetails : SearchLink] Clicking 'NS Search' link");
  	 		
		WebElement elem = d.findElement(By.xpath("//div[@id='O6']/div"));
		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		((JavascriptExecutor) d).executeScript(js, elem);
	
		Thread.sleep(3000);
		
		mouseHoverJScript(NSSearchLink);
		
		Thread.sleep(3000);
		
		Actions builder = new Actions(d);
		builder.moveToElement(MyYardLink).perform();
		NSSearchLink.click();
		
		Thread.sleep(10000);
  }
   
   public void mouseHoverJScript(WebElement HoverElement) {
		try {
			if (isElementPresent(HoverElement)) {
				
				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				((JavascriptExecutor) d).executeScript(mouseOverScript,HoverElement);
				((JavascriptExecutor) d).executeScript("arguments[0].click();", HoverElement);

			} else {
				System.out.println("Element was not visible to hover " + "\n");

			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + HoverElement
					+ "is not attached to the page document"
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + HoverElement + " was not found in DOM"
					+ e.getStackTrace());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while hovering"
					+ e.getStackTrace());
		}
	}

	public static boolean isElementPresent(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed()
					|| element.isEnabled())
				flag = true;
			} 	
			catch (NoSuchElementException e) {
					flag = false;
				} 
			catch (StaleElementReferenceException e) {
			flag = false;
				}
		return flag;
	}
    
}
