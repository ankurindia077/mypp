package com.spring.hibernate.webcontrols;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;

import com.spring.hibernate.webinterface.IWebTextBox;

public class UIWebTextBox implements IWebTextBox{

	private WebElement _textBox;
	 
	public UIWebTextBox(WebElement textBox)
    {
        _textBox = textBox;
    }

	@Override
	public void EnterText(String text) {
		try
        {
            if (_textBox.isDisplayed())
            {
                if (_textBox.isEnabled())
                {
                    _textBox.sendKeys(text);
                }
                else throw new ElementNotInteractableException("Element not found");
            }
            else throw new ElementNotInteractableException("Element not found");
        }
		catch(Exception e)
        {
            throw new ElementNotInteractableException("Element not found");
        }
	}

	@Override
	public void ClearText() {
		 try
         {
             if (_textBox.isDisplayed() && _textBox.isEnabled())
             {
                 _textBox.clear();
             }
             else throw new ElementNotInteractableException("Element not found");
         }
		 catch(Exception e)
	     {
	            throw new ElementNotInteractableException("Element not found");
	     }
		
	}

	@Override
	public String Text() {
		return _textBox.getAttribute("value");
	}
	
}
