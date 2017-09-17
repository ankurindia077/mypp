package com.spring.hibernate.webcontrols;

import org.openqa.selenium.WebElement;

import com.spring.hibernate.webinterface.IWebBrowser;
import com.spring.hibernate.webinterface.IWebTableCell;

public class UIWebTableCell extends UIWebBaseControl implements IWebTableCell{
	
	private WebElement _tableCell;
	
	public UIWebTableCell(WebElement tableCell)
    {
         _tableCell = tableCell;
    }

	@Override
	public void Click(IWebBrowser browser) {
		browser.ScrollAndClick(_tableCell);	
	}

	@Override
	public String Text() {
		return _tableCell.getText();
	}

	@Override
	public void Click() {
		super.Click(_tableCell);
	}
	 

}
