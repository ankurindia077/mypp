package com.spring.hibernate.webcontrols;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;

public class UIWebBaseControl {

	
	public void Click(WebElement element)
    {
        try
        {
            if (element.isDisplayed())
            {
                if (element.isEnabled())
                {
                    element.click();
                }
                else throw new ElementNotInteractableException(" Not enabled ");
            }
            else throw new ElementNotVisibleException("Does not exists");
        }
        catch(Exception e)
        {
        	System.out.println("Warning: Exception thrown");
        }
    }

	
	
}
