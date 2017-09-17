package com.spring.hibernate.webcontrols;

import org.openqa.selenium.WebElement;

import com.spring.hibernate.webinterface.IWebLink;

public class UIWebLink extends UIWebBaseControl implements IWebLink{

	private WebElement _link;
	
	public UIWebLink(WebElement link)
    {
       _link = link;
    }

	@Override
	public void Click() {
		super.Click(_link);
	}
	
	
}
