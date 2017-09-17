package com.spring.hibernate.webcontrols;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;

import com.spring.hibernate.webinterface.IWebRadioButton;

public class UIWebRadioButton extends UIWebBaseControl implements IWebRadioButton{

	 private WebElement _radiobutton;
	 
	 public UIWebRadioButton(WebElement radiobutton)
     {
         _radiobutton = radiobutton;
     }

	@Override
	public void Click() {
		super.Click(_radiobutton);
	}

	@Override
	public boolean Exists() {
		try{
			return _radiobutton.isDisplayed();
		}
		 catch(Exception e)
        {
			 System.out.println("Warning: Exception thrown");
	       	 throw new ElementNotInteractableException("Element not found");
        }
	}

	@Override
	public boolean Checked() {
		if(_radiobutton.isDisplayed())
			return _radiobutton.isSelected();
		else 
			throw new ElementNotInteractableException("Element not found");
	}
 
}
