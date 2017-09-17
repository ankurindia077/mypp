package com.spring.hibernate.webcontrols;

import org.openqa.selenium.WebElement;

import com.spring.hibernate.webinterface.IWebImage;

public class UIWebImage extends UIWebBaseControl implements IWebImage{

	 private WebElement _image;
	 
	 public UIWebImage(WebElement image)
     {
         _image = image;
     }

	@Override
	public void Click() {
		super.Click(_image);
		
	}

	@Override
	public boolean Exists() {
		return _image.isDisplayed();
	}

	@Override
	public String GetAttribute(String attributeName) {
		// TODO Auto-generated method stub
		return _image.getAttribute(attributeName);
	}

	
	 
	 
	 
}
