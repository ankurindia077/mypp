package com.spring.hibernate.webcontrols;

import org.openqa.selenium.WebElement;

import com.spring.hibernate.webinterface.IWebButton;

public class UIWebButton extends UIWebBaseControl implements IWebButton{
	
	 private WebElement _button;
	 
	 public UIWebButton(WebElement button)
	    {
		 	_button = button;
	    }

	@Override
	public void Click() {
		super.Click(_button);
		
	}
		

}
