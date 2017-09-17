package com.spring.hibernate.webcontrols;

import org.openqa.selenium.WebElement;

import com.spring.hibernate.webinterface.IWebCheckBox;

public class UIWebCheckBox extends UIWebBaseControl implements IWebCheckBox{
	
	private WebElement _checkBox;
	
	public UIWebCheckBox(WebElement checkBox)
    {
        _checkBox = checkBox;
    }

	@Override
	public void Click() {
		super.Click(_checkBox);
	}

	@Override
	public boolean Exists() {
		return _checkBox.isDisplayed();
	}

	@Override
	public boolean Checked() {
		return _checkBox.isSelected();
	}
	
	

}
